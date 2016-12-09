<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>


<h1>Добавление правовой формы</h1>
<form role="form">
  <div class="form-group">
    <label for="legalform">Правовая форма</label>
    <input type="text" class="form-control" id="legalform" placeholder="Введите Правовую форму">
  </div>
    
  <button type="submit" class="btn btn-default">Сохранить</button>
</form>



<%@include file='footer.jsp'%>