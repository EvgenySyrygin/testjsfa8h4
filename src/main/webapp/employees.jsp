<%@page import="com.kg.testjsfa8h4.entity.EmployesList"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="showEmployes" class="com.kg.testjsfa8h4.beans.EmployesBean" scope="application" />

<h2 class="sub-header">Сотрудники</h2>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>#</th>
                <th>Фирма</th>
                <th>ФИО</th>
                <th>Домашний телефон</th>                  
                <th>Мобильный телефон</th>                  
                <th>Рабочий телефон</th>                  
                <th>Домашний адрес</th>                  
                <th>Почта</th>                  
                <th>Банковские реквизиты</th>                  
                <th>Должность</th>                  
            </tr>
        </thead>
        <tbody>
            <% for (EmployesList e : showEmployes.returnAllEmployesList()) { %>
            <tr>
                <td><%out.print(e.getId());%></td>
                <td><%out.print(e.getIdForm1());%></td>
                <td><%out.print(e.getFio());%></td>
                <td><%out.print(e.getPhoneHome());%></td>
                <td><%out.print(e.getPhoneMobile());%></td>
                <td><%out.print(e.getPhoneWork());%></td>
                <td><%out.print(e.getHomeAddress());%></td>
                <td><%out.print(e.getMail());%></td>
                <td><%out.print(e.getBankDetails());%></td>
                <td><%out.print(e.getPosition());%></td>
                <td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Edit">
                        <a href="editemployee.jsp?id=<%out.print(e.getId());%>" class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal">
                            <span class="glyphicon glyphicon-pencil"></span></a></p></td>
                <td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Delete">
                        <a href="deleteemployesave?id=<%out.print(e.getId());%>" class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal">
                            <span class="glyphicon glyphicon-trash"></span></a></p></td>
            </tr>
            <% }%>
        </tbody>
    </table>
</div>

<a href="addemployee.jsp" class="btn btn-primary">Добавить Сотрудника</a>

<%@include file='footer.jsp'%>