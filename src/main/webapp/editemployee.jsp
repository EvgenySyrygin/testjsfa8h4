<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="empl" class="com.kg.testjsfa8h4.beans.EmployesBean" scope="application" /> 

<h1>Редактирование Сотрдуника <%= request.getParameter("id")%></h1>
<% empl.setId(Integer.valueOf(request.getParameter("id")));
    empl.returnEmployeById(); %>
<form role="form" action="addemployesave" method="post">
    <div class="form-group">
        <label for="fid">Ид формы</label>
        <input type="text" class="form-control" id="fid" name="fid" value="<% out.print(empl.getIdForm1()); %>" placeholder="Ид формы">
    </div>
    <div class="form-group">
        <label for="fio">ФИО</label>
        <input type="text" class="form-control" id="fio" name="fio" value="<% out.print(empl.getFio()); %>" placeholder="Введите ФИО">
    </div>
    <div class="form-group">
        <label for="hphone">Домашний телефон</label>
        <input type="text" class="form-control" id="hphone" name="hphone" value="<% out.print(empl.getPhoneHome()); %>" placeholder="Введите Домашний телефон">
    </div>
    <div class="form-group">
        <label for="mphone">Мобильный телефон</label>
        <input type="text" class="form-control" id="mphone" name="mphone" value="<% out.print(empl.getPhoneMobile()); %>" placeholder="Введите Мобильный телефон">
    </div>
    <div class="form-group">
        <label for="wphone">Рабочий телефон</label>
        <input type="text" class="form-control" id="wphone" name="wphone" value="<% out.print(empl.getPhoneWork()); %>" placeholder="Введите Рабочий телефон">
    </div>
    <div class="form-group">
        <label for="haddress">Домашний адрес</label>
        <input type="text" class="form-control" id="haddress" name="haddress" value="<% out.print(empl.getHomeAddress()); %>" placeholder="Введите Домашний адрес">
    </div>
    <div class="form-group">
        <label for="email">Почта</label>
        <input type="text" class="form-control" id="email" name="email" value="<% out.print(empl.getMail()); %>" placeholder="Введите email">
    </div>
    <div class="form-group">
        <label for="bankr">Банковские реквизиты</label>
        <input type="text" class="form-control" id="bankr" name="bankr" value="<% out.print(empl.getBankDetails()); %>" placeholder="Введите Банковские реквизиты">
    </div>
    <div class="form-group">
        <label for="position">Должность</label>
        <input type="text" class="form-control" id="position" name="position" value="<% out.print(empl.getPosition());%>" placeholder="Введите Должность">
    </div>

    <button type="submit" class="btn btn-default">Сохранить</button>
</form>



<%@include file='footer.jsp'%>