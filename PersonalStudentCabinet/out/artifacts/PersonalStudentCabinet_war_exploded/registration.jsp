
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/loginRegister" method="post">
    <table>
        <tr><td>Email : </td><td><input type="email" name="email"></td></tr>
        <tr><td>Password : </td><td><input type="password" name="password"></td></tr>
       <tr><td>First name : </td><td><input type="text" placeholder="First Name" name="firstName" required /></td>  </tr>
        <tr><td>Last name : </td><td><input type="text" placeholder="Last Name" name="lastName" required /></td></tr>
       <tr><td>Age : </td><td><input type="number" min="1" placeholder="Age" name="age" required /></td></tr>
        <tr><td>Gender : </td><td>
            <select placeholder="Gender" name="gender" required>
            <option value="" disabled selected>Gender</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
        </select>
        </td></tr>
        <tr><td><input type="submit" value="Register"></td><td><a href ="login.jsp">LogIn</a></td></tr>
    </table>
</form>
</body>
</html>
