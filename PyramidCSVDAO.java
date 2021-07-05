import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PyramidCSVDAO {
    /*
    The instance variable in this class is a list of pyramids. It is a list which elements are of type Pyramid.
    Every pyramid represents information stored in one row in the csv file
    Since it is a private variable, we added a getter called List<Pyramid> getPyramids()
     */
    private List<Pyramid> pyramidsList;

    /*
    The methods' algorithm (Big picture)
    1- We use the constructor method: public PyramidCSVDAO(String filePath) to do all of the work which is
        calling the method: void readPyramidsFromCSV(filePath) which takes the file path of the
        pyramids csv file, reads it line by line and adds a new pyramid to pyramidsList instance variable.
    2- The method: void readPyramidsFromCSV(filePath) calls the method: Pyramid createPyramid(String [] data)
       and passes the data read from every line to it. The method: Pyramid createPyramid(String [] data) creates an object
       of type Pyramid and validates all the inputs using three main methods:
       a) int convertToInt(String s) which checks that the input string is not null and convert the string to int
       b) String convertToString(String s) which checks that the input string is not null
       c) float convertToFloat(String s) which checks that the input string is not null and convert the string to float
          after checking that the input string has one or zero decimal points i.e (121, 215.25); if the input string has
          two decimal points such as 1.237.040 in (row 15, volume column), it removes the first decimal point to be 1237.040

          More details are found below
    */

    // PyramidCSVDAO constructor
    public PyramidCSVDAO(String filePath) {
        readPyramidsFromCSV(filePath);
    }

    // It was mentioned in the first step in the algorithm
    public void readPyramidsFromCSV(String filePath)
    {
        String line = "";  // a String line to store the lines read from the csv file in
        String splitBy = ","; // a String line that stores the character in which we split the line string at
        pyramidsList = new ArrayList<Pyramid>(); // initializing

        try //using try catch as we open and close a file
        {
            //info about buffered reader: https://www.programiz.com/java-programming/bufferedreader
            FileReader fr = new FileReader(filePath); //a FileReader object fr that takes the filepath
            BufferedReader br = new BufferedReader(fr); //a BufferedReader object that takes a FileReader object fr

            //read the first line as it contains the names of the columns, not the data. If this step is skipped
            //the code will generate an error because all the columns are strings and we stored some data such as base1
            //and base2 as floats
            br.readLine();

            //starts the while loop by reading the second line, it continues reading the rows as long as
            //there is more lines in the csv file.
            //line = br.readLine() reads a line and store it in the line variable defined above
            //line = br.readLine()) != null checks that this line has values; not null
            while ((line = br.readLine()) != null)
            {
                String [] data = line.split(splitBy);
                //String class has a method split that takes the splitBy string, in our case a (,) and returns
                //a String array which contains the elements in the line
                //for example, suppose line = "Djoser,Hiemlender,Step Pyramid of Djoser,3". It returns
                //{Djoser,Hiemlender,Step Pyramid of Djoser,3}. In other words, it converts the string to array of strings

                Pyramid thisRowsPyramid = createPyramid(data);
                //Creating a new pyramid object using createPyramid method and passing to it the array of strings data

                pyramidsList.add(thisRowsPyramid);
                //pyramidList is an ArrayList object, it has a method called add that is used to add a new element to the list
                //thisRowsPyramid object is added to the list: pyramidsList

                //after one iteration, if the next row doesnt contain null, the while loop continues adding new Pyramids
                //to the pyramidsList
            }

            br.close(); //closing the file to prevent errors
        }
        catch (IOException e) //catching if any exception was thrown in the try part
        {
            e.printStackTrace();
        }

    }

    //It was mentioned in the second step in the algorithm
    public Pyramid createPyramid(String [] data)
    {
        //initializing new local variables in the scope of createPyramid function only (only this method can see them)
        //and passing it to the Pyramid's class constructor to create an object
        //The local variables have the same name as the Pyramid's class variables for simplicity, they can be changed
        //to anything as long as they are passed to the pyramid's constructor by the same order

        //all convertToString, convertToFoat, convertToInt are used to validate the input

        String pharaoh = convertToString(data[0]); //calling convertToString method mentioned in step 2)b) in the algorithm
        String ancientName = convertToString(data[1]);
        String modernName = convertToString(data[2]);
        int dynasty = convertToInt(data[3]); //calling convertToInt method mentioned in step 2)a) in the algorithm
        String site = convertToString(data[4]);
        float base1 = convertToFloat(data[5]); //calling convertToFloat method mentioned in step 2)c) in the algorithm
        float base2 = convertToFloat(data[6]);
        float height= convertToFloat(data[7]);
        float slope=convertToFloat(data[8]);
        float volume=convertToFloat(data[9]);
        float latitude=convertToFloat(data[10]);
        float longitude=convertToFloat(data[11]);
        String type=convertToString(data[12]);
        String lepsius=convertToString(data[13]);
        String material=convertToString(data[14]);

        //if the comment column is null, the line reader eliminates the last column
        //which makes the array become of size 15 instead of 16 and an error is generated in line 116
        //Therefore, we added the if condition to store an space in the comment variable if it wasn't read
        String comment;
        if (data.length == 16)
            comment=convertToString(data[15]);
        else
            comment=" ";

        //creating the new pyramid object
        Pyramid rowPyramid = new Pyramid(pharaoh,ancientName,modernName,dynasty,site,base1,base2,height,slope,volume,latitude,longitude,type,lepsius,material,comment);
        return rowPyramid;
    }

    /*
    Staring validation methods:
    removePoints, convertToFloat, convertToString, convertToInt
     */

    //this method is mentioned in step 2)c) in the algorithm
    //it removes the extra point from (1.237.040) and similar elements
    private String removePoints(String s)
    {
        //initializing a queue of integers to use the FIFO (first in first out) feature
        Queue<Integer> decimalPosQueue = new LinkedList<Integer>();

        //indexOf gets the firs index of '.' it encounters
        Integer i = s.indexOf('.');

        //If it doesnt find any decimal points (for example: 121), i is negative and we don't enter the
        //if condition. If it finds a decimal points (for example: 215.25 or 1.237.040), it enters the
        //if condition to check if there is still more points
        if(i>=0)
        {
            decimalPosQueue.add(i); //we add the index of the first decimal point to the decimalPosQueue, It
            //will be the first decimal point out as well


            while(i >= 0) //the loop will continue as long as there are more decimal points
            {
                i = s.indexOf('.', i + 1); //indexOf this time starts looking just after the index found ln line 139
                if (i > 0)
                    decimalPosQueue.add(i); //if it finds an index (i is positive), we add this point to the queue
            }
        }
        //decimalPosQueue contents example:
        /*
            1- 121: will be empty
            2- 215.25: will have one integer 3 (index is 3)
            3- 1.237.040 will have two integers 1 and 5
         */

        //StringBuilder class is used because it is a String that contains the method deleteCharAt
        //check https://stackoverflow.com/questions/13386107/how-to-remove-single-character-from-a-string

        StringBuilder sb = new StringBuilder(s); //creating an object and passing the string input to it

        //in this while loop, we will continue removing decimals from the string until we have only one decimal
        //having more than one decimal in a float results in an exception
        while(decimalPosQueue.size()>1) //keep the loop going until the queue has only one element left
        {
            Integer indexToBeRemoved = decimalPosQueue.remove(); //remove the first element entered the queue and get its index
            sb.deleteCharAt(indexToBeRemoved); //for every iteration, delete the decimal point (char) at this index
        }
        //exit when one decimal point only remains
        String resultString = sb.toString(); //convert the StringBuilder object defined in line 167 to a regular String
        return resultString;
    }

    //This method is mentioned in step 2)c) in the algorithm
    private float convertToFloat(String s)
    {
        s = removePoints(s); //calling remove points and get the new string
        if (s==null || s.length()==0)
            return 0.0f; //if the string is null, return a 0 value
        else
            return Float.valueOf(s); //else, convert the string to float and return it
    }

    private int convertToInt(String s)
    {
        if (s==null || s.length()==0)
            return 0; //if the string is null, return a 0 value
        else
            return Integer.valueOf(s); //else, convert the string to int and return it
    }

    private String convertToString(String s)
    {
        if (s==null || s.length()==0)
            return " "; //if the string is null, return a space
        else
            return s; //else, return it as it is
    }

    /*
    Staring validation methods:
    removePoints, convertToFloat, convertToString, convertToInt
    */

    //a getter
    public List<Pyramid> getPyramids() {
        return pyramidsList;
    }
}
