package edu.umb.cs.cs680.hw07;


public class Httpd {

	public File fetch(String targetFile){
		FileCache filecache = FileCache.getInstance();
		File file = filecache.fetch(targetFile);
		return file;
	}

}