<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sum of First and Last Digit</title>
    <style>
        .red {
            color: red;
            font-size: 18px;
        }
    </style>
</head>
<body>
    <h1>Sum of First and Last Digit</h1>
    
    <form method="post">
        Enter a number: <input type="text" name="number">
        <input type="submit" value="Calculate">
    </form>

    <%
        if (request.getMethod().equals("POST")) {
            // Retrieve the number from the form
            String numberStr = request.getParameter("number");

            if (numberStr != null && !numberStr.isEmpty()) {
                // Parse the input number as an integer
                int number = Integer.parseInt(numberStr);

                // Calculate the first and last digits
                int firstDigit = 0;
                int lastDigit = number % 10;

                while (number != 0) {
                    firstDigit = number % 10;
                    number /= 10;
                }

                // Calculate the sum of the first and last digits
                int sum = firstDigit + lastDigit;

                // Display the result in red color with font size 18
    %>
                <p>Number: <%= numberStr %></p>
                <p class="red">Sum of First and Last Digit: <%= sum %></p>
    <%
            } else {
    %>
                <p class="red">Please enter a valid number.</p>
    <%
            }
        }
    %>
</body>
</html>

