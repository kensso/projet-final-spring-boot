package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Dao.Productrepository;
import model.Product;

@Controller
public class ProductController {
	@Autowired
	private Productrepository produitRespository;
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		//Page<Product> papeproduits = produitRespository.findAll(new PageRequest(0, 4, null));
		List<Product> produits = produitRespository.findAll();
		model.addAttribute("listProduits", produits);
		return "produits";
	}

}
