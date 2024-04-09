<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Prime Number Checker</title>
</head>
<body>
    <h1>Prime Number Checker</h1>


    <% String numberStr = request.getParameter("number"); %>
    

    <% if (numberStr != null && !numberStr.isEmpty()) { %>
        <%-- Convert the string number to an integer --%>
        <% int number = Integer.parseInt(numberStr); %>

        <% boolean isPrime = true; %>
        <% if (number <= 1) { %>
            <% isPrime = false; %>
        <% } else { %>
            <% for (int i = 2; i <= Math.sqrt(number); i++) { %>
                <% if (number % i == 0) { %>
                    <% isPrime = false; %>
                    <% break; %>
                <% } %>
            <% } %>
        <% } %>


        <p><font color="red"><%= number %> is <%= isPrime ? "prime" : "not prime" %></font></p>
    <% } else { %>

        <p>Please provide a number to check if it is prime.</p>
    <% } %>

    <form method="post" action="PrimeChecker.jsp">
        <label>Enter a number:</label>
        <input type="text" name="number">
        <input type="submit" value="Check">
    </form>
</body>
</html>

