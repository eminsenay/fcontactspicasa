package com.eminsenay.FacebookContactsForPicasa.UI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;

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
public class AboutBox extends Composite {
	private Label headerLabel;
	private Label versionLabel;
	private Label authorLabel;
	private Label labelHomepage;

	public AboutBox(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		FormLayout thisLayout = new FormLayout();
		this.setLayout(thisLayout);
		{
			labelHomepage = new Label(this, SWT.NONE);
			FormData labelHomepageLData = new FormData();
			labelHomepageLData.left =  new FormAttachment(0, 1000, 12);
			labelHomepageLData.top =  new FormAttachment(0, 1000, 75);
			labelHomepageLData.width = 264;
			labelHomepageLData.height = 18;
			labelHomepage.setLayoutData(labelHomepageLData);
			labelHomepage.setText("http://fcontactspicasa.sourceforge.net");
			labelHomepage.setAlignment(SWT.CENTER);
		}
		{
			authorLabel = new Label(this, SWT.NONE);
			FormData authorLabelLData = new FormData();
			authorLabelLData.left =  new FormAttachment(0, 1000, 12);
			authorLabelLData.top =  new FormAttachment(0, 1000, 54);
			authorLabelLData.width = 264;
			authorLabelLData.height = 18;
			authorLabel.setLayoutData(authorLabelLData);
			authorLabel.setText("Author: Emin \u015eenay");
			authorLabel.setAlignment(SWT.CENTER);
		}
		{
			versionLabel = new Label(this, SWT.NONE);
			FormData versionLabelLData = new FormData();
			versionLabelLData.left =  new FormAttachment(0, 1000, 12);
			versionLabelLData.top =  new FormAttachment(0, 1000, 33);
			versionLabelLData.width = 264;
			versionLabelLData.height = 18;
			versionLabel.setLayoutData(versionLabelLData);
			versionLabel.setText("version 0.1");
			versionLabel.setAlignment(SWT.CENTER);
		}
		{
			headerLabel = new Label(this, SWT.NONE);
			FormData headerLabelLData = new FormData();
			headerLabelLData.left =  new FormAttachment(0, 1000, 12);
			headerLabelLData.top =  new FormAttachment(0, 1000, 12);
			headerLabelLData.width = 264;
			headerLabelLData.height = 18;
			headerLabel.setLayoutData(headerLabelLData);
			headerLabel.setText("Facebook Contacts for Picasa");
			headerLabel.setAlignment(SWT.CENTER);
		}
		pack();
	}

}
