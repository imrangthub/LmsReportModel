<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/_partial/_header.jsp" />
<div class="container">
	<!-- Example row of columns -->
	<div class="row">
	
	<h1 align="center">========= Jasper  Report =========</h1>
       <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/report/reportModelOne" role="button">Go to Demo Model</a>
       
       <div class="row">
        <div class="col-md-8 col-md-offset-2 well">
         <table class="table table-hover">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Case No</th>
		      <th scope="col">Loan Name</th>
		      <th scope="col">Loan Type</th>
		      <th scope="col">Branch Name</th>
		      <th scope="col">Date</th>
		      <th scope="col">Amount</th>
		    </tr>
		  </thead>
		  <tbody>
		  
		  <c:forEach items="${loanList}" var="loanObj" varStatus="indexNo">	  
		    <tr>
		      <td>${indexNo.index+1}</td>
		      <td>${loanObj.caseNo }</td>
		      <td>${loanObj.loanName }</td>
		      <td>${loanObj.loanType }</td>
		      <td>${loanObj.branchName }</td>
		      <td>${loanObj.date }</td>
		      <td>${loanObj.amount }</td>
		    </tr>
		  </c:forEach>

		  </tbody>
		</table>
        </div>
       </div>


	</div>
	<jsp:include page="/WEB-INF/views/_partial/_footerMenu.jsp" />
</div>
<!-- /container -->
<jsp:include page="/WEB-INF/views/_partial/_footer.jsp" />