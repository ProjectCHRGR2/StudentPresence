package com.example.studentpresence;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class qractivity extends AppCompatActivity {

    SurfaceView cameraPreview;
    CameraSource cameraSource;
    BarcodeDetector barcodeDetector;
    TextView textView;

    FirebaseAuth mAuth;

    private static final int CAMERA_PERMISSION_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qractivity);

        mAuth = FirebaseAuth.getInstance();
        textView = findViewById(R.id.textView);
        cameraPreview = findViewById(R.id.cameraPreview);
        barcodeDetector = new BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.QR_CODE).build();

        cameraSource = new CameraSource.Builder(this, barcodeDetector).setRequestedPreviewSize(640, 480).build();
        // The size might be changed in the future for a better resolution. However, this is not required.

        cameraPreview.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE); //If no permission, get permission.
                }
                try {
                    cameraSource.start(surfaceHolder); // Start the previewer within the app.
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
            }
            // Surface won't change. However, this method is still required.

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                cameraSource.stop(); // Close the camera previewer when the activity is closed.
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) { // Handle whatever is detected within the QR code.
                final SparseArray<Barcode> qrCodes = detections.getDetectedItems();
                if (qrCodes.size() != 0) { // If something is detected, do the following. Else, do nothing.
                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                            vibrator.vibrate(250); // Vibrate after scanning.
                            // Toast.makeText(qractivity.this, qrCodes.valueAt(0).displayValue, Toast.LENGTH_SHORT).show(); // DEBUG TOOL: UNCOMMENT FOR CODE DISPLAY ON SCAN
                            textView.setText("You may now close the app.");
                            cameraSource.stop();

                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            final DatabaseReference databaseRef = database.getReference(); // Set reference to the database.
                            final DatabaseReference studentNumRef = databaseRef.child("Students").child(mAuth.getUid()).child("userStudentNum"); // Set reference to the child in the database called "Classes".
                            studentNumRef.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) { // Read the database and get the Student Number.
                                    String studentNum = dataSnapshot.getValue(String.class);
                                    String message = studentNum;
                                    System.out.println("Student Number read as: " + message);
                                    String qrCodeResult = qrCodes.valueAt(0).displayValue;
                                    System.out.println(qrCodeResult);
                                    DatabaseReference lessonRef = databaseRef.child(qrCodeResult).child(mAuth.getUid()); // Set path to QR Code location.
                                    Map<String, Object> presenceUpdate = new HashMap<>();
                                    presenceUpdate.put("StudentNumber", message); // Send update. This does not remove the other children, while .put() does.
                                    lessonRef.updateChildren(presenceUpdate);
                                    presenceUpdate.put("Present", "Present");
                                    lessonRef.updateChildren(presenceUpdate);
                                }
                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                    System.out.println("The read failed: " + databaseError.getCode());
                                }
                            });
                                                    }
                    });
                }
            }
        });

    }
}