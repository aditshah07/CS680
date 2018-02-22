package edu.umb.cs.cs680.hw07;

public class File {
	
	private String data;
	private long dateAdded;
	private long lastUsed;
	
	public File(String data, long dateAdded, long lastUsed) {
		this.data = data;
		this.dateAdded = dateAdded;
		this.lastUsed = lastUsed;
	}

	public String getData() {
		return this.data;
	}
	
	public long getDateAdded() {
		return this.dateAdded;
	}
	
	public long getLastUsed() {
		return this.lastUsed;
	}
	
	public void setLastUsed(long lastUsed) {
		this.lastUsed = lastUsed;
	}
	
	
}
