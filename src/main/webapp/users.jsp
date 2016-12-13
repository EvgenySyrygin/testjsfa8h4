<%@page import="com.kg.testjsfa8h4.entity.Users"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="showUsersBean" class="com.kg.testjsfa8h4.beans.UsersBean" scope="application" />

<h1>Пользователи системы</h1>
          <h2 class="sub-header">Section title</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Логин</th>
                  <th>ФИО</th>
                  <th>Группа</th>                  
                </tr>
              </thead>
              <tbody>
                <% for(Users u : showUsersBean.returnAllUsers()) { %>
                <tr>
                    <td><%out.print(u.getId());%></td>
                    <td><%out.print(u.getLogin());%></td>
                    <td><%out.print(u.getFio());%></td>
                    <td><%out.print(u.getIdAccess());%></td>
                    <td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Edit">
                            <a href="edituser.jsp?id=<%out.print(u.getId());%>" class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal">
                                <span class="glyphicon glyphicon-pencil"></span></a></p></td>
                    <td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Delete">
                                <a href="deleteusersave?id=<%out.print(u.getId());%>" class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal">
                                <span class="glyphicon glyphicon-trash"></span></a></p></td>
                </tr>
                <% } %>
              </tbody>
            </table>
          </div>

<a href="adduser.jsp" class="btn btn-primary">Добавить пользователя</a>

<%@include file='footer.jsp'%>