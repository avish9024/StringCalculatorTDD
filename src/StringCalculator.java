import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public static int add(String numbers) {
        if(numbers.length() == 0){
            return 0;
        }
        if(numbers.length() == 1) {
            return Integer.parseInt(numbers);
        }
        if (numbers.contains("\n")) {
            List<String> stringListWithoutNewLineAndComma = Arrays
                    .asList(numbers.replaceAll("\n", ",").split(","));
            return getSum(stringListWithoutNewLineAndComma);
        }
        List<String> numbersList = Arrays.asList(numbers.split(","));
        return getSum(numbersList);
    }

    public static int getSum(List<String> numbersList) {
        int sum = 0;
        for (String number: numbersList) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}