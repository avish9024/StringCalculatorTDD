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
                delimiter = numbers.substring(2, numbers.indexOf("\n"));
                numbers = numbers.substring(2 + delimiter.length());
            }
            List<String> stringListWithoutNewLineAndComma = Arrays
                    .asList(numbers.split(delimiter  + "|\n"));
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
                    sum += givenNumber < 1000 ? givenNumber : 0;
                }
            }
        }
        if (negativeString != "") {
            throw new IllegalArgumentException("Negative numbers are not allowed: " + negativeString);
        }
        return sum;
    }

    private String getDelimiter(String givenString) {
        return null;
    }
}
