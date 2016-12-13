<%@page import="com.kg.testjsfa8h4.entity.OwnType"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="showOt" class="com.kg.testjsfa8h4.beans.OwnTypeBean" scope="application" />

          <h2 class="sub-header">Форма собственности</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Форма собственности</th>
                </tr>
              </thead>
              <tbody>
                  <% for(OwnType o : showOt.returnAllOwnType()) { %>
                <tr>
                  <td><%out.print(o.getId());%></td>
                  <td><%out.print(o.getOwnType());%></td>
                  <td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Edit">
                            <a href="editown_type.jsp?id=<%out.print(o.getId());%>" class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal">
                                <span class="glyphicon glyphicon-pencil"></span></a></p></td>
                    <td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Delete">
                                <a href="deleteowntypesave?id=<%out.print(o.getId());%>" class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal">
                                <span class="glyphicon glyphicon-trash"></span></a></p></td>
                </tr>
                <% } %>
              </tbody>
            </table>
          </div>

<a href="addown_type.jsp" class="btn btn-primary">Добавить форму собственности</a>



<%@include file='footer.jsp'%>