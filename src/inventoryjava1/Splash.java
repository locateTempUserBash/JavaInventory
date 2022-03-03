/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryjava1;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import java.net.InetAddress;
import org.apache.derby.drda.NetworkServerControl;

/**
 *
 * @author admin
 */
public class Splash extends javax.swing.JFrame {

    /**
     * Creates new form Splash
     */
    public Splash() {
        initComponents();
    }
    int posX, posY;
private void dragWindow(Component component){
    	
        //<editor-fold defaultstate="collapsed" desc="code">
    	component.addMouseListener(new MouseAdapter() {
            @Override
			public void mousePressed(MouseEvent e) {
               posX = e.getX();
               posY = e.getY();
            }
        });

    	component.addMouseMotionListener(new MouseAdapter() {
            @Override
			public void mouseDragged(MouseEvent evt) {
                //sets frame position when mouse dragged            
                Rectangle rectangle = getBounds();
                component.setBounds(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY, rectangle.width, rectangle.height);
            }
            
        });
}
    	
public static boolean initialiseServer() {
	try{
		System.out.println(System.getProperty("os.name"));
		String path = null; 
		switch (System.getProperty("os.name")) 
		{
		            case "Mac OS X":   path = "/Users/admin/Desktop/dbfolder";
		                     break;
		            case "Windows 10": path = "C:\\dbfolder";
		                     break;
		}
	
		System.setProperty("derby.system.home",path);
		String host = "localhost";
		int port = 1527;
		InetAddress address = InetAddress.getByName(host);
        NetworkServerControl server= new NetworkServerControl(address,port);
        server.start(null);
        //System.out.println(server.getSysinfo());
        //System.out.println(server.getCurrentProperties());
       
        //Connection Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventorydb", "User1","User1");
        //String meta = Con.getMetaData().getURL();
        //System.out.println(meta);
        
  

        System.out.println("connecting.");
        return true;
            
        }catch (Exception ex) 
		{
        	System.out.println("connection cannot be found");
        	return false;
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Myprogress = new javax.swing.JProgressBar();
        Percentage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Myprogress.setBorder(null);
        Myprogress.setBorderPainted(false);

        Percentage.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Percentage.setForeground(new java.awt.Color(0, 102, 255));
        Percentage.setText("%");
        Percentage.setAlignmentX(0.5F);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Envanter Yönetim Sistemi");
        
        JLabel lblInvsys = new JLabel();
        //lblInvsys.setIcon(new ImageIcon(Splash.class.getResource("/images/database-128.png")));
        lblInvsys.setForeground(new Color(0, 102, 255));
        lblInvsys.setFont(new Font("Arial", Font.BOLD, 24));
        lblInvsys.setAlignmentX(0.5f);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(Myprogress, GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(342, Short.MAX_VALUE)
        			.addComponent(jLabel2)
        			.addGap(208))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(364)
        			.addComponent(lblInvsys, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(338, Short.MAX_VALUE))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(359)
        			.addComponent(Percentage)
        			.addContainerGap(466, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel2)
        			.addGap(62)
        			.addComponent(lblInvsys, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(61)
        			.addComponent(Percentage)
        			.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
        			.addComponent(Myprogress, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
      Splash MySplash = new Splash();
      initialiseServer();
      MySplash.setVisible(true);
      MySplash.dragWindow(MySplash);
      try{
          for (int i = 0; i<100;i++)
          {
              Thread.sleep(40);
              MySplash.Myprogress.setValue(i);
              MySplash.Percentage.setText(Integer.valueOf(i)+"%");
          }
      }catch(Exception e)
      {
          
      }
      new Login().setVisible(true);
      MySplash.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar Myprogress;
    private javax.swing.JLabel Percentage;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
}
