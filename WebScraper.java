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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
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
        g.drawString("Data will go here", 100, 75);
    }
}
   /***********************************************************************/
public class WebScraper extends JFrame implements ActionListener {
	/**
	 * @author Emily 
	 * sets up the menu bar on the top of the UI
	 * options are file and help
	 */
	private String DataToShow; // this is what the text area will show
	private JTextArea txaWords;  //  throughout the class
	 
	//JTextField txtTextToAdd = new JTextField(20); //i think we need  text feild 
	
    public void setupMenu() { //this sets up the menu 
    	DataToShow = ""; //got to set it to empty 
    	
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
        /***********************************************************************/
    /*    JButton btnAddData = new JButton("Add text");
        //still working on this this isnt 100 percent right
        
        btnAddData.addActionListener(new ActionListener() { //the button that will make the data show to screen
        	
            public void actionPerformed(ActionEvent e) {
                String data = txtTextToAdd.getText(); 
                DataToShow = DataToShow + "\n" + data;
                txaWords.setText(DataToShow);
            }
            
        }); */
        
        /***********************************************************************/
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
        		try {
        			//String data = urlToSearch.getText();
                    URL url = new URL(urlToSearch.getText());
                    URLConnection uconn = url.openConnection();
                    BufferedReader br = new BufferedReader(
                    		new InputStreamReader(uconn.getInputStream()));
                    String urlText = "";
                    String line;
                    while((line = br.readLine()) != null){ //while there is a line in the bufferedreader and it's not empty
                    	urlText += line;//add that line to the text of the URL 
                    }
                    DataToShow = DataToShow + "\n" + urlText;//prints out the HTML formatting of the webpage to the TextArea
                    showText.setText(DataToShow);                    
                
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
   
    
    /***********************************************************************/
    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    public static void main(String[] args) {
    	WebScraper frm = new WebScraper();
    	frm.setVisible(true); //show the frame
    	//ScreenScraper.Scrape(frm);

    }
}







