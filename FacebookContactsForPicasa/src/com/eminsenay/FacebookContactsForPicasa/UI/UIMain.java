package com.eminsenay.FacebookContactsForPicasa.UI;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;

import com.eminsenay.FacebookContactsForPicasa.Application;

public class UIMain {

	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="5,3"
	private Button BrowseButton = null;
	private Text ContactsTextBox = null;
	private Label ContactsXmlPathLabel = null;
	private Button RunButton = null;

	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		GridData gridData2 = new GridData();
		gridData2.grabExcessHorizontalSpace = false;
		gridData2.verticalAlignment = GridData.CENTER;
		gridData2.horizontalAlignment = GridData.FILL;
		GridData gridData11 = new GridData();
		gridData11.horizontalAlignment = GridData.FILL;
		gridData11.grabExcessHorizontalSpace = true;
		gridData11.verticalAlignment = GridData.CENTER;
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.BEGINNING;
		gridData1.grabExcessHorizontalSpace = false;
		gridData1.grabExcessVerticalSpace = false;
		gridData1.verticalAlignment = GridData.CENTER;
		GridData gridData = new GridData();
		gridData.horizontalSpan = 5;
		gridData.grabExcessHorizontalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		sShell = new Shell(SWT.SHELL_TRIM | SWT.APPLICATION_MODAL);
		sShell.setText("Facebook Contacts For Picasa");
		sShell.setSize(new Point(475, 200));
		sShell.setLayout(gridLayout);
		ContactsXmlPathLabel = new Label(sShell, SWT.NONE);
		ContactsXmlPathLabel.setText("Picasa contacts.xml path: ");
		ContactsTextBox = new Text(sShell, SWT.BORDER);
		ContactsTextBox.setLayoutData(gridData11);
		BrowseButton = new Button(sShell, SWT.NONE);
		BrowseButton.setText("Browse");
		BrowseButton.setLayoutData(gridData1);
		Label filler = new Label(sShell, SWT.NONE);
		Label filler1 = new Label(sShell, SWT.NONE);
		RunButton = new Button(sShell, SWT.NONE);
		RunButton.setText("Run");
		RunButton.setLayoutData(gridData2);
		RunButton.addSelectionListener(new RunButtonListener());
		BrowseButton.addSelectionListener(new BrowseButtonListener());
		sShell.setSize(new Point(300, 200));
		ContactsTextBox.setLayoutData(gridData);
	}
	
	public void Open()
	{
		createSShell();
		Display d = sShell.getDisplay();
		sShell.open();
		while (!sShell.isDisposed()) 
		{
			if (!d.readAndDispatch ())
			{
				d.sleep (); 
			}
		} 
		d.dispose ();
	}
	
	class BrowseButtonListener implements SelectionListener
	{
		public void widgetSelected(SelectionEvent e)
		{
			System.out.println("widgetSelected()");
		}
		public void widgetDefaultSelected(SelectionEvent e)
		{
		}
	}
	
	class RunButtonListener implements SelectionListener
	{
		public void widgetSelected(SelectionEvent e)
		{
			Application app = new Application();
			app.setContactsXmlPath(ContactsTextBox.getText());
			app.Run();
		}
		public void widgetDefaultSelected(SelectionEvent e)
		{
		}
	}

}
