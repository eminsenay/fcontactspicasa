package com.eminsenay.FacebookContactsForPicasa.UI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.eminsenay.FacebookContactsForPicasa.Application;

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
	private Label labelContactsXmlPath;
	private Button buttonRun;
	private Button buttonBrowse;
	private Text textContactsXmlPath;

	public UIMain(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		FormLayout thisLayout = new FormLayout();
		this.setLayout(thisLayout);
		{
			buttonRun = new Button(this, SWT.PUSH | SWT.CENTER);
			FormData buttonRunLData = new FormData();
			buttonRunLData.top =  new FormAttachment(0, 1000, 41);
			buttonRunLData.width = 47;
			buttonRunLData.height = 23;
			buttonRunLData.right =  new FormAttachment(1000, 1000, -12);
			buttonRun.setLayoutData(buttonRunLData);
			buttonRun.setText("Run");
			buttonRun.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					buttonRunWidgetSelected(evt);
				}
			});
		}
		{
			buttonBrowse = new Button(this, SWT.PUSH | SWT.CENTER);
			FormData buttonBrowseLData = new FormData();
			buttonBrowseLData.width = 47;
			buttonBrowseLData.height = 23;
			buttonBrowseLData.top =  new FormAttachment(0, 1000, 12);
			buttonBrowseLData.right =  new FormAttachment(1000, 1000, -11);
			buttonBrowse.setLayoutData(buttonBrowseLData);
			buttonBrowse.setText("Browse");
			buttonBrowse.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					buttonBrowseWidgetSelected(evt);
				}
			});
		}
		{
			FormData textContactsXmlPathLData = new FormData();
			textContactsXmlPathLData.left =  new FormAttachment(0, 1000, 146);
			textContactsXmlPathLData.top =  new FormAttachment(0, 1000, 17);
			textContactsXmlPathLData.width = 304;
			textContactsXmlPathLData.height = 13;
			textContactsXmlPathLData.right =  new FormAttachment(1000, 1000, -71);
			textContactsXmlPath = new Text(this, SWT.NONE);
			textContactsXmlPath.setLayoutData(textContactsXmlPathLData);
		}
		{
			labelContactsXmlPath = new Label(this, SWT.NONE);
			FormData labelContactsXmlPathLData = new FormData();
			labelContactsXmlPathLData.left =  new FormAttachment(0, 1000, 12);
			labelContactsXmlPathLData.top =  new FormAttachment(0, 1000, 17);
			labelContactsXmlPathLData.width = 122;
			labelContactsXmlPathLData.height = 13;
			labelContactsXmlPath.setLayoutData(labelContactsXmlPathLData);
			labelContactsXmlPath.setText("Path of the contacts.xml:");
		}
		pack();
		this.setSize(550, 200);
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

}
