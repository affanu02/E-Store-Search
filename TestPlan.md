# Test Cases #

1. for command line input filename, it will only execute reading and appending if the file exists

2. for adding to the list, it will make sure description, price, productID, year are inputted correctly through exception handling.
    1. for productId it makes sure it doesn't already exist
    2. for productID it makes sure it is 6 digits long
    3. if these requirements are not met, it will output a message to the message text area

    1. for price, it makes sure it is a positive number
    2. for price, it makes sure it is a number
    3. if these requirements are not met, it will output a message to the message text area

    1. for year it makes sure it is a number between 1000-9999
    2. for year it makes sure it is a number
    3. if these requirements are not met, it will output a message to the message text area

3. for searching to the list, if nothing is inputted in the 4 fields productID, description, start Year, end Year it will display all elements of the ArrayList
    1. for start Year, if a number is not inputted in its textfield, it will ignore the input
    2. for end year, if a number is not inputted in its textfield, it will ignore the input
    3. if start year is less than end year, it will output a message to the search results warning the user that they need to have the end year after the start year.

3. for quitting the program, the user can click the X button at the top right, but is recommended to hit quit through the "Commands" menu. This will append any new information to the textfile if it has been inputted.