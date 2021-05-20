
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="loginRegister" method="post">
            <table>
                <thead>
                    <tr><td>Login page!</td></tr>
                    <tr><td>${message}</td></tr>
                    <tr><td>${successMessage}</td></tr>
                </thead>
                <tbody>
                    <tr><td>Email : </td><td><input type="email" name="email"></td></tr>
                    <tr><td>Password : </td><td><input type="password" name="password"></td></tr>
                    <tr><td><input type="submit" name="submit" value="Login"></td><td><a href ="registration.jsp">Registration</a></td></tr>
                </tbody>
            </table>
    </form>
</body>
</html>
