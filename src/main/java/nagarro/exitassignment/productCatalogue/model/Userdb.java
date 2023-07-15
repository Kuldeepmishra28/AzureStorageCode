package nagarro.exitassignment.productCatalogue.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Userdb {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String email;
	private String firstname;
	private String lastname;
	private String password;
	private String confirmPassword;
	
	public Userdb(String email, String firstname, String lastname, String password, String confirmPassword) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public Userdb() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}
}
