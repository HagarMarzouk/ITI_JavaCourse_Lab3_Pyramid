import java.util.*;

public class main {
    public static void main(String [] args)
    {
        // pass the csv file path
        PyramidCSVDAO pDAO = new PyramidCSVDAO("/home/t/iti/java/lab2/src/pyramids.csv");
        List<Pyramid> pyramids = pDAO.getPyramids();

        int i=0;
        for (Pyramid p:pyramids) //for each pyramid in pyramids list
        {
            System.out.println("#"+(i++)+p); //print the object (thats why we used overriding of the method toString in Pyramid class
        }
    }
}
