import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int period) {
       double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);

       return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return round(amount + amount * yearRate * period, 2);
    }

    double round(double pay, int places) {
        double scale= Math.pow(10, places);

        return Math.round(pay * scale) / scale;
    }

    void printResult() {
        int period;
        int action;
        double yearRate = 0.06;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double calculationResult = 0;
        if (action == 1) {
            calculationResult = calculateSimplePercent(amount, yearRate, period);
        } else if (action == 2) {
            calculationResult = calculateComplexPercent(amount, yearRate, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + calculationResult);
    }

    public static void main(String[] args) {
        new DepositCalculator().printResult();
    }
}
