package edu.umb.cs.cs680.hw07;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileCache {
	
	private FileCache() {};
	private HashMap <String,File> cache = new HashMap <String,File>(5);
	private static FileCache fileCache=null;
	static CacheReplacementPolicy replacementPolicy;
	
	public static FileCache getInstance() {
		if(fileCache == null) {
			fileCache = new FileCache();
			replacementPolicy = new NullReplacementPolicy();
		}
		return fileCache;
	}
	
	public File fetch(String targetFile){
		long timest = System.nanoTime();
		String data ="";
		try{
			FileReader fileReader = new FileReader(targetFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			data = bufferedReader.readLine();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		File file= new File(data, timest,timest);
		if(cache.containsKey(targetFile)){
			cache.get(targetFile).setLastUsed(System.nanoTime());
			return cache.get(targetFile);
		}else{
			if(cache.size() < 5) {
				long ts = System.nanoTime();
				file= new File(data, ts,ts);
				cache.put(targetFile, file);
			}else {
				replace(targetFile);
			}
				
		}
		return file;
	}

	private void replace(String targetFile) {
		if(replacementPolicy != null)
			this.cache = replacementPolicy.replace(this.cache, targetFile);
	}
	
	public HashMap<String, File> getCache() {
		return this.cache;
	}
	
	public void changeReplacementPolicy(CacheReplacementPolicy cRP) {
		this.replacementPolicy = cRP;
	}

}
