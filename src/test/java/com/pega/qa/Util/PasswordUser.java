package com.pega.qa.Util;

public class PasswordUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strToEncode = "Ashok5151!";
        String key = "UcantUnlock";
        String strEncryptedString = StringEncrypt.encryptXOR(strToEncode, key);
        System.out.println("Encrypted string: " + strEncryptedString);
        String decodedPwd = StringEncrypt.decryptXOR(strEncryptedString, key);
        System.out.println("Decrypted string: " + decodedPwd);
		
	}

}
