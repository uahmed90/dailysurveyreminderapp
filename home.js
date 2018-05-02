//Buttons to variables; easier usage
//var A=document.getElementById('intro');
var B=document.getElementById('mid-day');
var C=document.getElementById('after');
var D=document.getElementById('evening');
var count=0;
var interval=1000*60*10;//1000ms=>60sec=>10 MINUTES

function toggler(){
	$(B).hide();
	$(C).hide();
	$(D).hide();
	switch(count%3){
		case 0:
			$(B).show();
			break;
		case 1:
			$(C).show();
			break;
		case 2:
			$(D).show();
			break;
	}
	count++;
}
window.setInterval(function(){
	toggler(count)}, interval);
// window.onload=function(){
//     setInterval(toggler(count), 1500);
// //    setTimeout(introOff(intro), 1500);
// //  setTimeout(introOn(intro), 3000);
// }

var user = firebase.auth().currentUser;

if(user != null){

	var email_id = user.email;
	document.getElementById("user_para").innerHTML="Welcome " + email_id;


}

function signOut(){
	firebase.auth().signOut().then(function() {
	  // Sign-out successful.
	  location.href = 'index.html';
	}, function(error) {
	  // An error happened.
	});
}