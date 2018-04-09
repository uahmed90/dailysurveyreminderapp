


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