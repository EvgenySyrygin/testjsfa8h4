<%@page import="com.kg.testjsfa8h4.entity.Form1"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="from1Bean" class="com.kg.testjsfa8h4.beans.Form1Bean" scope="application"/> 

<h1>Добавление Сотрдуника</h1>
<form role="form" action="addemployesave" method="post">
    <div class="form-group">
        <label for="fid">Ид формы 1</label>
        <select class="form-control" id="fid" name="fid" placeholder="Ид формы 1">
            <% for (Form1 f : from1Bean.returnAllForm1()) { %>
            <option value="<%out.print(f.getId());%>"><%out.print(f.getFioHead());%></option>
            <% }%>
        </select>
    </div>
    <div class="form-group">
        <label for="fio">ФИО</label>
        <input type="text" class="form-control" id="fio" name="fio" placeholder="Введите ФИО">
    </div>
    <div class="form-group">
        <label for="hphone">Домашний телефон</label>
        <input type="text" class="form-control" id="hphone" name="hphone" placeholder="Введите Домашний телефон">
    </div>
    <div class="form-group">
        <label for="mphone">Мобильный телефон</label>
        <input type="text" class="form-control" id="mphone" name="mphone" placeholder="Введите Мобильный телефон">
    </div>
    <div class="form-group">
        <label for="wphone">Рабочий телефон</label>
        <input type="text" class="form-control" id="wphone" name="wphone" placeholder="Введите Рабочий телефон">
    </div>
    <div class="form-group">
        <label for="haddress">Домашний адрес</label>
        <input type="text" class="form-control" id="haddress" name="haddress" placeholder="Введите Домашний адрес">
    </div>
    <div class="form-group">
        <label for="email">Почта</label>
        <input type="text" class="form-control" id="email" name="email" placeholder="Введите email">
    </div>
    <div class="form-group">
        <label for="bankr">Банковские реквизиты</label>
        <input type="text" class="form-control" id="bankr" name="bankr" placeholder="Введите Банковские реквизиты">
    </div>
    <div class="form-group">
        <label for="position">Должность</label>
        <input type="text" class="form-control" id="position" name="position" placeholder="Введите Должность">
    </div>

    <button type="submit" class="btn btn-default">Сохранить</button>
</form>



<%@include file='footer.jsp'%>