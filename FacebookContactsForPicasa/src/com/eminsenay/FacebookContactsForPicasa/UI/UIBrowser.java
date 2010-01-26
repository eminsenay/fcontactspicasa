package com.eminsenay.FacebookContactsForPicasa.UI;
import java.net.URI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.LocationAdapter;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.eminsenay.FacebookContactsForPicasa.URLUtils;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class UIBrowser extends Composite {
	private Browser browser1;

	public UIBrowser(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		setSize(new Point(300, 200));
		FillLayout thisLayout = new FillLayout(org.eclipse.swt.SWT.HORIZONTAL);
		this.setLayout(thisLayout);
		{
			browser1 = new Browser(this, SWT.NONE);
			browser1.addLocationListener(new LocationAdapter() {
				public void changed(LocationEvent evt) {
					browser1Changed(evt);
				}
			});
		}
	}
	
	public void OpenURL(String url)
	{
		browser1.setUrl(url);
	}
	
	private void browser1Changed(LocationEvent evt) {
		System.out.println(evt.location);
		if (evt.location.startsWith("http://www.facebook.com/connect/login_success.html")) 
		{
			String asciiStr = URLUtils.Unescape(evt.location);
			int jsonObjStartIndex = asciiStr.indexOf("{");
			String jsonStr = asciiStr.substring(jsonObjStartIndex);
			JSONTokener tokener = new JSONTokener(jsonStr);
			try {
				JSONObject obj = new JSONObject(tokener);
				System.out.println(obj.getString("secret"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}

}
