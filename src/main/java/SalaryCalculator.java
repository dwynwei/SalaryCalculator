import Calculator.ITaxCalculator;
import Calculator.TaxCalculator;
import Configuration.IValidator;
import Configuration.Validator;
import Model.Employee;

import java.util.Scanner;

public class SalaryCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen İsim Giriniz : ");
        String name = scanner.nextLine();
        System.out.print("Lütfen Soy İsim Giriniz : ");
        String lastName = scanner.nextLine();
        System.out.print("Lütfen Maaş Bilgisini Giriniz : ");
        double salary = scanner.nextDouble();
        System.out.print("Lütfen Haftalık Çalışma Saatini Giriniz : ");
        int workingHours = scanner.nextInt();
        System.out.print("Lütfen İşe Alınma Yılını Giriniz : ");
        int hireYear = scanner.nextInt();

        Employee employee = new Employee(name,lastName,salary,workingHours,hireYear);

        ITaxCalculator<Employee> calculator = new TaxCalculator(new Validator<Employee>(Employee.class));
        calculator.tax(employee);
        calculator.bonus(employee);
        calculator.raiseSalary(employee);

        System.out.println(employee.toString());

    }
}
