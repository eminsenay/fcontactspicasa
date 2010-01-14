package com.eminsenay.FacebookContactsForPicasa;
import java.util.ArrayList;

public class Main 
{

	public static void main(String args[]) 
	{
		FacebookFriendFetcher friendFetcher = new FacebookFriendFetcher();
		ArrayList<PicasaContact> friends = friendFetcher.GetFriends();
		
		PicasaXmlReader xmlReader = new PicasaXmlReader("contacts.xml");
		PicasaXmlWriter xmlWriter = new PicasaXmlWriter();
		try 
		{
			ArrayList<PicasaContact> existingContacts = xmlReader.Read();
			ArrayList<PicasaContact> allContacts = UnionContacts(friends, existingContacts);
			xmlWriter.CreatePicasaUserXml(allContacts);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	private static ArrayList<PicasaContact> UnionContacts(
			ArrayList<PicasaContact> friends,
			ArrayList<PicasaContact> existingContacts) 
	{
		ArrayList<PicasaContact> allContacts = new ArrayList<PicasaContact>();
		allContacts.addAll(existingContacts);
		boolean contactFound = false;
		for (int i = 0; i < friends.size(); i++)
		{
			contactFound = false;
			String nextFriendName = friends.get(i).getName();
			for (int j = 0; j < existingContacts.size(); j++)
			{
				if (nextFriendName.equalsIgnoreCase(existingContacts.get(j).getName()))
				{
					contactFound = true;
					break;
				}
			}
			if (!contactFound)
			{
				allContacts.add(friends.get(i));
			}
		}
		return allContacts;
	}
}
