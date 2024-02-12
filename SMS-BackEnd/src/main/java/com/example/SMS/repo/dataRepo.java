package com.example.SMS.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SMS.entity.data;

@Repository
public interface dataRepo extends JpaRepository<data, Long> {

}
