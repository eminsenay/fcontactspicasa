package com.eminsenay.FacebookContactsForPicasa.BusinessLogic;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.code.facebookapi.FacebookException;
import com.google.code.facebookapi.FacebookJaxbRestClient;
import com.google.code.facebookapi.ProfileField;
import com.google.code.facebookapi.schema.FriendsGetResponse;
import com.google.code.facebookapi.schema.User;
import com.google.code.facebookapi.schema.UsersGetInfoResponse;

/**
 * FacebookFriendFetcher
 * 
 * @author Emin Senay
 */
public class FacebookFriendFetcher {
	
	private static String API_KEY = "51131cfef6080b4e5e0e48fc1ba50580";
	private String sessionSecret;
	private String sessionKey;
	
	private void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	private String getSessionKey() {
		return sessionKey;
	}

	private void setSessionSecret(String sessionSecret) {
		this.sessionSecret = sessionSecret;
	}

	private String getSessionSecret() {
		return sessionSecret;
	}

	public FacebookFriendFetcher()
	{
	}
	
	/**
	 * Parses a given Facebook connection url.
	 * @param url
	 * @return true if session key and session secret can be successfully
	 * retrieved from the given url.
	 * */
	public Boolean ParseUrl(String url)
	{
		if (url.startsWith("http://www.facebook.com/connect/login_success.html"))
		{
			String asciiStr = URLUtils.Unescape(url);
			int jsonObjStartIndex = asciiStr.indexOf("{");
			String jsonStr = asciiStr.substring(jsonObjStartIndex);
			JSONTokener tokener = new JSONTokener(jsonStr);
			try {
				JSONObject obj = new JSONObject(tokener);
				setSessionKey(obj.getString("session_key"));
				setSessionSecret(obj.getString("secret"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Retrieves information of all Facebook friends.
	 * {@link #ParseUrl(String)} must be called first to get a valid 
	 * session key and a session secret.
	 * @return List of Facebook friends as Picasa contacts.
	 * */
	public ArrayList<PicasaContact> GetFriends()
	{
		if (getSessionKey() == null || getSessionSecret() == null)
		{
			return null;
		}
		
		ArrayList<PicasaContact> userNames = null;
		FacebookJaxbRestClient client = null;

		try 
		{
			client = new FacebookJaxbRestClient(API_KEY, getSessionSecret(), 
					getSessionKey());

			// Get friends list
			FriendsGetResponse response = client.friends_get();
			List<Long> friends = response.getUid();

			// Go fetch the information for the user list of user ids
			UsersGetInfoResponse userResponse = client.users_getInfo(friends,
					EnumSet.of(ProfileField.NAME));

			// Save friend information
			List<User> users = userResponse.getUser();
			userNames = new ArrayList<PicasaContact>();
			for (User user : users)
			{
				PicasaContact newContact = new PicasaContact();
				newContact.setName(user.getName());
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
