package com.example.SMS.services;

import java.util.List;

import com.example.SMS.entity.data;


public interface dataService {
List<data> getAllData();
data saveData(data d);
data updateData(data d);
data searchData(Long id);
void deleteData(Long id);
}
