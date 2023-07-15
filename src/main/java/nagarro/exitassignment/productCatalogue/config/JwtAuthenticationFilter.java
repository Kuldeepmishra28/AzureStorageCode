package nagarro.exitassignment.productCatalogue.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import nagarro.exitassignment.productCatalogue.helper.JwtUtil;
import nagarro.exitassignment.productCatalogue.service.CustomUserDetailsService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired 
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		String requestTokenHeader = request.getHeader("Authorization");
		String username=null;
		String password=null;
		String jwtToken=null;
		
		//null and format checking
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			//security checking
			if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				
				UserDetails userdetails = this.customUserDetailsService.loadUserByUsername(username);
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userdetails, null,userdetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}else {
				System.out.println("token is invalid");
			}
		}
		filterChain.doFilter(request, response);
		
	}
	
}
