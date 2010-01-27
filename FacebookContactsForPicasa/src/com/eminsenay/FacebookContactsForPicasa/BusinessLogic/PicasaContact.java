package com.eminsenay.FacebookContactsForPicasa.BusinessLogic;

public class PicasaContact {
	
	private String m_ID;
	private String m_Name;
	private String m_Display;
	private String m_ModifiedTime;
	private String m_SyncEnabled;
	
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
	public String getDisplay() {
		return m_Display;
	}
	public void setDisplay(String display) {
		m_Display = display;
	}
	public String getModifiedTime() {
		return m_ModifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		m_ModifiedTime = modifiedTime;
	}
	public String getSyncEnabled() {
		return m_SyncEnabled;
	}
	public void setSyncEnabled(String syncEnabled) {
		m_SyncEnabled = syncEnabled;
	}
	
}
