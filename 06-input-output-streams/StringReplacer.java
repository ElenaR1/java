package bg.uni.sofia.fmi.mjt.streams;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StringReplacer {
	private String input;
	private List<String> keys=new ArrayList<String>();
	private List<String> values=new ArrayList<String>();
	  public StringReplacer(String input) {
	        // TODO: implement me
		  this.input=input;
	    }
	    
	    public String replace(Map<String, String> map)throws IOException {
	    	 for (Map.Entry<String, String> entry : map.entrySet())
	            {
	                keys.add(entry.getKey());
	                values.add(entry.getValue());
	            }
	            String replacedtext  = this.input.replace( "{"+keys.get(0)+"}" , values.get(0));
	            for(int i=1;i<keys.size();i++) {
	            	  replacedtext = replacedtext.replace("{"+keys.get(i)+"}", values.get(i));	       
	            }
	        return replacedtext;
	        // TODO implement me
	    }
	  public String getInput() {
		  return this.input;
	  }
	
}
