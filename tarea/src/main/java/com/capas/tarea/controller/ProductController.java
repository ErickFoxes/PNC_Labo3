package com.capas.tarea.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capas.tarea.domain.Product;

@Controller
public class ProductController {
	
	private List<Product> products = new ArrayList<Product>();
	

	@GetMapping("/compraProducto")
	public ModelAndView compraProducto(){
		products.add(new Product(0,"Harry potter 1", 10));
		products.add(new Product(1,"Harry potter 2", 15));
		products.add(new Product(2,"Harry potter 3", 20));
		products.add(new Product(3,"Harry potter 4", 25));
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("productos");
		mav.addObject("prod",new Product());
		mav.addObject("producto",products);
		return mav;
	}
	
	
	@PostMapping("/validar")
	public ModelAndView  validar(Product prod) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("prod", products.get(prod.getId()).getNombre());
		if(products.get(prod.getId()).getCantidad() >= prod.getCantidad()) {
			mav.setViewName("compra");
		}
		else {
			mav.setViewName("error");
		}
		return mav;
	}
}
