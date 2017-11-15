package com.hardik.javase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Read XML UTF8 File using SAX Parser
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class App {

	/**
	 * App Main Method
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		try {
			InputStream inputStream = new FileInputStream(new File("src/main/resources/staff.xml"));
			Reader reader = new InputStreamReader(inputStream, "UTF-8");
			InputSource source = new InputSource(reader);
			source.setEncoding("UTF-8");

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();

			// DEFAULT-HANDLER
			DefaultHandler handler = new DefaultHandler() {

				boolean bfname = false;
				boolean blname = false;
				boolean bnname = false;
				boolean bsalary = false;

				/**
				 * START
				 */
				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {

					System.out.println("Start Element :" + qName);

					if (qName.equalsIgnoreCase("FIRSTNAME")) {
						bfname = true;
					}

					if (qName.equalsIgnoreCase("LASTNAME")) {
						blname = true;
					}

					if (qName.equalsIgnoreCase("NICKNAME")) {
						bnname = true;
					}

					if (qName.equalsIgnoreCase("SALARY")) {
						bsalary = true;
					}
				}

				/**
				 * CHARACTERS
				 */
				@Override
				public void characters(char[] ch, int start, int length) throws SAXException {

					if (bfname) {
						System.out.println("First Name : " + new String(ch, start, length));
						bfname = false;
					}

					if (blname) {
						System.out.println("Last Name : " + new String(ch, start, length));
						blname = false;
					}

					if (bnname) {
						System.out.println("Nick Name : " + new String(ch, start, length));
						bnname = false;
					}

					if (bsalary) {
						System.out.println("Salary : " + new String(ch, start, length));
						bsalary = false;
					}
				}

				/**
				 * END
				 */
				@Override
				public void endElement(String uri, String localName, String qName) throws SAXException {
					System.out.println("End Element :" + qName);
				}
			};

			parser.parse(source, handler);

		} catch (ParserConfigurationException ex) {
			ex.printStackTrace();
		} catch (SAXException ex) {
			ex.printStackTrace();
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
