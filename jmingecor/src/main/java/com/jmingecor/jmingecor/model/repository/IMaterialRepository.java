package com.jmingecor.jmingecor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmingecor.jmingecor.model.entity.Material;

public interface IMaterialRepository extends JpaRepository<Material,Long> {
    
}
