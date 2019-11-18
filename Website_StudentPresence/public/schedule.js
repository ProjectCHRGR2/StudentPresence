function CreateTableFromJSON(week) {
    /*var fs = require('fs');
    var allText = fs.readFileSync("weeks.txt").toString();*/
    var theSchedule = {"1":[
    {"Timeslot": "1","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "2","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "3","Monday": "coursecode, WD04.002 (inf2c)","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "4","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "5","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "6","Monday": "","Tuesday": "","Wednesday": "coursecode, WD04.002 (inf2c)","Thursday": "","Friday": ""},
    {"Timeslot": "7","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "8","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "9","Monday": "","Tuesday": "","Wednesday": "","Thursday": "coursecode, WD04.002 (inf2c)","Friday": ""},
    {"Timeslot": "10","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "11","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "12","Monday": "","Tuesday": "coursecode, WD04.002 (inf2c)","Wednesday": "","Thursday": "","Friday": "coursecode, WD04.002 (inf2c)"},
    {"Timeslot": "13","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "14","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "15","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""}
],
"2":[
    {"Timeslot": "1","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "2","Monday": "2","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "3","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "4","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "5","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "6","Monday": "","Tuesday": "","Wednesday": "4","Thursday": "","Friday": ""},
    {"Timeslot": "7","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "8","Monday": "3","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "9","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "10","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "11","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "12","Monday": "","Tuesday": "2","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "13","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "14","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "15","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""}
],
"3": [
    {"Timeslot": "1","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "2","Monday": "2","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "3","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "4","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "5","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "6","Monday": "","Tuesday": "","Wednesday": "4","Thursday": "","Friday": ""},
    {"Timeslot": "7","Monday": "","Tuesday": "2","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "8","Monday": "3","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "9","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "10","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "11","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "12","Monday": "","Tuesday": "2","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "13","Monday": "","Tuesday": "","Wednesday": "","Thursday": "yes","Friday": ""},
    {"Timeslot": "14","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "15","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
],
"4":[
    {"Timeslot": "1","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "2","Monday": "2","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "3","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "4","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "5","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "6","Monday": "","Tuesday": "","Wednesday": "4","Thursday": "","Friday": ""},
    {"Timeslot": "7","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "8","Monday": "3","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "9","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "10","Monday": "","Tuesday": "blah","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "11","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "12","Monday": "","Tuesday": "2","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "13","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "14","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "15","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
],
"5":[
    {"Timeslot": "1","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "2","Monday": "2","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "3","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "23","Friday": ""},
    {"Timeslot": "4","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "5","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "6","Monday": "","Tuesday": "","Wednesday": "4","Thursday": "","Friday": ""},
    {"Timeslot": "7","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "8","Monday": "3","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "9","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "10","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "11","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "12","Monday": "","Tuesday": "2","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "13","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "14","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "15","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
],
"6":[
    {"Timeslot": "1","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "2","Monday": "2","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "3","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "4","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "5","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "6","Monday": "","Tuesday": "","Wednesday": "4","Thursday": "","Friday": ""},
    {"Timeslot": "7","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "8","Monday": "3","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "9","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "10","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "11","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "12","Monday": "","Tuesday": "2","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "13","Monday": "class","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "14","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "15","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
],
"7":[
    {"Timeslot": "1","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "2","Monday": "2","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "3","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "4","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "5","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "6","Monday": "","Tuesday": "","Wednesday": "4","Thursday": "","Friday": ""},
    {"Timeslot": "7","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "8","Monday": "3","Tuesday": "3","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "9","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "10","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "11","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "12","Monday": "","Tuesday": "2","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "13","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "14","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "15","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
],
"8":[
    {"Timeslot": "1","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "2","Monday": "2","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "3","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "4","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "5","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "6","Monday": "","Tuesday": "","Wednesday": "4","Thursday": "","Friday": ""},
    {"Timeslot": "7","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "8","Monday": "3","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "9","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "10","Monday": "","Tuesday": "32143","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "11","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "12","Monday": "","Tuesday": "2","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "13","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "14","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "15","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
],
"9":[
    {"Timeslot": "1","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "2","Monday": "2","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "3","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "432","Friday": ""},
    {"Timeslot": "4","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "5","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "6","Monday": "","Tuesday": "","Wednesday": "4","Thursday": "","Friday": ""},
    {"Timeslot": "7","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "8","Monday": "3","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "9","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "10","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "11","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "12","Monday": "","Tuesday": "2","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "13","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "14","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "15","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
],
"10":[
    {"Timeslot": "1","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "2","Monday": "2","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "3","Monday": "1","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "4","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "5","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "6","Monday": "","Tuesday": "","Wednesday": "4","Thursday": "","Friday": ""},
    {"Timeslot": "7","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "8","Monday": "3","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "9","Monday": "","Tuesday": "","Wednesday": "meow","Thursday": "","Friday": ""},
    {"Timeslot": "10","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "11","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "12","Monday": "","Tuesday": "2","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "13","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "14","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
    {"Timeslot": "15","Monday": "","Tuesday": "","Wednesday": "","Thursday": "","Friday": ""},
]
}
theSchedule = theSchedule[week.toString()]
var col = [];
for (var i = 0; i < theSchedule.length; i++) {
    for (var key in theSchedule[i]) {
        if (col.indexOf(key) === -1) {
            col.push(key);
        }
    }
}

var table = document.createElement("table");


var tr = table.insertRow(-1);

for (var i = 0; i < col.length; i++) {
    var th = document.createElement("th");
    th.innerHTML = col[i];
    tr.appendChild(th);
}

for (var i = 0; i < theSchedule.length; i++) {

    tr = table.insertRow(-1);

    for (var j = 0; j < col.length; j++) {
        var tabCell = tr.insertCell(-1);
        tabCell.innerHTML = theSchedule[i][col[j]];
    }
}

var divContainer = document.getElementById("showData");
divContainer.innerHTML = "";
divContainer.appendChild(table);
}