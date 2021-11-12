package prfojetsid;

import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import Dao.Productrepository;
import model.Product;
@SpringBootApplication
//@EnableJpaRepositories("Dao")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CatalogmvcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CatalogmvcApplication.class, args);
		Productrepository produitRepository= ctx.getBean(Productrepository.class);
		EntityManagerFactory emf; 
		produitRepository.save(new Product(" mais", 25, 12));
		produitRepository.findAll().forEach(p->System.out.println(p.getDesignation()));
	}
	/*@RestController
	class PersonController{
		@Autowired
		EntityManager em;
		@PostMapping("/person")
		@Transactional
		public Person savePerson(@RequestParam String prenom) {
		Person p = new Person();
		p.setPrenom(prenom);
		em.persist(p);
		return p;
	}
	}*/

	

}
