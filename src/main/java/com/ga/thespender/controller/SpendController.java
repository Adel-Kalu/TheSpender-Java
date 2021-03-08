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
import com.ga.thespender.dao.SpendDao;
import com.ga.thespender.model.Spend;

//simply return the object and data written into HTTP response as JSON
//@CrossOrigin(origins = "https://pages.git.generalassemb.ly/adel-kalu/The-Spender/")
@RestController
public class SpendController {
	
	@Autowired
	private SpendDao dao;

// HTTP POST REQUEST - Spend Add
	@PostMapping("/spend/add")
	 public HashMap<String, String> addSpend(@RequestBody Spend spend) {
		 HashMap<String, String> response = new HashMap<String, String>();
		 dao.save(spend); 
		 response.put("message", "Spend adding successfully");
		 return response;	 
	 }

// HTTP GET REQUEST - Spend Index
	@GetMapping("/spend/index")
	public Iterable<Spend> getSpend() {
		var it = dao.findAll();
		return it;
	}

// HTTP GET REQUEST - Spend Detail
	@GetMapping("/spend/detail")
	public Spend spendDetails(@RequestParam int id) {
		System.out.println(id);
		Spend spend = dao.findById(id);
		return spend;
	}



	// HTTP GET REQUEST - User Edit
	@PutMapping("/spend/edit")
	 public HashMap<String, String> editSpend(@RequestBody Spend spend) {
		 HashMap<String, String> response = new HashMap<String, String>();
		 dao.save(spend); 
		 response.put("message", "Spend editing successfully");
		 return response;	 
	 }
	
// HTTP GET REQUEST - Spend Delete
	@DeleteMapping("/spend/delete")
	public boolean deleteSpend(@RequestParam int id) {
		Spend spend = dao.findById(id);
		dao.deleteById(id);
		return true;
	}

}
