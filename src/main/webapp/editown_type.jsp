<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="ot" class="com.kg.testjsfa8h4.beans.OwnTypeBean" scope="application" />

<h1>Редактирование формы собственности <%= request.getParameter("id") %></h1>
<% ot.setId(Integer.valueOf(request.getParameter("id")));
    ot.returnOwnTypeById();%>
<form role="form" action="editowntypesave" method="post" accept-charset="UTF-8">
  <div class="form-group">
    <label for="owntype">Форма собственности</label>
    <input type="text" class="form-control" id="owntype" name="owntype" value="<% out.print(ot.getOwnType()); %>" placeholder="Введите форму собственности">
  </div>
  <input type="hidden" name="id" value="<% out.print(request.getParameter("id")); %>"/>
  <button type="submit" class="btn btn-default">Сохранить</button>
</form>



<%@include file='footer.jsp'%>