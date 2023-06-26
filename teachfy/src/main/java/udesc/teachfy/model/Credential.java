package udesc.teachfy.model;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.mindrot.jbcrypt.BCrypt;

public class Credential {
	
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String[] getEncryptedPassword() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		final String salt = BCrypt.gensalt();
		String password = BCrypt.hashpw(this.password, salt);
		return new String[]{password, salt};
	}

}

