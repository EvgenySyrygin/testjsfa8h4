<%@page import="com.kg.testjsfa8h4.entity.LegalForm"%>
<%@page import="com.kg.testjsfa8h4.entity.OwnType"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="legalForm" class="com.kg.testjsfa8h4.beans.LegalFormBean" scope="application" />
<jsp:useBean id="ownType" class="com.kg.testjsfa8h4.beans.OwnTypeBean" scope="application"/> 

<script type="text/javascript" src="js/moment-with-locales.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" />

<h1>Добавление формы 1</h1>
<form role="form" action="addform1save" method="post" accept-charset="UTF-8">
    <div class="form-group">
        <label for="owntype">Форма собственности</label>
        <select class="form-control" id="owntype" name="owntype" placeholder="Выберите Форма собственности">
            <% for (OwnType ot : ownType.returnAllOwnType()) { %>
            <option value="<%out.print(ot.getId());%>"><%out.print(ot.getOwnType());%></option>
            <% } %>
        </select>
    </div>
    <div class="form-group">
        <label for="legalform">Правовая форма</label>
        <select class="form-control" id="legalform" name="legalform" placeholder="Выберите Правовая форма">
            <% for (LegalForm lf : legalForm.returnLegalForm()) { %>
            <option value="<%out.print(lf.getId());%>"><%out.print(lf.getLegalForm());%></option>
            <% }%>
        </select>
    </div>
    <div class="form-group">
        <label for="orgname">Название организации</label>
        <input type="text" class="form-control" id="orgname" name="orgname" placeholder="Введите Название организации">
    </div>
    <div class="form-group">
        <label for="fiohead">ФИО руководителя</label>
        <input type="text" class="form-control" id="fiohead" name="fiohead" placeholder="Введите ФИО руководителя">
    </div>
    <div class="form-group">
        <label for="fax">Факс</label>
        <input type="text" class="form-control" id="fax" name="fax" placeholder="Введите Факс">
    </div>
    <div class="form-group">
        <label for="phone">Телефон</label>
        <input type="text" class="form-control" id="phone" name="phone" placeholder="Введите Телефон">
    </div>
    <div class="form-group">
        <label for="webpage">Веб-страница</label>
        <input type="text" class="form-control" id="webpage" name="webpage" placeholder="Введите Веб-страница">
    </div>
    <div class="form-group">
        <label for="licensenumber">Номер лизенции (уникальный)</label>
        <input type="text" class="form-control" id="licensenumber" name="licensenumber" placeholder="Введите Номер лизенции (уникальный)">
    </div>
    <div class="form-group">
        <label for="licensenumberdate">Дата получения лицензии</label>
        <div class="input-group date" id="datetimepicker1">
            <input type="text" class="form-control" id="licensenumberdate" name="licensenumberdate" placeholder="Введите Дата получения лицензии"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
    </div>
    <div class="form-group">
        <label for="certificatenumber">Номер свидетельства</label>
        <input type="text" class="form-control" id="certificatenumber" name="certificatenumber" placeholder="Введите Номер свидетельства">
    </div>
    <div class="form-group">
        <label for="certificatenumberdate">Дата получения свидетельства</label>
        <div class="input-group date" id="datetimepicker2">
            <input type="text" class="form-control" id="certificatenumberdate" name="certificatenumberdate" placeholder="Введите Дата получения свидетельства"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
    </div>
    <div class="form-group">
        <label for="address">Адрес</label>
        <input type="text" class="form-control" id="address" name="address" placeholder="Введите Адрес">
    </div>
    <div class="form-group">
        <label for="files">Файлы для прикрепления(при необходимости)</label>
        <input type="text" class="form-control" id="files" name="files" placeholder="Введите Файлы для прикрепления(при необходимости)">
    </div>
    <div class="form-group">
        <label for="employees">Список сотрудников</label>
        <input type="text" class="form-control" id="employees" name="employees" placeholder="Введите Список сотрудников">
    </div>

    <button type="submit" class="btn btn-default">Сохранить</button>
</form>

<script type="text/javascript">
    $(function () {
        //Идентификатор элемента HTML (например: #datetimepicker1), для которого необходимо инициализировать виджет "Bootstrap datetimepicker"
        $('#datetimepicker1').datetimepicker({pickTime: false, language: 'ru'});
        $('#datetimepicker2').datetimepicker({pickTime: false, language: 'ru'});
    });
</script>

<%@include file='footer.jsp'%>