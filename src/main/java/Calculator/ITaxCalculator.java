package Calculator;

public interface ITaxCalculator<T> {
    public double tax(T t);
    public double bonus(T t);
    public double raiseSalary(T t);
}
