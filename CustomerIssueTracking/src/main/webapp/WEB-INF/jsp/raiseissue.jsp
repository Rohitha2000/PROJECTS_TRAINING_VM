<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.raiseissue {
	align-content: center;
}
.error{
color:red;
}
</style>
<title>RAISE ISSUE</title>
</head>
<div
	style="text-align: right; padding: 5px; margin: 5px 0px; background: #ccc;">	
</div>
<body style="background-color: lightgrey;">

		<form:form method="post" action="issueraised" modelAttribute="IssueDetail">
		<table align="center">
		<tr><td>
		Issue Id:</td><td style="background-color: white;">
		 <%-- <form:input path="" value="Auto Filled"/> --%> ${isid}
		<form:input type="hidden" path="custIssueId"/>
		</td></tr>
		<tr><td>
		Issue Report Date: (Format:yyyy/mm/dd)</td><td style="background-color: white;"> 
		<form:input path="issueReportDate"/>
		
		</td>
		<td><form:errors path="issueReportDate" cssClass="error"/></td></tr>
		<tr><td>
		Customer Id:</td><td style="background-color: white;"> 
		<%-- <form:input path="custId"/> --%> ${iid}
		</td></tr>
		<tr><td>
		Category:</td><td style="background-color: white;"> 
		<form:input path="category"/></td><td>
		<form:errors path="category" cssClass="error"/>
		</td></tr>
		<tr><td>
		Description:</td><td style="background-color: white;">
		 <form:textarea path="description"/>
		 </td><td><form:errors path="description" cssClass="error"/></td>
		<form:input type="hidden" path="ccRepId" value="CCR"/>
		<form:input type="hidden" path="issueStatus" value="In Progress"/>
		</tr>
		<tr><td>
		<input type="submit" value=Submit>
		</td><td>
		<input type="reset" value="Clear">
		</td></tr>
		</table>
		</form:form>
	
</body>
</html>