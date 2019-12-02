//De Lay and Maierhofer 
//screenscraper this actually takes in the website
import java.util.Scanner;
import java.net.URL;
public class ScreenScraper {
	public static void main(String[] args) {
		
        System.out.print("Enter url for website: ");
        Scanner sc = new Scanner(System.in);
        String addr = sc.nextLine();
        String line;
        
        try {
        	
            URL link = new URL(addr);
            Scanner linksc = new Scanner(link.openStream());
            while (linksc.hasNextLine()) {
                line = linksc.nextLine();
                System.out.println(line);
            }
            /*
             * Takes in the chosen website from the user
             * and if unable to conect it will notify the user 
             */
            
            linksc.close(); //closes 
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Could not connect to chosen website."
            		+ "Use different website or try again");
        }
         
    }
}
