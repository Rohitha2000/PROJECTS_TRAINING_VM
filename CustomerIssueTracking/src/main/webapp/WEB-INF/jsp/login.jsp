<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.loginform {
	align-content: center;
}
</style>
<script>



</script>
<title>Welcome To Login Page</title>
</head>
<body style="background-color: powderblue;">
	<div
		style="text-align: right; padding: 5px; margin: 5px 0px; background: #ccc;">
		
	</div>
	<h2>Welcome To Customer Page</h2>
	<form action="customerform" modelAttribute="customer">
	Please Select Your Option:
	<input type="radio" name="radioName" value="raise" >Raise
	<input type="radio" name="radioName" value="view" >View Issue Status Enter Id of Issue You Wish to See:
	<input type="text" name=issueId path="custIssueId">
	<br><br><br>
	<input type="submit" value="Submit">
	</form>
	
	
</body>
</html>