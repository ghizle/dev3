package com.ghizlen.coffee.controllers;

import org.springframework.web.bind.annotation.RequestMapping;




//import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

//import com.souleimen.Coffees.dto.Coffee;
import com.ghizlen.coffee.entities.Coffee;
import com.ghizlen.coffee.entities.TypeCo;
import com.ghizlen.coffee.service.CoffeeService;

import jakarta.validation.Valid;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoffeeController {
	@Autowired
	CoffeeService coffeeService;
	
	@GetMapping("/accessDenied")
	public String error()
	{
	return "accessDenied";
	}


	@RequestMapping("/ListeCoffees")
	public String listeCoffees(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)
 {
		Page<Coffee> coffs = coffeeService.getAllCoffeesParPage(page, size);
		modelMap.addAttribute("coffees", coffs);
		modelMap.addAttribute("pages", new int[coffs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);

		return "listeCoffees";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<TypeCo> typs = coffeeService.getAllTypeCos();
		modelMap.addAttribute("Coffee", new Coffee());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("typeCos", typs);

		return "formCoffee";
	}
	
	@RequestMapping("/saveCoffee")
	public String saveCoffee(@Valid Coffee coffee, BindingResult bindingResult,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
 {

		int currentPage;
		boolean isNew = false;

		if (bindingResult.hasErrors()) return "formCoffee";

		if (coffee.getIdCoffee()==null) //ajout
        {
            isNew=true;
        }


		coffeeService.saveCoffee(coffee);

		if (isNew) //ajout
		{
		Page<Coffee> avios = coffeeService.getAllCoffeesParPage(page, size);
		currentPage = avios.getTotalPages()-1;
		}
		else //modif
		currentPage=page;

		//return "formCoffee";
		return ("redirect:/ListeCoffees?page="+currentPage+"&size="+size);

	}


	@RequestMapping("/supprimerCoffee")
	public String supprimerCoffee(@RequestParam("id") Long id,
							ModelMap modelMap,
							@RequestParam (name="page",defaultValue = "0") int page,
							@RequestParam (name="size", defaultValue = "2") int size)
		 {
		coffeeService.deleteCoffeeById(id);

		Page<Coffee> avios = coffeeService.getAllCoffeesParPage(page,size);
				modelMap.addAttribute("coffees", avios);
				modelMap.addAttribute("pages", new int[avios.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				modelMap.addAttribute("size", size);

		return "listeCoffees";
	}

	@RequestMapping("/modifierCoffee")
	public String editerCoffee(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		List<TypeCo> typs = coffeeService.getAllTypeCos();
		Coffee p = coffeeService.getCoffee(id);
		modelMap.addAttribute("coffee", p);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("TypeCos", typs);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);


		return "formCoffee";
	}

	@RequestMapping("/updateCoffee")
	public String updateCoffee(@ModelAttribute("coffee") Coffee coffee, @RequestParam("date") String date, ModelMap modelMap) throws ParseException {
		//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateFabrication = dateformat.parse(String.valueOf(date));
		coffee.setDateFabrication(dateFabrication);

		coffeeService.updateCoffee(coffee);
		List<Coffee> avios = coffeeService.getAllCoffees();
		//List<Coffee> avios = CoffeeService.getAllCoffees();

		modelMap.addAttribute("coffees", avios);

		return "listeCoffees";
	}

	@GetMapping(value = "/")
	public String welcome() {
	 return "index";

	 /*
	 @PostMapping("/createCoffee")
	 public String createCoffee(@Valid Coffee Coffee, BindingResult bindingResult, ModelMap modelMap) {
	     if (bindingResult.hasErrors()) {
	         // If there are validation errors, return to the form with error messages
	         modelMap.addAttribute("Coffee", Coffee);
	         modelMap.addAttribute("TypeCos", CoffeeService.getAllTypeCos());
	         return "formCoffee";
	     }

	     CoffeeService.saveCoffee(Coffee);
	     modelMap.addAttribute("message", "Coffee créé avec succès");
	     return "success";
	 }
	}
	*/
}
}