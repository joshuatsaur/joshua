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
    <form:form action="save" method="post" commandName="emp">
       <table>
         <tr>
           <td>ID:</td>
           <td><form:input path="id"/></td>
           <td><form:errors path="id" cssClass="error"/></td>
         </tr>
         <tr>
           <td>Name:</td>
           <td><form:input path="name"/></td>
           <td><form:errors path="name" cssClass="error"/></td>
         </tr>
         <tr>
           <td>Create Date:</td>
           <td><form:input path="createdDate" placeholder="MM/dd/yyyy" /></td>
           <td><form:errors path="createdDate" cssClass="error"/></td>
         </tr>
         <tr>
           <td>Role:</td>
           <td>
             <form:select path="role">
               <form:option value="AD" label="AD"></form:option>
               <form:option value="PM" label="PM"></form:option>
             </form:select>
           </td>
           <td><form:errors path="role" cssClass="error"/></td>
         </tr>
		<tr>
		    <td colspan="3"> <input type="submit" value="save" /> </td>
		</tr>
       </table>
    </form:form>
</body>
</html>