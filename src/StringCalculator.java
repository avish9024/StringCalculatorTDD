import java.util.*;

public class StringCalculator {

    public static final List<String> RESERVED_CHARACTERS = new ArrayList<>(Arrays.asList("*", ".", "[", "{", "(", "+", "?", "^", "$", "|"));
    private static final String DEFAULT_DELIMITER = ",";

    public static int add(String numbers) {
        if(numbers.length() == 0){
            return 0;
        }
        if(numbers.length() == 1) {
            return Integer.parseInt(numbers);
        }
        if (numbers.contains("\n")) {
            /*if(numbers.matches("//(.*)\n(.*)")){
                delimiter = getDelimiter(numbers);
                System.out.println(delimiter);
                numbers = numbers.substring(2 + delimiter.length());
            }*/
            List<String> parsedNumberString = getParsedString(numbers);
           /* List<String> stringListWithoutNewLineAndComma = Arrays
                    .asList(parsedNumberString.split(DEFAULT_DELIMITER  + "|\n"));*/
            return getSum(parsedNumberString);
        }
        List<String> numbersList = Arrays.asList(numbers.split(","));
        return getSum(numbersList);
    }

    public static int getSum(List<String> numbersList) {
        System.out.println(numbersList);
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

    private static List<String> getParsedString(String givenString) {
        String delimiterPart;
        String numberPart = "";
        Set<String> delimiters = new HashSet<>();
        System.out.println(givenString);
        int index = givenString.lastIndexOf("]");
        System.out.println(index);
        if (index < 0) {
            int onlyDelimiterIndex = givenString.indexOf("//");
            if(onlyDelimiterIndex == 0) {
                delimiterPart = givenString.substring(2, 3);
                delimiters = new HashSet<>(Arrays.asList(delimiterPart));
                numberPart = givenString.substring(4);
            }
        } else {
            delimiterPart = givenString.substring(2, index + 1);
            System.out.println(delimiterPart);
            boolean closingBrace = false;
            String eachDelimiter = null;
            delimiters = new HashSet<>();

            for(int i = 0; i < delimiterPart.length(); ++i) {
                char c = delimiterPart.charAt(i);
                if(c == '[') {
                    closingBrace = false;
                    eachDelimiter = "";
                    continue;
                }
                if(c != ']') {
                    eachDelimiter+=c;
                }
                if(c == ']') {
                    delimiters.add(eachDelimiter);
                    closingBrace = true;
                }
            }
            numberPart = givenString.substring(index + 2); //index+1 point to \n
        }
        System.out.println(numberPart);
        for(String curDelimiter: delimiters)
        {
            numberPart = numberPart.replace(curDelimiter, DEFAULT_DELIMITER);
        }
        String numbers[] = numberPart.split(DEFAULT_DELIMITER);
        return Arrays.asList(numbers);
    }
}
