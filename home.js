
function signOut(){
	firebase.auth().signOut().then(function() {
	  // Sign-out successful.
	  location.href = 'index.html';
	}, function(error) {
	  // An error happened.
	});
}