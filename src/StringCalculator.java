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
            String delimiter = ",";
            if(numbers.matches("//(.*)\n(.*)")){
                delimiter = Character.toString(numbers.charAt(2));
                numbers = numbers.substring(4);
            }
            List<String> stringListWithoutNewLineAndComma = Arrays
                    .asList(numbers.replaceAll("\n", ",").split(delimiter));
            return getSum(stringListWithoutNewLineAndComma);
        }
        List<String> numbersList = Arrays.asList(numbers.split(","));
        return getSum(numbersList);
    }

    public static int getSum(List<String> numbersList) {
        int sum = 0;
        String negativeString = "";
        for (String number: numbersList) {
            if (number.length() != 0) {
                int givenNumber = Integer.parseInt(number);
                if (givenNumber < 0) {
                    if(negativeString == "") {
                        negativeString = number;
                    } else {
                        negativeString += ("," + number);
                    }
                } else {
                    sum += givenNumber;
                }
            }
        }
        if (negativeString != "") {
            throw new IllegalArgumentException("Negative numbers are not allowed: " + negativeString);
        }
        return sum;
    }
}
