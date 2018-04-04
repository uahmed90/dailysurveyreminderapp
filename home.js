

var user = firebase.auth().currentUser;

if (user) {
  // User is signed in.
  document.getElementById("user_div").style.display = "block";
  if (user != null){
            var email_id = user.email;
			document.getElementById("user_para").innerHTML = "Welcome "+ email_id;
        }

} else {
  // No user is signed in.
  location.href = 'index.html';
}


function signOut(){
	firebase.auth().signOut().then(function() {
	  // Sign-out successful.
	  location.href = 'index.html';
	}, function(error) {
	  // An error happened.
	});
}