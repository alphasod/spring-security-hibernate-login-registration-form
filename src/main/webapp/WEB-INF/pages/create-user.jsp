<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
 <title>Registration Page</title>
</head>
<body>
<h2>Registration form</h2>

<form:form modelAttribute="user" method="post" >
 <h4>${error}</h4>
 <table>
  <tr>
   <td>User:</td>
   <td><input title="Enter your username" type="text" required pattern="\w+" name="username" ></td>
  </tr>
  <tr>
   <td>Password:</td>
   <td><input title="Password must contain at least 6 characters, including UPPER/lowercase and numbers" type="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" name="password" onchange="
  this.setCustomValidity(this.validity.patternMismatch ? this.title : '');
  if(this.checkValidity()) form.password2.pattern = this.value;"></td>
  </tr>
  <tr>
   <td>Confirm Password:</td>
   <td><input title="Please enter the same Password as above" type="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" name="password2" onchange="
  this.setCustomValidity(this.validity.patternMismatch ? this.title : '');
"></td>
  </tr>
 </table>
 <input type="submit" value="Sign Up" />
</form:form>
</body>
</html>