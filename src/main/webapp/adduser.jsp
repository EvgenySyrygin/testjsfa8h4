<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>



<form role="form">
  <div class="form-group">
    <label for="login">Логин</label>
    <input type="email" class="form-control" id="login" placeholder="Введите логин">
  </div>
  <div class="form-group">
    <label for="password">Пароль</label>
    <input type="password" class="form-control" id="password" placeholder="Введите пароль">
  </div>
  <div class="form-group">
    <label for="fio">ФИО</label>
    <input type="email" class="form-control" id="fio" placeholder="Введите ФИО">
  </div>
  <div class="form-group">
    <label for="phone">Телефон</label>
    <input type="password" class="form-control" id="phone" placeholder="Введите телефон">
  </div>
  <div class="form-group">
    <label for="email">Email</label>
    <input type="email" class="form-control" id="email" placeholder="Введите email">
  </div>
    
  <button type="submit" class="btn btn-default">Сохранить</button>
</form>



<%@include file='footer.jsp'%>