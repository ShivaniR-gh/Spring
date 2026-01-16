<!DOCTYPE html>
<html>
<head>
    <title>Xworkz | Home</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            padding-top: 80px;
            background-color: #f4f6f9;
        }

        /* Navbar */
        .navbar-custom {
            background: linear-gradient(90deg, #0f2027, #203a43, #2c5364);
        }

        .navbar-brand span {
            font-size: 22px;
            font-weight: 700;
            letter-spacing: 1px;
            color: #ffffff;
        }

        .btn-signin {
            border: 1px solid #ffffff;
            color: #ffffff;
            border-radius: 20px;
            padding: 6px 16px;
            margin-right: 10px;
        }

        .btn-signup {
            background-color: #ffc107;
            color: #000;
            border-radius: 20px;
            padding: 6px 16px;
        }

        /* Layout */
        .main-section {
            min-height: calc(100vh - 80px);
            display: flex;
            align-items: center;
        }

        /* LEFT PANEL */
        .left-panel {
            animation: slideLeft 1.2s ease;
        }

        .left-panel h2 {
            font-weight: 700;
            color: #203a43;
        }

        .tech {
            display: inline-block;
            background: #203a43;
            color: white;
            padding: 6px 14px;
            border-radius: 20px;
            font-size: 14px;
            margin: 5px 5px 0 0;
        }

        /* RIGHT PANEL */
        .right-panel {
            animation: slideRight 1.2s ease;
        }

        /* Animations */
        @keyframes slideLeft {
            from { opacity: 0; transform: translateX(-60px); }
            to { opacity: 1; transform: translateX(0); }
        }

        @keyframes slideRight {
            from { opacity: 0; transform: translateX(60px); }
            to { opacity: 1; transform: translateX(0); }
        }
    </style>
</head>

<body>

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top shadow">
    <div class="container-fluid">
        <a class="navbar-brand d-flex align-items-center" href="home">
            <img src="${pageContext.request.contextPath}/Xworkz.png" width="42" height="42" class="me-2">
            <span>XWORKZ</span>
        </a>
        <div class="ms-auto">
           <a href="signup" class="btn btn-signup">Sign Up</a>
           <a href="signin" class="btn btn-signin">Sign In</a>
        </div>
    </div>
</nav>
</body>
</html>
