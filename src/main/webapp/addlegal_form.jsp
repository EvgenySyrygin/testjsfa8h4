<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>


<h1>Добавление правовой формы</h1>
<form role="form" action="addlegalformsave" method="post" accept-charset="UTF-8">
    <div class="form-group">
        <label for="legalform">Правовая форма</label>
        <input type="text" class="form-control" id="legalform" name="legalform" placeholder="Введите Правовую форму">
    </div>

    <button type="submit" class="btn btn-default">Сохранить</button>
</form>



<%@include file='footer.jsp'%>