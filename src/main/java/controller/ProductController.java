package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Dao.Productrepository;
import model.Product;
import prfojetsid.CatalogmvcApplication;

@RestController
@EntityScan("model")
@EnableJpaRepositories("Dao")
//@EnableJpaRepositories("repository") 
public class ProductController {
	@Autowired
	private Productrepository produitRespository;
	
	/*@RequestMapping(value="/")
	public String index(ModelMap model) {
		//Page<Product> papeproduits = produitRespository.findAll(new PageRequest(0, 4, null));
		List<Product> produits = produitRespository.findAll();
		model.addAttribute("listProduits", produits);
		return "produits";
	}*/
	
	@GetMapping(value="/")
	  public String viewHomePage(ModelMap model) {
	      List<Product> produits = produitRespository.findAll();
	      model.addAttribute("listProducts", produits);
	       
	      return "produits";
	}
	@GetMapping(value="/new")
	  @RequestMapping(value="/new")
	  public String showNewProductPage(ModelMap model) {
	      Product product = new Product();
	      model.addAttribute("product", product);
	       
	      return "new_product";
	  }
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public String saveProduct(ModelMap model,@ModelAttribute("product") Product product) {
		  produitRespository.save(product);
	       
	      return "redirect:/";
	  }
	
	

}
