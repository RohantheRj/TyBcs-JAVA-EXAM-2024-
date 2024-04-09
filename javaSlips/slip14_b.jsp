<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sum of First and Last Digit</title>
</head>
<body>
    <h2>Calculate Sum of First and Last Digit</h2>
    
    <% 

        String numberStr = request.getParameter("number");


        if (numberStr != null && !numberStr.isEmpty()) {
            try {

                int number = Integer.parseInt(numberStr);


                int lastDigit = number % 10;
                int firstDigit = 0;


                while (number != 0) {
                    firstDigit = number % 10;
                    number /= 10;
                }


                int sum = firstDigit + lastDigit;


    %>
                <p style="color: red; font-size: 18px;">
                    Sum of First and Last Digit of <%= number %> is: <%= sum %>
                </p>
    <% 
            } catch (NumberFormatException e) {

    %>
                <p style="color: red; font-size: 18px;">
                    Invalid input. Please enter a valid number.
                </p>
    <% 
            }
        }
    %>

    <form method="post">
        Enter a number: <input type="text" name="number">
        <input type="submit" value="Calculate">
    </form>
</body>
</html>

