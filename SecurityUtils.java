package exam;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtils {
	
	public static String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashedPassword = md.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			for(byte b: hashedPassword) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		}catch(NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static boolean verifyPassword(String password, String hash) {
		return hash.equals(hashPassword(password));
	}
}