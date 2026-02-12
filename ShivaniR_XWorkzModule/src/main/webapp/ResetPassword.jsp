<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reset Password</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #0a1f44, #132f63);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .card {
            border-radius: 12px;
            box-shadow: 0 12px 30px rgba(0,0,0,0.25);
        }

        .card-header {
            background-color: #0a1f44;
            color: white;
            border-radius: 12px 12px 0 0;
        }

        .form-control:focus {
            border-color: #0a1f44;
            box-shadow: 0 0 0 0.2rem rgba(10, 31, 68, 0.25);
        }

        .btn-success {
            background-color: #198754;
            border: none;
            font-weight: 600;
        }

        .btn-success:hover {
            background-color: #157347;
        }

        .email-box {
            background-color: #f1f4f9;
            border-radius: 6px;
            padding: 10px;
            font-weight: 600;
            color: #0a1f44;
            text-align: center;
        }
    </style>
</head>

<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-4">

            <div class="card">
                <div class="card-header text-center">
                    <h4 class="mb-0">Reset Your Password</h4>
                </div>

                <div class="card-body">

                    <!-- EMAIL DISPLAY -->
                    <div class="mb-3">
                        <div class="email-box">
                            ${email}
                        </div>
                    </div>

                    <!-- RESET FORM -->
                    <form action="resetPassword" method="post">

                        <!-- REQUIRED: HIDDEN EMAIL -->
                        <input type="hidden" name="email" value="${email}" />

                        <div class="mb-3">
                            <label class="form-label">New Password</label>
                            <input type="password"
                                   name="password"
                                   class="form-control"
                                   placeholder="Enter new password"
                                   required />
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Confirm Password</label>
                            <input type="password"
                                   name="confirmPassword"
                                   class="form-control"
                                   placeholder="Re-enter password"
                                   required />
                        </div>

                        <button type="submit" class="btn btn-success w-100">
                            Reset Password
                        </button>
                    </form>

                    <!-- ERROR MESSAGE -->
                    <c:if test="${not empty errorMsg}">
                        <p class="text-danger text-center mt-3">
                            ${errorMsg}
                        </p>
                    </c:if>

                </div>
            </div>

            <!-- TEMP DEBUG (REMOVE LATER) -->
            <p class="text-center mt-3 text-warning fw-bold">
                DEBUG EMAIL JSP = ${email}
            </p>

        </div>
    </div>
</div>

</body>
</html>
