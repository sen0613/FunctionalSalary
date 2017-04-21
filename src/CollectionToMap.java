import model.Salary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by danawacomputer on 2017-04-21.
 */
public class CollectionToMap {
    public static void main(String[] args) {

        try {
            Map<String, Salary> map =
                    Files.lines(Paths.get("src\\Salaries.csv"))
                            .skip(1)
                            .map(x -> {
                                String[] spl = x.split(",");
                                return new Salary(
                                        LocalDate.of(Integer.parseInt(spl[0]), 1, 1),
                                        spl[1], spl[2], spl[3], Integer.parseInt(spl[4]));
                            })
                            .collect(Collectors.toMap(
                                    x -> String.valueOf(new Random().nextInt()), x -> x));
            System.out.println(map);
            map.forEach((k, v) -> System.out.println(k + ":" + v));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
