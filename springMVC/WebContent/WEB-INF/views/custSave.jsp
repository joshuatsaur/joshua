<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cust Save Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
    <form:form action="save/${urlParm}" method="post" commandName="customer">
       <table>
         <tr>
           <td>Name:</td>
           <td><form:input path="name"/></td>
           <td><form:errors path="name" cssClass="error"/></td>
         </tr>
         <tr>
           <td>Email:</td>
           <td><form:input path="email"/></td>
           <td><form:errors path="email" cssClass="error"/></td>
         </tr>
         <tr>
           <td>Age:</td>
           <td><form:input path="age"/></td>
           <td><form:errors path="age" cssClass="error"/></td>
         </tr>
         <tr>
           <td>Gender:</td>
           <td>
              <form:select path="gender">
                 <form:option value="MALE" label="男"/>
                 <form:option value="FEMALE" label="女"/>
              </form:select>
           </td>
           <td><form:errors path="gender"/> </td>
         </tr>
         <tr>
           <td>Birthday:</td>
           <td><form:input path="birthday" placeholder="MM/dd/yyyy" /> </td>
           <td><form:errors path="birthday" cssClass="error"/> </td>
         </tr>
         <tr>
			<td>Phone:</td>
			<td><form:input path="phone" /></td>
			<td><form:errors path="phone" cssClass="error" /></td>
		</tr>
		<tr>
		    <td colspan="3"> <input type="submit" value="save" /> </td>
		</tr>
       </table>
    </form:form>
</body>
</html>