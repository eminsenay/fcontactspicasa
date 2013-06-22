Picasa keeps the contacts in an xml file called "Contacts.xml".

Default contacts.xml paths for different platforms are as follows:

Windows 7: 	C:\Users\<UserName>\AppData\Local\Google\Picasa2\contacts\contacts.xml
Windows XP: C:\Documents and Settings\<UserName>\Local Settings\Application Data\Google\Picasa2\contacts\contacts.xml
MacOS X:  	~/Library/Application\ Support/Google/Picasa3/contacts/contacts.xml

After generating a new contacts.xml, change the original (get a backup of the original first).

Note that Mac support is not as smoothless as possible for now. To use the application, you have to extract the zip file, open a Terminal and run the .sh file.

For developers:

You must use the right version of the swt library to build the application. Swt libraries for Windows (32/64 bit), linux (32 bit) and mac osx (64 bit) can be found under lib. Make sure that you reference the right version.  You also have to register a new app in Facebook and fill the app id and secret with your own. These fields can be found under Configuration.cs.

Contact:
Emin Şenay
eminsenay at gmail dot com 
