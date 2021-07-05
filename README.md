# E-Store Search #

A simple virtual store application with an interactive user interface for product browsing using Java. Using Java swing packages allowing retailers to add several types of products and customers to search and browse through the products. The info needed for Books: product Id, Description, year, price, author, publisher. For Electronics: product Id, Description, year, price, maker. Classes for Objects contain Accessors, maintainers and ToStrings to help assist with the main program in adding and searching Objects.

The program will display a JFrame allowing you to choose from a commands menu: Add, Search, Quit. If "Add" is chosen it will prompt GUI panel for adding a product. The user will choose wether to add a Book or an Electronic. Text fields will be open for user to input information. Exception handling will make sure correct information is inputted. If "Search" is chosen, then it will prompt the user to input search values into the GUI text fields. If none are inputted, it will output all the elements in the list. If "Quit" was chosen, it will end the program after outputting all arrayList information to the textfile if it has been inputted in commandLine. If an inputFile is entered in commandLine, it will read all information automatically adding to the arrayLists.

To end the program, you can hit the "X" button. It is recommended to quit through the "quit" button in the
"Commands" menu. This will append any new information that has been added to the ArrayLists to the textfile.

## How to Run ##
 - in terminal, make sure the project is all in the correct directory
 - run the code with the assist of gradle:         gradle run --console=plain

## How to Run With Input Files ##
 - in terminal, make sure the project is all in the correct directory
 - run the coded with the assist of gradle:        gradle run --args='inputFile.txt' --console=plain

in this case the input file is inputted and named inputFile.txt in the package.