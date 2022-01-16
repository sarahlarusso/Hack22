package general;

import java.io.*;
import java.util.*;

public class SchoolParser {

    public static HashList<School> parseFile(String fileName) throws IOException {
        HashList<School> schools = new HashList<>();
        Scanner scanley = new Scanner(new File(fileName));
        while(scanley.hasNextLine()){
            String line = scanley.nextLine();
            School sch = new School();
            int start = line.indexOf(','), end = line.lastIndexOf(',');
            String name = line.substring(0, start), town = line.substring(start+1,end);
            String state = line.substring(end+1);

            // setting the values in org
            sch.setName(name);
            sch.setTown(town);
            sch.setState(town);


            schools.add(sch);
        }
        scanley.close();
        return schools;
    }

}
