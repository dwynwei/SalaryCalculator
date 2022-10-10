package Configuration;

import Model.Employee;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator<T extends Employee> implements IValidator {

    private Class<T> employee;

    public Validator(Class<T> employee) {
        this.employee = employee;
    }

    @Override
    public Boolean nameValidator(Employee employee){

        Pattern patternNames = Pattern.compile("[A-Za-z]");

        Matcher matcherName = patternNames.matcher(employee.getName());
        Matcher matcherLastName = patternNames.matcher(employee.getLastName());

        Boolean matchFoundName = matcherName.find();
        Boolean matchFoundLastName = matcherName.find();

        if(matchFoundName && matchFoundLastName){
            return true;
        }

        return false;

    }

    @Override
    public Boolean salaryValidator(Employee employee){
        if(employee.getSalary() <= 0){
            return false;
        }

        return true;

    }

    @Override
    public Boolean workingHoursValidator(Employee employee) {
        if(employee.getWorkHours() <= 0){
            return false;
        }
        return true;
    }

    @Override
    public Boolean hireYearValidator(Employee employee) {
        if(employee.getYear() <= 1900 && employee.getYear() >= LocalDate.now().getYear()){
            return false;
        }
        return true;
    }

}
