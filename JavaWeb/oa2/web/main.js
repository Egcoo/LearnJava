
// JavaScript (main.js)
document.getElementById("login-form").addEventListener("submit", function(event) {
event.preventDefault();
const username = document.getElementById("username").value;
const password = document.getElementById("password").value;
// Perform login logic here
console.log("Username:", username, "Password:", password);
});

// import React from 'react';
// import './styles.css';
//
// function Login() {
//     return (
//         <div className="login-container">
//             <h1>Login</h1>
//             <form action="/oa2/user/login" method="post" id="login-form">
//                 <label htmlFor="username">Username:</label>
//                 <input type="text" id="username" name="username" required />
//                 <label htmlFor="password">Password:</label>
//                 <input type="password" id="password" name="password" required />
//                 <button type="submit">Login</button>
//             </form>
//         </div>
//     );
// }
//
// export default Login;


// const form = document.querySelector('form');
// const username = document.querySelector('#username');
// const password = document.querySelector('#password');
//
// form.addEventListener('submit', e => {
//     e.preventDefault();
//     if (username.value === '') {
//         showError('请输入用户名');
//     } else if (password.value === '') {
//         showError('请输入密码');
//     } else {
//         showSuccess('登录成功');
//     }
// });
//
// function showError(message) {
//     const errorDiv = document.createElement('div');
//     errorDiv.className = 'error';
//     errorDiv.appendChild(document.createTextNode(message));
//     const container = document.querySelector('.container');
//     const h1 = document.querySelector('h1');
//     container.insertBefore(errorDiv, h1);
//     username.classList.add('error');
//     password.classList.add('error');
//     setTimeout(() => {
//         errorDiv.remove();
//         username.classList.remove('error');
//         password.classList.remove('error');
//     }, 3000);
// }
//
// function showSuccess(message) {
//     const successDiv = document.createElement('div');
//     successDiv.className = 'success';
//     successDiv.appendChild(document.createTextNode(message));
//     const container = document.querySelector('.container');
//     const h1 = document.querySelector('h1');
//     container.insertBefore(successDiv, h1);
//     setTimeout(() => {
//         successDiv.remove();
//     }, 3000);
// }


