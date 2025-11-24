<%@ page isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Employees</title>

<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">

</head>
<body class="bg-light">

<!-- 🔥 Center whole content perfectly -->
<div class="d-flex justify-content-center">
    <div class="container mt-4" style="max-width: 1100px;">

        <h2 class="text-center mb-4">Employee List</h2>

        <c:if test="${!empty msg}">
            <div class="alert alert-info text-center">${msg}</div>
        </c:if>

        <table class="table table-bordered table-striped text-center">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Salary</th>
                    <th>Email</th>
                    <th>Department</th>
                    <th>Actions</th>
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

                            <td>
                                <div class="d-flex gap-2 justify-content-center">
                                    <a href="update?empId=${employee.empId}" 
                                       class="btn btn-warning btn-sm">Edit</a>

                                    <a href="delete?empId=${employee.empId}" 
                                       class="btn btn-danger btn-sm"
                                       onclick="return confirm('Are you sure to delete?')">Delete</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>

                <c:otherwise>
                    <tr>
                        <td colspan="6" class="text-center text-danger">
                            No Records Found
                        </td>
                    </tr>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>

        <div class="text-center mt-4">
            <a href="add" class="btn btn-success m-2">Add Employee</a>
            <a href="./" class="btn btn-secondary m-2">Home</a>
        </div>

    </div>
</div>

</body>
</html>
