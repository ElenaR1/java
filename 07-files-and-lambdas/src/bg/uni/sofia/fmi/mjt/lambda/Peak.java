package bg.uni.sofia.fmi.mjt.lambda;

/**
 * Representation of a peak with loaded data from the dataset. The class is
 * immutable. If you wish, you could provide suitable equals() and hashCode()
 * implementations
 */
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class Peak {
    
    private final int pos;
    private final String name;
    private final double height;
    private final double prominence;
    private final String range;
    private final int firstAscent;
    private final int totalAscents;

    private Peak(int pos, String name, double height, double prominence, String range, int firstAscent,
            int totalAscents) {
        this.pos = pos;
        this.name = name;
        this.height = height;
        this.prominence = prominence;
        this.range = range;
        this.firstAscent = firstAscent;
        this.totalAscents = totalAscents;
    }

    public static Peak createPeak(String line) {
    	String[] arr=line.split(",");
    	String pos;
    	String h,pr,fA,tA;
    	String name=arr[1];
    	pos=arr[0];
    	int position=Integer.parseInt(pos);
    	h=arr[2];
    	double height=Double.parseDouble(h);
    	pr=arr[3];
    	double prominence=Double.parseDouble(pr);
    	String range=arr[4];
    	fA=arr[5];
    	int firstAscent=Integer.parseInt(fA);
    	tA=arr[6];
    	int totalAscents=Integer.parseInt(tA);
    	
    	for(int i=0;i<7;i++) {
    		System.out.printf(arr[i]+" ");
    	}
    	System.out.println();
    	Peak obj=new Peak(position,name,height,prominence,range,firstAscent,totalAscents);
    	return obj;
    
      //  throw new UnsupportedOperationException("Please provide implementation");
    }
    
    public void Print() 
    {}
    
    public int getPos() {
        return pos;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getProminence() {
        return prominence;
    }

    public String getRange() {
        return range;
    }

    public int getFirstAscent() {
        return firstAscent;
    }

    public int getTotalAscents() {
        return totalAscents;
    }

}