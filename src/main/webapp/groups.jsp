<%@page import="com.kg.testjsfa8h4.entity.Groups"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="showGroupsBean" class="com.kg.testjsfa8h4.beans.GroupsBean" scope="application" />

<h2 class="sub-header">Группы</h2>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>#</th>
                <th>Краткое название</th>
                <th>Описание</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <% for (Groups g : showGroupsBean.returnAllGroups()) { %>
            <tr>
                <td><%out.print(g.getIdAccess());%></td>
                <td><%out.print(g.getPrivelege());%></td>
                <td><%out.print(g.getDescription());%></td>
                <td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Edit">
                        <a href="editgroup.jsp?id=<%out.print(g.getIdAccess());%>" class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal">
                            <span class="glyphicon glyphicon-pencil"></span></a></p></td>
                <td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Delete">
                        <a href="deletegroupsave?id=<%out.print(g.getIdAccess());%>" class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal">
                            <span class="glyphicon glyphicon-trash"></span></a></p></td>
            </tr>
            <% }%>
        </tbody>
    </table>
</div>
<a href="addgroup.jsp" class="btn btn-primary">Добавить группу</a>


<%@include file='footer.jsp'%>