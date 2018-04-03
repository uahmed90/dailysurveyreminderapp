function signup(){

	var userEmail = document.getElementById("su_email_field").value;
    var userPass = document.getElementById("su_password_field").value;
}

firebase.auth().createUserWithEmailAndPassword(su_email_field, su_password_field).catch(function(error) {
  // Handle Errors here.
  var errorCode = error.code;
  var errorMessage = error.message;
  // ...
});