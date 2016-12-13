<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="legalF" class="com.kg.testjsfa8h4.beans.LegalFormBean" scope="application" />

<h1>Редактирование правовой формы <%= request.getParameter("id") %></h1>
<% legalF.setId(Integer.valueOf(request.getParameter("id")));
    legalF.returnLegalFormById();%>
<form role="form" action="editlegalformsave" method="post" accept-charset="UTF-8">
  <div class="form-group">
    <label for="legalform">Правовая форма</label>
    <input type="text" class="form-control" id="legalform" name="legalform" value="<% out.print(legalF.getLegalForm()); %>" placeholder="Введите Правовую форму">
  </div>
  <input type="hidden" name="id" value="<% out.print(request.getParameter("id")); %>"/>
  <button type="submit" class="btn btn-default">Сохранить</button>
</form>



<%@include file='footer.jsp'%>