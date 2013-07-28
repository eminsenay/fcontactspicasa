# Facebook Contacts for Picasa

## Description

Facebook Contacts for Picasa is a small tool which gets your Facebook friends and imports them as Picasa contacts. The binaries are still kept in sourceforge at http://sourceforge.net/projects/fcontactspicasa/.

## About the Tool

Picasa keeps the contacts in an xml file called "Contacts.xml".

Default contacts.xml paths for different platforms are as follows:

- Windows 7:    C:\Users\<UserName>\AppData\Local\Google\Picasa2\contacts\contacts.xml
- Windows XP:   C:\Documents and Settings\<UserName>\Local Settings\Application Data\Google\Picasa2\contacts\contacts.xml
- MacOS X:      ~/Library/Application\ Support/Google/Picasa3/contacts/contacts.xml

The tool allows users to generate a new contacts.xml based on their Facebook contacts. It is also possible to merge an existing contacts.xml with the Facebook contacts.

After generating a new contacts.xml, you have change the original file with this one (get a backup of the original first).

## Running the Tool

### Windows/Linux Users

After downloading the package for your platform, just execute the jar file (double clicking should work). 

### Mac Users

Mac support is not as smooth as possible for now. To use the application, you have to extract the zip file that you downloaded, open a Terminal and run the extracted .sh file.

## For Developers

You must use the right version of the swt library to build the application. Swt libraries for Windows (32/64 bit), linux (32 bit) and mac osx (64 bit) can be found under lib. Make sure that you reference the right version.  You also have to register a new app in Facebook and fill the app id and secret with your own. These fields can be found under Configuration.cs.
