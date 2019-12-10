import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*functions that write the data to the screen
 * and saves the data to text file and to json 
 */
public class Writer {
	/*
	 * this has to take in the array list 
	 * 
	 */
	   public static boolean writeToTextFile(String fname,  //write to txt file - 
			    ArrayList<data> datapulled) {
		   //still figurig this out its not 100 percent right 
			        try {
  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
			        for (data m: datapulled) {
			                pw.println(m);
			            }
			            pw.close();
			            return true;
			        } catch (Exception ex) {
			            return false;
			        }
			    }
	   public static boolean writeMembersToJSON(String fname, //DeLay and Maierhofer
				ArrayList<data> datapulled) { 
			try {
	            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
	            // create a JSON object for each student
	            JSONObject Obj;
	            JSONArray array = new JSONArray();
	            for (data in : datapulled) {
	                Obj = new JSONObject();
	                Obj.put("Name", in.getName());
	                Obj.put("number", in.getNumber());
	                Obj.put("animal", in.getAnimal());
	                Obj.put("gender", in.getGender());
	                Obj.put("breed", in.getBreed());
	                Obj.put("age", in.getAge());
	                Obj.put("id", in.getId());
	                
	               // int Score = Assessor.tScore(in);
	            //    Obj.put("Score", Score);
	             //   String verdict = verdict(in);
	             //   Obj.put("Verdict", verdict);
	                array.add(Obj);
	            }
	            JSONObject outer = new JSONObject();
	           // outer.put("Customers", array);
	            pw.println(outer.toJSONString());
	            pw.close();
	            return true;
	        } catch (Exception ex) {
	            return false;
	        }
		}
}
