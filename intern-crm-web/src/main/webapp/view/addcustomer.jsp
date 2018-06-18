<%--
  Created by IntelliJ IDEA.
  User: Tuyen
  Date: 6/18/2018
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Customer</title>
    <style type="text/css">
        .a{
            margin-top: 30px;
            width: 800px;
        }
        h2{
            margin-left: 20px;
        }
    </style>
</head>
<body>
    <div class="a">
        <h2>Add customer</h2>
    <div class="col-auto">
    <form:form>
        <div class="form-group col-md-10">
            <label for="formGroupExampleInput">Name</label>
            <input type="text" class="form-control" id="formGroupExampleInput" placeholder="name">
            <label for="formGroupExampleInput2">Age</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="age">
            <label for="formGroupExampleInput2">Phone</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="phone">
            <label for="formGroupExampleInput2">Company</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="company">
            <label for="formGroupExampleInput2">Facebook</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="facebook">
            <label for="formGroupExampleInput2">Email</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Email">
            <label class="mr-sm-2" for="inlineFormCustomSelect">Product type</label>
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                <option selected>Choose...</option>
                <option value="1">offsource</option>
                <option value="2">odc</option>
            </select>
            <br/>
            <div class="col-auto my-1">
                <button type="submit" class="btn btn-primary mb-2">Add</button>
            </div>
        </div>
    </form:form>
    </div>
    </div>
</body>
</html>
