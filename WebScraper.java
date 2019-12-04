/*@author 

 * De Lay and Maierhofer 
 * main class
 */
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Scanner;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/***********************************************************************/
class ButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        //put action of button here
    }
}

   class DrawingPanel extends JPanel {
 
    /* JPanels draw themselves using
     * public void paintComponent. 
     */
    @Override
    public void paintComponent(Graphics g) {
        // g is our drawing surface
        super.paintComponent(g); // paint the background
        g.drawString("Data will go here", 75, 75);
    }
}
   /***********************************************************************/
public class WebScraper extends JFrame implements ActionListener {
	/**
	 * @author Emily 
	 * sets up the menu bar on the top of the UI
	 * options are file and help
	 */
	
    public void setupMenu() { //this sets up the menu 
        JMenuBar mbar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
		JMenuItem miExit = new JMenuItem("Exit");
		JMenuItem miOpen = new JMenuItem("Open");
        miOpen.addActionListener(new ActionListener() { //FOR THE EXIT BUTTON
            public void actionPerformed(ActionEvent e) {
            	try {
                    JFileChooser jfc = new JFileChooser();
                    if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        System.out.println(jfc.getSelectedFile().getPath());
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"OOF");
                }
            }
                
        });
            
        JMenu mnuhelp = new JMenu("Help");
        JMenuItem miabout = new JMenuItem("About");
        miabout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"This project was created by"
						+ " De Lay and Maierhofer."
						+ " Welcome to a program that takes in "
						+ " data from a wesbite and has the option to save it to"
						+ " a text or a json file.");

			}
		});
        //JMenuItem miExit = new JMenuItem("Exit");
        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    /***********************************************************************/
        //mnuFile.add(miOpen);
        mnuFile.add(miExit); //exit
        mbar.add(mnuFile); //file
        setJMenuBar(mbar);
        mnuhelp.add(miabout);
        
		mbar.add(mnuhelp);
		setJMenuBar(mbar);
    }
    /***********************************************************************/
    public WebScraper() {
        // set up the look inside the constructor
        setTitle("Web Scraper");
        setBounds(50,100,400,300); 
        // left = 50, top=100, width=400, height= 300
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextArea showText = new JTextArea();
        showText.setEditable(false);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(showText, BorderLayout.CENTER);
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        /***********************************************************************/
        JButton btnSave = new JButton("Save to text");
        btnSave.setBackground(Color.RED);
        btnSave.setForeground(Color.BLACK);
        Font f = new Font("Arial",Font.BOLD+Font.ITALIC,10);
        btnSave.setFont(f);
        ButtonHandler bh = new ButtonHandler();
        btnSave.addActionListener(bh);
        //c.add(btnSave,BorderLayout.NORTH);
        panSouth.add(btnSave);
        
        
        /***********************************************************************/
        JButton btnSaveJSON = new JButton("Save to JSON");
        btnSaveJSON.setBackground(Color.BLUE);
        btnSaveJSON.setForeground(Color.RED);
        Font o = new Font("Arial",Font.BOLD+Font.ITALIC,10);
        btnSaveJSON.setFont(o);
        ButtonHandler bh2 = new ButtonHandler();
        btnSaveJSON.addActionListener(bh2);
        //c.add(btnSaveJSON,BorderLayout.SOUTH);
        panSouth.add(btnSaveJSON);
        c.add(panSouth, BorderLayout.SOUTH);
        
        /***********************************************************************/
        JButton btnHelp = new JButton("Help");
        btnHelp.addActionListener(this);

        setupMenu(); 
        
        /**
    	 * @author Mackenzie 
    	 * creates the URL text field and fetch 
    	 * button
    	 */

        JLabel label = new JLabel("Enter URL:");
		JTextField urlToSearch = new JTextField(15);
		JButton btnFetch = new JButton ("Fetch");
		btnFetch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
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
                    
                     // Takes in the chosen website from the user
                     // and if unable to connect it will notify the user 
                    
                    
                    linksc.close(); //closes 
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Could not connect to chosen website."
                  		+ "Use different website or try again");
        	}
        	}
        });
		
		JPanel panNorth = new JPanel();
		panNorth.setLayout(new FlowLayout());
		panNorth.add(label);
		panNorth.add(urlToSearch);
		panNorth.add(btnFetch);
		c.add(panNorth, BorderLayout.NORTH);
    } 
    /***********************************************************************/
    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    public static void main(String[] args) {
    	WebScraper frm = new WebScraper();
    	frm.setVisible(true);
    	//ScreenScraper.Scrape(frm);
        //frm.setVisible(true); //show the frame

    }
}




