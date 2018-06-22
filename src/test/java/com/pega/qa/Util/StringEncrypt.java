package com.pega.qa.Util;

import cucumber.deps.com.thoughtworks.xstream.core.util.Base64Encoder;

public class StringEncrypt {
	public static String encryptXOR(String message, String key) {
		try {
			if (message == null || key == null)
				return null;
			char[] keys = key.toCharArray();
			char[] mesg = message.toCharArray();
			int ml = mesg.length;
			int kl = keys.length;
			char[] newmsg = new char[ml];
			for (int i = 0; i < ml; i++) {
				newmsg[i] = (char) (mesg[i] ^ keys[i % kl]);
			}
			mesg = null;
			keys = null;
			return new String(new Base64Encoder().encode(new String(newmsg).getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String decryptXOR(String message, String key) {
		try {
			if (message == null || key == null)
				return null;
			Base64Encoder decoder = new Base64Encoder();
			char[] keys = key.toCharArray();
			char[] mesg = new String(decoder.decode(message)).toCharArray();
			int ml = mesg.length;
			int kl = keys.length;
			char[] newmsg = new char[ml];
			for (int i = 0; i < ml; i++) {
				newmsg[i] = (char) (mesg[i] ^ keys[i % kl]);
			}
			mesg = null;
			keys = null;
			return new String(newmsg);
		} catch (Exception e) {
			return null;
		}
	}

}
