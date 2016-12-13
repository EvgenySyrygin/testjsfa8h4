<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="editGroupsBean" class="com.kg.testjsfa8h4.beans.GroupsBean" scope="application" />

<h1>Редактирование Группы <%= request.getParameter("id") %></h1>
<% editGroupsBean.setId(Integer.valueOf(request.getParameter("id")));
    editGroupsBean.returnGroupById(); %>
<form role="form" action="editgroupsave" method="post">
  <div class="form-group">
    <label for="group">Группа</label>
    <input type="text" class="form-control" id="group" name="group" value="<% out.print(editGroupsBean.getPrivelege()); %>" placeholder="Введите имя групппы">
  </div>
  <div class="form-group">
    <label for="description">Описание группы</label>
    <input type="text" class="form-control" id="description" name="description" value="<% out.print(editGroupsBean.getDescription()); %>" placeholder="Введите описание группы">
  </div>
    
  <input type="hidden" name="id" value="<% out.print(request.getParameter("id")); %>"/>
  <button type="submit" class="btn btn-default">Сохранить</button>
</form>



<%@include file='footer.jsp'%>