
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JTextField;
import javax.swing.SwingUtilities; 

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/** 
 * 
 * @author leet_coder 
 */

public class GUI { 
	
	// Models
	
	Recipe	recipe;
	Hub		hub;
	
	// Jswings
    JFrame frame; 
    JPanel mainDisplayPanel,adminPanel,loginPanel,helpPanel,recipePanel; 
    
    //mainDisplayPanel
    JButton admin;
    JButton help;
    JTextField searchBar;
    JButton suprizeMe;
	JButton searchButton;
	JPanel recipe1;
	JButton recipe1button;
	JPanel recipe2;
	JPanel recipe3;
	JPanel recipe4;
	JPanel recipe5;
	JPanel recipe6;
	JList list1;
	JList list2;
	DefaultListModel dlm1 = new DefaultListModel();
	DefaultListModel dlm2 = new DefaultListModel();
	
	JScrollPane scrollPanel1;
	JScrollPane scrollPanel2;
	JScrollBar recipeScroll;
	
	JLabel preperationTime;
	
	String[] order= {"Sort by likes", "Sort by cooking time", "Sort by calories", "Order"};
	
	//LoginPanel
	JFrame frame2;
    JButton btn_login;
    JTextField txt_userName;
    JPasswordField passF_password;
    JLabel lbl_userName, lbl_password;
    public static String AdminEntrance = "admin";
    public static String Password = "12345";

    //Help Panel
    JFrame frame3;
	JTextArea helpInfo;
	JButton backHome;
    
	//Admin Panel
	JPanel addRecipe;
	JPanel deleteRecipe;
	JPanel deleteP;
	JButton add;
	JButton delete;
    JTextField searchBar2;
    JLabel name;
    JTextField addname;
    JTextArea addInfo;
    JLabel calories;
    JTextField addCalorie;
    JLabel likes;
    JTextField addLike;
    JLabel cookingTime;
    JTextField addCookingTime;
    JPanel info;
	JScrollPane areaScrollPane;
	JLabel name2;

	//Recipe Panel
	
	JButton homePage;
	JTextArea recipeInfo;
	JLabel recipeName;
	JPanel recipeIP;
	JLabel recipeName2;
	JPanel rec;
	JLabel recipeName3;
	JTextArea information;
	JLabel logo;
    /** Creates a new instance of Main */ 
    public GUI() throws Exception{ 
    	
    	//this.hub = hub;
    	createMainDisplayPanel(); 
        createAdminPanel();
        createLoginPanel();
        createRecipePanel();
        createHelpPanel();
        frame = new JFrame("What to Cook?"); 
        frame.add(mainDisplayPanel); 
        frame.setSize(850,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(scrSize.width/6 , scrSize.height/10);
        frame.setVisible(true); 
        
        frame2 = new JFrame("Login"); 
        frame2.setBounds(500, 250, 300, 250);
        frame2.add(loginPanel);        
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        frame3 = new JFrame ("Help");
        frame3.setBounds(320, 100, 600, 620);
        frame3.add(helpPanel);        
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        recipe = new Recipe();
        
    } 
    
    public void addHub(Hub hub){
    	this.hub = hub;
    	
    }
    /** birinci panel nesnemizi oluþturacak ve panele deneme amaçlý 
     * bir JLabel ile bir JButton ekleyecek olan metod */ 
    private void createMainDisplayPanel() { 
        
    	mainDisplayPanel = new JPanel(); 
    	mainDisplayPanel.setLayout(null);
    	admin = new JButton("Admin");
        help = new JButton("Help");
        list1 = new JList (dlm1);
		list2 = new JList (dlm2);
		list1.setBorder(BorderFactory.createTitledBorder("Ingredients"));
		list2.setBorder(BorderFactory.createTitledBorder("Restrictions"));
		
		preperationTime = new JLabel("Prepering Time: ");

		suprizeMe = new JButton("Surprize Me!");

		scrollPanel1 = new JScrollPane(list1);
		scrollPanel2 = new JScrollPane(list2);
		JComboBox orderList = new JComboBox(order);
		orderList.setSelectedIndex(3);
		searchButton = new JButton("Search");
		searchButton.setSize(75, 20);
		searchButton.setLocation(127, 50);
		
		JScrollPane thePane = new JScrollPane();
		recipeScroll = thePane.getVerticalScrollBar();
        recipeScroll.setPreferredSize(new Dimension(15, 0)); 
		
		recipe1 = new JPanel();
		recipe1.setSize(200, 140);
		recipe1.setLocation(250, 100);
		recipe1.setBackground(Color.white);
		
		recipe1button = new JButton();
//		recipe1button.setSize(100,40);
		recipe1button.setLocation(280,130);
		recipe1button.setBackground(Color.white);
		recipe1button.setIcon(new ImageIcon("recipe1.jpg"));


		recipe2 = new JPanel();
		recipe2.setSize(200, 125);
		recipe2.setLocation(500, 100);
		recipe2.setBackground(Color.white);


		recipe3 = new JPanel();
		recipe3.setSize(200, 125);
		recipe3.setLocation(250, 300);
		recipe3.setBackground(Color.white);


		recipe4 = new JPanel();
		recipe4.setSize(200, 125);
		recipe4.setLocation(500, 300);
		recipe4.setBackground(Color.white);

		
		recipe5 = new JPanel();
		recipe5.setSize(200, 125);
		recipe5.setLocation(250, 480);
		recipe5.setBackground(Color.white);

		
		recipe6 = new JPanel();
		recipe6.setSize(200, 125);
		recipe6.setLocation(500, 480);
		recipe6.setBackground(Color.white);

		recipe1.setBorder (BorderFactory.createTitledBorder ("Recipe 1"));
		recipe2.setBorder (BorderFactory.createTitledBorder ("Recipe 2"));
		recipe3.setBorder (BorderFactory.createTitledBorder ("Recipe 3"));
		recipe4.setBorder (BorderFactory.createTitledBorder ("Recipe 4"));
		recipe5.setBorder (BorderFactory.createTitledBorder ("Recipe 5"));
		recipe6.setBorder (BorderFactory.createTitledBorder ("Recipe 6"));
		
		mainDisplayPanel.setBackground(Color.white);
        
       
      
        
        //SET BOUNDS
        admin.setBounds(740, 455, 70, 35);
        help.setBounds(740, 45, 65, 35);
        searchBar = new JTextField(20);

        
		searchBar.setSize(105, 20);
		searchBar.setLocation(25, 50);
		list1.setBounds(25,65,200,200);
		list2.setBounds(25,270,180,180);
		scrollPanel1.setBounds(25,80,180,180);
		scrollPanel2.setBounds(25,270,180,180);
		suprizeMe.setBounds(25, 455, 180, 35);
		orderList.setBounds(250, 50, 200, 20);
		recipeScroll.setBounds(820, 0, 10, 780);
		
		//ADD TO PANEL
		mainDisplayPanel.add(help);
        mainDisplayPanel.add(admin);
        mainDisplayPanel.add(searchBar);
        mainDisplayPanel.add(scrollPanel1);
		mainDisplayPanel.add(scrollPanel2);
		mainDisplayPanel.add(suprizeMe);
		mainDisplayPanel.add(orderList);
		mainDisplayPanel.add(searchButton);
		mainDisplayPanel.add(recipe1);
		mainDisplayPanel.add(recipe2);
		mainDisplayPanel.add(recipe3);
		mainDisplayPanel.add(recipe4);
		mainDisplayPanel.add(recipe5);
		mainDisplayPanel.add(recipe6);
		mainDisplayPanel.add(recipeScroll);
		recipe1.add(recipe1button);
		recipe1.add(preperationTime);
	

		
        
        
        
        //ACTION LISTENER
        admin.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent _event){ 
            	goToLogin();
            }
    
        });
        
        help.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent _event){ 
            	gotoHelpPanel();
            }
    
        });
        
        suprizeMe.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent _event){ 
            	
            	recipe = hub.getRandom();
            	gotoRecipePanel();
            }
    
        });
        recipe1button.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent _event){ 
            	gotoRecipePanel();
            }
    
        });
    }
    
    private void createRecipePanel(){
    	
    	
    	try {
    		recipe = hub.getRandom();
    		recipeName = new JLabel("Cooking Time..." + recipe.getName());
    		recipeName.setBounds(30, 30, 100, 20);
    	
    	}
    	catch (Exception e){} 
    	
    	recipePanel = new JPanel(); 
        recipePanel.setBackground(Color.white);
        recipePanel.setLayout(null);
        
        homePage = new JButton("Home Page");
        homePage.setBounds(700, 455, 100, 35);
        
        recipePanel.add(homePage);
        
        
        recipeName2 = new JLabel("Calories...");
        recipeName2.setBounds(30, 50, 100, 20);

        recipeName3 = new JLabel("Likes...");
        recipeName3.setBounds(30, 70, 100, 20);
        
        recipeName = new JLabel("Cooking Time..." + " 10");
		recipeName.setBounds(30, 30, 100, 20);

        
        recipeIP = new JPanel();
        recipeIP.setLayout(null);
        recipeIP.setSize(200, 100);
        recipeIP.setLocation(30, 70);
        recipeIP.setBackground(Color.white);
        recipeIP.setBorder (BorderFactory.createTitledBorder ("General Information"));
        
        rec = new JPanel();
        rec.setLayout(null);
        rec.setSize(750, 250);
        rec.setLocation(30, 200);
        rec.setBackground(Color.white);
        rec.setBorder (BorderFactory.createTitledBorder ("How to COOK???"));
        
        information = new JTextArea("<< Instructions >> \n 2-4 green pepper \n4 eggs \n2-4 Bermuda Onions "
        		+ "\nSalt & Pepper \n2 tbsp olive oil \n1 finely minced garlic \n10 eggs" +
        		"\n\n1. Core and seed the peppers. Cut the peppers into very slice way.");
        information.setFont(new Font("Plain", Font.BOLD, 14));
        information.setLineWrap(true);
        information.setWrapStyleWord(false);
        information.setEditable(false);
        information.setBounds(30, 40, 700, 220);
        
		Icon icon = new ImageIcon("recipe1.jpg");
		logo = new JLabel(icon);
		logo.setSize(150, 150);
		logo.setLocation(600, 40);
        
        recipeInfo = new JTextArea(" Recipe 1 Name....");
        recipeInfo.setFont(new Font("Plain", Font.BOLD, 14));
        recipeInfo.setLineWrap(true);
        recipeInfo.setWrapStyleWord(false);
        recipeInfo.setEditable(false);
        recipeInfo.setBounds(30, 30, 160, 100);
        
        recipePanel.add(recipeIP);
        recipePanel.add(recipeInfo);
        recipePanel.add(logo);
        recipeIP.add(recipeName);
        recipeIP.add(recipeName2);
        recipeIP.add(recipeName3);
        recipePanel.add(rec);
        rec.add(information);

        
        homePage.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent _event){ 
                frame.remove(recipePanel);
                frame.add(mainDisplayPanel);
                SwingUtilities.updateComponentTreeUI(frame); // frame'in görünümünü güncelle 

            }
    
        });
    }
    
    void gotoRecipePanel(){

        frame.remove(mainDisplayPanel);
        frame.add(recipePanel); // ikinci paneli ekle 
        SwingUtilities.updateComponentTreeUI(frame); // frame'in görünümünü güncelle 
    }
    private void createLoginPanel() { 
    	
        loginPanel = new JPanel(); 
        loginPanel.setLayout(null);
        
      //  adminPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
        lbl_userName = new JLabel("Admin Entrance:");
        lbl_userName.setBounds(20, 20, 100, 20);
        txt_userName = new JTextField();
        txt_userName.setBounds(120, 20, 150, 20);
        lbl_password = new JLabel("Password :");
        lbl_password.setBounds(20, 50, 100, 20);
        passF_password = new JPasswordField();
        passF_password.setBounds(120, 50, 150, 20);
        btn_login = new JButton("Login");
        btn_login.setBounds(120, 80, 80, 20);

        // Nesneleri Panele ekliyorum
        loginPanel.add(lbl_userName);
        loginPanel.add(txt_userName);
        loginPanel.add(lbl_password);
        loginPanel.add(passF_password);
        loginPanel.add(btn_login);

        //paneli Frame e ekliyorum
        //add(loginPanel); //---&gt;&gt;&gt;frame.add(panel) ile ayný anlamý taþýr

        //btn_login Butonuna ActionListener Ekliyorum
        btn_login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(txt_userName.getText().equals(AdminEntrance) && passF_password.getText().equals(Password))
                {	
                	 gotoAdminPanel();
                	 }
                else
                    JOptionPane.showMessageDialog(null, "Try Again...");
            }
        });
   }
    void goToLogin(){ 
        
        frame2.setVisible(true); 
        SwingUtilities.updateComponentTreeUI(frame); // frame'in görünümünü güncelle 
    } 
    
    /** ikinci panel nesnemizi oluþturacak ve panele deneme amaçlý bir JLabel ekleyecek olan metod */ 
    private void createAdminPanel() throws Exception { 
    	
        adminPanel = new JPanel(); 
        adminPanel.setBackground(Color.white);
        adminPanel.setLayout(null);
		adminPanel.setBorder (BorderFactory.createTitledBorder ("Recipe Management"));

        
        addRecipe = new JPanel();
        addRecipe.setSize(380, 600);
        addRecipe.setLocation(20, 20);
        addRecipe.setBorder (BorderFactory.createTitledBorder ("Add Recipe"));
        addRecipe.setBackground(Color.white);
		
		deleteRecipe = new JPanel();
		deleteRecipe.setSize(400, 600);
		deleteRecipe.setLocation(420, 20);
		deleteRecipe.setBorder (BorderFactory.createTitledBorder ("Delete Recipe"));
		deleteRecipe.setBackground(Color.white);
		
		add= new JButton("Add");
		add.setBounds(280,450,80,20);
		
				
		delete = new JButton("Delete");
		delete.setSize(100,20);
		delete.setLocation(600,40);
		//delete.setBounds(600,40,100,20);
		
		addname = new JTextField(20);
		addname.setSize(105,20);
		addname.setLocation(65,20);
		
	    searchBar2= new JTextField(20);
	    searchBar2.setSize(80, 10);
		searchBar2.setLocation(500, 40);
		
		name2 = new JLabel ("Name: ");
		name2.setBounds(23, 20, 100, 20);
		
		name = new JLabel ("Name: ");
		name.setBounds(23, 20, 100, 20);
		
	    calories=new JLabel("Calories: ");
	    calories.setBounds(23,350,100,20);
	    addCalorie = new JTextField(20);
	    addCalorie.setSize(105,20);
	    addCalorie.setLocation(80,350);
	    likes= new JLabel("Likes: ");
	    likes.setBounds(23,375,100,20);
	    addLike = new JTextField(20);
	    addLike.setSize(105,20);
	    addLike.setLocation(80,375);
	    cookingTime= new JLabel("Cooking Time: ");
	    cookingTime.setBounds(23,400,100,20);
	    addCookingTime= new JTextField(20);
	    addCookingTime.setSize(105,20);
	    addCookingTime.setLocation(110,400);
	    
	    info = new JPanel();
	    info.setSize(300, 300);
        info.setLocation(23, 40);
        info.setBorder (BorderFactory.createTitledBorder ("Informations"));
        info.setBackground(Color.white);
		info.setLayout(null);
		addRecipe.setLayout(null);
		
	    
	    addInfo = new JTextArea("Instructions about Recipe: ");
	    addInfo.setFont(new Font("Serif", Font.ITALIC, 12));
	  	addInfo.setLineWrap(true);
      	addInfo.setWrapStyleWord(false);
       	addInfo.setBounds(40, 40, 250, 250);

       	
		adminPanel.add(addRecipe);
		adminPanel.add(deleteRecipe);
		addRecipe.add(info);
		info.add(addInfo);
		addRecipe.add(calories);
		addRecipe.add(addCalorie);
		addRecipe.add(likes);
		addRecipe.add(addLike);
		addRecipe.add(cookingTime);
		addRecipe.add(addCookingTime);
		addRecipe.add(addname);
		addRecipe.add(name);
		addRecipe.add(add);
		deleteRecipe.add(name2);
		deleteRecipe.add(searchBar2);
		deleteRecipe.add(delete);
		//
		
//		add.addActionListener( new ActionListener() {
//    		
//    		public void actionPerformed(ActionEvent _event) { 
//    			
//    			try {
//    				recipe = new Recipe(0, addname.getText(), Integer.parseInt(calories.getText() ), Integer.parseInt( likes.getText()), 
//    					Integer.parseInt( cookingTime.getText() )  ,  addInfo.getText() );
//    			
//    				hub.addRecipe( recipe);
//    			
//    			}
//    			catch (Exception e){}
//    		}
//    			
//
//    	} );
    } 
    void gotoAdminPanel(){ 
        frame2.setVisible(false); // Birinci paneli frame'den kaldýr 
        SwingUtilities.updateComponentTreeUI(frame2); // frame'in görünümünü güncelle 

        frame.remove(mainDisplayPanel);
        frame.add(adminPanel); // ikinci paneli ekle 
        SwingUtilities.updateComponentTreeUI(frame); // frame'in görünümünü güncelle 
    } 
 	private void createHelpPanel() { 
       
 		helpPanel = new JPanel(); 
        helpPanel.setLayout(null);
        helpPanel.setBackground(Color.white);
    	helpInfo = new JTextArea("Wellcome to What to COOK!" + "\n\nThis application is designed to solve your meal plan trouble." 
        + "You are at right \nplace. You may be; \n1) Do not know what to cook in a short time \n2) Have a few ingredients at your home \n3) Waiting companies and you want to prepare sophisticated food for them\n4)Trying to keeping fit"
    			+ "\n\nIf you are option one; you can order button and select sorting recipes according to cooking time then you can select one of the photographed recipes you like.\n\nIf you are option two; you can enter the ingredients you have at your home,then you can put some restrictions below and specify what you will not use then you can select from the recipes."
        +"\nIf you are option three; you can use all of above features or you can select order options sort by likes and select many food according to favorites.\n\nIf you are option four; you can use order option and select sort by calories then you can select one of the low fat recipes you like"
    			+ "\n\n\nHave a nice meal :)");
    	helpInfo.setFont(new Font("Serif", Font.BOLD, 14));
    	helpInfo.setLineWrap(true);
    	helpInfo.setWrapStyleWord(false);
    	helpInfo.setEditable(false);
    	helpInfo.setBounds(30, 30, 500, 500);
    	
    	backHome= new JButton("Home Page");
		backHome.setBounds(365, 455, 100, 35);
	//	backHome.setBounds(340, 355, 70, 45);

    	
    	helpPanel.add(helpInfo);
    	helpInfo.add(backHome);
    	   
    	backHome.addActionListener(new ActionListener(){ 
               public void actionPerformed(ActionEvent _event){ 
               	frame3.setVisible(false);               
               	}
       
           });
 	} 
    void gotoHelpPanel(){ 
    	
        frame3.setVisible(true); 
        SwingUtilities.updateComponentTreeUI(frame); // frame'in görünümünü güncelle 
    } 
    /** 
     * @param args the command line arguments 
     */ 
    
//    public static void main(String[] args) { 
//        // TODO code application logic here 
//        new GUI(); 
//    } 


     
}  