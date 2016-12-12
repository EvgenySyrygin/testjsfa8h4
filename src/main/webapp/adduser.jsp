<%@page import="com.kg.testjsfa8h4.entity.Groups"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="showGroupsBean" class="com.kg.testjsfa8h4.beans.GroupsBean" scope="application" />

<jsp:useBean id="users" 
                    class="com.kg.testjsfa8h4.beans.UsersBean"> 
  
</jsp:useBean>

<h1>Добавление пользователей</h1>
<form role="form" action="addusersave" method="post">
  <div class="form-group">
    <label for="login">Логин</label>
    <input type="text" class="form-control" id="login" name="login" placeholder="Введите логин">
  </div>
  <div class="form-group">
    <label for="password">Пароль</label>
    <input type="password" class="form-control" id="password" name="password" placeholder="Введите пароль">
  </div>
  <div class="form-group">
    <label for="fio">ФИО</label>
    <input type="text" class="form-control" id="fio" name="fio" placeholder="Введите ФИО">
  </div>
  <div class="form-group">
    <label for="phone">Телефон</label>
    <input type="text" class="form-control" id="phone" name="phone" placeholder="Введите телефон">
  </div>
  <div class="form-group">
    <label for="email">Email</label>
    <input type="email" class="form-control" id="email" name="email" placeholder="Введите email">
  </div>
  <div class="form-group">
    <label for="email">Группа</label>
      <select class="form-control" id="group" name="group" placeholder="Выберите группу">
        <% for(Groups g : showGroupsBean.returnAllGroups()) { %>
        <option value="<%out.print(g.getId());%>"><%out.print(g.getPrivelege());%></option>
        <% } %>
      </select>
  </div>
    
  <button type="submit" class="btn btn-default" id="submit">Сохранить</button>
</form>


<%@include file='footer.jsp'%>