<%@page import="com.kg.testjsfa8h4.entity.LegalForm"%>
<%@page import="com.kg.testjsfa8h4.entity.OwnType"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="legalForm" class="com.kg.testjsfa8h4.beans.LegalFormBean" scope="application" />
<jsp:useBean id="ownType" class="com.kg.testjsfa8h4.beans.OwnTypeBean" scope="application"/> 
<jsp:useBean id="form1" class="com.kg.testjsfa8h4.beans.Form1Bean" scope="application"/> 

<script type="text/javascript" src="js/moment-with-locales.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" />

<h1>Редактирование формы 1 <%= request.getParameter("id")%></h1>
<% form1.setId(Integer.valueOf(request.getParameter("id")));
    form1.returnForm1ById(); %>
<form role="form" action="editform1save" method="post" accept-charset="UTF-8">
    <div class="form-group">
        <label for="owntype">Форма собственности</label>
        <select class="form-control" id="owntype" name="owntype" placeholder="Выберите Форма собственности">
            <% for (OwnType ot : ownType.returnAllOwnType()) { %>
            <% if (ot.getId().equals(form1.getId())) { %>
            <option selected="selected" value="<%out.print(ot.getId());%>"><%out.print(ot.getOwnType());%></option>
            <% } else { %>
            <option value="<%out.print(ot.getId());%>"><%out.print(ot.getOwnType());%></option>
            <% }
            } %>
        </select>
    </div>
    <div class="form-group">
        <label for="legalform">Правовая форма</label>
        <select class="form-control" id="legalform" name="legalform" placeholder="Выберите Правовая форма">
            <% for (LegalForm lf : legalForm.returnLegalForm()) { %>
            <% if (lf.getId().equals(form1.getId())) { %>
            <option selected="selected" value="<%out.print(lf.getId());%>"><%out.print(lf.getLegalForm());%></option>
            <% } else { %>
            <option value="<%out.print(lf.getId());%>"><%out.print(lf.getLegalForm());%></option>
            <% }
            } %>
        </select>
    </div>
    <div class="form-group">
        <label for="orgname">Название организации</label>
        <input type="text" class="form-control" id="orgname" name="orgname" value="<% out.print(form1.getOrgName()); %>" placeholder="Введите Название организации">
    </div>
    <div class="form-group">
        <label for="fiohead">ФИО руководителя</label>
        <input type="text" class="form-control" id="fiohead" name="fiohead" value="<% out.print(form1.getFioHead()); %>" placeholder="Введите ФИО руководителя">
    </div>
    <div class="form-group">
        <label for="fax">Факс</label>
        <input type="text" class="form-control" id="fax" name="fax" value="<% out.print(form1.getFax()); %>" placeholder="Введите Факс">
    </div>
    <div class="form-group">
        <label for="phone">Телефон</label>
        <input type="text" class="form-control" id="phone" name="phone" value="<% out.print(form1.getPhone()); %>" placeholder="Введите Телефон">
    </div>
    <div class="form-group">
        <label for="webpage">Веб-страница</label>
        <input type="text" class="form-control" id="webpage" name="webpage" value="<% out.print(form1.getWebPage()); %>" placeholder="Введите Веб-страница">
    </div>
    <div class="form-group">
        <label for="licensenumber">Номер лизенции (уникальный)</label>
        <input type="text" class="form-control" id="licensenumber" name="licensenumber" value="<% out.print(form1.getLicenseNumber()); %>" placeholder="Введите Номер лизенции (уникальный)">
    </div>
    <div class="form-group">
        <label for="licensenumberdate">Дата получения лицензии</label>
        <div class="input-group date" id="datetimepicker1">
            <input type="text" class="form-control" id="licensenumberdate" name="licensenumberdate" value="<% out.print(form1.getLicenseDate()); %>" placeholder="Введите Дата получения лицензии"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
    </div>
    <div class="form-group">
        <label for="certificatenumber">Номер свидетельства</label>
        <input type="text" class="form-control" id="certificatenumber" name="certificatenumber" value="<% out.print(form1.getCertificateNumber()); %>" placeholder="Введите Номер свидетельства">
    </div>
    <div class="form-group">
        <label for="certificatenumberdate">Дата получения свидетельства</label>
        <div class="input-group date" id="datetimepicker2">
            <input type="text" class="form-control" id="certificatenumberdate" name="certificatenumberdate" value="<% out.print(form1.getCertificateDate()); %>" placeholder="Введите Дата получения свидетельства"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
    </div>
    <div class="form-group">
        <label for="address">Адрес</label>
        <input type="text" class="form-control" id="address" name="address" value="<% out.print(form1.getAddress()); %>" placeholder="Введите Адрес">
    </div>
    <div class="form-group">
        <label for="files">Файлы для прикрепления(при необходимости)</label>
        <input type="text" class="form-control" id="files" name="files" value="<% out.print(form1.getIdFiles()); %>" placeholder="Введите Файлы для прикрепления(при необходимости)">
    </div>
    <div class="form-group">
        <label for="employees">Список сотрудников</label>
        <input type="text" class="form-control" id="employees" name="employees" value="<% out.print(form1.getIdEmployesList()); %>" placeholder="Введите Список сотрудников">
    </div>
    <input type="hidden" name="id" value="<% out.print(request.getParameter("id"));%>"/>
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