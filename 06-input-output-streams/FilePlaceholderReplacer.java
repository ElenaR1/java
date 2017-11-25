package bg.uni.sofia.fmi.mjt.streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FilePlaceholderReplacer  {
	public static void replace(String fromFileName, String toFileName,
			Map<String, String> placeholders) throws IOException {
			BufferedReader reader = new BufferedReader(new FileReader(fromFileName));
			String line = null;
			String oldtext="";
			while((line = reader.readLine()) != null)
            {
            oldtext += line + "\r\n";      
            }
			System.out.println(oldtext);
			StringReplacer obj=new StringReplacer(oldtext);
			String newText=obj.replace(placeholders);
			System.out.println(newText);
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(toFileName));
			writer.write(newText);
			writer.close();
		}
}
