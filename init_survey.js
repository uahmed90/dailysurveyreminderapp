var q1 = document.getElementById("q1");
var q1a1 = document.getElementById("q1a1");
var q1a2 = document.getElementById("q1a2");


var askme = firebase.database().ref().child("QnA").child("s0q1").child("question");

askme.on('value', function(snapshot){
	q1.innerHTML = snapshot.val();
});

var tellme = firebase.database().ref().child("QnA").child("s0q1").child("a1");

tellme.on('value', function(snapshot){
	q1a1.innerHTML = snapshot.val();
});

var tellme2 = firebase.database().ref().child("QnA").child("s0q1").child("a2");

tellme2.on('value', function(snapshot){
	q1a2.innerHTML = snapshot.val();
});



