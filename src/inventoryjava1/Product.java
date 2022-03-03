/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryjava1;

import java.sql.Statement;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.derby.drda.NetworkServerControl;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.proteanit.sql.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

/**
 *
 * @author admin
 */
public class Product extends javax.swing.JFrame {

    /**
     * Creates new form Product
     */
    public Product() {
    	
    		
    
        initComponents();
        //dragWindow(this);
        SelectProd();
        GetCat();
    }
public boolean adminflag;
        Connection Con = null;
        Statement St = null;
        ResultSet Rs = null;
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
    	public void saveFile(XSSFWorkbook hwb) throws IOException {
    		JFileChooser chooser=new JFileChooser(".");

    		   FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files","xlsx","excel");
    		  
    		   chooser.addChoosableFileFilter(filter);

    		   chooser.setFileFilter(filter);
    		   chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    		   chooser.setDialogTitle("Save File");
    		   chooser.setCurrentDirectory(new File(System.getProperties().getProperty("user.home")));
    		   chooser.setFileFilter(new javax.swing.filechooser.FileFilter()
    		   {
    		        @Override
					public boolean accept(final File f)
    		        {
    		            return f.isDirectory()|| f.getAbsolutePath().endsWith(".xlsx");
    		        }

    		        @Override
					public String getDescription()
    		        {
    		            return "Excel files (*.xlsx)";
    		        }
    		  });
    		   int returnVal1;
    		  
    		   returnVal1=chooser.showSaveDialog(this);
    		  if (returnVal1 == JFileChooser.APPROVE_OPTION) 
    		  {


    		        File file1 = chooser.getSelectedFile();

    		       
    				if(!file1.exists())
    		        {

    		            FileOutputStream fileOut =  new FileOutputStream(file1);
    		            hwb.write(fileOut);
    		            fileOut.close();
    		            System.out.println("\n Your Excel file has been generated!");
    		            JOptionPane.showMessageDialog(this,"File Created.");
    		        }
    		        else if(file1.exists())
    		        {
    		            int res=JOptionPane.showConfirmDialog(this,"File already exists.Do you wish to overwrite?");
    		            if(res == JOptionPane.YES_OPTION)
    		            {
    		                FileOutputStream fileOut =  new FileOutputStream(file1);
    		                hwb.write(fileOut);
    		                fileOut.close();
    		                System.out.println("\n Your Excel file has been generated!");
    		                JOptionPane.showMessageDialog(this,"File Created.");
    		            }
    		            else if(res == JOptionPane.NO_OPTION)
    		            {
    		                int returnVal2=chooser.showSaveDialog(this);
    		                if (returnVal2 == JFileChooser.APPROVE_OPTION) 
    		                {

    		                    File file2 = chooser.getSelectedFile();
    		                    if(!file2.exists())
    		                    {

    		                        FileOutputStream fileOut =  new FileOutputStream(file2);
    		                        hwb.write(fileOut);
    		                        fileOut.close();
    		                        System.out.println("\n Your Excel file has been generated!");
    		                        //JOptionPane.showMessageDialog(this,"File Created.", returnVal2);
    		                    }

    		                }
    		            }
    		            else if (res == JOptionPane.CANCEL_OPTION) 
    		            {
    		                JOptionPane.showMessageDialog(this, "User cancelled operation.");
    		            } 
    		        }
    		        }
    		   // return file1;

    		}
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ProdName = new javax.swing.JTextField();
        PartNo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ProdDesc = new javax.swing.JTextField();
        ProdQty = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        CatCb = new javax.swing.JComboBox<>();
        UpdateBtn = new javax.swing.JButton();
        AddBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProdTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Envanter Yönetim Sistemi");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Envanter Yönetimi");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("X");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 255));
        jLabel6.setText("Part No");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 255));
        jLabel7.setText("İsim");

        ProdName.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N

        PartNo.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        PartNo.setToolTipText("");
        PartNo.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                PartNoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 255));
        jLabel8.setText("Miktar");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 255));
        jLabel9.setText("Açıklama");

        ProdDesc.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N

        ProdQty.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        ProdQty.setToolTipText("");
        ProdQty.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdQtyActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 255));
        jLabel10.setText("Kategori");

        UpdateBtn.setText("Değiştir");
        UpdateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateBtnMouseClicked(evt);
            }
        });
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        AddBtn.setText("Ekle");
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnMouseClicked(evt);
            }
        });
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setText("Sil");
        DeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteBtnMouseClicked(evt);
            }
        });
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        jButton4.setText("Ana Menü");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        ProdTable.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        ProdTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Part No", "İsim", "Miktar", "Açıklama", "Kategori"
            }
        ));
        ProdTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        ProdTable.setRowHeight(30);
        ProdTable.setSelectionBackground(new java.awt.Color(0, 102, 255));
        ProdTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProdTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProdTable);

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        
        JButton toExcel = new JButton("Excel'e Çevir");
        toExcel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Connection Con = null;
        		Statement St = null;
        		ResultSet Rs1 = null;
        		try {
					Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventorydb", "User1","User1");
					St = Con.createStatement();
	        	    String Query = "select * from User1.PRODUCTTBL";
	        	    Rs1 = St.executeQuery(Query);
	        		
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
        	    xlsCreate xfile = new xlsCreate();
        		try {
					xfile.ProductsWriteToExcel(Rs1);
					saveFile(xfile.book1);
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}
        });
        toExcel.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        	}
        });
        getContentPane().setLayout(new BorderLayout(0, 0));
        
        JButton AddAmount = new JButton("+");
        AddAmount.addMouseListener(new MouseAdapter() {
        	
        	@Override
        	
        	public void mouseClicked(MouseEvent e) {
        		//DefaultTableModel model = (DefaultTableModel)ProdTable.getModel();
        	       //int Myindex = ProdTable.getSelectedRow();
        	      // ProdQty.setText(model.getValueAt(Myindex, 2).toString());
        		int qty = Integer.parseInt(ProdQty.getText());
        		qty++;
        		ProdQty.setText(Integer.toString(qty));
        		
        	}
        	
        });
        
        JButton SubtractAmount = new JButton("-");
        SubtractAmount.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int qty = Integer.parseInt(ProdQty.getText());
        		qty--;
        		ProdQty.setText(Integer.toString(qty));
        	}
        });
        getContentPane().add(jPanel1, BorderLayout.CENTER);
        
        SearchField = new JTextField();
        SearchField.setColumns(10);
        
        JButton SearchButton = new JButton("Ara");
        SearchButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		String Query =null;
        		try{
        			String searchText = SearchField.getText();
        			int a;
        			try {
        			   a = Integer.parseInt(searchText);
        			}
        			catch (NumberFormatException nex)
        			{
        			   a = -1;
        			}
        			if(a >= 0) {
        				Query ="select * from PRODUCTTBL WHERE  PARTNO LIKE '%"+searchText+"%' OR PRODQTY = "+searchText+" OR PRODNAME LIKE '%"+searchText+"%'  OR PRODDESC LIKE '%"+searchText+"%' OR PRODCAT LIKE '%"+searchText+"%' OR PRODLOC LIKE '%"+searchText+"%'";
        				//Query = "select * from PRODUCTTBL WHERE  PRODLOC LIKE '%"+searchText+"%'";
        			}else {
        				Query = "select * from PRODUCTTBL WHERE  PARTNO LIKE '%"+searchText+"%' OR PRODNAME LIKE '%"+searchText+"%'  OR PRODDESC LIKE '%"+searchText+"%' OR PRODCAT LIKE '%"+searchText+"%' OR PRODLOC LIKE '%"+searchText+"%'";
        				//Query = "select * from PRODUCTTBL WHERE  PRODLOC LIKE '%"+searchText+"%'";
                		
        			}
        			//String Query = "select * from PRODUCTTBL where PARTNO like '%"+searchText+"%' or PRODNAME like '%"+searchText+"";
        			
        			System.out.println(Query);
        			System.out.println("Query");
        			Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventorydb", "User1","User1");
                    St = Con.createStatement();
                    Rs = St.executeQuery(Query);
                    ProdTable.setModel(DbUtils.resultSetToTableModel(Rs));
                    
                }catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
        		
        	}
        });
        
        JLabel lblNewLabel = new JLabel("Ürün Arama");
        
        ProdLoc = 	new JTextField();
        ProdLoc.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        
        JLabel lblLokasyon = new JLabel();
        lblLokasyon.setText("Lokasyon");
        lblLokasyon.setForeground(new Color(0, 102, 255));
        lblLokasyon.setFont(new Font("Arial", Font.BOLD, 18));
        GroupLayout gl_jPanel1 = new GroupLayout(jPanel1);
        gl_jPanel1.setHorizontalGroup(
        	gl_jPanel1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel1.createSequentialGroup()
        			.addGap(3)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 1059, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_jPanel1.createSequentialGroup()
        			.addGap(20)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        					.addGroup(gl_jPanel1.createSequentialGroup()
        						.addGap(17)
        						.addComponent(jLabel6))
        					.addGroup(gl_jPanel1.createSequentialGroup()
        						.addGap(17)
        						.addComponent(jLabel7))
        					.addGroup(gl_jPanel1.createSequentialGroup()
        						.addGap(17)
        						.addComponent(jLabel8))
        					.addGroup(gl_jPanel1.createSequentialGroup()
        						.addGap(17)
        						.addComponent(jLabel9))
        					.addComponent(toExcel)
        					.addGroup(gl_jPanel1.createSequentialGroup()
        						.addGap(17)
        						.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        							.addComponent(lblLokasyon, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
        							.addComponent(jLabel10))))
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addComponent(AddBtn)
        					.addGap(18)))
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        						.addComponent(PartNo, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
        						.addComponent(ProdName, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
        						.addComponent(ProdQty, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
        						.addComponent(ProdDesc, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
        						.addComponent(CatCb, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jButton4))
        					.addGap(6)
        					.addComponent(AddAmount, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        					.addGap(6)
        					.addComponent(SubtractAmount, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addComponent(UpdateBtn)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(DeleteBtn))
        				.addComponent(ProdLoc, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
        			.addGap(117)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addComponent(SearchField, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(SearchButton))
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 579, GroupLayout.PREFERRED_SIZE)))
        		.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 1065, GroupLayout.PREFERRED_SIZE)
        		.addGroup(gl_jPanel1.createSequentialGroup()
        			.addGap(473)
        			.addComponent(lblNewLabel))
        );
        gl_jPanel1.setVerticalGroup(
        	gl_jPanel1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel1.createSequentialGroup()
        			.addGap(6)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(11)
        			.addComponent(lblNewLabel)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addGap(101)
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        						.addComponent(AddAmount)
        						.addComponent(SubtractAmount)))
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        						.addComponent(SearchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(SearchButton))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addGap(8)
        							.addComponent(jLabel6)
        							.addGap(25)
        							.addComponent(jLabel7)
        							.addGap(25)
        							.addComponent(jLabel8)
        							.addGap(26)
        							.addComponent(jLabel9)
        							.addGap(17)
        							.addComponent(jLabel10))
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addComponent(PartNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(12)
        							.addComponent(ProdName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(12)
        							.addComponent(ProdQty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(13)
        							.addComponent(ProdDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(12)
        							.addComponent(CatCb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        					.addGap(4)
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        						.addComponent(ProdLoc, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblLokasyon, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        								.addComponent(AddBtn)
        								.addComponent(UpdateBtn)
        								.addComponent(DeleteBtn))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(toExcel))
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addGap(41)
        							.addComponent(jButton4)))))
        			.addGap(6)
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1.setLayout(gl_jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void GetCat()
{
    try{
         Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventorydb", "User1","User1");
         St = Con.createStatement();
         String Query = "select * from User1.CATEGORYTBL";
         Rs = St.executeQuery(Query);
         while(Rs.next())
         {
             String MyCat = Rs.getString("CATNAME");
             CatCb.addItem(MyCat);
             
         }
  
    }catch(Exception e)
    {
        
    }
}
    private void PartNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PartNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PartNoActionPerformed

    private void ProdQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProdQtyActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
    public void SelectProd(){
        try{
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventorydb", "User1","User1");
            St = Con.createStatement();
            Rs = St.executeQuery("select * from PRODUCTTBL");
            ProdTable.setModel(DbUtils.resultSetToTableModel(Rs));
            
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }
           
    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked
      
        try{
            
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventorydb", "User1","User1");
            PreparedStatement add = Con.prepareStatement("insert into PRODUCTTBL values(?,?,?,?,?,?)");
            add.setString(1,PartNo.getText());
            add.setString(2,ProdName.getText());
            add.setInt(3,Integer.valueOf(ProdQty.getText()));
            add.setString(4,ProdDesc.getText());
            add.setString(5,CatCb.getSelectedItem().toString());
            add.setString(6,ProdLoc.getText());
            int row = add.executeUpdate();
            JOptionPane.showMessageDialog(this,"Malzeme envantere eklendi.");
            Con.close();
            SelectProd();       
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_AddBtnMouseClicked

    private void DeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBtnMouseClicked
        if(PartNo.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Silinecek olan envanteri girin");
        }
        else
        {
            try{
              Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventorydb", "User1","User1");  
              String Id = PartNo.getText();
              String Query = "Delete from User1.PRODUCTTBL where PARTNO="+"'"+Id+"'";
              Statement Add = Con.createStatement();
              Add.executeUpdate(Query);
              SelectProd();
              JOptionPane.showMessageDialog(this, "Ürün envanterden silindi.");
              
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
                    
        }
    }//GEN-LAST:event_DeleteBtnMouseClicked

    private void ProdTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProdTableMouseClicked
       DefaultTableModel model = (DefaultTableModel)ProdTable.getModel();
       int Myindex = ProdTable.getSelectedRow();
       PartNo.setText(model.getValueAt(Myindex, 0).toString());
       ProdName.setText(model.getValueAt(Myindex, 1).toString());
       ProdQty.setText(model.getValueAt(Myindex, 2).toString());    
       ProdDesc.setText(model.getValueAt(Myindex, 3).toString());
    }//GEN-LAST:event_ProdTableMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
    	try {
        	String host = "localhost";
    		int port = 1527;
    		InetAddress address = InetAddress.getByName(host);
            NetworkServerControl server= new NetworkServerControl(address,port);
            server.shutdown();
        	}catch (Exception ex)
        	{
        		System.out.println("connection cannot be found");
        	
        	}
        System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void UpdateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBtnMouseClicked
        if(PartNo.getText().isEmpty()||ProdName.getText().isEmpty()||ProdQty.getText().isEmpty()||ProdDesc.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Eksik bilgi");
        }
        else
        {
            try{
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventorydb", "User1","User1"); 
                String UpdateQuery = "UPDATE User1.PRODUCTTBL SET PRODNAME =' "+ProdName.getText()+"'"+", PRODQTY= "+ProdQty.getText()+""+", PRODDESC=' "+ProdDesc.getText()+"'"+", PRODCAT=' "+CatCb.getSelectedItem().toString()+"', PRODLOC= '"+ProdLoc.getText()+"'"+"where PARTNO= '"+PartNo.getText()+"'";
                Statement Add = Con.createStatement();
                Add.executeUpdate(UpdateQuery);
                JOptionPane.showMessageDialog(this, "Ürün Güncellendi");
                SelectProd();
                }catch(Exception e){
                    e.printStackTrace();
            
            }
        }
    }//GEN-LAST:event_UpdateBtnMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        new HomeForm().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton4MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
			public void run() {
                new Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JComboBox<String> CatCb;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JTextField PartNo;
    private javax.swing.JTextField ProdDesc;
    private javax.swing.JTextField ProdName;
    private javax.swing.JTextField ProdQty;
    private javax.swing.JTable ProdTable;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private JTextField SearchField;
    private JTextField ProdLoc;
}
