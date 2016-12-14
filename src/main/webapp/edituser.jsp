<%@page import="com.kg.testjsfa8h4.entity.Groups"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="showGroupsBean" class="com.kg.testjsfa8h4.beans.GroupsBean" scope="application" />
<jsp:useBean id="user" class="com.kg.testjsfa8h4.beans.UsersBean" scope="application" /> 

<h1>Редактирование пользователя <%= request.getParameter("id")%></h1>
<% user.setId(Integer.valueOf(request.getParameter("id")));
    user.returnUserById(); %>
<form role="form" action="editusersave" method="post">
    <div class="form-group">
        <label for="login">Логин</label>
        <input type="text" class="form-control" id="login" name="login" value="<% out.print(user.getLogin()); %>" placeholder="Введите логин">
    </div>
    <div class="form-group">
        <label for="password">Пароль</label>
        <input type="password" class="form-control" id="password" name="password" value="<% out.print(user.getPassword()); %>" placeholder="Введите пароль">
    </div>
    <div class="form-group">
        <label for="fio">ФИО</label>
        <input type="text" class="form-control" id="fio" name="fio" value="<% out.print(user.getFio()); %>" placeholder="Введите ФИО">
    </div>
    <div class="form-group">
        <label for="phone">Телефон</label>
        <input type="text" class="form-control" id="phone" name="phone" value="<% out.print(user.getPhoneNumber()); %>" placeholder="Введите телефон">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" id="email" name="email" value="<% out.print(user.getEmail()); %>" placeholder="Введите email">
    </div>
    <div class="form-group">
        <label for="email">Группа</label>
        <select class="form-control" id="group" name="group" placeholder="Выберите группу">
            <% for (Groups g : showGroupsBean.returnAllGroups()) { %>
            <% if (g.getIdAccess().equals(user.getId())) { %>
            <option selected="selected" value="<%out.print(g.getIdAccess());%>"><%out.print(g.getPrivelege());%></option>
            <% } else { %>
            <option value="<%out.print(g.getIdAccess());%>"><%out.print(g.getPrivelege());%></option>
            <% }
            } %>
        </select>
    </div>
    <input type="hidden" name="id" value="<% out.print(request.getParameter("id"));%>"/>
    <button type="submit" class="btn btn-default" id="submit">Сохранить</button>
</form>


<%@include file='footer.jsp'%>