package edu.umb.cs.cs680.hw09;

import java.util.ArrayList;

public class Link extends FSElement {

	private FSElement target;
	public Link(Directory parent, String name, String owner, FSElement target) {
		super(parent, name, owner);
		this.setSize(0);
		this.target=target;
	}

	public int getSize() {
		return this.size;
	}
	
	public int getTargetSize() {
		return this.target.getSize();
	}

	public boolean isFile() {
		return false;
	}

	public boolean isLeaf() {
		return true;
	}

	public ArrayList<FSElement> getChildren() {
		return null;
	}

}
