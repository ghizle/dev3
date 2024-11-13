package com.ghizlen.coffee.repos;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.ghizlen.coffee.entities.Image;
 
 
public interface ImageRepository extends JpaRepository<Image , Long> { 
} 