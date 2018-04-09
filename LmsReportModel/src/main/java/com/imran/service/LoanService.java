package com.imran.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.imran.model.Loan;

@Service
public class LoanService {
	
	public List<Loan> loanList(){
		List<Loan> loanList = Arrays.asList(
				  new Loan(1, "LMS-90988", "Car Loan", "carLoan","farmgate",  new Date(), 232323d),
				  new Loan(2, "LMS-90989", "Home Loan", "homeLoan","kawranBazar",  new Date(), 32323d),
				  new Loan(3, "LMS-90991", "Car Loan", "carLoan","shabug",  new Date(), 9899888d),
				  new Loan(4, "LMS-90992", "Education Loan", "educationLoan","dhanmondi",new Date(), 23232d),
				  new Loan(5, "LMS-90993", "Car Loan", "caroLoan","dhanmondi",  new Date(), 878778d)
				);
		

		

		return loanList;		
	}
	
	public List<Loan> filteringByBranchName(List<Loan> loanList, String branchName){
		List<Loan> filteratedList = new ArrayList<>();		
		
		// filtering by branch  
		if(branchName.equals("farmgate")) {
			filteratedList =  loanList.stream()  
		                .filter(p ->p.getBranchName().equals("farmgate"))   
		                .collect(Collectors.toList()); 
		}else if(branchName.equals("kawranBazar")){
			filteratedList =  loanList.stream()  
		                .filter(p ->p.getBranchName().equals("kawranBazar"))   
		                .collect(Collectors.toList());
		}else if(branchName.equals("shabug")){
			filteratedList =  loanList.stream()  
		                .filter(p ->p.getBranchName().equals("shabug"))   
		                .collect(Collectors.toList());
		}else if(branchName.equals("dhanmondi")){
			filteratedList =  loanList.stream()  
	                .filter(p ->p.getBranchName().equals("dhanmondi"))   
	                .collect(Collectors.toList());
		}else {
			filteratedList = loanList;
		}
		
		
		return filteratedList;
	}
	
	public List<Loan> filteringByLoanType(List<Loan> loanList, String typeName){
		List<Loan> filteratedList = new ArrayList<>();		
		// filtering loan type  
		if(typeName.equals("carLoan")) {
			filteratedList =  loanList.stream()  
		                .filter(p ->p.getLoanType().equals("carLoan"))   
		                .collect(Collectors.toList()); 
		}else if(typeName.equals("homeLoan")){
			filteratedList =  loanList.stream()  
		                .filter(p ->p.getLoanType().equals("homeLoan"))   
		                .collect(Collectors.toList());
		}else if(typeName.equals("educationLoan")){
			filteratedList =  loanList.stream()  
		                .filter(p ->p.getLoanType().equals("educationLoan"))   
		                .collect(Collectors.toList());
		}else {
			filteratedList = loanList;
		}
		
		
		return filteratedList;
	}

}
