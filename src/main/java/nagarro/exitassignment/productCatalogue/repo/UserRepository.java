package nagarro.exitassignment.productCatalogue.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nagarro.exitassignment.productCatalogue.model.Userdb;

@Repository
public interface UserRepository extends JpaRepository<Userdb, Integer> {
	
	public Userdb findByEmail(String email);
	
}
