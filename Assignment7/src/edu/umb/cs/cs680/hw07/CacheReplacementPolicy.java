package edu.umb.cs.cs680.hw07;


import java.util.HashMap;

public interface CacheReplacementPolicy {

	public HashMap<String, File> replace(HashMap<String,File> cache, String file);
}
