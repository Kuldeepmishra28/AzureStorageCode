package nagarro.exitassignment.productCatalogue.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import nagarro.exitassignment.productCatalogue.model.CustomUserDetails;
import nagarro.exitassignment.productCatalogue.model.Userdb;
import nagarro.exitassignment.productCatalogue.repo.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Userdb user = this.userRepository.findByEmail(username);
		
		if (user==null) {
			throw new UsernameNotFoundException("No user exist");
		}else {
			return new CustomUserDetails(user);
		}
		

	}
	
	

}
