import model.Salary;
import service.FunctionalSalaryService;


import java.util.List;
import java.util.OptionalDouble;


/**
 * Created by danawacomputer on 2017-04-21.
 * 1. 1900년대 평균 연봉(1985~1999)
 * 2. NYY 구단의 평균연봉
 * 3. 최상위연봉자 10명의 평균
 */
public class FunctionalSalaryMain {
    public static void main(String[] args) {

        List<Salary> list = FunctionalSalaryService
                .generateServiceList("src\\Salaries.csv");

//        1. 1900년대 평균 연봉(1985~1999)
        OptionalDouble avgOf1900s =
                list.stream()
                .filter(x -> x.getYearID().getYear() < 2000)
                .mapToInt(Salary::getSalary)
                .average();
        if(avgOf1900s.isPresent()) {
            System.out.printf("1900년대의 평균 연봉은 %.2f달러 입니다.\n",avgOf1900s.getAsDouble());
        } else {
            System.out.println("no data");
        }


//        2. NYY 구단의 평균연봉

        OptionalDouble salaryAvgOfNYY =
                list.stream()
                .filter(x -> x.getTeamID().equals("NYY"))
                .mapToInt(Salary::getSalary)
                .average();
        if(avgOf1900s.isPresent()) {
            System.out.printf("NYY의 평균 연봉은 %.2f달러 입니다.\n",salaryAvgOfNYY.getAsDouble());
        } else {
            System.out.println("no data");
        }

//        3. 최상위연봉자 10명의 평균
        OptionalDouble avgOfTopTenSalary =
                list.stream()
                .sorted((x,y) -> y.getSalary() - x.getSalary())
                .limit(10)
                .mapToInt(x -> x.getSalary())
                .average();

        if(avgOfTopTenSalary.isPresent()) {System.out.printf("최상위연봉자 10명의 평균 연봉은 %.2f달러 입니다.\n",avgOfTopTenSalary
                    .getAsDouble());
        } else {
            System.out.println("no data");
        }
    }
}
