package com.example.studentpresence;

public class UserProfile {
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userStudentNum;
    private String userClass;

    public void userProfile(){
    }

    public void userProfile(String userFirstName, String userLastName, String userEmail, String userStudentNum, String userClass) {

        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userStudentNum = userStudentNum;
        this.userClass = userClass;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName= userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserStudentNum() {
        return userStudentNum;
    }

    public void setUserStudentNum(String userStudentNum) {
        this.userStudentNum = userStudentNum;
    }

    public String getUserClass() {
        return userClass;
    }

    public void setUserClass(String userClass) {
        this.userClass= userClass;
    }

}
