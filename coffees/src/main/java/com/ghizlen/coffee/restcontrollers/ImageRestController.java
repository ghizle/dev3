package com.ghizlen.coffee.restcontrollers;

import com.ghizlen.coffee.entities.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*; 
import org.springframework.web.multipart.MultipartFile;

import com.ghizlen.coffee.entities.Image;
import com.ghizlen.coffee.service.CoffeeService;
import com.ghizlen.coffee.service.ImageService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List; 
 
@RestController 
@RequestMapping("/api/image")
@CrossOrigin(origins = "*") 
public class ImageRestController { 
	 
    @Autowired 
    ImageService  imageService ; 
    
    @Autowired
    CoffeeService coffeeService;
   
    @RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST) 
    public void uploadImageFS(@RequestParam("image") MultipartFile 
    		file,@PathVariable("id") Long id) throws IOException { 
    	Coffee p = coffeeService.getCoffee(id);
    	p.setImagePath(id+".jpg"); 

    	Files.write(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath())
    			, file.getBytes()); 
    	coffeeService.saveCoffee(p);

    } 

    @RequestMapping(value = "/loadfromFS/{id}" ,  
    		method = RequestMethod.GET, 
    		produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

    	Coffee p = coffeeService.getCoffee(id);
    	return
    			Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
    }
    
   
    @RequestMapping(value = "/upload" , method = RequestMethod.POST) 
    public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException { 
        return imageService.uplaodImage(file); 
    } 
    @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET) 
    public Image getImageDetails(@PathVariable("id") Long id) throws IOException { 
        return imageService.getImageDetails(id) ; 
    } 
    @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET) 
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException 
{ 
        return imageService.getImage(id); 
    } 
     
   
    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE) 
    public void deleteImage(@PathVariable("id") Long id){ 
        imageService.deleteImage(id); 
    } 
    @RequestMapping(value="/update",method = RequestMethod.PUT) 
    public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException { 
        return imageService.uplaodImage(file); 
    } 
    
//    @PostMapping(value = "/uplaodImageCoff/{idCoff}" )
//    public Image uploadMultiImages(@RequestParam("image")MultipartFile file, 
//                @PathVariable("idCoff") Long idCoff)
//		throws IOException { 
//		       return imageService.uplaodImageCoff(file,idCoff);
//	}
    
    
    @PostMapping(value = "/uplaodImageCoff/{idCoff}" )
	 public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
			 @PathVariable("idCoff") Long idCoff)
					 throws IOException {
		 return imageService.uplaodImageCoff(file,idCoff);
	 }
    
		
		@RequestMapping(value = "/getImagesCoff/{idCoff}",method = RequestMethod.GET)
		   public List<Image> getImagesCoff(@PathVariable("idCoff") Long idCoff)
		throws IOException { 
		      return imageService.getImagesParCoff(idCoff);
		   } 
    
    
    
}