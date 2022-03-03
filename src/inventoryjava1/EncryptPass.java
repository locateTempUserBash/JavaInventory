package inventoryjava1;

import org.mindrot.jbcrypt.BCrypt;
public class EncryptPass {

	private String encryptedPassword;	
	public void savePassword(String passwd) {
		
		this.encryptedPassword = BCrypt.hashpw(passwd, BCrypt.gensalt());
		//System.out.println("Your encrypted password is: "+this.encryptedPassword );
	}
	public boolean verifyPassword(String testpasswd, String hashpasswd) {
           // System.out.println("verifyPAssword");
		return BCrypt.checkpw(testpasswd, hashpasswd);
	}
	public String getPass() {
		String encryptedpass = this.encryptedPassword;
		return encryptedpass;
	}
	public void encryptPass(String passwd) {
		System.out.print("Enter a new password: ");
		savePassword(passwd);
		
	}
}

