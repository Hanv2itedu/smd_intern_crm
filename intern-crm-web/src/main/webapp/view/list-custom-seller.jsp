<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <div class="title">
        <h2 class="text-muted text-center my-5 h1 font-weight-light">List Customer</h2>
    </div>
    <div class="row  mx-5 mb-3">
        <div class="col-3">
            <div class="input-group">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect03">Options</label>
                </div>
                <select class="custom-select" id="inputGroupSelect03">
                    <option selected>Choose...</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
            </div>
        </div>
        <div class="col-4">
            <div class="input-group">
                <form class="form-inline d-inline form-search float-right ">
                    <input class="form-control" type="text" placeholder="Search">
                    <button class="btn btn-success " type="submit">Search</button>
                </form>
            </div>
        </div>

    </div>

    <!-- Add and Search -->
    <div class="parent">
        <button class="btn btn-success mx-5 my-3 " data-toggle="modal" data-target="#createAccountModal">
            <a href="#" class="btn btn-success fa fa-plus-circle" > Add Customer</a>
        </button>
    </div>
    <!-- Table list seller -->

    <div class="table-seller mx-5">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Work Place</th>
                <th>Phone</th>

                <td></td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${customers}">
            <tr>
                <td><a href="/seller/advisory/${item.id}">${item.name}</a></td>
                <td>${item.company}</td>
                <td>${item.phone}</td>
                <td>
                   <button class="btn btn-info btn btn-primary" data-toggle="modal" data-target="#exampleModal" value="">EDIT</button>
                </td>
                <td>
                    <button class="btn btn-danger">DELETE</button>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">EDIT CUSTOMER</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <label for="formGroupExampleInput">Name</label>
                    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="name" value="">
                    <label for="formGroupExampleInput2">Age</label>
                    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="age" value="">
                    <label for="formGroupExampleInput2">Phone</label>
                    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="phone" value="">
                    <label for="formGroupExampleInput2">Company</label>
                    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="company" value="">
                    <label for="formGroupExampleInput2">Facebook</label>
                    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="facebook" value="">
                    <label for="formGroupExampleInput2">Email</label>
                    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Email" value="">
                    <label class="mr-sm-2" for="inlineFormCustomSelect">Product type</label>
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                        <option selected>Choose...</option>
                        <option value="1">offsource</option>
                        <option value="2">odc</option>
                    </select>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</div>