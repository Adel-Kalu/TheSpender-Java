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
import com.ga.thespender.dao.LastSpendDao;
import com.ga.thespender.model.LastSpend;

//simply return the object and data written into HTTP response as JSON
//@CrossOrigin(origins = "https://pages.git.generalassemb.ly/adel-kalu/The-Spender/")
@RestController
public class LastSpendController {
	
	@Autowired
	private LastSpendDao dao;

// HTTP POST REQUEST - LastSpend Add
	@PostMapping("/lastSpend/add")
	 public HashMap<String, String> addLastSpend(@RequestBody LastSpend lastSpend) {
		 HashMap<String, String> response = new HashMap<String, String>();
		 dao.save(lastSpend); 
		 response.put("message", "LastSpend adding successfully");
		 return response;	 
	 }

// HTTP GET REQUEST - LastSpend Index
	@GetMapping("/lastSpend/index")
	public Iterable<LastSpend> getLastSpend() {
		var it = dao.findAll();
		return it;
	}

// HTTP GET REQUEST - LastSpend Detail
	@GetMapping("/lastSpend/detail")
	public LastSpend lastSpendDetails(@RequestParam int id) {
		System.out.println(id);
		LastSpend lastSpend = dao.findById(id);
		return lastSpend;
	}



	// HTTP GET REQUEST - User Edit
	@PutMapping("/lastSpend/edit")
	 public HashMap<String, String> editLastSpend(@RequestBody LastSpend lastSpend) {
		 HashMap<String, String> response = new HashMap<String, String>();
		 dao.save(lastSpend); 
		 response.put("message", "LastSpend editing successfully");
		 return response;	 
	 }
	
// HTTP GET REQUEST - LastSpend Delete
	@DeleteMapping("/lastSpend/delete")
	public boolean deleteLastSpend(@RequestParam int id) {
		LastSpend lastSpend = dao.findById(id);
		dao.deleteById(id);
		return true;
	}

}
