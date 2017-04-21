package service;

import model.Salary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danawacomputer on 2017-04-21.
 */
public class FunctionalSalaryService {
    public static List<Salary> generateServiceList(String filename) {

        List<Salary> list = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(
                    new FileReader(filename));
            String line = "";
            br.readLine(); //skip the first line
            while ((line = br.readLine()) != null) {
                String[] spl = line.split(",");

                LocalDate d = LocalDate.of(Integer.parseInt(spl[0]), 1,1);
                list.add(new Salary(d, spl[1], spl[2], spl[3],
                        Integer.parseInt(spl[4])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

