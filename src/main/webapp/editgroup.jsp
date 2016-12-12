<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>


<h1>Добавление Группы</h1>
<form role="form" action="addgroupsave" method="post">
  <div class="form-group">
    <label for="group">Группа</label>
    <input type="text" class="form-control" id="group" name="group" placeholder="Введите имя групппы">
  </div>
  <div class="form-group">
    <label for="description">Описание группы</label>
    <input type="text" class="form-control" id="description" name="description" placeholder="Введите описание группы">
  </div>
    
  <button type="submit" class="btn btn-default">Сохранить</button>
</form>



<%@include file='footer.jsp'%>