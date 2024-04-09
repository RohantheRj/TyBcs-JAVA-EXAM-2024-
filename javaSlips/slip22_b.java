<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Greeting Page</title>
</head>
<body>
    <h1>Greeting Page</h1>
    
    <form method="post">
        Enter your name: <input type="text" name="username">
        <input type="submit" value="Greet">
    </form>

    <%-- Java code to process the form submission --%>
    <%@ page import="java.util.Date" %>
    <%@ page import="java.text.SimpleDateFormat" %>
    <%@ page import="java.util.Calendar" %>
    <%@ page import="java.io.PrintWriter" %>
    
    <%-- Get the current time on the server --%>
    <% Calendar cal = Calendar.getInstance();
       SimpleDateFormat sdf = new SimpleDateFormat("HH");
       int hour = Integer.parseInt(sdf.format(cal.getTime()));
    %>

    <%-- Get the username from the form submission --%>
    <% String username = request.getParameter("username");
       if (username != null && !username.isEmpty()) {
           String greeting = "";
           if (hour >= 0 && hour < 12) {
               greeting = "Good Morning";
           } else if (hour >= 12 && hour < 18) {
               greeting = "Good Afternoon";
           } else {
               greeting = "Good Evening";
           }
    %>

    <h2>
        <% out.println(greeting + ", " + username + "!"); %>
    </h2>

    <% } %>
</body>
</html>

