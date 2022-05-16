package kz.iitu.itse1908.springfinalproject.Utils;

import kz.iitu.itse1908.springfinalproject.Entities.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    public static void downloadCsv(PrintWriter writer) {
        writer.write("fname, lname, email, password, roleId, groupId\n");
    }

    public static List<String[]> readNewStudents(String fileName){
        String line = "";
        String splitBy = ",";
        int k = 0;
        List<String[]> newUserDetails = new ArrayList<String[]>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null)
            {
                k++;
                if (k == 1)
                    continue;
                String[] userInfo = line.split(splitBy);
                newUserDetails.add(userInfo);
            }
            return newUserDetails;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}