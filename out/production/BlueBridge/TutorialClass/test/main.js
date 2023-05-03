
// JavaScript (main.js)
document.getElementById("login-form").addEventListener("submit", function(event) {
event.preventDefault();
const username = document.getElementById("username").value;
const password = document.getElementById("password").value;
// Perform login logic here
console.log("Username:", username, "Password:", password);
});