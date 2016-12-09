<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>


<h1>Добавление формы собственности</h1>
<form role="form">
  <div class="form-group">
    <label for="owntype">Форма собственности</label>
    <input type="text" class="form-control" id="owntype" placeholder="Введите форму собственности">
  </div>
      
  <button type="submit" class="btn btn-default">Сохранить</button>
</form>



<%@include file='footer.jsp'%>