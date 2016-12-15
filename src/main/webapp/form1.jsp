<%@page import="com.kg.testjsfa8h4.entity.Form1"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="showForm1" class="com.kg.testjsfa8h4.beans.Form1Bean" scope="application" />


<h2 class="sub-header">Форма 1</h2>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>#</th>
                <th>Форма собственности</th>
                <th>Правовая форма</th>
                <th>Название организации</th>
                <th>ФИО руководителя</th>
                <th>Факс</th>
                <th>Телефон</th>
                <th>Веб-страница</th>
                <th>Номер лизенции (уникальный)</th>
                <th>Дата получения лицензии</th>
                <th>Номер свидетельства</th>
                <th>Дата получения свидетельства</th>
                <th>Адрес</th>
                <th>Файлы</th>
                <th>Сотрудники</th>
            </tr>
        </thead>
        <tbody>
            <% for (Form1 f1 : showForm1.returnAllForm1()) { %>
            <tr>
                <td><%out.print(f1.getId());%></td>
                <td><%out.print(f1.getOwnType().getOwnType());%></td>
                <td><%out.print(f1.getLegalForm().getLegalForm());%></td>
                <td><%out.print(f1.getOrgName());%></td>
                <td><%out.print(f1.getFioHead());%></td>
                <td><%out.print(f1.getFax());%></td>
                <td><%out.print(f1.getPhone());%></td>
                <td><%out.print(f1.getWebPage());%></td>
                <td><%out.print(f1.getLicenseNumber());%></td>
                <td><%out.print(f1.getLicenseDate());%></td>
                <td><%out.print(f1.getCertificateNumber());%></td>
                <td><%out.print(f1.getCertificateDate());%></td>
                <td><%out.print(f1.getAddress());%></td>
                <td><%out.print(f1.getIdFiles());%></td>
                <td><%out.print(f1.getIdEmployesList());%></td>
                <td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Edit">
                        <a href="editform1.jsp?id=<%out.print(f1.getId());%>" class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal">
                            <span class="glyphicon glyphicon-pencil"></span></a></p></td>
                <td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Delete">
                        <a href="deleteform1save?id=<%out.print(f1.getId());%>" class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal">
                            <span class="glyphicon glyphicon-trash"></span></a></p></td>
            </tr>

            <% }%>
        </tbody>
    </table>
</div>



<a href="addform1.jsp" class="btn btn-primary">Добавить форму 1</a>

<%@include file='footer.jsp'%>