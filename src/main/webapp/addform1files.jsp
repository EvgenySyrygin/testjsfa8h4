<%@page import="java.util.List"%>
<%@page import="com.kg.testjsfa8h4.beans.TempForm1FilesBean"%>
<%@page import="com.kg.testjsfa8h4.entity.Form1"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="form1Bean" class="com.kg.testjsfa8h4.beans.Form1Bean" scope="application" />

<h1>Добавление файла к фомер 1</h1>
<div class="jumbotron">
    <h2> Выбор файла </h2>
    <p>Выберите файл и нажмите кнопку добавить.</p>
    <form role="form" action="addform1file" method="post" enctype="multipart/form-data">

        <div class="form-group">
            <label for="file">Файл</label>
            <input type="file" id="file" name="file" placeholder="Выберите файл">
        </div>

        <button type="submit" class="btn btn-default" id="submit">Добавить</button>
    </form>
</div>
<h3>${message}</h3>
<br/>
<br/>
<form role="form" action="addform1filesave" method="post">
    <div class="form-group">
        <label for="form1">Форма 1</label>
        <select class="form-control" id="form1" name="form1" placeholder="Выберите форму 1">
            <% for (Form1 f : form1Bean.returnAllForm1()) { %>
            <option value="<%out.print(f.getId());%>"><%out.print(f.getFioHead());%></option>
            <% }%>
        </select>
    </div>
    <table class="table table-responsive">
        <thead>
            <tr>
                <th>Имя</th>
                <th>Дата</th>  
                <th></th>
            </tr>
        </thead>
        <tbody>
        <% 
            List<TempForm1FilesBean> tf1fBean = (List<TempForm1FilesBean>) request.getSession().getAttribute("loadedFiles");
            if (tf1fBean != null) {
                int i = 0;
                
                for (TempForm1FilesBean t : tf1fBean){
                    i++;
                    %>
                    <tr>
                        <td>
                            <input type="hidden" name="fileName<% out.print(i); %>" value="<% out.print(t.getFileName()); %>">
                            <% out.print(t.getFileName()); %></td>
                        <td><input type="hidden" name="fileDate<% out.print(i); %>" value="<% out.print(t.getFileDate()); %>">
                            <input type="hidden" name="filePath<% out.print(i); %>" value="<% out.print(t.getFilePath()); %>">
                            <% out.print(t.getFileDate()); %></td>
                        <td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Delete">
                            <a href="deleteform1tempfile?file=<%out.print(t.getFileName());%>" class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal">
                            <span class="glyphicon glyphicon-trash"></span></a></p></td>
                    </tr>
                    <%
                }
                %> <input type="hidden" name="fileCount" value="<% out.print(i); %>"> <%
            }  
        %>
        
        </tbody>
    </table>
    <button type="submit" class="btn btn-success" id="submit">Сохранить</button>
</form>
        

<%@include file='footer.jsp'%>