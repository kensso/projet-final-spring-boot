package prfojetsid;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Dao.Productrepository;
import model.Product;
//@SpringBootApplication
@SpringBootApplication
//@ComponentScan("model")
@EntityScan("model")
@EnableJpaRepositories("Dao")
public class CatalogmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogmvcApplication.class, args);
		//ApplicationContext ctx = SpringApplication.run(CatalogmvcApplication.class, args);
		//Productrepository produitRepository= ctx.getBean(Productrepository.class);
		
		//produitRepository.save(new Product(" mais", 25, 12));
		//produitRepository.findAll().forEach(p->System.out.println(p.getDesignation()));
	}
	

	@RestController
	class MonController{
		@GetMapping("/bonjour")
		public String direBonjour() {
			return "Bonjour";
		}
	}
	@RestController
	class ProductController{
		@Autowired
		private Productrepository produitRespository;
		@GetMapping(value="/produit")
		  public List<Product> viewHomePage(ModelMap model) {
		      List<Product> produits = produitRespository.findAll();
		      model.addAttribute("listProducts", produits);
		       
		      return produits;
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

	

}
