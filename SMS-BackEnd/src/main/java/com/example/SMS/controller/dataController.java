package com.example.SMS.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import com.example.SMS.entity.data;
import com.example.SMS.exception.ResourceNotFoundException;
import com.example.SMS.repo.dataRepo;
import com.example.SMS.services.dataService;


@RestController
@RequestMapping("/auth/api")
public class dataController {
private dataService ds;
private dataRepo dr;
public dataController(dataService ds,dataRepo dr) {
	super();
	this.ds=ds;
	this.dr=dr;
}

@GetMapping("/Alldata")
public List<data> AllData() {
	return ds.getAllData();
}

@PostMapping("/addData")
public String addNewData(@RequestBody data d) {
	ds.saveData(d);
	return "Added Sucussfully";
}

@PutMapping("/updateData/{id}")
public ResponseEntity<String> updateData(@PathVariable Long id,@RequestBody data dt)throws ResourceNotFoundException{
data d=dr.findById(id).orElseThrow(()->new ResourceNotFoundException("Data does not Exist id:"+id));
d.setName(dt.getName());
d.setAge(dt.getAge());
d.setGender(dt.getGender());
data ud=ds.saveData(d);
return ResponseEntity.ok("Data has been updated sucessfully");
}

@GetMapping("/serachData/{id}")
public data SearchData(@PathVariable Long id) {
	return ds.searchData(id);
}

@DeleteMapping("/delete/{id}")
public void deleteData(@PathVariable Long id) {
	 ds.deleteData(id);
}
}
