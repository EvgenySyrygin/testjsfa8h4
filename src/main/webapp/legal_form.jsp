<%@page import="com.kg.testjsfa8h4.entity.LegalForm"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="showLegalF" class="com.kg.testjsfa8h4.beans.LegalFormBean" scope="application" />

 <h2 class="sub-header">Правовая форма</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Правовая формы</th>
                </tr>
              </thead>
              <tbody>
                  <% for(LegalForm l : showLegalF.returnLegalForm()) { %>
                <tr>
                  <td><%out.print(l.getId());%></td>
                  <td><%out.print(l.getLegalForm());%></td>
                  <td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Edit">
                            <a href="editlegal_form.jsp?id=<%out.print(l.getId());%>" class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal">
                                <span class="glyphicon glyphicon-pencil"></span></a></p></td>
                    <td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Delete">
                                <a href="deletelegalformsave?id=<%out.print(l.getId());%>" class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal">
                                <span class="glyphicon glyphicon-trash"></span></a></p></td>
                </tr>
                <% } %>
                
              </tbody>
            </table>
          </div>

        <a href="addlegal_form.jsp" class="btn btn-primary">Добавить правовую форму</a>

<%@include file='footer.jsp'%>