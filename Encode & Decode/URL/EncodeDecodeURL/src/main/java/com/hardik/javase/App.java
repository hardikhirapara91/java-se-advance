package com.hardik.javase;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Encode & Decode URL & Form Data
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class App {
	/**
	 * App Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String url = "<![CDATA[ <IMG SRC=\"javascript:document.vulnerable=true;\"> ]]>";

		try {
			// ENCODE
			String encodeUrl = URLEncoder.encode(url, "UTF-8");
			System.out.println("Encoded URL: " + encodeUrl);

			// DECODE
			String decodeUrl = URLDecoder.decode(encodeUrl, "UTF-8");
			System.out.println("Decoded URL: " + decodeUrl);

		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
	}
}
