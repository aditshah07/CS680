package edu.umb.cs.cs680.hw07;


import java.util.HashMap;

public class NullReplacementPolicy implements CacheReplacementPolicy {

	@Override
	public HashMap<String, File> replace(HashMap<String,File> cache, String str) {
			return cache;
	}
}
