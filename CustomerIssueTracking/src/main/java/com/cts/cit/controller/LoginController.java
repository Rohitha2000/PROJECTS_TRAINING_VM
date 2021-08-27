package com.cts.cit.controller;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cts.cit.dao.CustomerRepo;
//import com.cts.cit.dao.CustomerRepo;
import com.cts.cit.exception.ApplicationException;
import com.cts.cit.model.CCRepresentative;
import com.cts.cit.model.Customer;
import com.cts.cit.model.IssueDetail;
import com.cts.cit.service.CustomerIssueService;
//import com.cts.cit.service.CustomerIssueService;



@Controller
public class LoginController

{
	
	
	int iss;

	public int issueid() {
		iss = (int) (Math.random() * (1000) + 1000);
		return iss;
	}

	int issueid = issueid();
	int resultIssue;
	
  @Autowired
  CustomerRepo repo;
	
	
	  @Autowired CustomerIssueService custService;
	 
	@Autowired 
	  public LoginController(CustomerIssueService service, Validator validator) {
	  System.out.println("in parametized constr of controller with validator");
	  this.custService=service; this.validator=validator; }
	
	
	@Autowired
	private Validator validator;
	
	IssueDetail issue = new IssueDetail();

	@RequestMapping(value="/login1", method=RequestMethod.GET)
		public String showLoginPage(@ModelAttribute("customer") Customer customer )
	{
		
			
		return "customerform";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showCustomerPage(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,
			ModelMap map) throws ApplicationException

	{
		String cid = customer.getCustId();
		issue.setCustId(cid);
	
		map.addAttribute("id", customer.getCustId());
		System.out.println("after form:.  " + customer.getCustId());
		System.out.println("cust id:  "+ issue.getCustId());
		if (result.hasErrors()) {
			return "customerform";
		}

		return "login";
	}
	
	
	@GetMapping(value="/customerform")
	public String showCustomerForm(@ModelAttribute("IssueDetail") IssueDetail issueDetail, 
			Customer customer, ModelMap modelMap,@RequestParam("issueId") String issue_id,
			@RequestParam("radioName") String radioName) throws ApplicationException {

		String raise="raise";
		String view="view";
		System.out.println("radioname"+ radioName);
		String id = customer.getCustId();
		issueDetail.setCustId(id);
		System.out.println("calling..."+issueid());
	     resultIssue=issueid();
	     System.out.println("resis init  "+resultIssue);
		issue.setCustIssueId(resultIssue);
        
		modelMap.addAttribute("iid", issue.getCustId());
		System.out.println("custid:  " + issue.getCustId());
		modelMap.addAttribute("isid", issue.getCustIssueId());
		System.out.println("iss id: " + issue.getCustIssueId());
		System.out.println("raise iss:  " + issue.getCustId());
		
		
		if(radioName.equals(raise)) {
			System.out.println("raise");
			return "raiseissue";
		} 
		else if(radioName.equals(view)){
			System.out.println("view");
			IssueDetail isdd= issueResult(Integer.valueOf(issue_id));
			modelMap.addAttribute("idd", isdd.getCustIssueId());
			modelMap.addAttribute("irp", isdd.getIssueReportDate());
		modelMap.addAttribute("cid", isdd.getCustId());
		System.out.println("cid"+ isdd.getCustId());
		modelMap.addAttribute("cat", isdd.getCategory());
		modelMap.addAttribute("des", isdd.getDescription());
		modelMap.addAttribute("stat", isdd.getIssueStatus());
		modelMap.addAttribute("rep", isdd.getCcRepId());		
		//System.out.println("Model Map :: " + modelMap);  
			return "customerissue";
		}
		else if(radioName.equals(null))
		{
			return "error1";
		}
		return "error1";
	}
		
	
	
	 @RequestMapping(value="/customerPage")
		public String customerPage() {
			return "login";
		}
		
	 @PostMapping(path="/issueraised")
		public String addIssue(@Valid @ModelAttribute("IssueDetail") IssueDetail issueDetail,
				BindingResult result,
				Customer customer, Model map) {
			System.out.println("issue raised");
			
			if (result.hasErrors()) {
				map.addAttribute("iid",issue.getCustId() );
				map.addAttribute("isid", issue.getCustIssueId());
				return "raiseissue";
			}
			
			String idd = issue.getCustId();
			issueDetail.setCustId(idd);
		
			issueDetail.setCustIssueId(	resultIssue);
			
			map.addAttribute("custid", customer);
			repo.save(issueDetail); // saving record in table
			return "issueraised";
		}
	
		
	 public IssueDetail issueResult(
				int custIssueId) {
			System.out.println("retrieval :  " + custIssueId);
			IssueDetail issueRetrieved = repo.findById(custIssueId).get(); // retrieve from table
			
			System.out.println("retrieved issue :: " + issueRetrieved);
			return issueRetrieved; //returning record

		}
	

}
