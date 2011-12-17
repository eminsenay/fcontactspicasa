package com.eminsenay.FacebookContactsForPicasa.BusinessLogic;

import java.util.ArrayList;
import java.util.Hashtable;

public class Application 
{
	public Application()
	{}
	
	/**
	 * Merges Facebook friends with Picasa contacts using the given hashtable and
	 * creates an output file to be used as the new Picasa contacts.xml. 
	 * Existing Picasa contacts are kept.
	 * @throws Exception 
	 * */
	public void SaveContacts(ArrayList<PicasaContact> facebookFriends, 
			ArrayList<PicasaContact> picasaContacts, Hashtable<Integer, Integer> facebookPicasaMap,
			String outputPath) throws Exception
	{
		ArrayList<PicasaContact> mergedFriends = MergeFriends(facebookFriends, picasaContacts, 
				facebookPicasaMap);
		PicasaXmlWriter writer = new PicasaXmlWriter();
		writer.CreatePicasaUserXml(mergedFriends, outputPath);
	}

	private ArrayList<PicasaContact> MergeFriends(ArrayList<PicasaContact> facebookFriends,
			ArrayList<PicasaContact> picasaContacts,
			Hashtable<Integer, Integer> facebookPicasaMap)
	{
		if (facebookFriends == null || facebookFriends.size() == 0)
		{
			return picasaContacts;
		}
		if (picasaContacts == null || picasaContacts.size() == 0)
		{
			return facebookFriends;
		}
		ArrayList<PicasaContact> mergedFriends = new ArrayList<PicasaContact>();
		// Keep the mapped contact indices in a separate list to determine
		// which Picasa contacts need to be added to the mergedFriends.
		int[] mappedPicasaContacts = new int[picasaContacts.size()];
		for (int i = 0; i < mappedPicasaContacts.length; i++)
		{
			mappedPicasaContacts[i] = 0;
		}

		for (int i = 0; i < facebookFriends.size(); i++)
		{
			PicasaContact nextFacebookFriend = facebookFriends.get(i);
			PicasaContact newContact = new PicasaContact();
			Integer mapKey = new Integer(i);
			newContact.setName(nextFacebookFriend.getName());
			if (facebookPicasaMap.containsKey(mapKey))
			{
				// Mapping found. Use the information from Picasa for the rest.
				Integer picasaContactsIndex = facebookPicasaMap.get(mapKey);
				mappedPicasaContacts[picasaContactsIndex.intValue()] = 1;
				PicasaContact mappedPicasaContact = picasaContacts.get(
						picasaContactsIndex.intValue());
				newContact.setID(mappedPicasaContact.getID());
				newContact.setLocalContact(mappedPicasaContact.getLocalContact());
			}
			mergedFriends.add(newContact);
		}
		// Find all non-mapped existing Picasa Friends and add them to mergedFriends
		for (int i = 0; i < picasaContacts.size(); i++)
		{
			PicasaContact nextContact = picasaContacts.get(i);
			if (mappedPicasaContacts[i] == 0)
			{
				mergedFriends.add(nextContact);
			}
		}
		
		return mergedFriends;
	}
}
