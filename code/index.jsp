<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
/* Full-width inputs */
form
{
 border: 1px solid;
  padding: 10px;
  box-shadow: 5px 10px red;
}
input[type=text], input[type=password] {
  width: 30%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 30%;
}

/* Add a hover effect for buttons */
button:hover {
  opacity: 0.8;
}

/* Create two equal columns that floats next to each other */
.column {
  float: left;
  width: 45%;
 padding: 16px;
  height: 300px; 
   border: 1px solid;
  padding: 10px;
  box-shadow: 5px 10px red;
    /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
.open-button {
  background-color:#04AA6D;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 280px;
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 20px;
  left: 500px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}

</style>
<h1>Library</h1>
<div class="row">
  <div class="column" style="background-color:white;">
  <h3>Admin Login</h3>
    <form action="AdminLogin" method="post">
    <label for="uname"><b>Email</b></label>
    <input type="text" placeholder="EmailId" name="email" required>
<br>
    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
<br>
    <button type="submit">Login</button>
  </form>
  </div>
  <br><br><br><br>
  <div class="column" style="background-color:white;">
    <h3>Member Login</h3> 
  <form action="memberLogin" method="post">
    <label for="uname"><b>Email</b></label>
    <input type="text" placeholder="EmailId" name="email" required>
<br>
    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
<br>
    <button type="submit">Login</button> 
    </form>
 
<button class="open-button" onclick="openForm()">New Account</button>   
<div class="form-popup" id="myForm">
  <form action="memreg" method="post" class="form-container">
    <h1>New Account</h1>
    <label for="email"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="name" required>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    
    <label for="Membership"><b>Membership</b></label>
    <input type="membership" placeholder="Yes/no" name="membership" required>
    
    <button type="submit" class="btn">Create</button>
    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
  </form>
</div>

<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>
</body>
</html>