package com.eminsenay.FacebookContactsForPicasa.UI;
import java.util.ArrayList;

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
	private Combo comboSynchronizeWith;
	private Text textContactNickname;
	private Text textContactName;
	private Label labelContactSynchronize;
	private Label labelContactNickname;
	private Label labelContactName;
	private List listFacebookContacts;
	private Button buttonRun;
	private Button buttonBrowse;
	private Text textContactsXmlPath;
	private FacebookFriendFetcher facebookFriendFetcher;

	public UIMain(Composite parent, int style) {
		super(parent, style);
		initialize();
		facebookFriendFetcher = new FacebookFriendFetcher();
	}

	private void initialize() {
		FormLayout thisLayout = new FormLayout();
		this.setLayout(thisLayout);
		{
			groupPicasaSettings = new Group(this, SWT.NONE);
			FormLayout groupPicasaSettingsLayout = new FormLayout();
			groupPicasaSettings.setLayout(groupPicasaSettingsLayout);
			FormData groupPicasaSettingsLData = new FormData();
			groupPicasaSettingsLData.left =  new FormAttachment(0, 1000, 12);
			groupPicasaSettingsLData.top =  new FormAttachment(0, 1000, 7);
			groupPicasaSettingsLData.width = 578;
			groupPicasaSettingsLData.height = 38;
			groupPicasaSettingsLData.right =  new FormAttachment(1000, 1000, -12);
			groupPicasaSettings.setLayoutData(groupPicasaSettingsLData);
			groupPicasaSettings.setText("Picasa Settings");
			{
				labelContactsXmlPath = new Label(groupPicasaSettings, SWT.NONE);
				FormData labelContactsXmlPathLData = new FormData();
				labelContactsXmlPathLData.width = 112;
				labelContactsXmlPathLData.height = 13;
				labelContactsXmlPathLData.left =  new FormAttachment(0, 1000, 8);
				labelContactsXmlPathLData.top =  new FormAttachment(328, 1000, 0);
				labelContactsXmlPath.setLayoutData(labelContactsXmlPathLData);
				labelContactsXmlPath.setText("Contacts.xml Path:");
			}
			{
				FormData textContactsXmlPathLData = new FormData();
				textContactsXmlPathLData.width = 227;
				textContactsXmlPathLData.height = 19;
				textContactsXmlPathLData.top =  new FormAttachment(242, 1000, 0);
				textContactsXmlPathLData.left =  new FormAttachment(0, 1000, 126);
				textContactsXmlPathLData.right =  new FormAttachment(1000, 1000, -217);
				textContactsXmlPathLData.bottom =  new FormAttachment(785, 1000, 0);
				textContactsXmlPath = new Text(groupPicasaSettings, SWT.NONE);
				textContactsXmlPath.setLayoutData(textContactsXmlPathLData);
				textContactsXmlPath.setOrientation(SWT.HORIZONTAL);
				textContactsXmlPath.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
			}
			{
				buttonBrowse = new Button(groupPicasaSettings, SWT.PUSH | SWT.CENTER);
				FormData buttonBrowseLData = new FormData();
				buttonBrowseLData.width = 60;
				buttonBrowseLData.height = 26;
				buttonBrowseLData.top =  new FormAttachment(128, 1000, 0);
				buttonBrowseLData.right =  new FormAttachment(1000, 1000, -145);
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
				buttonGetPicasaContactsLData.width = 124;
				buttonGetPicasaContactsLData.height = 26;
				buttonGetPicasaContactsLData.top =  new FormAttachment(128, 1000, 0);
				buttonGetPicasaContactsLData.right =  new FormAttachment(1000, 1000, -9);
				buttonGetPicasaContacts.setLayoutData(buttonGetPicasaContactsLData);
				buttonGetPicasaContacts.setText("Get Picasa Contacts");
			}
		}
		{
			comboSynchronizeWith = new Combo(this, SWT.NONE);
			FormData comboSynchronizeWithLData = new FormData();
			comboSynchronizeWithLData.left =  new FormAttachment(0, 1000, 387);
			comboSynchronizeWithLData.top =  new FormAttachment(0, 1000, 206);
			comboSynchronizeWithLData.width = 126;
			comboSynchronizeWithLData.height = 21;
			comboSynchronizeWithLData.right =  new FormAttachment(1000, 1000, -66);
			comboSynchronizeWith.setLayoutData(comboSynchronizeWithLData);
			comboSynchronizeWith.setText("None");
			comboSynchronizeWith.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
		}
		{
			FormData textContactNicknameLData = new FormData();
			textContactNicknameLData.left =  new FormAttachment(0, 1000, 387);
			textContactNicknameLData.top =  new FormAttachment(0, 1000, 178);
			textContactNicknameLData.width = 149;
			textContactNicknameLData.height = 19;
			textContactNicknameLData.right =  new FormAttachment(1000, 1000, -66);
			textContactNickname = new Text(this, SWT.NONE);
			textContactNickname.setLayoutData(textContactNicknameLData);
			textContactNickname.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
		}
		{
			FormData textContactNameLData = new FormData();
			textContactNameLData.left =  new FormAttachment(0, 1000, 387);
			textContactNameLData.top =  new FormAttachment(0, 1000, 151);
			textContactNameLData.width = 149;
			textContactNameLData.height = 18;
			textContactNameLData.right =  new FormAttachment(1000, 1000, -66);
			textContactName = new Text(this, SWT.NONE);
			textContactName.setLayoutData(textContactNameLData);
			textContactName.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
		}
		{
			labelContactSynchronize = new Label(this, SWT.NONE);
			FormData labelContactSynchronizeLData = new FormData();
			labelContactSynchronizeLData.left =  new FormAttachment(0, 1000, 247);
			labelContactSynchronizeLData.top =  new FormAttachment(0, 1000, 211);
			labelContactSynchronizeLData.width = 107;
			labelContactSynchronizeLData.height = 13;
			labelContactSynchronize.setLayoutData(labelContactSynchronizeLData);
			labelContactSynchronize.setText("Synchronize With:");
		}
		{
			labelContactNickname = new Label(this, SWT.NONE);
			FormData labelContactNicknameLData = new FormData();
			labelContactNicknameLData.left =  new FormAttachment(0, 1000, 247);
			labelContactNicknameLData.top =  new FormAttachment(0, 1000, 181);
			labelContactNicknameLData.width = 107;
			labelContactNicknameLData.height = 13;
			labelContactNickname.setLayoutData(labelContactNicknameLData);
			labelContactNickname.setText("Nickname:");
		}
		{
			labelContactName = new Label(this, SWT.NONE);
			FormData labelContactNameLData = new FormData();
			labelContactNameLData.left =  new FormAttachment(0, 1000, 247);
			labelContactNameLData.top =  new FormAttachment(0, 1000, 153);
			labelContactNameLData.width = 107;
			labelContactNameLData.height = 13;
			labelContactName.setLayoutData(labelContactNameLData);
			labelContactName.setText("Name:");
		}
		{
			FormData listFacebookContactsLData = new FormData();
			listFacebookContactsLData.left =  new FormAttachment(0, 1000, 12);
			listFacebookContactsLData.top =  new FormAttachment(0, 1000, 113);
			listFacebookContactsLData.width = 209;
			listFacebookContactsLData.height = 221;
			listFacebookContactsLData.bottom =  new FormAttachment(1000, 1000, -12);
			listFacebookContacts = new List(this, SWT.V_SCROLL);
			listFacebookContacts.setLayoutData(listFacebookContactsLData);
			listFacebookContacts.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
		}
		{
			buttonLogin = new Button(this, SWT.PUSH | SWT.CENTER);
			FormData buttonLoginLData = new FormData();
			buttonLoginLData.left =  new FormAttachment(0, 1000, 12);
			buttonLoginLData.top =  new FormAttachment(0, 1000, 73);
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
			buttonRun = new Button(this, SWT.PUSH | SWT.CENTER);
			FormData buttonRunLData = new FormData();
			buttonRunLData.width = 61;
			buttonRunLData.height = 29;
			buttonRunLData.right =  new FormAttachment(1000, 1000, -12);
			buttonRunLData.bottom =  new FormAttachment(1000, 1000, -12);
			buttonRun.setLayoutData(buttonRunLData);
			buttonRun.setText("Save");
			buttonRun.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					buttonRunWidgetSelected(evt);
				}
			});
		}
		pack();
		this.setSize(608, 346);
	}
	
	private void buttonRunWidgetSelected(SelectionEvent evt) {
		Application app = new Application();
		app.setContactsXmlPath(textContactsXmlPath.getText());
		app.Run();
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
			ArrayList<PicasaContact> facebookFriends =
				facebookFriendFetcher.GetFriends();
			
			for (PicasaContact picasaContact : facebookFriends) {
//				System.out.println(picasaContact.getName());
				listFacebookContacts.add(picasaContact.getName());
			}
		}
//		System.out.println("Address:" + currAddress);
	}

}
