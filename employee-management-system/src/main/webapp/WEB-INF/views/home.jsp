<%@ page  isELIgnored="false"  pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management System - Home</title>

<!-- Optional: Bootstrap for better UI -->
<link rel="stylesheet" 
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">

</head>
<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow-lg">
        <div class="card-body text-center">

            <h3 class="mb-4 text-primary">Employee Management System</h3>
            <hr/>

            <!-- Add Employee -->
            <a href="add" 
               class="btn btn-success btn-lg m-2">
               Add Employee
            </a>

            <!-- View Employees -->
            <a href="employees" 
               class="btn btn-primary btn-lg m-2">
                View Employees
            </a>

        </div>
    </div>

</div>

</body>
</html>

