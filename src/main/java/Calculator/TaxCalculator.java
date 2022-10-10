package Calculator;

import Configuration.IValidator;
import Configuration.Validator;
import Model.Employee;

import java.time.DateTimeException;
import java.time.LocalDate;

public class TaxCalculator implements ITaxCalculator<Employee>{

    private IValidator<Employee> employeeIValidator;

    public TaxCalculator(IValidator<Employee> employeeIValidator) {
        this.employeeIValidator = employeeIValidator;
    }

    @Override
    public double tax(Employee employee) {

        if(employeeIValidator.nameValidator(employee)){
            throw new RuntimeException("İsim Formatları Doğru Değil !");
        }

        if(!employeeIValidator.salaryValidator(employee)){
            throw new ArithmeticException("Maaş formatı doğru değil !");
        }

        if(employee.getSalary() > 1000){
            employee.setSalary(employee.getSalary() - (0.03*employee.getSalary()));
            return employee.getSalary();
        }
        return employee.getSalary();
    }

    @Override
    public double bonus(Employee employee){

        if(!employeeIValidator.workingHoursValidator(employee)){
            throw new ArithmeticException("Çalışılan Saat formatı doğru değil!");
        }

        if(employee.getWorkHours() > 40){
           employee.setSalary(employee.getSalary() + 30* (employee.getWorkHours() - 40));
           return employee.getSalary();
        }
        return employee.getSalary();
    }

    @Override
    public double raiseSalary(Employee employee){
        int year = LocalDate.now().getYear();

        if(!employeeIValidator.hireYearValidator(employee)){
            throw new DateTimeException("Girilen Tarih formatı istenilen aralıkta değil! <1900 - Bugün>");
        }

        if((year - employee.getYear()) > 9 && (year - employee.getYear() < 20)){
            employee.setSalary(0.1*employee.getSalary() + employee.getSalary());
            return employee.getSalary();
        }else if((year - employee.getYear()) > 19){
            employee.setSalary(0.15*employee.getSalary() + employee.getSalary());
            return employee.getSalary();
        }

        return employee.getSalary();
    }
}
