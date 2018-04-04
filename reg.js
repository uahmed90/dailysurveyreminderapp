

firebase.auth().onAuthStateChanged(function(user) {
  if (user) {
    // User is signed in.
    location.href = 'home.html';

    
  } else {
    // No user is signed in.
  }
});




function signup(){

	var userEmail = document.getElementById("su_email_field").value;
    var userPass = document.getElementById("su_password_field").value;

    window.alert("Hey there: " + userEmail + "Your password is: " + userPass)

	firebase.auth().createUserWithEmailAndPassword(userEmail, userPass).catch(function(error) {
	  // Handle Errors here.
	  var errorCode = error.code;
	  var errorMessage = error.message;
	  window.alert("Error : " + errorCode + " " + errorMessage);
	});
}