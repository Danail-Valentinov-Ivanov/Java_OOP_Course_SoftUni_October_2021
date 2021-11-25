package E4_Interfaces_and_Abstraction.P5_Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String url : urls) {
            boolean isValid = true;
            for (int i = 0; i < url.length(); i++) {
                char currentChar = url.charAt(i);
                if (Character.isDigit(currentChar)) {
                    stringBuilder.append("Invalid URL!").append(System.lineSeparator());
                    isValid = false;
                    break;
                }
            }
            if (!isValid) {
                continue;
            }
            stringBuilder.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String number : numbers) {
            if (number.matches("\\D+[0-9]+|[0-9]+\\D+[0-9]+|\\D+|\\D+[0-9]+\\D+|[0-9]+\\D+")) {
                stringBuilder.append("Invalid number!").append(System.lineSeparator());
                continue;
            }
            stringBuilder.append("Calling... ").append(number).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
