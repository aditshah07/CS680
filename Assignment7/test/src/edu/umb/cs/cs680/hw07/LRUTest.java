package edu.umb.cs.cs680.hw07;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*; 
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class LRUTest {
	Httpd httpd= new Httpd();
	FileCache fileCache = FileCache.getInstance();
    @Before
    public void createCache(){
            fileCache.changeReplacementPolicy(new LRU());
    		httpd.fetch("File1.txt");
    		httpd.fetch("File2.txt");
    		httpd.fetch("File3.txt");
    		httpd.fetch("File4.txt");
    }
    
    @Test
    public void fetchFileNotStored() {
    		File file = httpd.fetch("File5.txt");
    		System.out.println("fetchFileNotStored cache. Cache is of size-5 and has File1, File2, File3 and File4 and requesting for File5 ");
    		System.out.println("Printing cache");
            HashMap <String,File> cache = new HashMap <String,File>();
    		cache = fileCache.getCache();
    		Iterator<String> iterator = cache.keySet().iterator();
    		while(iterator.hasNext()) {
    			String str1 = iterator.next();
    			System.out.println(str1);
    		}
    		assertThat(file.getData(),is("This is File5."));
    }
    
    @Test
    public void fetchFileStored() {
    		File fileAdd = httpd.fetch("File5.txt");
    		File file = httpd.fetch("File1.txt");
            System.out.println("fetchFileStored cache. Cache is of size-5 and has File1, File2, File3, File4 and File5 and requesting for File1");
    		System.out.println("Printing cache");
            HashMap <String,File> cache = new HashMap <String,File>();
    		cache = fileCache.getCache();
    		Iterator<String> iterator = cache.keySet().iterator();
    		while(iterator.hasNext()) {
    			String str1 = iterator.next();
    			System.out.println(str1);
    		}
    		assertThat(file.getData(),is("This is File1."));
    }
    
    @Test
    public void fetchFileStoredAndNotStored() {
            File file1 = httpd.fetch("File5.txt");
    		File file2 = httpd.fetch("File1.txt");
    		File file3 = httpd.fetch("File6.txt");
    		System.out.println("fetchFileStoredAndNotStored cache. Cache is of size-5 and has File1, File2, File3 and File4 and requesting for File5, File1 and File6");
    		System.out.println("Printing cache");
            HashMap <String,File> cache = new HashMap <String,File>();
    		cache = fileCache.getCache();
    		Iterator<String> iterator = cache.keySet().iterator();
    		while(iterator.hasNext()) {
    			String str1 = iterator.next();
    			System.out.println(str1);
    		}
    		assertThat(file3.getData(),is("This is File6."));
    }
}