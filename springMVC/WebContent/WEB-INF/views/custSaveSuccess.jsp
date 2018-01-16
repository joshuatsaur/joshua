<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Saved Successfully Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
    <table>
         <tr>
           <td>Name:</td>
           <td>${customer.name}</td>
         </tr>
         <tr>
           <td>Email:</td>
           <td>${customer.email}</td>
         </tr>
         <tr>
           <td>Age:</td>
           <td>${customer.age}</td>
         </tr>
         <tr>
           <td>Gender:</td>
           <td>
              <c:choose>
                <c:when test="${customer.gender == 'MALE'}">
                  <spring:message code="gender.male"/>
                </c:when>
                <c:otherwise>
                  <spring:message code="gender.female"/>
                </c:otherwise>
              </c:choose>
           </td>
         </tr>
         <tr>
           <td>Birthday:</td>
           <td > <fmt:formatDate value="${customer.birthday}" pattern="MM/dd/yyyy"/> </td>
         </tr>
         <tr>
			<td>Phone:</td>
			<td>${customer.phone} </td>
		   </tr>
       </table>
</body>
</html>