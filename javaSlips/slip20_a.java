<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Number to Words Converter</title>
</head>
<body>
    <h1>Number to Words Converter</h1>
    
    <form method="post">
        Enter a number: <input type="text" name="number">
        <input type="submit" value="Convert">
    </form>

    <%-- Convert number to words --%>
    <%@ page import="java.util.Scanner" %>
    <%
        String numberStr = request.getParameter("number");

        if (numberStr != null && !numberStr.isEmpty()) {
            int number = Integer.parseInt(numberStr);
            String words = convertNumberToWords(number);
    %>

    <h2 style="color: red;">Number in Words: <%= words %></h2>

    <% } %>

    <%!

        public String convertNumberToWords(int number) {
            String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
            String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
            String[] thousands = {"", "Thousand", "Million", "Billion"};

            String words = "";

            int i = 0;
            while (number > 0) {
                if (number % 1000 != 0) {
                    words = convertLessThanThousand(number % 1000, units, tens) + thousands[i] + " " + words;
                }
                number /= 1000;
                i++;
            }

            return words.trim();
        }

        public String convertLessThanThousand(int number, String[] units, String[] tens) {
            String current;

            if (number % 100 < 20) {
                current = units[number % 100];
                number /= 100;
            } else {
                current = units[number % 10];
                number /= 10;

                current = tens[number % 10] + " " + current;
                number /= 10;
            }

            if (number == 0) {
                return current;
            }

            return units[number] + " Hundred " + current;
        }
    %>
</body>
</html>

