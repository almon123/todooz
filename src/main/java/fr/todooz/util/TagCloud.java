package fr.todooz.util;

import java.util.ArrayList;
import java.util.List;

public class TagCloud {
	
	private List<String> tags = new ArrayList<String>();
	   
	public void add(String... tags) {
		if (tags == null) {
			return;
		}
		
		for (String tag : tags) {
			if (tag != null && !contains(tag)) {
				this.tags.add(tag);
			}
		}
	 }
	
	
    public int size() {
        return this.tags.size();
    }

	public boolean contains(String string) {
		return this.tags.contains(string);
	}

	public void top(int count) {
		if (count < 0) {
			count = 0;
		}
		
		tags = tags.subList(0, Math.min(count, tags.size()));     
	}


	public void shuffle() {
		
	}
	

		

	
	

}
