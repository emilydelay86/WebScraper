//De Lay and Maierhofer 
//screenscraper this actually takes in the website
//OOPFinal
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
public class ScreenScraper {
	public static void Scrape(WebScraper frm) {
		JLabel label = new JLabel("Enter URL:");
		JTextField urlToSearch = new JTextField(30);
		JButton btnFetch = new JButton ("Fetch");
        
		/*System.out.print("Enter url for website: ");
        *Scanner sc = new Scanner(System.in);
        *String addr = sc.nextLine();
        *String line;
        *try {
        	
            URL link = new URL(addr);
            Scanner linksc = new Scanner(link.openStream());
            while (linksc.hasNextLine()) {
                line = linksc.nextLine();
                System.out.println(line);
            }
            /*
             * Takes in the chosen website from the user
             * and if unable to connect it will notify the user 
             *
            
            linksc.close(); //closes 
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Could not connect to chosen website."
        /*   		+ "Use different website or try again");
      */
        btnFetch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
    }
}


