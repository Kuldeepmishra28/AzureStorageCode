package nagarro.exitassignment.productCatalogue;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import nagarro.exitassignment.productCatalogue.model.Pincode;
import nagarro.exitassignment.productCatalogue.model.Product;
import nagarro.exitassignment.productCatalogue.repo.PinCodeRepository;
import nagarro.exitassignment.productCatalogue.repo.ProductRepository;

@RestController
@CrossOrigin
public class ProductController {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	PinCodeRepository pincodeRepository;
	@GetMapping("/products")
	public List<Product> allProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	public Optional<Product> getProduct(@PathVariable int id) {
		return productRepository.findById(id);
	}
	@GetMapping("/productsearch/{brand}")
	public List<Product> getProductByBrand(@PathVariable String brand){
		return productRepository.getByBrand(brand);
	}
	@GetMapping("/productsearch/low/{brand}")

    public List<Product> getProductByLowRange(@PathVariable String brand) {

        return productRepository.getByPrice(brand);

	}

    @GetMapping("/productsearch/high/{brand}")

    public List<Product> getProductByHighRange(@PathVariable String brand) {

        return productRepository.getByHighPrice(brand);

    }
	
	@GetMapping("/pincode/{pid}")
	public Optional<Pincode> getPincode(@PathVariable int pid) {
		return pincodeRepository.findById(pid);
	}
}
