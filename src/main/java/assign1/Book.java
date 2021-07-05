/*
 * File Name: Book
 * Package Name: assign1
 * Author: Affan Khan
 * Last Modified On: 2020-10-19 
 * Description: An object class for books to be used in the EStoreSearch class. Has variable modifers and accessors.
 */
package assign1;

public class Book extends Product{
        //variables
        private String authors;
        private String publishers;

        /*
        * Description: constructor for all variables in class
        * Parameters: String productID, String Description, double price, int year, String maker
        * Return: none
        */
        public Book(String productID, String Description, double price, int year, String authors, String publishers) throws Exception{
            super(productID, Description, price, year);
            this.authors = authors;
            this.publishers = publishers;
        }

        /*
        * Description: constructor for all variables in class
        * Parameters: none
        * Return: none
        */
        public Book(){
            super();
            this.authors = "-----A------";
            this.publishers = "------P------";
        }

        
        /*
        * Description: gets the author value and returns it back
        * Parameters: none
        * Return: String author
        */
        public String getAuthors(){
            return authors;
        }

        /*
        * Description: gets the publisher value and returns it back
        * Parameters: none
        * Return: String publisher
        */
        public String getPublishers(){
            return publishers;
        }

        /*
        * Description: sets a new authors to the authors variable
        * Parameters: String newAuthors
        * Return: none
        */
        public void setAuthors(String newAuthors){
            authors = newAuthors;
        }

        /*
        * Description: sets a new publisher to the publisher variable
        * Parameters: String newpublisher
        * Return: none
        */
        public void setPublishers(String newPublishers){
            publishers = newPublishers;
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

    public String outputFile(){
        return "type = \"book\"\nproductID  = \"" + getProductID() + 
        "\"\ndescription= \"" + getDescription() +"\"\nprice = \"" + 
        getPrice() + "\"\nyear = \"" + getYear() +"\"\nauthors = \"" +
         authors + "\"\npublisher= \"" + publishers + "\"";
    }


    /*
    * Description: Prints a String to the output
    * Parameters: none
    * Return: String
    */
    public String toString(){
        return "\n" + getProductID() + "\n" + getDescription() + "\n" + getYear() + "\n$" + getPrice() + "\n" + 
            authors + "\n" + publishers + "\n-------------";
    }

}