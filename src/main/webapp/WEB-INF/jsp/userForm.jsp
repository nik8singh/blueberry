<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Registration Page</title>
</head>
<body bgcolor=#ffffcc text=orange><div align="center">
    <h1>User Information</h1></div><hr></hr>
<form:form method="POST" commandName="user">
    <table align="center" >
        <tr>
            <td>User Name :</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>Password :</td>
            <td><form:password path="password" /></td>
        </tr>
        <tr>
            <td>Gender :</td>
            <td><form:radiobutton path="gender" value="Male" label="Male" /> <form:radiobutton
                    path="gender" value="Female" label="Female" /></td>
        </tr>
        <tr>
            <td>Languages :</td>
            <td><form:checkboxes path="language" items="${languageList}" itemValue="key" itemLabel="value" /></td>
        </tr>
        <tr>
            <td>Course :</td>
            <td><form:select path="course">
                <form:option value="0" label="Select" />
                <form:options items="${courseList}" itemValue="courseId" itemLabel="courseName" />
            </form:select></td>
        </tr>
        <tr>
            <td>Address :</td>
            <td><form:textarea path="address" /></td>
        </tr>

        <tr>
            <td></td>
            <td><form:checkbox path="rememberMe"
                               label="Remember Me" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Register"></td>
        </tr>
    </table>
</form:form>

</body>
</html>