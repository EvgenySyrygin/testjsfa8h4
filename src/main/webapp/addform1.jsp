<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>


<h1>Добавление формы 1</h1>
<form role="form">
  <div class="form-group">
    <label for="owntype">Форма собственности</label>
    <input type="text" class="form-control" id="owntype" placeholder="Введите Форма собственности">
  </div>
  <div class="form-group">
    <label for="legalform">Правовая форма</label>
    <input type="text" class="form-control" id="legalform" placeholder="Введите Правовая форма">
  </div>
  <div class="form-group">
    <label for="orgname">Название организации</label>
    <input type="text" class="form-control" id="orgname" placeholder="Введите Название организации">
  </div>
  <div class="form-group">
    <label for="fiohead">ФИО руководителя</label>
    <input type="text" class="form-control" id="fiohead" placeholder="Введите ФИО руководителя">
  </div>
  <div class="form-group">
    <label for="fax">Факс</label>
    <input type="text" class="form-control" id="fax" placeholder="Введите Факс">
  </div>
  <div class="form-group">
    <label for="phone">Телефон</label>
    <input type="text" class="form-control" id="phone" placeholder="Введите Телефон">
  </div>
  <div class="form-group">
    <label for="webpage">Веб-страница</label>
    <input type="text" class="form-control" id="webpage" placeholder="Введите Веб-страница">
  </div>
  <div class="form-group">
    <label for="licensenumber">Номер лизенции (уникальный)</label>
    <input type="email" class="form-control" id="licensenumber" placeholder="Введите Номер лизенции (уникальный)">
  </div>
  <div class="form-group">
    <label for="licensenumberdate">Дата получения лицензии</label>
    <input type="text" class="form-control" id="licensenumberdate" placeholder="Введите Дата получения лицензии">
  </div>
  <div class="form-group">
    <label for="certificatenumber">Номер свидетельства</label>
    <input type="text" class="form-control" id="certificatenumber" placeholder="Введите Номер свидетельства">
  </div>
  <div class="form-group">
    <label for="certificatenumberdate">Дата получения свидетельства</label>
    <input type="text" class="form-control" id="certificatenumberdate" placeholder="Введите Дата получения свидетельства">
  </div>
  <div class="form-group">
    <label for="address">Адрес</label>
    <input type="text" class="form-control" id="address" placeholder="Введите Адрес">
  </div>
  <div class="form-group">
    <label for="files">Файлы для прикрепления(при необходимости)</label>
    <input type="text" class="form-control" id="files" placeholder="Введите Файлы для прикрепления(при необходимости)">
  </div>
  <div class="form-group">
    <label for="employees">Список сотрудников</label>
    <input type="text" class="form-control" id="employees" placeholder="Введите Список сотрудников">
  </div>
    
  <button type="submit" class="btn btn-default">Сохранить</button>
</form>



<%@include file='footer.jsp'%>