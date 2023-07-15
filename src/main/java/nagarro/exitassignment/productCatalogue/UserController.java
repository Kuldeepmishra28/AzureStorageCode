package nagarro.exitassignment.productCatalogue;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nagarro.exitassignment.productCatalogue.model.Pincode;
import nagarro.exitassignment.productCatalogue.model.Product;
import nagarro.exitassignment.productCatalogue.repo.PinCodeRepository;
import nagarro.exitassignment.productCatalogue.repo.ProductRepository;
import nagarro.exitassignment.productCatalogue.service.ProductStoreService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nagarro.exitassignment.productCatalogue.model.Userdb;
import nagarro.exitassignment.productCatalogue.repo.UserRepository;



@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	PinCodeRepository pincodeRepository;
	
	//saving user while registration
	    
		@PostMapping("/user")
		public Userdb createUsers(@RequestBody Userdb user) {
			return userRepository.save(user);
		}
		
		

		
		@GetMapping("/emailauth/{email}")
		public Userdb getUser(@PathVariable String email) {
			return userRepository.findByEmail(email);
		}
		
		

		
}