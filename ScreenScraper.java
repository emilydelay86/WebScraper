//De Lay and Maierhofer 
//screenscraper this actually takes in the website
//OOPFinal
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
public class ScreenScraper {
	public static ArrayList<ScreenScraper> Scrape (WebScraper frm) {
		//JLabel label = new JLabel("Enter URL:");
		//JTextField urlToSearch = new JTextField(30);
		//JButton btnFetch = new JButton ("Fetch");
        
		//System.out.print("Enter url for website: ");
		//btnFetch = JButton;
        //JTextField urlToSearch = null;
        try {
    		//trying to create the array list for the data
    		ArrayList<ScreenScraper> datapulled = new ArrayList<ScreenScraper>();
			//URL link = new URL(urlToSearch.getText());
    		URL url = new URL(urlToSearch.getText());
            URLConnection uconn = url.openConnection();
            BufferedReader br = new BufferedReader(
            		new InputStreamReader(uconn.getInputStream()));
            
            String urlText = "";
            String line;
            while((line = br.readLine()) != null){ 
            //while there is a line in the bufferedreader and it's not empty
            urlText += line;//add that line to the text of the URL 
            System.out.print(urlText);
            }
           
            
             // Takes in the chosen website from the user
             // and if unable to connect it will notify the user 
            
            
            br.close(); //closes 
            return datapulled; 
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Could not connect to chosen website."
          		+ "Use different website or try again");
        }
		return null;
		 
    }

	
/*
 * public static ArrayList<ScreenScraper> readFromWebsite(String fname) { 
 
	try {
		//trying to create the array list for the data
		ArrayList<ScreenScraper> datapulled = new ArrayList<ScreenScraper>();
		
	}catch (Exception ex){
		ex.printStackTrace();
		return null; //null if file can't be read
}
*/
}








