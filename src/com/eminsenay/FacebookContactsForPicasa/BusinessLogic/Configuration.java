package com.eminsenay.FacebookContactsForPicasa.BusinessLogic;

/**
 * Contains the Facebook configuration such as app id or secret.
 * Register a new application and get your app id and secret if you want to run this application from the source code.  
 */
public class Configuration {

	public static final String FACEBOOK_APP_ID = "YOUR_ID_HERE";
	public static final String FACEBOOK_APP_SECRET = "YOUR_SECRET_HERE";
	public static final String FACEBOOK_REDIRECT_URI = "https://www.facebook.com/connect/login_success.html";
	
	public static String FACEBOOK_ACCESS_TOKEN = null;
	
	/** 
	 * Tries to get the Facebook access token from the given redirect address and
	 * sets the {@link Configuration.FACEBOOK_ACCESS_TOKEN} in success case. 
	 * @param uri Facebook redirect address which contains the user response.
	 * @return true if the Facebook access token can be set. The user may either authorize the app or press cancel button 
	 * (or directly close the browser). At first case, the redirect uri is expected to contain the access token.
	 */
	public static boolean setAccessTokenFromRedirectUri(String uri)
	{
		if (uri == null || uri.equals(""))
		{
			return false;
		}
		String asciiStr = URLUtils.Unescape(uri);
		int accessTokenIndex = asciiStr.indexOf("access_token=");
		if (accessTokenIndex == -1)
		{
			return false;
		}
		int expiresInIndex = asciiStr.indexOf("&expires_in=");
		if (expiresInIndex == -1)
		{
			FACEBOOK_ACCESS_TOKEN = asciiStr.substring(accessTokenIndex + 13);
		}
		else
		{
			FACEBOOK_ACCESS_TOKEN = asciiStr.substring(accessTokenIndex + 13, expiresInIndex);
		}
		return true;
	}
}
