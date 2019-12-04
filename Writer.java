import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/*functions that write the data to the screen
 * and saves the data to text file and to json 
 */
public class Writer {
	   public static boolean writeToTextFile(String fname,   //write to txt file - 
			    ArrayList<ScreenScraper> datapulled) {
		   //still figurig this out its not 100 percent right 
			        try {
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
			        for (ScreenScraper m: datapulled) {
			                pw.println(m);
			            }
			            pw.close();
			            return true;
			        } catch (Exception ex) {
			            return false;
			        }
			    }
}
