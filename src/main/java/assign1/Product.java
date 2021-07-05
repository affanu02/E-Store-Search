/*
 * File Name: Product
 * Package Name: assign1
 * Author: Affan Khan
 * Last Modified On: 2020-10-19
 * Description: An object class for electronics to be used in the EStoreSearch class. Has variable modifers and accessors.
 */
package assign1;

public class Product{
    //variables
    private String productID;
    private String Description;
    private double price;
    private int year;

    /*
    * Description: constructor for all variables in class
    * Parameters: String productID, String Description, double price, int year, String maker
    * Return: none
    */
    public Product(String productID, String Description, double price, int year) throws Exception{
        //error handling productID
        if(productID.equals("")){
            throw new Exception("ProductID must be entered.");
        }
        else if(productID.length() != 6){
            throw new Exception("ProductID must be 6 characters long.");
        }
        else{
            this.productID = productID;
        }

        //error handling Description
        if(Description.isBlank()){
            throw new Exception("Description must be entered.");
        }
        else{
            this.Description = Description;
        }

        //error handling price
        if(price < 0){
            throw new Exception("Price must be positive.");
        }
        else{
            this.price = price;
        }
        
        if(year > 9999 || year < 1000){
            throw new Exception("Year must be a number between 1000-9999.");
        } 
        else{
            this.year = year;
        }
    }

    /*
    * Description: constructor for all variables in class
    * Parameters: none
    * Return: none
    */
    public Product(){
        this.productID = "000000";
        this.Description = "-----name-----";
        this.price = 0.00;
        this.year = 0;
    }


    /*
    * Description: gets the productID value and returns it back
    * Parameters: none
    * Return: String productID
    */
    public String getProductID(){
        return productID;
    }

    /*
    * Description: gets the description value and returns it back
    * Parameters: none
    * Return: String Description
    */
    public String getDescription(){
        return Description;
    }

    /*
    * Description: gets the price value and returns it back
    * Parameters: none
    * Return: double price
    */
    public double getPrice(){
        return price;
    }

    /*
    * Description: gets the year value and returns it back
    * Parameters: none
    * Return: int year
    */
    public int getYear(){
        return year;
    }


    /*
    * Description: sets a new product Id to the product variable
    * Parameters: String newProductID
    * Return: none
    */
    public void setProductID(String newProductID){
        productID = newProductID;
    }

    /*
    * Description: sets a new Description to the description variable
    * Parameters: String newDescription
    * Return: none
    */
    public void setDescription(String newDescription){
        Description = newDescription;
    }

    /*
    * Description: sets a new price to the price variable
    * Parameters: double price
    * Return: none
    */
    public void setPrice(double newPrice){
        price = newPrice;
    }

    /*
    * Description: sets a new year to the year variable
    * Parameters: int year
    * Return: none
    */
    public void setYear(int newYear){
        year = newYear;
    }


    public String outputFile(){
        return "type = \"product\"\nproductID  = \"" + getProductID() + 
        "\"\ndescription= \"" + getDescription() +"\"\nprice = \"" + 
        getPrice() + "\"\nyear = \"" + getYear() +"\"";
    }


    /*
    * Description: compares two integers and returns a true or false boolean
    * Parameters: int x, int y
    * Return: boolean false or true
    */
    public boolean equalsI(int x, int y){
        if(x == y){
            return true;
        }
        else{
            return false;
        }
    }

    /*
    * Description: compares two Strings and returns a true or false boolean
    * Parameters: String x, String y
    * return: boolean false or true
    */
    public boolean equalsS(String x, String y){
        if(x.equalsIgnoreCase(x)){
            return true;
        }
        else{
            return false;
        }
    }

    /*
    * Description: Prints a String to the output
    * Parameters: none
    * Return: String
    */
    public String toString(){
        return "\n" + productID + "\n" + Description + "\n" + year + "\n$" + price;
    }



}
