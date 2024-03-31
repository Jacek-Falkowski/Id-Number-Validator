<%-- 
    Document   : History
    Author     : jfalkowski
    Description: JSP page to display the operation history.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.model.HistoryObject" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Operation History</title>
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

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: #fff;
        }
    </style>
</head>
<body>
    <h1>History</h1>
    <table>
        <thead>
            <tr>
                <th>Input Number</th>
                <th>Decoded Data</th>
            </tr>
        </thead>
        <tbody>
            <% 
            List<HistoryObject> historyObjectList = (List<HistoryObject>) request.getAttribute("history");
            if (historyObjectList != null && !historyObjectList.isEmpty()) {
                for (HistoryObject hisObj : historyObjectList) { 
            %>
            <tr>
                <td><%= hisObj.getInputNumber() %></td>
                <td><%= hisObj.getDecodedData() %></td>
            </tr>
            <% 
                } 
            }
            %>
        </tbody>
    </table>
</body>
</html>
