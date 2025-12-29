<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Registration Successful</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f6fc;
        }
        .card {
            width: 450px;
            margin: 100px auto;
            padding: 30px;
            background: #ffffff;
            border-radius: 8px;
            text-align: center;
            box-shadow: 0 4px 12px rgba(0,0,0,0.15);
        }
        h2 {
            color: green;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: white;
            background: #007bff;
            padding: 10px 18px;
            border-radius: 5px;
        }
        a:hover {
            background: #0056b3;
        }
    </style>
</head>

<body>

<div class="card">
    <h2>Registration Successful</h2>

    <p>Your job seeker account has been created successfully.</p>

    <a href="<%= request.getContextPath() %>/">Go to Home</a>
    <br><br>
    <a href="<%= request.getContextPath() %>/getAll">View All Job Seekers</a>
</div>

</body>
</html>
