package com.hardik.javase;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Read XML File (SAX Parser)
 * 
 * SAX Parser is faster and uses less memory than DOM parser.
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

		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			// Default Handler
			DefaultHandler handler = new DefaultHandler() {

				boolean bfname = false;
				boolean blname = false;
				boolean bnname = false;
				boolean bsalary = false;

				/**
				 * START ELEMENT
				 */
				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {

					System.out.println("Start Element: " + qName);

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
				 * END ELEMENT
				 */
				@Override
				public void endElement(String uri, String localName, String qName) throws SAXException {
					System.out.println("End Element: " + qName);
				}

			};

			saxParser.parse("src/main/resources/staff.xml", handler);

		} catch (ParserConfigurationException ex) {
			ex.printStackTrace();
		} catch (SAXException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
