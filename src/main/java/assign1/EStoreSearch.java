/*
 * File Name: EStoreSearch
 * Package Name: assign1
 * Author: Affan Khan
 * Last Modified On: 2020-10-19
 * Description: An estore that holds multiple kinds of products and allows user to add and search for them online
 */
package assign1;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EStoreSearch extends JFrame{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 600;
    public static final int LINES = 10;
    public static final int CHAR_PER_LINE = 17;

    private JPanel addPanel;
    private JPanel searchPanel;
    private JPanel openingPanel;
    private JPanel mainPanel;//main holding 3 above panels
    //labels for adding
    private JLabel authorsLabel;
    private JLabel publisherLabel;
    private JLabel makerLabel;
    //textfields for adding
    private JTextField authorsText;
    private JTextField publisherText;
    private JTextField makerText;
    private JTextField productIDText;
    private JTextField descriptionText;
    private JTextField priceText;
    private JTextField yearText;
    //message
    private static JTextArea messageDisplay;
    private JTextArea searchDisplay;
    //textfields for searching
    private JTextField searchProductIDText;
    private JTextField searchDescriptionText;
    private JTextField startYearText;
    private JTextField endYearText;
    //array list
    private static ArrayList<Product> List = new ArrayList<Product>();
    private static String productChoice = "Book";
    private static String productID;
    private static String Description;
    private static String price;
    private static String year;
    private static String authors;
    private static String publisher;
    private static String maker;
    //search var
    private String searchProductID;
    private String searchDescription;
    private String startYear;
    private String endYear;
    //filename
    private static String filename;
    private static boolean filenameBoolean = false;

    //listener classes for buttons, menu choices, and comboBox choices
    private class AddListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            openingPanel.setVisible(false);
            searchPanel.setVisible(false);
            addPanel.setVisible(true);
        }
    }//end of AddListener class
    private class SearchListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            openingPanel.setVisible(false);
            searchPanel.setVisible(true);
            addPanel.setVisible(false);
        }
    }//end of SearchListener class
    private class QuitListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(filenameBoolean){
                output();
            }
            System.exit(0);
        }
    }//end of QuitListener class
    private class ComboBoxListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JComboBox cb = (JComboBox)e.getSource();
            productChoice = (String)cb.getSelectedItem();
            String choiceElec = "Electronic";
            if(choiceElec.equals(productChoice)){
                authorsLabel.setVisible(false);
                publisherLabel.setVisible(false);
                makerLabel.setVisible(true);
                authorsText.setVisible(false);
                publisherText.setVisible(false);
                makerText.setVisible(true);
            }
            else{
                authorsLabel.setVisible(true);
                publisherLabel.setVisible(true);
                makerLabel.setVisible(false);
                authorsText.setVisible(true);
                publisherText.setVisible(true);
                makerText.setVisible(false);
            }
        }
    }//end of comboBoxListenr
    private class ResetAddListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String buttonString = e.getActionCommand();

            if(buttonString.equals("Reset")){
                authorsText.setText("");
                publisherText.setText("");
                makerText.setText("");
                productIDText.setText("");
                descriptionText.setText("");
                priceText.setText("");
                yearText.setText("");
                messageDisplay.setText("");
            }
            else if(buttonString.equals("Add")){
                add();
            }
            else{
                System.out.println("Unexpectated error.");
            }
        }
    }//end of ResetAddlistener
    private class ResetSearchListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String buttonString = e.getActionCommand();

            if(buttonString.equals("Reset")){
                searchProductIDText.setText("");
                searchDescriptionText.setText("");
                startYearText.setText("");
                endYearText.setText("");
                searchDisplay.setText("");
            }
            else if(buttonString.equals("Search")){
                search();
            }
            else{
                System.out.println("Unexpectated error.");
            }
        }
    }

    //ALL FOR ADD PANEL
    /*
    * Description: creates an inputTextPanel with labels and text fields
    * Parameters: none
    * Return: inputting text Jpanel for addPanel
    */
    private JPanel makeInputPanel(){
        //makes the input panel layour and background color
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(10, 1));
        inputPanel.setBackground(Color.PINK);

        //initial label
        JLabel inputLabel = new JLabel("Adding a product");
        inputPanel.add(inputLabel);
        JLabel blankLabel = new JLabel(" ");
        inputPanel.add(blankLabel);
        //comboBox type and label
        JLabel typeLabel = new JLabel("Type:");
        inputPanel.add(typeLabel);
        String[] types = {"Book", "Electronic"};
        JComboBox typesList = new JComboBox(types);
        typesList.setSelectedIndex(0);
        typesList.addActionListener(new ComboBoxListener());
        inputPanel.add(typesList);

        //other labels
        JLabel productIDLabel = new JLabel("productID:");//productID
        inputPanel.add(productIDLabel);
        productIDText = new JTextField("", 9);
        productID = productIDText.getText();
        inputPanel.add(productIDText);
        //description
        JLabel descriptionLabel = new JLabel("description:");
        inputPanel.add(descriptionLabel);
        descriptionText = new JTextField("", 9);
        Description = descriptionText.getText();
        inputPanel.add(descriptionText);
        //price
        JLabel priceLabel = new JLabel("price:");
        inputPanel.add(priceLabel);
        priceText = new JTextField("", 9);
        price = priceText.getText();
        inputPanel.add(priceText);
        //year
        JLabel yearLabel = new JLabel("year:");
        inputPanel.add(yearLabel);
        yearText = new JTextField("", 9);
        year = yearText.getText();
        inputPanel.add(yearText);
        //authors
        authorsLabel = new JLabel("authors:");
        authorsLabel.setVisible(true);
        inputPanel.add(authorsLabel);
        authorsText = new JTextField("", 9);
        authors = authorsText.getText();
        authorsText.setVisible(true);
        inputPanel.add(authorsText);
        //publisher
        publisherLabel = new JLabel("publisher:");
        publisherLabel.setVisible(true);
        inputPanel.add(publisherLabel);
        publisherText = new JTextField("", 9);
        publisher = publisherText.getText();
        publisherText.setVisible(true);
        inputPanel.add(publisherText);
        //maker
        makerLabel = new JLabel("Maker:");
        makerLabel.setVisible(false);
        inputPanel.add(makerLabel);
        makerText = new JTextField("", 9);
        maker = makerText.getText();
        makerText.setVisible(false);
        inputPanel.add(makerText);

        return inputPanel;
    }

    /*
    * Description: creates a buttonPanel with buttons to add or reset
    * Parameters: none
    * Return: button text Jpanel for addPanel
    */
    private JPanel makeAddButtonPanel(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2 , 1));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        //makes the reset button, sets it color, and adds to the panel
        JButton resetButton = new JButton("Reset");
        resetButton.setBackground(Color.RED);
        resetButton.addActionListener(new ResetAddListener());
        buttonPanel.add(resetButton);

        //makes the reset button, sets its color, and adds to the panel
        JButton addButton = new JButton("Add");        
        addButton.setBackground(Color.GREEN);
        addButton.addActionListener(new ResetAddListener());
        buttonPanel.add(addButton);

        //returns buttonPanel back
        return buttonPanel;
    }

    /*
    * Description: creats a messagePanel with a label, and a text Area to output messages to
    * Parameters: none
    * Return: messagePanel JPanel for addPanel
    */
    private JPanel makeMessagePanel(){
        JPanel messagePanel = new JPanel();
        messagePanel.setBackground(Color.PINK);
        messagePanel.setLayout(new FlowLayout());

        //makes the label messages
        JLabel messageLabel = new JLabel("Messages");
        messagePanel.add(messageLabel);

        //makes the text field area
        messageDisplay = new JTextArea(LINES, CHAR_PER_LINE);
        messageDisplay.setBackground(Color.WHITE);

        //chunk for scoll bars, gotten form class notes
        JScrollPane scrolledText = new JScrollPane(messageDisplay);
        scrolledText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        messagePanel.add(scrolledText);//adds scrollPane to the panel

        return messagePanel;
    }

    /*
    * Description: creates an addPanel with labels and JPanels
    * Parameters: none
    * Return: addPanel for the mainPanel
    */
    private JPanel makeAddPanel(){
        //makes return panel and sets it layout
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new BorderLayout());

        //adds the input part of panel
        JPanel inputPanel = makeInputPanel();
        newPanel.add(inputPanel, BorderLayout.WEST);
        //adds the two buttons on the right
        JPanel buttonPanel = makeAddButtonPanel();
        newPanel.add(buttonPanel, BorderLayout.EAST);
        //adds the message box under
        JPanel messagePanel = makeMessagePanel();
        newPanel.add(messagePanel, BorderLayout.SOUTH);

        //sets visibility to false and returns newPanel
        newPanel.setVisible(false);
        return newPanel;
    }//end of add panel stuff

    //ALL FOR SEARCH PANEL
    /*
    * Description: creates an inputPanel with labels and text fields to search for
    * Parameters: none
    * Return: inputPanel Jpanel for searchPanel
    */
    private JPanel makeInputSearchPanel(){
        //creates the inputPanel, makes its layout type, and sets color
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 1));
        inputPanel.setBackground(Color.PINK);

        //initial label
        JLabel inputLabel = new JLabel("Searching Products");
        inputPanel.add(inputLabel);
        JLabel blankLabel = new JLabel(" ");
        inputPanel.add(blankLabel);

        //other labels
        JLabel productIDLabel = new JLabel("productID:");//productID
        inputPanel.add(productIDLabel);
        searchProductIDText = new JTextField("", 9);
        searchProductID = searchProductIDText.getText();
        inputPanel.add(searchProductIDText);
        //description
        JLabel descriptionLabel = new JLabel("description:");
        inputPanel.add(descriptionLabel);
        searchDescriptionText = new JTextField("", 9);
        searchDescription = searchDescriptionText.getText();
        inputPanel.add(searchDescriptionText);
        //start year
        JLabel yearLabel = new JLabel("Start year:");
        inputPanel.add(yearLabel);
        startYearText = new JTextField("", 9);
        startYear = startYearText.getText();
        inputPanel.add(startYearText);
        //end year
        JLabel yearLabel2 = new JLabel("End year:");
        inputPanel.add(yearLabel2);
        endYearText = new JTextField("", 9);
        endYear = endYearText.getText();
        inputPanel.add(endYearText);
        
        return inputPanel;
    }

    /*
    * Description: creates a buttonPanel with buttons to add or search
    * Parameters: none
    * Return: button text Jpanel for searchPanel
    */
    private JPanel makeSearchButtonPanel(){
        //makes the buttin panel, its layout, and color
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2 , 1));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        //makes the reset button
        JButton resetButton = new JButton("Reset");
        resetButton.setBackground(Color.RED);
        resetButton.addActionListener(new ResetSearchListener());
        buttonPanel.add(resetButton);

        //makes the search button
        JButton searchButton = new JButton("Search");
        searchButton.setBackground(Color.GREEN);
        searchButton.addActionListener(new ResetSearchListener());
        buttonPanel.add(searchButton);

        return buttonPanel;
    }

    /*
    * Description: creates a searchResultsPanel with a label, and a text Area to output search results to
    * Parameters: none
    * Return: searchPanel JPanel for searchPanel
    */
    private JPanel makeSearchResultsPanel(){
        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(Color.PINK);
        searchPanel.setLayout(new FlowLayout());

        //makes the label messages
        JLabel messageLabel = new JLabel("Search Results");
        searchPanel.add(messageLabel);

        //makes the text field area
        searchDisplay = new JTextArea(LINES, CHAR_PER_LINE);
        searchDisplay.setBackground(Color.WHITE);

        //chunk for scoll bars
        JScrollPane scrolledText = new JScrollPane(searchDisplay);
        scrolledText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        searchPanel.add(scrolledText);//adds scrollPane to the panel

        return searchPanel;
    }

    /*
    * Description: creates a searchPanel with a label, and Panels
    * Parameters: none
    * Return: searchPanel JPanel for mainPanel
    */
    private JPanel makeSearchPanel(){
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new BorderLayout());

        //adds the input part of panel
        JPanel inputPanel = makeInputSearchPanel();
        newPanel.add(inputPanel, BorderLayout.WEST);
        //adds the two buttons on the right
        JPanel buttonPanel = makeSearchButtonPanel();
        newPanel.add(buttonPanel, BorderLayout.EAST);
        //adds the message box under
        JPanel messagePanel = makeSearchResultsPanel();
        newPanel.add(messagePanel, BorderLayout.SOUTH);

        //sets visibility to false and returns newPanel
        newPanel.setVisible(false);
        return newPanel;
    }//end of search panel stuff

    /*
    * Description: creates the JFrame interface with menu Bar, and creates the addPanel, introPanel, searchPanel all contained in the mainPanel
    * Parameters: none
    * Return: none
    */
    public EStoreSearch(){
        //required stuff for JFrame
        super("eStoreSearch");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        //main big panel
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setLayout(new FlowLayout());

        //displays the welcome message out
        openingPanel = new JPanel();
        openingPanel.setBackground(Color.LIGHT_GRAY);
        openingPanel.setLayout(new GridLayout(3, 1));
        JLabel welcomer = new JLabel("Welcome");
        openingPanel.add(welcomer);
        JLabel firstLine = new JLabel("Choose a command from the \"Commands\" menu above for");
        openingPanel.add(firstLine);
        JLabel secondLine = new JLabel("addding a product, searching products, or quitting the program");
        openingPanel.add(secondLine);
        //adds the bigger welcome openingPanel to the JFrame
        openingPanel.setVisible(true);
        mainPanel.add(openingPanel);

        //add panel
        addPanel = makeAddPanel();
        mainPanel.add(addPanel);
        //search panel
        searchPanel = makeSearchPanel();
        mainPanel.add(searchPanel);

        //adds main panel to JFrame
        add(mainPanel, BorderLayout.CENTER);

        //creates the JMenu
        JMenu Commands = new JMenu("Commands");
        //menu items
        JMenuItem addchoice = new JMenuItem("Add");
        addchoice.addActionListener(new AddListener());
        Commands.add(addchoice);
        JMenuItem searchChoice = new JMenuItem("Search");
        searchChoice.addActionListener(new SearchListener());
        Commands.add(searchChoice);
        JMenuItem quitChoice = new JMenuItem("Quit");
        quitChoice.addActionListener(new QuitListener());
        Commands.add(quitChoice);
        //adds the menu bar at the top of the JFrame
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(Commands);
        setJMenuBar(menuBar);
    }

    /*
    * Description: if there is an textfile input in the command line, it will get all info and inset in the ArrayList. throws Exception if it the textfile does
    * does not exist. the inmput file has been given, check ReadMe.txt
    * Parameters: none
    * Return: none
    */
    private static void input()  throws Exception{
        try{
            //gets the file name and creates a reader Scanner
            File myFile = new File(filename);
            Scanner reader = new Scanner(myFile);
            filenameBoolean = true;
            
            while(reader.hasNextLine()){
                String line = reader.nextLine();

                if(line.equalsIgnoreCase("type = \"book\"")){
                    Book b = new Book();

                    String attributes = reader.nextLine();
                    String productW[] = attributes.split("\"");
                    b.setProductID(productW[1]);

                    attributes = reader.nextLine();
                    String descriptionW[] = attributes.split("\"");
                    b.setDescription(descriptionW[1]);

                    attributes = reader.nextLine();
                    String priceW[] = attributes.split("\"");
                    b.setPrice(Double.parseDouble(priceW[1]));

                    attributes = reader.nextLine();
                    String yearW[] = attributes.split("\"");
                    b.setYear(Integer.parseInt(yearW[1]));

                    attributes = reader.nextLine();
                    String authorsW[] = attributes.split("\"");
                    b.setAuthors(authorsW[1]);

                    attributes = reader.nextLine();
                    String publisherW[] = attributes.split("\"");
                    b.setPublishers(publisherW[1]);

                    List.add(b);
                }
                else if(line.equalsIgnoreCase("type = \"electronics\"")){
                    Electronics e = new Electronics();

                    String attributes = reader.nextLine();
                    String productW[] = attributes.split("\"");
                    e.setProductID(productW[1]);

                    attributes = reader.nextLine();
                    String descriptionW[] = attributes.split("\"");
                    e.setDescription(descriptionW[1]);

                    attributes = reader.nextLine();
                    String priceW[] = attributes.split("\"");
                    e.setPrice(Double.parseDouble(priceW[1]));

                    attributes = reader.nextLine();
                    String yearW[] = attributes.split("\"");
                    e.setYear(Integer.parseInt(yearW[1]));
                    
                    attributes = reader.nextLine();
                    String makerW[] = attributes.split("\"");
                    e.setMaker(makerW[1]);

                    List.add(e);
                }
            }

            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error, file was not found");
        }
    }
    
    /*
    * Description: if there is an textfile input in the command line, it will get all the ArrayList elements and append to the textfile that has been inputted
    * Parameters: none
    * Return: none
    */
    private static void output(){
        PrintWriter outputStream = null;
        try{
            outputStream = new PrintWriter(new FileOutputStream(filename));
            
            for(Product e:List){
                outputStream.println(e.outputFile());
            }

            outputStream.close();
        }
        catch(FileNotFoundException e){
            System.out.println("error in finding file");
        }
    }

    /*
    * Description: checks to see if a given string is a number
    * Parameters: String str
    * Return: boolean
    */
    public static boolean isNumeric(String str){
        try {  
            Double.parseDouble(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }  
    }
    
    /*
    * Description: gets the text fields of the addPanel and throws exceptions to see if the information is correct. If not, it will display message to the messageDisplay.
    * if the information is correctly inputted, it will add to the Arraylist.
    * Parameters: none
    * Return: none
    */
    private void add(){
        boolean inputWrong = false;

        //this is for adding electrionics
        if(productChoice.equals("Electronic")){
            //gets the new inputted info
            productID = productIDText.getText();
            Description = descriptionText.getText();
            price = priceText.getText();
            year = yearText.getText();
            maker = makerText.getText();

            try{
                //extra error trapping that wouldve been though through exceptions
                for(Product b: List){//makes sure product ID doesnt already exist
                    if(productID.equals(b.getProductID())){
                        messageDisplay.setText("This product ID already exists");
                        inputWrong = true;
                    }
                }

                if(inputWrong){
                    //do nothing
                }
                else{
                    //checks if the price is a number
                    if(price.isBlank()){
                        price = "0";
                    }

                    if(!isNumeric(price)){
                        messageDisplay.setText("The price should be a positive number.");
                    }
                    //checks if the year is a number
                    else if(!isNumeric(year)){
                        messageDisplay.setText("The year should be a positive number.");
                    }
                    else{
                        int yearTemp = Integer.parseInt(year);
                        Double priceTemp = Double.parseDouble(price);
                        Electronics e1 = new Electronics(productID, Description, priceTemp, yearTemp, maker);
                        List.add(e1);
                        messageDisplay.setText("The product has been added!");
                    }
                }

            } catch(Exception e){
                messageDisplay.setText(e.getMessage());
            }
        }
        //this is for adding books
        else if(productChoice.equals("Book")){
            //gets the new inputted info
            productID = productIDText.getText();
            Description = descriptionText.getText();
            price = priceText.getText();
            year = yearText.getText();
            authors = authorsText.getText();
            publisher = publisherText.getText();

            try{
                //extra error trapping that wouldve been though through exceptions
                for(Product b: List){//makes sure product ID doesnt already exist
                    if(productID.equals(b.getProductID())){
                        messageDisplay.setText("This product ID already exists");
                        inputWrong = true;
                    }
                }

                if(inputWrong){
                    //do nothing
                }
                else{
                    //checks if the price is a number
                    if(price.isBlank()){
                        price = "0";
                    }
                    else if(!isNumeric(price)){
                        messageDisplay.setText("The price should be a positive number.");
                    }
                    //checks if the year is a number
                    else if(!isNumeric(year)){
                        messageDisplay.setText("The year should be a positive number.");
                    }
                    else{
                        int yearTemp = Integer.parseInt(year);
                        Double priceTemp = Double.parseDouble(price);
                        Book b1 = new Book(productID, Description, priceTemp, yearTemp, authors, publisher);
                        List.add(b1);
                        messageDisplay.setText("The product has been added!");
                    }
                }

            } catch(Exception e){
                messageDisplay.setText(e.getMessage());
            }
        }
        else{//if somehow neither
            System.out.println("Unexpectated error.");
        }
    }

    /*
    * Description: gets the text fields of the searchPanel and throws exceptions to see if the information is correct. If not, it will display message to the searchResults.
    * if the information is corrrectly inputted, it will show the results of the products that match that search
    * Parameters: none
    * Return: none
    */
    private void search(){
        //gets the updated strings from field texts, and clears the search menu
        searchProductID = searchProductIDText.getText();
        searchDescription = searchDescriptionText.getText();
        startYear = startYearText.getText();
        endYear = endYearText.getText();
        searchDisplay.setText("");

        //if nothing is inputted in text fields, prints all products
        if(searchProductID.equals("") && searchDescription.equals("") && startYear.equals("") && endYear.equals("")){
            for(Product e:List){
                searchDisplay.append(e.toString());
            }
        }
        else{
            //searchs specific productID
            for(Product e1:List){
                if(searchProductID.equals(e1.getProductID())){
                   searchDisplay.append(e1.toString());
                }
            }

            //searchs for description
            StringTokenizer tokenize = new StringTokenizer(searchDescription);
            while(tokenize.hasMoreTokens()){//first search tokenizer loop
                String word = tokenize.nextToken();
                for(Product b:List){//shifts through all elements in List
                    StringTokenizer tokenizeDesc = new StringTokenizer(b.getDescription());

                    while(tokenizeDesc.hasMoreTokens()){//second tokenizer loop
                        String wordDesc = tokenizeDesc.nextToken();

                        if(word.equalsIgnoreCase(wordDesc)){//prints if true
                            searchDisplay.append(b.toString());
                        }
                    }
                }
            }

            //sets two integers as startYear and EndYear
            int startYearInt;
            int endYearInt;
            //searchs the years
            if(isNumeric(startYear)){//converts start year if it is an integer
                startYearInt = Integer.parseInt(startYear);
                if(startYearInt < 1000 || startYearInt > 9999){//checks the number
                    startYearInt = 0;
                }
            }
            else{
                startYearInt = 0;
            }
            //converts end year integer if it is an integer
            if(isNumeric(endYear)){
                endYearInt = Integer.parseInt(endYear);
                if(endYearInt < 1000 || endYearInt > 9999){//checks the number 
                    endYearInt = 0;
                }
            }
            else{
                endYearInt = 0;
            }
            //4 possibilities now
            if(endYearInt != 0 && startYearInt != 0){//prinout products in between
                if(endYearInt < startYearInt){
                    searchDisplay.setText("End Year cannot be higher than start year, try again please");
                }
                else{    
                    for(Product e:List){
                        if((e.getYear() >= startYearInt) && (e.getYear() <= endYearInt)){
                            searchDisplay.append(e.toString());
                        }
                    }
                }
            }
            else if(startYearInt != 0 && endYearInt == 0){//printout all products after the year
                for(Product e:List){
                    if(e.getYear() >= startYearInt){
                        searchDisplay.append(e.toString());
                    }
                }
            }
            else if(startYearInt == 0 && endYearInt != 0){//printout all products before the year
                for(Product e:List){
                    if(e.getYear() <= endYearInt){
                        searchDisplay.append(e.toString());
                    }
                }
            }
            else{
                //do nothing
            }
        }

        //if nothing is appended
        String random = searchDisplay.getText();
        if(random.isBlank()){
            searchDisplay.setText("There are no results");
        }
    }

    /*
    * Description: gets the args[0] from the command line if it has been given. creates the gui interface and sets it to be visible
    * does not exist. the inmput file has been given, check ReadMe.txt
    */
    public static void main(String[] args)throws Exception{
        //if input file is given, input all infp to ArrayList
        if(args.length == 1){
            filename = args[0];
            input();
        }

        EStoreSearch gui = new EStoreSearch();
        gui.setVisible(true);
    }//end of main

}