firebase.auth().onAuthStateChanged(function(user) {
    if (user) {
        // User is signed in.
       location.href = 'home.html';

        var user = firebase.auth().currentUser;

    } else {

        document.getElementById("login_div").style.display = "block";
        // No user is signed in.
    }
});


function login(){
    
    var userEmail = document.getElementById("email_field").value;
    var userPass = document.getElementById("password_field").value;
    
    firebase.auth().signInWithEmailAndPassword(userEmail, userPass).catch(function(error) {
        // Handle Errors here.
        var errorCode = error.code;
        var errorMessage = error.message;
        window.alert("Error : " + errorCode + " " + errorMessage);
    });
    
    
}

