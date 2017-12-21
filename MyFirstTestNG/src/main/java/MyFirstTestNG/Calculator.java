package MyFirstTestNG;

public class Calculator {
    private int first;
    private int second;

    public Calculator(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getResult(){
        return first * second;
    }
}