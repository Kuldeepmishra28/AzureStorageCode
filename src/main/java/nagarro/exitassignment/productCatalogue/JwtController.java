package nagarro.exitassignment.productCatalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nagarro.exitassignment.productCatalogue.helper.JwtUtil;
import nagarro.exitassignment.productCatalogue.model.JwtRequest;
import nagarro.exitassignment.productCatalogue.model.JwtResponse;
import nagarro.exitassignment.productCatalogue.service.CustomUserDetailsService;



@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		System.out.println(jwtRequest);
		 try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Invalid Credentials!!!");
		}
		 
		//after validated
		UserDetails userDetails =  this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("JWT "+ token);
		
		return ResponseEntity.ok(new JwtResponse(token));

	}
}