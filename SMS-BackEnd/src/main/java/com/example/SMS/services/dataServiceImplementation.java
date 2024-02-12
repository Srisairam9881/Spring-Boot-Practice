package com.example.SMS.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SMS.entity.data;
import com.example.SMS.repo.dataRepo;

@Service
public class dataServiceImplementation implements dataService{

	private dataRepo dr;
	
	public dataServiceImplementation(dataRepo dr) {
		super();
		this.dr = dr;
	}

	@Override
	public List<data> getAllData() {
		// TODO Auto-generated method stub
		return dr.findAll();
	}

	@Override
	public data saveData(data d) {
		// TODO Auto-generated method stub
		return dr.save(d);
	}

	@Override
	public data updateData(data d) {
		// TODO Auto-generated method stub
		return dr.save(d);
	}

	@Override
	public data searchData(Long id) {
		// TODO Auto-generated method stub
		return dr.findById(id).get();
	}

	@Override
	public void deleteData(Long id) {
		// TODO Auto-generated method stub
		 dr.deleteById(id);
	}

}
