<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>


<h1>Добавление Сотрдуника</h1>
<form role="form">
  <div class="form-group">
    <label for="fid">Ид формы</label>
    <input type="text" class="form-control" id="fid" placeholder="Ид формы">
  </div>
  <div class="form-group">
    <label for="fio">ФИО</label>
    <input type="text" class="form-control" id="fio" placeholder="Введите ФИО">
  </div>
  <div class="form-group">
    <label for="hphone">Домашний телефон</label>
    <input type="text" class="form-control" id="hphone" placeholder="Введите Домашний телефон">
  </div>
  <div class="form-group">
    <label for="mphone">Мобильный телефон</label>
    <input type="text" class="form-control" id="mphone" placeholder="Введите Мобильный телефон">
  </div>
  <div class="form-group">
    <label for="wphone">Рабочий телефон</label>
    <input type="text" class="form-control" id="wphone" placeholder="Введите Рабочий телефон">
  </div>
  <div class="form-group">
    <label for="haddress">Домашний адрес</label>
    <input type="text" class="form-control" id="haddress" placeholder="Введите Домашний адрес">
  </div>
  <div class="form-group">
    <label for="email">Почта</label>
    <input type="email" class="form-control" id="email" placeholder="Введите email">
  </div>
  <div class="form-group">
    <label for="email">Банковские реквизиты</label>
    <input type="text" class="form-control" id="email" placeholder="Введите Банковские реквизиты">
  </div>
  <div class="form-group">
    <label for="position">Должность</label>
    <input type="text" class="form-control" id="position" placeholder="Введите Должность">
  </div>
    
  <button type="submit" class="btn btn-default">Сохранить</button>
</form>



<%@include file='footer.jsp'%>