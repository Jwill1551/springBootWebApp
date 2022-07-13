package com.gcu;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ProductsBusinessInterface;
import com.gcu.model.ProductModel;
import com.gcu.model.SearchModel;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/products")
public class ProductController
{
	@Autowired
	private ProductsBusinessInterface service;
	
	@GetMapping("/newProduct")
	public String newProduct(Model model)
	{
		model.addAttribute("title", "New Product");
		model.addAttribute("productModel", new ProductModel());
		return "newProduct";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "New Product");
			return "newProduct";
		}
		if(service.addProduct(productModel) > 0)
		{
			model.addAttribute("productModel", productModel);
			return "productSuccess";
		}
		else
		{
			return "newProduct";
		}
	}
	
	@GetMapping("/productAdmin")
	public String productAdminView(Model model)
	{
		List<ProductModel> products = service.getAllProducts();
		model.addAttribute("title", "Product Admin");
		model.addAttribute("products", products);
		return "productAdmin";
	}
	
	@GetMapping("/searchProducts")
	public String searchProductDisplay(Model model)
	{
		model.addAttribute("title", "Search for Vacations");
		model.addAttribute("searchModel", new SearchModel());
		return "searchProducts";
	}
	
	@PostMapping("/searchProductName")
	public String searchByProductName(@Valid SearchModel searchModel, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "Search for Vacations");
			return "searchProducts";
		}
		List<ProductModel> products = service.searchProductByName(searchModel.getSearchTerm());
		model.addAttribute("title", "Search for a Vacation by Name");
		model.addAttribute("searchModel", searchModel);
		model.addAttribute("products", products);
		return "productSearchResults";
	}
	
	@PostMapping("/searchProductLocation")
	public String searchByProductLocation(@Valid SearchModel searchModel, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "Search for Vacations");
			return "searchProducts";
		}
		List<ProductModel> products = service.searchProductByLocation(searchModel.getSearchTerm());
		model.addAttribute("title", "Search for a Product by Vacation");
		model.addAttribute("searchModel", searchModel);
		model.addAttribute("products", products);
		return "productSearchResults";
	}
	
	@GetMapping("/updateProduct")
	public String updateProductDisplay(ProductModel productModel, Model model)
	{
		System.out.println(productModel.toString());
		model.addAttribute("title", "Edit Product");
		model.addAttribute("productModel", productModel);
		return "editProduct";
	}
	
	@PostMapping("/doUpdateProduct")
	public String updateUser(@Valid ProductModel productModel, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "Product Admin");
			return "userAdmin";
		}
		service.updateProduct(productModel.getVacationId(), productModel);
		List<ProductModel> products = service.getAllProducts();
		model.addAttribute("title", "Product Admin");
		model.addAttribute("products", products);
		return "productAdmin";
	}
	
	@PostMapping("/deleteProduct")
	public String deleteProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "Product Admin");
			return "productAdmin";
		}
		service.deleteProduct(productModel.getVacationId());
		List<ProductModel> products = service.getAllProducts();
		model.addAttribute("title", "Product Admin");
		model.addAttribute("products", products);
		return "productAdmin";
	}
}