package com.eminsenay.FacebookContactsForPicasa;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;


public class PicasaXmlWriter
{

	public PicasaXmlWriter() 
	{}

	private static String m_PicasaXmlRoot = "contacts";
	private static String m_PicasaXmlContactElement = "contact";
	private static String m_PicasaXmlIDAttr = "id";
	private static String m_PicasaXmlNameAttr = "name";
	private static String m_PicasaXmlDisplayAttr = "display";
	private static String m_PicasaXmlModifiedTimeAttr = "modified_time";
	private static String m_PicasaXmlSyncEnabledAttr = "sync_enabled";

	public void CreatePicasaUserXml(List<PicasaContact> users) throws Exception 
	{

		Random random =  new Random();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
	    
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		Document document = documentBuilder.newDocument();
		Element rootElement = document.createElement(m_PicasaXmlRoot);
		document.appendChild(rootElement);
		for (int i = 1; i < users.size(); i++) 
		{
			PicasaContact currContact = users.get(i);
			Element em = document.createElement(m_PicasaXmlContactElement);
			
		    em.setAttribute(m_PicasaXmlNameAttr, currContact.getName());
		    if (currContact.getID() != null)
		    {
		    	em.setAttribute(m_PicasaXmlIDAttr, currContact.getID());
		    }
		    else
		    {
		    	long r1 = random.nextLong();
			    String contactId = Long.toHexString(r1);
		    	em.setAttribute(m_PicasaXmlIDAttr, contactId);
		    }
		    
		    if (currContact.getDisplay() != null)
		    {
		    	em.setAttribute(m_PicasaXmlDisplayAttr, currContact.getDisplay());
		    }
		    else
		    {
		    	em.setAttribute(m_PicasaXmlDisplayAttr, currContact.getName());
		    }
		    
		    if (currContact.getModifiedTime() != null)
		    {
		    	em.setAttribute(m_PicasaXmlModifiedTimeAttr, currContact.getModifiedTime());
		    }
		    else
		    {
		    	String formattedDate = sdf.format(new Date());
		    	em.setAttribute(m_PicasaXmlModifiedTimeAttr, formattedDate);
		    }
		    
		    if (currContact.getSyncEnabled() != null)
		    {
		    	em.setAttribute(m_PicasaXmlSyncEnabledAttr, currContact.getSyncEnabled());
		    }
		    else
		    {
		    	em.setAttribute(m_PicasaXmlSyncEnabledAttr, "1");
		    }

			rootElement.appendChild(em);
		}
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File("output.xml"));
		transformer.transform(source, result);
	}

}