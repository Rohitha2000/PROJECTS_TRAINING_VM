<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: rgb(200, 240, 300)">
	<br>
	<br>
	<!-- Add code here.. -->
	 <h1 id="heading" >Indian Railway System</h1>
<sf:form name="form" action="getTicketBookingResultPage" modelAttribute="ticketBooking1" method="post">
<table>
<caption style="font-weight:bold;">Book Your Tatkal Ticket</caption>
<tr>
<td>
<sf:label path="customerName">Customer Name:</sf:label>
</td>
<td>
<sf:input path="customerName" id="customerName" />
</td>
<td>
<sf:errors path="customerName" cssStyle="color:red;"/>
</td>
</tr>
<tr>
<td>
<sf:label path="mobileNumber">Mobile Number:</sf:label>
</td>
<td>
<sf:input path="mobileNumber" id="mobileNumber" />
</td>
<td>
<sf:errors path="mobileNumber" cssStyle="color:red;" />
</td>
</tr>
<tr>
<td>
<sf:label path="fromCity">From:</sf:label>
</td>
<td>
<sf:select path="fromCity" id="fromCity">
<sf:options items="${from}" />
<%-- <sf:option value="Pune" label="Pune"/>  
        <sf:option value="Bangalore" label="Bangalore"/>  
        <sf:option value="Chennai" label="Chennai"/>  
        <sf:option value="Delhi" label="Delhi"/>   --%>
</sf:select>
</td>
</tr>
<tr>
<td>
<sf:label path="toCity">To:</sf:label>
</td>
<td>
<sf:select path="toCity" id="toCity">
 <sf:options items="${to}" />
<%-- <sf:option value="Pune" label="Pune"/>  
        <sf:option value="Bangalore" label="Bangalore"/>  
        <sf:option value="Chennai" label="Chennai"/>  
        <sf:option value="Delhi" label="Delhi"/>  --%> 
</sf:select>
</td>
</tr>
<tr>
<td>
<sf:label path="travelClass">Class:</sf:label>
</td>
<td>
<sf:select path="travelClass" id="travelClass">
<sf:options items="${classType}" />
<%-- <sf:option value="1A" label="AC FirstClass(1A)"/>
<sf:option value="2A" label="AC SecondClass(2A)"/>
<sf:option value="2A" label="AC ThirdClass(3A)"/>
<sf:option value="SL" label="SL SleeperClass(SL)"/>
<sf:option value="2S" label="AC (2S)"/> --%>
</sf:select>
</td>
</tr>
<tr>
<td>
<sf:label path="noOfTickets">No. of Tickets:</sf:label>
</td>
<td>
<sf:input path="noOfTickets" id="noOfTickets" />
</td>
<td>
<sf:errors path="noOfTickets" cssStyle="color:red;" />
</td>
</tr>
<tr>
<td>
<input type="submit" id=”submit” name=”submit” value="Book" />
</td>
<td>
<input type="reset" value="Clear" />
</td>
</tr>
</table>






</sf:form>
	 
 
</body>
</html>