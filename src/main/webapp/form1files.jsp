<%@page import="com.kg.testjsfa8h4.entity.Form1Files"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="f1fBean" class="com.kg.testjsfa8h4.beans.FormFilesBean" scope="application" />

<h2 class="sub-header">Файлы формы 1</h2>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>#</th>
                <th>Фома</th>
                <th>Имя файла</th>
                <th>Дата</th>                  
            </tr>
        </thead>
        <tbody>
            <% for (Form1Files ff : f1fBean.returnAllForm1Files()) { %>
            <tr>
                <td><%out.print(ff.getId());%></td>
                <td><%out.print(ff.getForm1().getId());%></td>
                <td><%out.print(ff.getFileName());%></td>
                <td><%out.print(ff.getFileDate());%></td>
                <td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Delete">
                        <a href="deleteform1filessave?id=<%out.print(ff.getId());%>" class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal">
                            <span class="glyphicon glyphicon-trash"></span></a></p></td>
            </tr>
            <% }%>
        </tbody>
    </table>
</div>

<a href="addform1files.jsp" class="btn btn-primary">Добавить Файл</a>

<%@include file='footer.jsp'%>