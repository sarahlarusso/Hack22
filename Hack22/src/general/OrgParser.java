package general;

import java.io.*;
import java.util.*;

public class OrgParser {

    public static HashList<Organization> parseFile(String fileName) throws IOException {
        HashList<Organization> orgs = new HashList<>();
        Scanner scanley = new Scanner(new File(fileName));
            while(scanley.hasNextLine()){
                String line = scanley.nextLine();
                Organization org = new Organization();
                int start = line.indexOf('\"'), end = line.lastIndexOf('\"'), semi = line.lastIndexOf(';');
                String name = line.substring(0, start), description = line.substring(start+1,end);
                String town = line.substring(end+1, semi);

                // setting the values in org
                org.setName(name);
                org.setDescripton(description);
                org.setTown(town);
                //tags
                String[] tags = line.substring(semi+1).split(",");
                for(String tag : tags){
                    org.add(Category.getCategory(tag));
                }

                orgs.add(org);
            }
            scanley.close();
            return orgs;
    }

}
