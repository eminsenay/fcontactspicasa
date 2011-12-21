package com.eminsenay.FacebookContactsForPicasa.UI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;

public class MainWindow {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(700, 480);
		shell.setText("Facebook Contacts for Picasa");
		shell.setLayout(new FormLayout());
		
		SashForm sashForm = new SashForm(shell, SWT.NONE);
		FormData fd_sashForm = new FormData();
		fd_sashForm.top = new FormAttachment(0);
		fd_sashForm.left = new FormAttachment(0);
		fd_sashForm.bottom = new FormAttachment(100);
		fd_sashForm.right = new FormAttachment(100);
		sashForm.setLayoutData(fd_sashForm);
		
		Composite composite = new Composite(sashForm, SWT.NONE);
		composite.setLayout(new FormLayout());
		
		Label lblExisting = new Label(composite, SWT.NONE);
		FormData fd_lblExisting = new FormData();
		fd_lblExisting.top = new FormAttachment(0, 5);
		fd_lblExisting.left = new FormAttachment(0);
		lblExisting.setLayoutData(fd_lblExisting);
		lblExisting.setText("Existing Picasa Contacts");
		
		ScrolledComposite scrolledCompositeExisting = new ScrolledComposite(composite, SWT.BORDER | 
				SWT.H_SCROLL | SWT.V_SCROLL);
		FormData fd_scrolledCompositeExisting = new FormData();
		fd_scrolledCompositeExisting.top = new FormAttachment(lblExisting, 6);
		fd_scrolledCompositeExisting.bottom = new FormAttachment(100);
		fd_scrolledCompositeExisting.left = new FormAttachment(0);
		fd_scrolledCompositeExisting.right = new FormAttachment(100);
		scrolledCompositeExisting.setLayoutData(fd_scrolledCompositeExisting);
		scrolledCompositeExisting.setExpandHorizontal(true);
		scrolledCompositeExisting.setExpandVertical(true);
		
		List listExisting = new List(scrolledCompositeExisting, SWT.NONE);
		scrolledCompositeExisting.setContent(listExisting);
		scrolledCompositeExisting.setMinSize(listExisting.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setLayout(new FormLayout());
		
		Button btnSave = new Button(composite_1, SWT.NONE);
		FormData fd_btnSave = new FormData();
		fd_btnSave.left = new FormAttachment(100, -65);
		fd_btnSave.top = new FormAttachment(0);
		fd_btnSave.right = new FormAttachment(100);
		btnSave.setLayoutData(fd_btnSave);
		btnSave.setText("Save");
		
		Label lblResulting = new Label(composite_1, SWT.NONE);
		FormData fd_lblResulting = new FormData();
		fd_lblResulting.top = new FormAttachment(0, 5);
		fd_lblResulting.left = new FormAttachment(0);
		lblResulting.setLayoutData(fd_lblResulting);
		lblResulting.setText("Resulting Contacts");
		
		ScrolledComposite scrolledCompositeResulting = new ScrolledComposite(composite_1, SWT.BORDER | 
				SWT.H_SCROLL | SWT.V_SCROLL);
		FormData fd_scrolledCompositeResulting = new FormData();
		fd_scrolledCompositeResulting.top = new FormAttachment(btnSave, 1);
		fd_scrolledCompositeResulting.bottom = new FormAttachment(100);
		fd_scrolledCompositeResulting.left = new FormAttachment(0);
		fd_scrolledCompositeResulting.right = new FormAttachment(100);
		scrolledCompositeResulting.setLayoutData(fd_scrolledCompositeResulting);
		scrolledCompositeResulting.setExpandHorizontal(true);
		scrolledCompositeResulting.setExpandVertical(true);
		
		List listResulting = new List(scrolledCompositeResulting, SWT.NONE);
		scrolledCompositeResulting.setContent(listResulting);
		scrolledCompositeResulting.setMinSize(listResulting.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		Composite composite_2 = new Composite(sashForm, SWT.NONE);
		composite_2.setLayout(new FormLayout());
		
		Button btnGetContacts = new Button(composite_2, SWT.NONE);
		FormData fd_btnGetContacts = new FormData();
		fd_btnGetContacts.right = new FormAttachment(100);
		btnGetContacts.setLayoutData(fd_btnGetContacts);
		btnGetContacts.setText("Get Contacts");
		
		Label lblFacebook = new Label(composite_2, SWT.NONE);
		FormData fd_lblFacebook = new FormData();
		fd_lblFacebook.top = new FormAttachment(btnGetContacts, 5, SWT.TOP);
		fd_lblFacebook.left = new FormAttachment(0);
		lblFacebook.setLayoutData(fd_lblFacebook);
		lblFacebook.setText("Facebook Contacts");
		
		ScrolledComposite scrolledCompositeFacebook = new ScrolledComposite(composite_2, SWT.BORDER | 
				SWT.H_SCROLL | SWT.V_SCROLL);
		FormData fd_scrolledCompositeFacebook = new FormData();
		fd_scrolledCompositeFacebook.top = new FormAttachment(btnGetContacts, 1);
		fd_scrolledCompositeFacebook.right = new FormAttachment(btnGetContacts, 0, SWT.RIGHT);
		fd_scrolledCompositeFacebook.left = new FormAttachment(0);
		fd_scrolledCompositeFacebook.bottom = new FormAttachment(100, 0);
		scrolledCompositeFacebook.setLayoutData(fd_scrolledCompositeFacebook);
		scrolledCompositeFacebook.setExpandHorizontal(true);
		scrolledCompositeFacebook.setExpandVertical(true);
		
		List listFacebook = new List(scrolledCompositeFacebook, SWT.NONE);
		scrolledCompositeFacebook.setContent(listFacebook);
		scrolledCompositeFacebook.setMinSize(listFacebook.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		sashForm.setWeights(new int[] {1, 1, 1});
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmTools = new MenuItem(menu, SWT.CASCADE);
		mntmTools.setText("Tools");
		
		Menu menu_1 = new Menu(mntmTools);
		mntmTools.setMenu(menu_1);
		
		MenuItem mntmOptions = new MenuItem(menu_1, SWT.NONE);
		mntmOptions.setText("Options...");
		
		MenuItem mntmHelp = new MenuItem(menu, SWT.CASCADE);
		mntmHelp.setText("Help");
		
		Menu menu_2 = new Menu(mntmHelp);
		mntmHelp.setMenu(menu_2);
		
		MenuItem mntmAbout = new MenuItem(menu_2, SWT.NONE);
		mntmAbout.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				aboutMenuItemWidgetSelected(arg0);
			}
		});
		mntmAbout.setText("About...");

	}
	
	private void aboutMenuItemWidgetSelected(SelectionEvent evt)
	{
		AboutDialog aboutDialog = new AboutDialog(shell, SWT.APPLICATION_MODAL
				| SWT.DIALOG_TRIM | SWT.RESIZE);
		aboutDialog.open();
	}
}
