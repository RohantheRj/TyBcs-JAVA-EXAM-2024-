<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*" %>

<%
    // Retrieve username and password from the request
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Check if username and password are the same
    if (username != null && password != null && username.equals(password)) {
        response.sendRedirect("LoginSuccess.html"); // Redirect to LoginSuccess.html
    } else {
        response.sendRedirect("LoginError.html"); // Redirect to LoginError.html
    }
%>

