<%--
  Created by IntelliJ IDEA.
  User: valdy
  Date: 07/05/2024
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<tg:template title="Catégorie">
    <jsp:attribute name="content">
        <div class="row p-4">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <div class="row">
                            <div class="col-10 mt-2">
                                <h3 class="card-title">Categories</h3>
                            </div>
                            <div class="col-2">
                                <a type="button" class="btn float-right btn-primary"
                                   href="${pageContext.request.contextPath}/category/create"> <i
                                        class="fa fa-plus"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">

                        <div class="d-flex justify-content-between p-2">
                            <div>
                                <select name="size" class="form-control">
                                    <option value="5">5</option>
                                    <option value="10">10</option>
                                    <option value="20">20</option>
                                </select>
                            </div>
                            <div>
                                <input type="text" name="param" id="param" class="form-control col-12 float-right"
                                       placeholder="Search..."/>
                            </div>
                        </div>

                        <c:if test="${not empty requestScope.message}">
                            <div class="alert alert-success alert-dismissible fade show" role="alert">
                                <p>${requestScope.message}</p>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </c:if>

                        <table class="table table-bordered table-striped">
                            <thead>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Actions</th>
                            </thead>
                            <tbody>

                            </tr>

                            <c:forEach var="c" items="${categories}">

                            <tr>
                                <td>${c.id}</td>
                                <td>${c.name}</td>
                                <td>${c.description}</td>

                                <td>
                                </td>
                            </tr>
                             </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </jsp:attribute>
</tg:template>