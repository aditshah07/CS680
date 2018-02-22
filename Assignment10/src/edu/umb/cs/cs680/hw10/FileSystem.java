package edu.umb.cs.cs680.hw10;

public class FileSystem {

	private static FileSystem instance = null;
	public Directory root;

	private FileSystem() {
	}

	public static FileSystem getInstance() {
		if (instance == null) {
			instance = new FileSystem();
		}
		return instance;
	}

	public void showAllElements(FSElement currDirectory) {
		if(currDirectory.isLeaf()==true){
			System.out.print(currDirectory.getName());
			System.out.print(" > ");
			return;
		}

		if (currDirectory != null) {
			System.out.println();
			if(currDirectory.getParent()!=null) 
				System.out.print(currDirectory.getParent().getName() +"/");
			System.out.println(currDirectory.getName());
			for(FSElement f:currDirectory.getChildren()){
				showAllElements(f);
			}
			return;
		} 
	}
	
}
