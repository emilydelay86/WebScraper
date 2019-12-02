/*@author 
 * De Lay and Maierhofer 
 * main class
 */

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
 
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
public class WebScraper extends JFrame implements ActionListener {
	
    public void setupMenu() {
        JMenuBar mbar = new JMenuBar();
        JMenu mnuFile = new JMenu("Web Scraper");
        
        JMenuItem miOpen = new JMenuItem("Open");
        
        miOpen.addActionListener(new ActionListener() {
       
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
        mnuFile.add(miOpen);
        JMenuItem miExit = new JMenuItem("Exit");
        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnuFile.add(miExit); //exit
        
        mbar.add(mnuFile); //file
        
        setJMenuBar(mbar);
    }
    /***********************************************************************/
    public WebScraper() {
        // set up the look inside the constructor
        setTitle("Web Scraper");
        setBounds(50,100,400,300);  // left = 50, top=100, width=400, height= 300
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        /***********************************************************************/
        JButton btnSave = new JButton("Save to text");
        btnSave.setBackground(Color.RED);
        btnSave.setForeground(Color.BLACK);
        Font f = new Font("Arial",Font.BOLD+Font.ITALIC,10);
        btnSave.setFont(f);
        ButtonHandler bh = new ButtonHandler();
        btnSave.addActionListener(bh);
        c.add(btnSave,BorderLayout.LINE_START);
        
        /***********************************************************************/
        JButton btnSaveJSON = new JButton("Save to JSON");
        btnSaveJSON.setBackground(Color.BLUE);
        btnSaveJSON.setForeground(Color.RED);
        Font o = new Font("Arial",Font.BOLD+Font.ITALIC,10);
        btnSaveJSON.setFont(o);
        ButtonHandler bh2 = new ButtonHandler();
        btnSaveJSON.addActionListener(bh2);
        c.add(btnSaveJSON,BorderLayout.LINE_END);
        /***********************************************************************/
        
  /*      btnNorth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton btnThatExperienced = (JButton)e.getSource();
                System.out.println(btnThatExperienced.getText());
            } 
        }); */
        setupMenu(); 
    } 
    /***********************************************************************/
    public void actionPerformed(ActionEvent e) {

       // JOptionPane.showMessageDialog(null,"");
    }
    public static void main(String[] args) {
    	WebScraper frm = new WebScraper();
        frm.setVisible(true);  // show the frame
    }
}
