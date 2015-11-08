<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
 <title>Registration Page</title>
</head>
<body>
<h2>Registration form</h2>

<form:form modelAttribute="user" method="post">
 <h3>${error}</h3>
 <table>
  <tr>
   <td>User:</td>
   <td><input type='text' name='username'></td>
  </tr>
  <tr>
   <td>Password:</td>
   <td><input type='password' name='password' /></td>
  </tr>
 </table>
 <input type="submit" value="Sign Up" />
</form:form>
</body>
</html>