package com.eminsenay.FacebookContactsForPicasa.BusinessLogic;
import java.util.ArrayList;
import java.util.List;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Friend;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

/**
 * FacebookFriendFetcher
 * 
 * @author Emin Senay
 */
public class FacebookFriendFetcher 
{
	public FacebookFriendFetcher()
	{
	}
	
	/**
	 * Retrieves information of all Facebook friends.
	 * {@link #ParseUrl(String)} must be called first to get a valid 
	 * session key and a session secret.
	 * @return List of Facebook friends as Picasa contacts.
	 * */
	public List<PicasaContact> GetFriends()
	{
		Facebook facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId(Configuration.FACEBOOK_APP_ID, Configuration.FACEBOOK_APP_SECRET);
		facebook.setOAuthAccessToken(new AccessToken(Configuration.FACEBOOK_ACCESS_TOKEN));
		
		ResponseList<Friend> friends = null;
		List<PicasaContact> userNames = null;
		try 
		{
			friends = facebook.getFriends();
			if (friends != null)
			{
				userNames = new ArrayList<PicasaContact>();
			}
			for (Friend friend : friends) 
			{
				PicasaContact newContact = new PicasaContact();
				newContact.setName(friend.getName());
				userNames.add(newContact);
			}
		} 
		catch (FacebookException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userNames;
	}
}
