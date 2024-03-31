<%-- 
    Document   : Validation
    Author     : jfalkowski
    Description: JSP page to display the validation result.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Id Number Validator Result</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 40px;
            text-align: center;
            background-color: #e8e8e8;
        }

        h1 {
            color: #333;
        }

        div.result {
            max-width: 500px;
            margin: 0 auto;
            border-radius: 10px;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <h1>Id Number Validator Result</h1>
    <div class="result">
        <p>${requestScope.validationResult}</p>
    </div>
</body>
</html>
