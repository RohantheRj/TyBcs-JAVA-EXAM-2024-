<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reverse String</title>
</head>
<body>
    <h1>Reverse String</h1>
    
    <form method="post">
        Enter a string: <input type="text" name="inputString">
        <input type="submit" value="Reverse">
    </form>

    <%
        if (request.getMethod().equals("POST")) {
            // Retrieve the input string from the form
            String inputString = request.getParameter("inputString");

            // Check if the input string is not null
            if (inputString != null && !inputString.isEmpty()) {
                // Reverse the input string
                String reversedString = new StringBuilder(inputString).reverse().toString();

                // Display the reversed string
    %>
                <p>Original String: <%= inputString %></p>
                <p>Reversed String: <%= reversedString %></p>
    <%
            } else {
    %>
                <p>Please enter a valid string.</p>
    <%
            }
        }
    %>
</body>
</html>

