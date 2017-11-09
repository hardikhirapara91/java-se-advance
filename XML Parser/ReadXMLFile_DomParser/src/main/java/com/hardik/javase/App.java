package com.hardik.javase;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Read XML File (DOM Parser)
 * 
 * Warning : DOM Parser is slow and consumes a lot of memory when it loads an
 * XML document which contains a lot of data. Please consider SAX parser as
 * solution for it, SAX is faster than DOM and use less memory.
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

		File file = new File("src/main/resources/staff.xml");

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(file);

			/**
			 * Optional (but recommended), Read Following:
			 * http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			 */
			document.getDocumentElement().normalize();

			// XML Root Node
			System.out.println("Root Element: " + document.getDocumentElement().getNodeName());

			// XML Child Nodes
			NodeList nodes = document.getElementsByTagName("staff");

			System.out.println("----------------------------------------");

			for (int i = 0; i < nodes.getLength(); i++) {

				// XML Child Node
				Node node = nodes.item(i);

				System.out.println("\nCurrent Element :" + node.getNodeName());

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) node;

					System.out.println("Staff id : " + element.getAttribute("id"));
					System.out.println(
							"First Name : " + element.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println(
							"Last Name : " + element.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println(
							"Nick Name : " + element.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Salary : " + element.getElementsByTagName("salary").item(0).getTextContent());
				}
			}

		} catch (ParserConfigurationException ex) {
			ex.printStackTrace();
		} catch (SAXException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
