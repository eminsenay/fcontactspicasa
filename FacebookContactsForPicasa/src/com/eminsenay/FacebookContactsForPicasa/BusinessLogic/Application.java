package com.eminsenay.FacebookContactsForPicasa.BusinessLogic;

import java.util.ArrayList;

public class Application {

	private String m_contactsXmlPath;
	
	public String getContactsXmlPath() 
	{
		return m_contactsXmlPath;
	}

	public void setContactsXmlPath(String contactsXmlPath) 
	{
		this.m_contactsXmlPath = contactsXmlPath;
	}

	public Application()
	{}
	
	public void Run()
	{
		FacebookFriendFetcher friendFetcher = new FacebookFriendFetcher();
		ArrayList<PicasaContact> friends = friendFetcher.GetFriends();
		
		PicasaXmlReader xmlReader = new PicasaXmlReader(getContactsXmlPath());
		PicasaXmlWriter xmlWriter = new PicasaXmlWriter();
		try 
		{
			ArrayList<PicasaContact> existingContacts = xmlReader.Read();
			ArrayList<PicasaContact> allContacts = MergeContacts(existingContacts, friends);
			xmlWriter.CreatePicasaUserXml(allContacts);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	/** Merges given two Picasa Contact Lists.
	 *  Second parameter is used as a basis. Each PicasaContact of
	 *  first parameter is compared with the ones in second parameter wrt 
	 *  Name and added if not found.
	 * */
	private ArrayList<PicasaContact> MergeContacts(ArrayList<PicasaContact> base,
			ArrayList<PicasaContact> mergeWith)
	{
		ArrayList<PicasaContact> allContacts = new ArrayList<PicasaContact>();
		allContacts.addAll(base);
		boolean contactFound = false;
		for (int i = 0; i < mergeWith.size(); i++)
		{
			contactFound = false;
			String nextFriendName = mergeWith.get(i).getName();
			for (int j = 0; j < base.size(); j++)
			{
				if (nextFriendName.equalsIgnoreCase(base.get(j).getName()))
				{
					contactFound = true;
					break;
				}
			}
			if (!contactFound)
			{
				allContacts.add(mergeWith.get(i));
			}
		}
		return allContacts;
	}
}
