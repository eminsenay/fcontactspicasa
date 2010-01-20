package com.eminsenay.FacebookContactsForPicasa;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.eminsenay.FacebookContactsForPicasa.UI.UIMain;

public class Main 
{

	public static void main(String args[]) 
	{
		Display display = new Display();
	    final Shell shell = new Shell(display);
	    
	    shell.setText("Facebook Contacts for Picasa");
	    final UIMain composite = new UIMain(shell, SWT.NONE);
	    shell.setLayout(new FillLayout());
	    shell.pack();
	    shell.open();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch())
	        display.sleep();
	    }
	    display.dispose();
	}
}
