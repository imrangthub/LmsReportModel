<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/_partial/_header.jsp" />
<div class="container">
	<!-- Example row of columns -->
	<div class="row">
	
	
	
	<h2 align="center">Dynamic report :: Model 01</h2><hr>
<%--        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/static/" role="button">Go to Demo Model</a> --%>
	</div>
	
	<div class="row">
	 <div class="col-md-10 col-md-offset-1 well">

 <form action="${pageContext.request.contextPath}/report/view" method="post" target="blank">
  
 <div class="row">
    <div class="col-md-12" style="width: 128%;">
    <h4><label>Report Manage</label></h4>
		  <div class="row">
		    <div class="col-md-3" style="background-color: skyblue; padding-top: 45px;padding-bottom: 20px; height:300px;margin-right: 20px">
	    	<div class="alert alert-success" role="alert" style="background-color:#337ab7; color:#f5f5f5">Filter Items</div>   
			 <div class="form-group">
			    <label for="filterByBranch">By Branch</label>
			    
			    <select name="filterByBranch" class="form-control" id="filterByBranch">
			      <option value="all">All</option>
			      <option value="farmgate">Farmgate</option>
			      <option value="kawranBazar">kawran bazar</option>
			      <option value="shabug">Shabug</option>
			      <option value="dhanmondi">Dhanmondi</option>
			    </select>
			  </div>
  			  <div class="form-group">
			    <label for="filterByLoanType">By Loan type</label>
			    <select class="form-control" id="filterByLoanType" name="filterByLoanType">
			      <option value="all">All</option>
			      <option value="homeLoan">Home Loan</option>
			      <option value="carLoan">Car Loan</option>
			      <option value="educationLoan">Education Loan</option>
			    </select>
			  </div>	
		    </div>
		    
		    <div class="col-md-3" style="background-color: skyblue; padding-top: 45px;padding-bottom: 20px; height:300px;margin-right: 20px">
		     	<div class="alert alert-success" role="alert" style="background-color:#337ab7; color:#f5f5f5">Showing Column</div>     
		      <div class="form-check">
			    <label class="form-check-label">
			      <input type="checkbox" value="true" name="isCaseNoShow" id="isCaseNoShow"  class="form-check-input" checked="checked">
			      Case No
			    </label>
  			  </div>
  			  <div class="form-check">
			    <label class="form-check-label">
			      <input type="checkbox" value="true" name="loanNameColumn" id="loanNameColumn"  class="form-check-input" checked="checked">
			      Loan Name
			    </label>
  			  </div>	
  			  <div class="form-check">
			    <label class="form-check-label">
			      <input type="checkbox" value="true" name="isLoanTypeShow" value=true id="isLoanTypeShow" class="form-check-input" checked="checked">
			      Loan Type
			    </label>
  			  </div>
  			  <div class="form-check">
			    <label class="form-check-label">
			      <input type="checkbox" value="true" name="isBranchNameShow" id="isBranchNameShow"  class="form-check-input" checked="checked">
			      Branch Name
			    </label>
  			  </div>
  			  <div class="form-check">
			    <label class="form-check-label">
			      <input type="checkbox" value="true" name="isDateShow" id="isDateShow"  class="form-check-input" checked="checked">
			       Date
			    </label>
  			  </div>
  			  <div class="form-check">
			    <label class="form-check-label">
			      <input name="isAmountShow" value="true" type="checkbox" id="isAmountShow"  class="form-check-input" checked="checked">
			      Amount
			    </label>
  			  </div>
		    </div>
		    
		    
      		    <div class="col-md-3" style="background-color: skyblue; padding-top: 45px;padding-bottom: 20px; height:300px;margin-right: 20px">
		     	<div class="alert alert-success" role="alert" style="background-color:#337ab7; color:#f5f5f5">Calcution</div>     
		      <div class="form-check">
			    <label class="form-check-label">
			      <input type="checkbox" value="true" name="isSumShow" id="isSumShow" class="form-check-input">
			      Total Amount
			    </label>
  			  </div>
  			  
  			   <div class="form-check">
			    <label class="form-check-label">
			      <input type="checkbox" value="true"  name="isAverageShow" id="isAverageShow"  class="form-check-input">
			      Average amount
			    </label>
  			  </div>
  			  	
		    </div>
		  </div>
    </div>
  </div>
  
  <hr>
  
    <div class="row">
    <div class="col-md-12">
    
<!--     <label class="form-check-label col-md-4">
      <input name="allData"  id="allData" type="checkbox" class="form-check-input" checked="checked">
      Wide Page
    </label>
    
      <label class="form-check-label col-md-4">
      <input name="documentHeader"  id="documentHeader" type="checkbox" class="form-check-input" checked="checked">
      Landes cap Page
    </label> -->
    
            <div class="col-md-4" style="background-color: skyblue; padding-top: 45px;padding-bottom: 20px;">
         
			  
			    <label for="reportFormate">Report Formate</label>
			    <select class="form-control" id="reportFormate" name="reportFormate">
			      <option value="pdf">PDF (.pdf)</option>
			      <option value="cvs">CVS (.xlsx)</option>
			    </select>
	          </div>
    
    </div>
  </div> 
  
  
  
  <button type="submit" class="btn btn-primary pull-right">Print Report</button>
</form>
         
	 </div>
	</div>
	
	
	
	
	<jsp:include page="/WEB-INF/views/_partial/_footerMenu.jsp" />
</div>
<!-- /container -->
<jsp:include page="/WEB-INF/views/_partial/_footer.jsp" />