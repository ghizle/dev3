package com.ghizlen.coffee.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.ghizlen.coffee.entities.Coffee;
import com.ghizlen.coffee.entities.Image;
import com.ghizlen.coffee.repos.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType; 
import org.springframework.http.ResponseEntity; 
import org.springframework.stereotype.Service; 
import org.springframework.web.multipart.MultipartFile;

import com.ghizlen.coffee.repos.CoffeeRepository;


@Service 
public class ImageServiceImpl implements ImageService{ 

	@Autowired
    ImageRepository imageRepository;

	@Autowired
	CoffeeService coffeeService;
	
	@Autowired
	CoffeeRepository coffeeRepository;

	@Override
	public Image uplaodImage(MultipartFile file) throws IOException {
		/*
		 * Ce code commenté est équivalent au code utilisant le design pattern Builder
		 * Image image = new Image(null, file.getOriginalFilename(),
		 * file.getContentType(), file.getBytes(), null);
		 *   return imageRepository.save(image);
		 */
		return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.image(file.getBytes()).build());
	}

	@Override 
	public Image getImageDetails(Long id) throws IOException{ 
		final Optional<Image> dbImage = imageRepository. findById (id); 

		return Image.builder() 
				.idImage(dbImage.get().getIdImage()) 
				.name(dbImage.get().getName()) 
				.type(dbImage.get().getType()) 
				.image(dbImage.get().getImage()).build() ; 
	} 

	@Override 
	public ResponseEntity<byte[]> getImage(Long id) throws IOException{ 
		final Optional<Image> dbImage = imageRepository. findById (id); 

		return ResponseEntity 
				.ok() 
				.contentType(MediaType.valueOf(dbImage.get().getType())) 
				.body(dbImage.get().getImage()); 
	} 

	@Override 
	public void deleteImage(Long id) { 
		imageRepository.deleteById(id); 
	} 
	
	@Override 
	 public Image uplaodImageCoff(MultipartFile file,Long idCoff)
	throws IOException { 
	  Coffee p = new Coffee();
	  p.setIdCoffee(idCoff);
	  return imageRepository.save(Image.builder() 
	                .name(file.getOriginalFilename()) 
	                .type(file.getContentType()) 
	                .image(file.getBytes()) 
	                .coffee(p).build() );
	 }

	@Override
	public List<Image> getImagesParCoff(Long coffId) {
		Coffee p = coffeeRepository.findById(coffId).get();
		return p.getImages();
	}

	
	
} 