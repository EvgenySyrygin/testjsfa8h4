<%@page import="com.kg.testjsfa8h4.entity.Form1"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="form1Bean" class="com.kg.testjsfa8h4.beans.Form1Bean" scope="application" />

<h1>Добавление файла к фомер 1</h1>
<form role="form" action="addusersave" method="post">
    <div class="form-group">
        <label for="form1">Форма 1</label>
        <select class="form-control" id="form1" name="form1" placeholder="Выберите форму 1">
            <% for (Form1 f : form1Bean.returnAllForm1()) { %>
            <option value="<%out.print(f.getId());%>"><%out.print(f.getFioHead());%></option>
            <% }%>
        </select>
    </div>
    <div class="form-group">
        <label for="file">Файл</label>
        <input type="file" id="file" name="file" placeholder="Выберите файл">
    </div>
    

    <button type="submit" class="btn btn-default" id="submit">Сохранить</button>
</form>


<%@include file='footer.jsp'%>