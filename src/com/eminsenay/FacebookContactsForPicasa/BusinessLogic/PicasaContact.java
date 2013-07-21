package com.eminsenay.FacebookContactsForPicasa.BusinessLogic;

public class PicasaContact {
	
	private String m_ID;
	private String m_Name;
	private String m_ModifiedTime;
	private String m_LocalContact;
	
	public String getID() {
		return m_ID;
	}
	public void setID(String ID) {
		m_ID = ID;
	}
	public String getName() {
		return m_Name;
	}
	public void setName(String name) {
		m_Name = name;
	}
	public String getModifiedTime() {
		return m_ModifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		m_ModifiedTime = modifiedTime;
	}
	public String getLocalContact() {
		return m_LocalContact;
	}
	public void setLocalContact(String localContact) {
		m_LocalContact = localContact;
	}
	
}
