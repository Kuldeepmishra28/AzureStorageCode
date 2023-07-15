package nagarro.exitassignment.productCatalogue.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nagarro.exitassignment.productCatalogue.model.Product;
import nagarro.exitassignment.productCatalogue.model.Userdb;


	@Repository
	public interface ProductRepository extends JpaRepository<Product, Integer> {

		
		@Query("select p from Product p where p.brand=?1")
		List<Product> getByBrand(String brand);
	    @Query("select p from Product p where p.brand=?1 order by price asc")
	    List<Product> getByPrice(String brand);
	    @Query("select p from Product p where p.brand=?1 order by price desc")
	    List<Product> getByHighPrice(String brand);
	}

