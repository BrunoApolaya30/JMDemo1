package com.jmingecor.jmingecor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmingecor.jmingecor.model.entity.Personal;

public interface  IPersonalRepository extends JpaRepository<Personal,Long> {
    
}
