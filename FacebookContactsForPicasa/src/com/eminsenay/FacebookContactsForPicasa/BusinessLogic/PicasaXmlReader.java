package com.eminsenay.FacebookContactsForPicasa.BusinessLogic;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/** Reads Picasa contacts.xml */
public class PicasaXmlReader {

	private static String m_PicasaXmlContactElement = "contact";
	private static String m_PicasaXmlIDAttr = "id";
	private static String m_PicasaXmlNameAttr = "name";
	private static String m_PicasaXmlModifiedTimeAttr = "modified_time";
	private static String m_PicasaXmlLocalContactAttr = "local_contact";
	
	private String m_FilePath;
	
	public PicasaXmlReader(String xmlPath)
	{
		m_FilePath = xmlPath;
	}
	
	public ArrayList<PicasaContact> Read() throws Exception
	{
		ArrayList<PicasaContact> contacts = new ArrayList<PicasaContact>();

		File file = new File(m_FilePath);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		
		NodeList nodeList = doc.getElementsByTagName(m_PicasaXmlContactElement);
		
		for (int i = 0; i < nodeList.getLength(); i++)
		{
			PicasaContact contact = new PicasaContact();
			
			Node nextNode = nodeList.item(i);
			NamedNodeMap attributes = nextNode.getAttributes();
			for (int j = 0; j < attributes.getLength(); j++)
			{
				String nextAttrName = attributes.item(j).getNodeName();
				String nextAttrVal = attributes.item(j).getNodeValue();
				
				if (nextAttrName.equalsIgnoreCase(m_PicasaXmlIDAttr))
				{
					contact.setID(nextAttrVal);
				}
				else if (nextAttrName.equalsIgnoreCase(m_PicasaXmlNameAttr))
				{
					contact.setName(nextAttrVal);
				}
				else if (nextAttrName.equalsIgnoreCase(m_PicasaXmlModifiedTimeAttr))
				{
					contact.setModifiedTime(nextAttrVal);
				}
				else if (nextAttrName.equalsIgnoreCase(m_PicasaXmlLocalContactAttr))
				{
					contact.setLocalContact(nextAttrVal);
				}
			}
			
			contacts.add(contact);
		}
		return contacts;
	}
}
