<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Voter Eligibility Result</title>
</head>
<body>
    <h1>Voter Eligibility Result</h1>

    <%

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));


        boolean isEligible = (age >= 18);


        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Age: " + age + "</p>");

        if (isEligible) {
            out.println("<p>Congratulations! You are eligible to vote.</p>");
        } else {
            out.println("<p>Sorry! You are not eligible to vote.</p>");
        }
    %>
</body>
</html>

