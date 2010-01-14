package com.eminsenay.FacebookContactsForPicasa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

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
 * Modified from FacebookClient of Mitch Coopet, Code 42 Software, Inc.
 * The original code can be found at: http://straylink.wordpress.com/2008/06/03/logging-in-with-facebook-java-api/
 */
public class FacebookFriendFetcher {
	
	private static String API_KEY = "Your API Key";
	private static String SECRET = "Your Secret Key";
	
	public FacebookFriendFetcher()
	{}
	
	public ArrayList<PicasaContact> GetFriends()
	{
		ArrayList<PicasaContact> userNames = null;
		// Create the client instance
		FacebookJaxbRestClient client = new FacebookJaxbRestClient(API_KEY,
				SECRET);

		try {
			String token = client.auth_createToken();
			// Build the authentication URL for the user to fill out
			String url = "http://www.facebook.com/login.php?api_key=" + API_KEY
					+ "&v=1.0" + "&auth_token=" + token;
			// Open an external browser to login to your application
			Runtime.getRuntime().exec("open " + url); // OS X only!
			// Wait until the login process is completed
			System.out.println("Use browser to login then press return");
			System.in.read();

			client.auth_getSession(token, true);
			String sessionSecret = client.getCacheSessionSecret();
			String sessionKey = client.getCacheSessionKey();
			// new facebook client object
			client = new FacebookJaxbRestClient(API_KEY, sessionSecret, sessionKey);

			// keep track of the logged in user id
			//Long userId = client.users_getLoggedInUser();
//			System.out.println("Fetching friends for user " + userId);

			// Get friends list
			FriendsGetResponse response = client.friends_get();
			List<Long> friends = response.getUid();

			// Go fetch the information for the user list of user ids
			UsersGetInfoResponse userResponse = client.users_getInfo(friends,
					EnumSet.of(ProfileField.NAME));

			// Print out the user information
			List<User> users = userResponse.getUser();
			userNames = new ArrayList<PicasaContact>();
			for (User user : users) {
				PicasaContact newContact = new PicasaContact();
				newContact.setName(user.getName());
				userNames.add(newContact);
//				System.out.println(user.getName());
			}
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userNames;
	}
	

}
