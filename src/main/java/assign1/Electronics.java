/*
 * File Name: Electronics
 * Package Name: assign1
 * Author: Affan Khan
 * Last Modified On: 2020-10-19
 * Description: An object class for electronics to be used in the EStoreSearch class. Has variable modifers and accessors.
 */
package assign1;

public class Electronics extends Product{
    //variables
    private String maker;

    /*
    * Description: constructor for all variables in class
    * Parameters: String productID, String Description, double price, int year, String maker
    * Return: none
    */
    public Electronics(String productID, String Description, double price, int year, String maker) throws Exception{
        super(productID, Description, price, year);
        this.maker = maker;
    }

    /*
    * Description: constructor for all variables in class
    * Parameters: none
    * Return: none
    */
    public Electronics(){
        super();
        this.maker = "-----M------";
    }

    /*
    * Description: gets the maker and returns it back
    * Parameters: none
    * Return: String maker
    */
    public String getMaker(){
        return maker;
    }

    
    /*
    * Description: sets a new maker to the maker variable
    * Parameters: String maker
    * Return: none
    */
    public void setMaker(String newMaker){
        maker = newMaker;
    }

    /*
    * Description: compares two integers and returns a true or false boolean
    * Parameters: int x, int y
    * Return: boolean false or true
    */
    public boolean equalsI(Object otherObj){
        /*if(otherObj == null){
            return false;
        }
        else{
            Electronics otherProduct = (Electronics)otherObj;
            return(maker.equals(otherObj.getMaker()));
        }*/
        return false;
    }

    public String outputFile(){
        return "type = \"electronics\"\nproductID  = \"" + getProductID() + 
        "\"\ndescription= \"" + getDescription() +"\"\nprice = \"" + 
        getPrice() + "\"\nyear = \"" + getYear() +"\"\nmaker= \"" + maker + "\"";
    }

    /*
    * Description: Prints a String to the output
    * Parameters: none
    * Return: String
    */
    public String toString(){
        return "\n" + getProductID() + "\n" + getDescription() + "\n" + getYear() + "\n$" + getPrice() + "\n" + 
            maker + "\n-------------";
    }



}
