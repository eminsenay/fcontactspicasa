package com.eminsenay.FacebookContactsForPicasa.UI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;

import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import com.eminsenay.FacebookContactsForPicasa.BusinessLogic.*;

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
public class UIMain extends Composite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	
	private Label labelContactsXmlPath;
	private Button buttonLogin;
	private Group groupPicasaSettings;
	private Button buttonGetPicasaContacts;
	private Combo comboMergeWith;
	private Text textContactName;
	private Label labelContactMerge;
	private Label labelContactName;
	private List listFacebookContacts;
	private Button buttonSave;
	private Button buttonBrowse;
	private Text textContactsXmlPath;
	private FacebookFriendFetcher facebookFriendFetcher;
	private ArrayList<PicasaContact> m_FacebookFriends;
	private ArrayList<PicasaContact> m_PicasaContacts;
	private Hashtable<Integer, Integer> m_FacebookPicasaMap;
	
	public Hashtable<Integer, Integer> getFacebookPicasaMap() {
		return m_FacebookPicasaMap;
	}

	public void setFacebookPicasaMap(
			Hashtable<Integer, Integer> facebookPicasaMap) {
		m_FacebookPicasaMap = facebookPicasaMap;
	}

	public ArrayList<PicasaContact> getPicasaContacts() {
		return m_PicasaContacts;
	}

	public void setPicasaContacts(ArrayList<PicasaContact> picasaContacts) {
		m_PicasaContacts = picasaContacts;
	}

	public ArrayList<PicasaContact> getFacebookFriends() {
		return m_FacebookFriends;
	}

	public void setFacebookFriends(ArrayList<PicasaContact> facebookFriends) {
		m_FacebookFriends = facebookFriends;
	}

	public UIMain(Composite parent, int style) {
		super(parent, style);
		initialize();
		facebookFriendFetcher = new FacebookFriendFetcher();
		this.setFacebookPicasaMap(new Hashtable<Integer, Integer>());
	}

	private void initialize() {
		FormLayout thisLayout = new FormLayout();
		this.setLayout(thisLayout);
		{
			groupPicasaSettings = new Group(this, SWT.NONE);
			FormLayout groupPicasaSettingsLayout = new FormLayout();
			groupPicasaSettings.setLayout(groupPicasaSettingsLayout);
			FormData groupPicasaSettingsLData = new FormData();
			groupPicasaSettingsLData.left =  new FormAttachment(0, 1000, 248);
			groupPicasaSettingsLData.top =  new FormAttachment(0, 1000, 12);
			groupPicasaSettingsLData.width = 470;
			groupPicasaSettingsLData.height = 79;
			groupPicasaSettingsLData.right =  new FormAttachment(1000, 1000, -20);
			groupPicasaSettings.setLayoutData(groupPicasaSettingsLData);
			groupPicasaSettings.setText("Picasa Settings");
			{
				labelContactsXmlPath = new Label(groupPicasaSettings, SWT.NONE);
				FormData labelContactsXmlPathLData = new FormData();
				labelContactsXmlPathLData.width = 480;
				labelContactsXmlPathLData.height = 16;
				labelContactsXmlPathLData.left =  new FormAttachment(0, 1000, 5);
				labelContactsXmlPathLData.top =  new FormAttachment(64, 1000, 0);
				labelContactsXmlPath.setLayoutData(labelContactsXmlPathLData);
				labelContactsXmlPath.setText("Contacts.xml Path:");
			}
			{
				FormData textContactsXmlPathLData = new FormData();
				textContactsXmlPathLData.width = 384;
				textContactsXmlPathLData.height = 16;
				textContactsXmlPathLData.top =  new FormAttachment(335, 1000, 0);
				textContactsXmlPathLData.left =  new FormAttachment(0, 1000, 5);
				textContactsXmlPathLData.right =  new FormAttachment(1000, 1000, -79);
				textContactsXmlPathLData.bottom =  new FormAttachment(546, 1000, 0);
				textContactsXmlPath = new Text(groupPicasaSettings, SWT.NONE);
				textContactsXmlPath.setLayoutData(textContactsXmlPathLData);
				textContactsXmlPath.setOrientation(SWT.HORIZONTAL);
				textContactsXmlPath.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
			}
			{
				buttonBrowse = new Button(groupPicasaSettings, SWT.PUSH | SWT.CENTER);
				FormData buttonBrowseLData = new FormData();
				buttonBrowseLData.width = 66;
				buttonBrowseLData.height = 26;
				buttonBrowseLData.top =  new FormAttachment(256, 1000, 0);
				buttonBrowseLData.right =  new FormAttachment(1000, 1000, -1);
				buttonBrowse.setLayoutData(buttonBrowseLData);
				buttonBrowse.setText("Browse");
				buttonBrowse.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						buttonBrowseWidgetSelected(evt);
					}
				});
			}
			{
				buttonGetPicasaContacts = new Button(groupPicasaSettings, SWT.PUSH | SWT.CENTER);
				FormData buttonGetPicasaContactsLData = new FormData();
				buttonGetPicasaContactsLData.width = 148;
				buttonGetPicasaContactsLData.height = 26;
				buttonGetPicasaContactsLData.top =  new FormAttachment(664, 1000, 0);
				buttonGetPicasaContactsLData.right =  new FormAttachment(1000, 1000, 2);
				buttonGetPicasaContacts.setLayoutData(buttonGetPicasaContactsLData);
				buttonGetPicasaContacts.setText("Get Picasa Contacts");
				buttonGetPicasaContacts.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						buttonGetPicasaContactsWidgetSelected(evt);
					}
				});
			}
		}
		{
			comboMergeWith = new Combo(this, SWT.DROP_DOWN | SWT.READ_ONLY);
			FormData comboMergeWithLData = new FormData();
			comboMergeWithLData.left =  new FormAttachment(0, 1000, 387);
			comboMergeWithLData.top =  new FormAttachment(0, 1000, 175);
			comboMergeWithLData.width = 297;
			comboMergeWithLData.height = 23;
			comboMergeWithLData.right =  new FormAttachment(1000, 1000, -66);
			comboMergeWith.setLayoutData(comboMergeWithLData);
			comboMergeWith.add("None");
			comboMergeWith.select(0);
			comboMergeWith.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
		}
		{
			FormData textContactNameLData = new FormData();
			textContactNameLData.left =  new FormAttachment(0, 1000, 387);
			textContactNameLData.top =  new FormAttachment(0, 1000, 137);
			textContactNameLData.width = 297;
			textContactNameLData.height = 18;
			textContactNameLData.right =  new FormAttachment(1000, 1000, -66);
			textContactName = new Text(this, SWT.NONE);
			textContactName.setLayoutData(textContactNameLData);
			textContactName.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
		}
		{
			labelContactMerge = new Label(this, SWT.NONE);
			FormData labelContactMergeLData = new FormData();
			labelContactMergeLData.left =  new FormAttachment(0, 1000, 248);
			labelContactMergeLData.top =  new FormAttachment(0, 1000, 177);
			labelContactMergeLData.width = 107;
			labelContactMergeLData.height = 18;
			labelContactMerge.setLayoutData(labelContactMergeLData);
			labelContactMerge.setText("Merge With:");
		}
		{
			labelContactName = new Label(this, SWT.NONE);
			FormData labelContactNameLData = new FormData();
			labelContactNameLData.left =  new FormAttachment(0, 1000, 248);
			labelContactNameLData.top =  new FormAttachment(0, 1000, 138);
			labelContactNameLData.width = 107;
			labelContactNameLData.height = 16;
			labelContactName.setLayoutData(labelContactNameLData);
			labelContactName.setText("Name:");
		}
		{
			FormData listFacebookContactsLData = new FormData();
			listFacebookContactsLData.left =  new FormAttachment(0, 1000, 12);
			listFacebookContactsLData.top =  new FormAttachment(0, 1000, 48);
			listFacebookContactsLData.width = 209;
			listFacebookContactsLData.height = 286;
			listFacebookContactsLData.bottom =  new FormAttachment(1000, 1000, -12);
			listFacebookContacts = new List(this, SWT.V_SCROLL);
			listFacebookContacts.setLayoutData(listFacebookContactsLData);
			listFacebookContacts.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
			listFacebookContacts.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					listFacebookContactsWidgetSelected(evt);
				}
			});
		}
		{
			buttonLogin = new Button(this, SWT.PUSH | SWT.CENTER);
			FormData buttonLoginLData = new FormData();
			buttonLoginLData.left =  new FormAttachment(0, 1000, 12);
			buttonLoginLData.top =  new FormAttachment(0, 1000, 12);
			buttonLoginLData.width = 161;
			buttonLoginLData.height = 28;
			buttonLogin.setLayoutData(buttonLoginLData);
			buttonLogin.setText("Get Facebook Contacts");
			buttonLogin.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					buttonLoginWidgetSelected(evt);
				}
			});
		}
		{
			buttonSave = new Button(this, SWT.PUSH | SWT.CENTER);
			FormData buttonSaveLData = new FormData();
			buttonSaveLData.width = 61;
			buttonSaveLData.height = 29;
			buttonSaveLData.right =  new FormAttachment(1000, 1000, -12);
			buttonSaveLData.bottom =  new FormAttachment(1000, 1000, -12);
			buttonSave.setLayoutData(buttonSaveLData);
			buttonSave.setText("Save");
			buttonSave.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					buttonRunWidgetSelected(evt);
				}
			});
		}
		pack();
	}
	
	private void buttonRunWidgetSelected(SelectionEvent evt) {
		//TODO: implement
	}
	
	private void buttonBrowseWidgetSelected(SelectionEvent evt) {
		FileDialog fd = new FileDialog(this.getShell(), SWT.OPEN);
        fd.setText("Open");
        //...Local Settings\Application Data\Google\Picasa2\contacts\contacts.xml
        fd.setFilterPath(System.getProperty("user.home"));
        String[] filterExt = { "*.xml" };
        fd.setFilterExtensions(filterExt);
        String selected = fd.open();
        if (selected != null) 
        {
        	textContactsXmlPath.setText(selected);	
        }
	}
	
	private void buttonLoginWidgetSelected(SelectionEvent evt)
	{
		final Shell dialog = new Shell(this.getShell(), SWT.APPLICATION_MODAL
				| SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX);
		dialog.setText("Browser");
		dialog.setSize(600, 400);
		dialog.setLayout(new FillLayout());
		
		UIBrowser browser = new UIBrowser(dialog, SWT.NONE);
		
		// Not using AutoClose feature because of an error in Mac
		// __NSAutoreleaseNoPool(): Object 0x100677900 of class NSEvent autoreleased with no pool in place - just leaking
		//ArrayList<String> autoCloseURLs = new ArrayList<String>();
		//autoCloseURLs.add("http://www.facebook.com/connect/login_success.html");
		//autoCloseURLs.add("http://www.facebook.com/connect/login_failure.html");
		//browser.setAutoCloseURLs(autoCloseURLs);
		browser.OpenURL("http://www.facebook.com/login.php?api_key=51131cfef6080b4e5e0e48fc1ba50580&connect_display=popup&v=1.0&next=http://www.facebook.com/connect/login_success.html&cancel_url=http://www.facebook.com/connect/login_failure.html&fbconnect=true&return_session=true&session_key_only=true");
		
		dialog.open();
		// Wait until the browser is closed
		while(!dialog.isDisposed())
		{
			if (!this.getShell().getDisplay().readAndDispatch())
				this.getShell().getDisplay().sleep();
		}
		String currAddress = browser.getCurrentAddress();
		if (facebookFriendFetcher.ParseUrl(currAddress))
		{
			getFacebookPicasaMap().clear();
			ArrayList<PicasaContact> facebookFriends = facebookFriendFetcher.GetFriends();
			Collections.sort(facebookFriends, new Comparator<PicasaContact>() {
				  public int compare(PicasaContact c1, PicasaContact c2) {
		               return c1.getName().compareToIgnoreCase(c2.getName());
		            }
			});
			setFacebookFriends(facebookFriends);
			
			for (PicasaContact picasaContact : facebookFriends) {
//				System.out.println(picasaContact.getName());
				listFacebookContacts.add(picasaContact.getName());
			}
		}
		MatchContacts();
//		System.out.println("Address:" + currAddress);
	}
	
	private void listFacebookContactsWidgetSelected(SelectionEvent evt) {
		int selectionIndex = listFacebookContacts.getSelectionIndex();
		PicasaContact activeContact = getFacebookFriends().get(selectionIndex);
		textContactName.setText(activeContact.getName());
		Hashtable<Integer, Integer> facebookPicasaMap = getFacebookPicasaMap();
		Integer i_SelectionIndex = new Integer(selectionIndex);
		if (facebookPicasaMap.containsKey(i_SelectionIndex))
		{
			comboMergeWith.select(getFacebookPicasaMap().get(i_SelectionIndex).intValue() + 1);
		}
		else
		{
			comboMergeWith.select(0); // select None
		}
	}
	
	private void buttonGetPicasaContactsWidgetSelected(SelectionEvent evt) {
		if (textContactsXmlPath != null && textContactsXmlPath.getText() != null &&
				textContactsXmlPath.getText() != "")
		{
			PicasaXmlReader reader = new PicasaXmlReader(textContactsXmlPath.getText());
			try {
				ArrayList<PicasaContact> picasaContacts = reader.Read();
				Collections.sort(picasaContacts, new Comparator<PicasaContact>() {
					  public int compare(PicasaContact c1, PicasaContact c2) {
			               return c1.getName().compareToIgnoreCase(c2.getName());
			            }
				});
				setPicasaContacts(picasaContacts);
				for (int i = 0; i < picasaContacts.size(); i++) {
					PicasaContact picasaContact = picasaContacts.get(i);
					comboMergeWith.add(picasaContact.getName());
				}
				getFacebookPicasaMap().clear();
				MatchContacts();
				MessageBox mb = new MessageBox(this.getShell(), SWT.OK);
				mb.setText("Facebook Contacts for Picasa");
				mb.setMessage("Existing Picasa contacts are read successfully.");
				mb.open();
			} catch (Exception e) {
				MessageBox mb = new MessageBox(this.getShell(), SWT.OK);
				mb.setText("Facebook Contacts for Picasa");
				mb.setMessage("Contacts.xml could not be read.");
				mb.open();
			}
		}
	}
	
	private void MatchContacts()
	{
		ArrayList<PicasaContact> facebookFriends = getFacebookFriends();
		ArrayList<PicasaContact> picasaContacts = getPicasaContacts();
		Hashtable<Integer, Integer> facebookPicasaMap = getFacebookPicasaMap();
		if (facebookFriends != null && !facebookFriends.isEmpty() &&
				picasaContacts != null && !picasaContacts.isEmpty())
		{
			facebookPicasaMap.clear();
			for (int i = 0; i < facebookFriends.size(); i++)
			{
				for(int j = 0; j < picasaContacts.size(); j++)
				{
					if (facebookFriends.get(i).getName().equalsIgnoreCase(
							picasaContacts.get(j).getName()))
					{
						facebookPicasaMap.put(new Integer(i), new Integer(j));
						break;
					}
				}
			}
		}
	}

}
