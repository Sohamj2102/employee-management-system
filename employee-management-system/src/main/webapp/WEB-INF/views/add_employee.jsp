<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>

<!-- Minimal Bootstrap -->
<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">

<style>
    body {
        padding: 10px;          /* small padding */
        background: #f7f7f7;
    }
    .form-box {
        max-width: 450px;       /* small width */
        margin: auto;           /* center on screen */
        padding: 20px;
        background: white;
        border-radius: 8px;
        border: 1px solid #ddd;
    }
</style>
</head>

<body>

<div class="form-box">

    <h5 class="text-center mb-3">Add Employee</h5>

    <frm:form action="add" method="post" modelAttribute="employee">

        <!-- NAME -->
        <div class="mb-2">
            <label class="form-label small">Name</label>
            <frm:input path="name" cssClass="form-control form-control-sm"/>
            <frm:errors path="name" cssClass="text-danger small"/>
        </div>

        <!-- SALARY -->
        <div class="mb-2">
            <label class="form-label small">Salary</label>
            <frm:input path="salary" cssClass="form-control form-control-sm"/>
            <frm:errors path="salary" cssClass="text-danger small"/>
        </div>

        <!-- EMAIL -->
        <div class="mb-2">
            <label class="form-label small">Email</label>
            <frm:input path="email" cssClass="form-control form-control-sm"/>
            <frm:errors path="email" cssClass="text-danger small"/>
        </div>

        <!-- DEPARTMENT -->
        <div class="mb-2">
            <label class="form-label small">Department</label><br>

            <c:forEach var="dept" items="${deptList}">
                <label class="small me-3">
                    <input type="radio" name="deptId" value="${dept.deptId}"> 
                    ${dept.deptName}
                </label>
            </c:forEach>

            <frm:errors path="deptId" cssClass="text-danger small"/>
        </div>

        <!-- BUTTONS -->
        <div class="text-center mt-3">
            <button type="submit" class="btn btn-primary btn-sm">Save</button>
            <a href="${pageContext.request.contextPath}/" class="btn btn-secondary btn-sm">Back</a>
        </div>

    </frm:form>

</div>

</body>
</html>
