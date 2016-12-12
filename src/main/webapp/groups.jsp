<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file='header.jsp'%>
<jsp:useBean id="showGroupsBean" class="com.kg.testjsfa8h4.beans.GroupsBean" scope="request" />

<h1>Группы</h1>

          <h2 class="sub-header">Группы</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Краткое название</th>
                  <th>Описание</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1,001</td>
                  <td>Lorem</td>
                  <td>ipsum</td>
                </tr>
                <tr>
                  <td>1,002</td>
                  <td>amet</td>
                  <td>consectetur</td>
                </tr>
                
              </tbody>
            </table>
          </div>
          
          
          <c:forEach items="${showGroupsBean.returnAllGroups()}" var="list">
            <tr>
                <td>${list.getId()}</td>
                <td>${list.getPrivelege()}</td>
                <td>${list.getDescription()}</td>
            </tr>
          </c:forEach>

<a href="addgroup.jsp" class="btn btn-primary">Добавить группу</a>


<%@include file='footer.jsp'%>