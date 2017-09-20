package library;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cript {

	
	public String make(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		// algoritmo de criptografia
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(text.getBytes("UTF-8"));
		
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest)
			hexString.append(String.format("%02X", 0xFF & b));
		
		String hash = hexString.toString(); // hash da senha
		
		return hash;
	}
}
