package nagarro.exitassignment.productCatalogue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nagarro.exitassignment.productCatalogue.model.Product;
import nagarro.exitassignment.productCatalogue.repo.ProductRepository;

@Service
public class ProductStoreService {
@Autowired 
ProductRepository productRepo;


	public Product create(Product product) {
		return productRepo.save(product);
	}
	
}
