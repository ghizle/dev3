package com.ghizlen.coffee.service;

import java.io.IOException;
import java.util.List;

import com.ghizlen.coffee.entities.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService { 
     Image uplaodImage(MultipartFile file) throws IOException;
     Image getImageDetails(Long id) throws IOException; 
     ResponseEntity<byte[]> getImage(Long id) throws IOException; 
     void deleteImage(Long id); 
     
     Image uplaodImageCoff(MultipartFile file,Long idAvio) throws IOException;
     List<Image> getImagesParCoff(Long avioId);
     
} 