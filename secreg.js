
/*firebase.auth().onAuthStateChanged(function(user) {
  if (user) {
    // User is signed in.
    location.href = 'secreg.html';

    
  } else {
    // No user is signed in.
  }
});
*/
var users = firebase.database().ref("users/");

users.set({
	User1: {
		age: 14,
		grade: 9 
	},
	User2: {
		age: 18,
		grade: 12
	}
});
