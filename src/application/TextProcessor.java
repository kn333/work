package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TextProcessor {


	private HashMap<String, String> mapping = new HashMap<String, String>();

	public String doProcess (String text) throws IOException {

		/*
		 * Text file containing Latin-to-Cyrillic transliteration is read into the HashMap, 
		 * the key-value pair is separated through ":"
		 */
		String filePath = "MapLatinCyrillic.txt";
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		while ((line = reader.readLine()) != null)
		{
			String[] parts = line.split(":", 2);
			if (parts.length >= 2)
			{
				String key = parts[0];
				String value = parts[1];
				mapping.put(key, value);
			} else {
				//System.out.println("ignoring line: " + line);
			}
		}
		reader.close();

		/*
		 * TreeMap sorts the keys according to their length 
		 * to replace the longer substrings first
		 */
		Map<String, String> treeMap = new TreeMap<String, String>(
				new Comparator<String>() {
					public int compare(String s1, String s2) {
						if (s1.length() > s2.length()) {
							return -1;
						} else if (s1.length() < s2.length()) {
							return 1;
						} else {
							return s1.compareTo(s2);
						}
					}
				}
				);

		//System.out.println(mapping);
		treeMap.putAll(mapping);
		//System.out.println(treeMap);


		Iterator<Entry<String, String>> it = treeMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> pair = (Map.Entry<String, String>)it.next();
			//System.out.println(pair.getKey() + " = " + pair.getValue());
			//System.out.println(text);
			text = text.replaceAll(pair.getKey().toString(), pair.getValue().toString());
			//System.out.println(text);
			it.remove(); // avoids a ConcurrentModificationException
		}

		return text;
	}

}
