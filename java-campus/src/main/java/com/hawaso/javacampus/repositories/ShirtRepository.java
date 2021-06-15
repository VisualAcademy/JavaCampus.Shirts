package com.hawaso.javacampus.repositories;

import com.hawaso.javacampus.models.Shirt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShirtRepository extends JpaRepository<Shirt, Integer> {
    
}
