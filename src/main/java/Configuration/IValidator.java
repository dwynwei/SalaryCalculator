package Configuration;

import Model.Employee;

public interface IValidator<T extends Employee> {

    Boolean nameValidator(T employee);
    Boolean salaryValidator(T employee);
    Boolean workingHoursValidator(T employee);
    Boolean hireYearValidator(T employee);

}
