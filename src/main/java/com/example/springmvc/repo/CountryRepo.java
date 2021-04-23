package com.example.springmvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springmvc.entity.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {

}
