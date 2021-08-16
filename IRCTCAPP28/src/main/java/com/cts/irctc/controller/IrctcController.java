package com.cts.irctc.controller;
import com.cts.irctc.service.*;
import com.cts.irctc.model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.irctc.exception.ApplicationException;
import com.cts.irctc.model.TicketBooking;
import com.cts.irctc.model.TrainInfo;
import com.cts.irctc.service.IrctcService;

@Controller
public class IrctcController {
	@Autowired
	private IrctcService service;

	
	@Autowired
	public IrctcController(IrctcService service) {
		super();
		this.service = service;
	}

	
	@RequestMapping("/showTicketBookingForm")
	public String showTicketBookingForm(@ModelAttribute("ticketBooking1") TicketBooking ticketBook) throws ApplicationException {
		//ticketBook.getCustomerName()
		ModelAndView modelAndView = new ModelAndView();    
		modelAndView.setViewName("ticketBooking1");  
		modelAndView.addObject("ticketBook", ticketBook);  

		 return "ticketBooking";
		
	}
	
	
	@RequestMapping("/getTicketBookingResultpage")
	public String getTicketBookingResultpage(@Valid @ModelAttribute("ticketBooking1") TicketBooking ticketBook,BindingResult result, ModelMap map) throws ApplicationException
	{
		if(result.hasErrors())
		{
		return "ticketBooking";
		}
		//System.out.println(ticketBooking.getCustomerName()+"2")
		TrainInfo ti= service.getTicketBookingResult(ticketBook);
	
	   map.addAttribute("pnr",ticketBook.getPnrNumber());
	   map.addAttribute("tno", ti.getTrainNumber());
	   map.addAttribute("tname", ti.getTrainName());
	   map.addAttribute("dot", ticketBook.getDateOfTravel());
	   map.addAttribute("dept", ti.getDeparture());
	   map.addAttribute("dur", ti.getDuration());
	   map.addAttribute("arr", ti.getArrival());
	   map.addAttribute("fare", ti.getFarePerPassenger() * ticketBook.getNoOfTickets());
		if(ti == null)
		{
			return "trainNotAvailable";
		}
		else
		{
			/*
			 * ModelAndView mv= new ModelAndView(); mv.addObject(ti);
			 */
			return "ticketBookingResult";
		}
		
	
	}
	  
	
	@ModelAttribute("from")
	public List<String> populateFromCities() {
		List<String> fromCities = new ArrayList<String>();

		 fromCities.add("Chennai"); 
		  fromCities.add("Delhi"); 
		  fromCities.add("Bangalore"); 
		  fromCities.add("Pune");
				
		return fromCities;
	}
	
	@ModelAttribute("to")
	public List<String> populateToCities() {
		List<String> toCities = new ArrayList<String>();
		 
		  toCities.add("Chennai"); 
		  toCities.add("Delhi");
		  toCities.add("Bangalore"); 
		  toCities.add("Pune");		 	
		
		return toCities;
	}
	
	@ModelAttribute("classType")
	public List<String> populateClassType() {
		List<String> classTypes = new ArrayList<String>();
		  
		 classTypes.add("AC First Class (1A)");
		  classTypes.add("AC 2 Tier (2A)"); 
		  classTypes.add("AC 3 Tier (3A)");
		  classTypes.add("Sleeper (SL)"); 
		  classTypes.add("Second Sitting (2S)"); 
		  
			
		return classTypes;
	}
	
	
}
