import model.Salary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;


/**
 * Created by danawacomputer on 2017-04-21.
 */
public class StreamDemo {
    public static void main(String[] args) {
        try {
            List<Salary> list =
            Files.lines(Paths.get("src\\Salaries.csv"))// 'lines'라는 함수가 file을 한 라인씩 나눠서 String으로 만들어줌
                    .skip(1)
                    .map(x -> {
                        String[] spl = x.split(",");
                        return new Salary(
                                LocalDate.of(Integer.parseInt(spl[0]),1,1),
                                spl[1], spl[2], spl[3], Integer.parseInt(spl[4]));
                    })
                    .collect(Collectors.toList());
            for(Salary e : list) {
                System.out.println(e);
            }

            long sum =
                    LongStream.range(1, 10000000).sum();
            System.out.println(sum);

            IntStream.generate(() -> 1)
                    .limit(1)
                            .forEach(System.out::println);

            Random ra = new Random();
            ra.ints(1,6)
                    .limit(100000)
                    .forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
