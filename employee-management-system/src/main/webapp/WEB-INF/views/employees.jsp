<%@ page isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Employees</title>

<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">

<style>
    body {
        background: #f8f9fa;
        height: 100vh;
        margin: 0;
        overflow: hidden;  /* 🚫 PAGE SCROLL DISABLED */
    }

    .page-box {
        width: 90%;
        max-width: 1100px;
        height: 95vh;     /* Page fits perfectly */
        margin: auto;
        display: flex;
        flex-direction: column;
    }

    .header-box {
        text-align: center;
        padding: 10px 0;
    }

    /* 🔥 MAKE TABLE AREA SCROLLABLE, NOT PAGE */
    .table-box {
        flex-grow: 1;
        overflow-y: auto;       /* Only table scrolls */
        border: 1px solid #ddd;
        background: white;
        margin-top: 10px;
        padding: 5px;
        border-radius: 6px;
    }

    table {
        font-size: 14px;
    }

    th, td {
        padding: 6px !important;   /* Reduce height */
        white-space: nowrap;
    }

    .action-btns a {
        padding: 2px 8px !important;
        font-size: 12px;
    }
</style>

</head>
<body>

<div class="page-box">

    <!-- 🔷 HEADER -->
    <div class="header-box">
        <h4 class="text-primary">Employee List</h4>

        <c:if test="${!empty msg}">
            <div class="alert alert-info py-1 my-2">${msg}</div>
        </c:if>

        <!-- Search Employee by ID -->
        <form action="search" method="get" class="d-flex justify-content-center" style="max-width: 350px; margin:auto;">
            <input type="number" name="id" class="form-control form-control-sm me-2"
                   placeholder="Enter Employee ID" required>

            <button class="btn btn-primary btn-sm">Search</button>
        </form>
    </div>

    <!-- 🔷 TABLE BOX (scrolls internally) -->
    <div class="table-box">
        <table class="table table-bordered table-striped text-center mb-0">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Salary</th>
                    <th>Email</th>
                    <th>Department</th>
                    <th>Action</th>
                </tr>
            </thead>

            <tbody>
            <c:choose>
                <c:when test="${!empty employeeList}">
                    <c:forEach var="employee" items="${employeeList}">
                        <tr>
                            <td>${employee.empId}</td>
                            <td>${employee.name}</td>
                            <td>${employee.salary}</td>
                            <td>${employee.email}</td>
                            <td>${employee.department.deptName}</td>

                            <td class="action-btns">
                                <a href="update?empId=${employee.empId}" 
                                   class="btn btn-warning btn-sm">Edit</a>

                                <a href="delete?empId=${employee.empId}" 
                                   class="btn btn-danger btn-sm"
                                   onclick="return confirm('Are you sure to delete?')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>

                <c:otherwise>
                    <tr>
                        <td colspan="6" class="text-danger">No Records Found</td>
                    </tr>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </div>

    <!-- 🔷 FOOTER BUTTONS -->
    <div class="text-center mt-2">
        <a href="add" class="btn btn-success btn-sm m-1">Add Employee</a>
        <a href="./" class="btn btn-secondary btn-sm m-1">Home</a>
    </div>

</div>

</body>
</html>
