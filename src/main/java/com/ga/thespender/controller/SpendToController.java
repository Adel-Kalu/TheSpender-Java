package com.ga.thespender.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ga.thespender.dao.SpendToDao;
import com.ga.thespender.model.SpendTo;

//simply return the object and data written into HTTP response as JSON
//@CrossOrigin(origins = "https://pages.git.generalassemb.ly/adel-kalu/The-Spender/")
@RestController
public class SpendToController {
	
	@Autowired
	private SpendToDao dao;

// HTTP POST REQUEST - SpendTo Add
	@PostMapping("/spendTo/add")
	 public HashMap<String, String> addSpendTo(@RequestBody SpendTo spendTo) {
		 HashMap<String, String> response = new HashMap<String, String>();
		 dao.save(spendTo); 
		 response.put("message", "SpendTo adding successfully");
		 return response;	 
	 }

// HTTP GET REQUEST - SpendTo Index
	@GetMapping("/spendTo/index")
	public Iterable<SpendTo> getSpendTo() {
		var it = dao.findAll();
		return it;
	}

// HTTP GET REQUEST - SpendTo Detail
	@GetMapping("/spendTo/detail")
	public SpendTo spendToDetails(@RequestParam int id) {
		System.out.println(id);
		SpendTo spendTo = dao.findById(id);
		return spendTo;
	}



	// HTTP GET REQUEST - User Edit
	@PutMapping("/spendTo/edit")
	 public HashMap<String, String> editSpendTo(@RequestBody SpendTo spendTo) {
		 HashMap<String, String> response = new HashMap<String, String>();
		 dao.save(spendTo); 
		 response.put("message", "SpendTo editing successfully");
		 return response;	 
	 }
	
// HTTP GET REQUEST - SpendTo Delete
	@DeleteMapping("/spendTo/delete")
	public boolean deleteSpendTo(@RequestParam int id) {
		SpendTo spendTo = dao.findById(id);
		dao.deleteById(id);
		return true;
	}

}
