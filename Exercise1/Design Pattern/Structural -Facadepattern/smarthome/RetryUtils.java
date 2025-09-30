package smarthome;

import java.util.Scanner;
import java.util.function.Function;

public class RetryUtils {
    public static <T> T retryInput(String prompt, Function<String, T> parser, int maxRetries) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        while (attempts < maxRetries) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return parser.apply(input);
            } catch (Exception e) {
                attempts++;
                AppLogger.error("Invalid input, attempts left: " + (maxRetries - attempts), e);
                if (attempts >= maxRetries) throw new RuntimeException("Max retries exceeded.");
            }
        }
        throw new RuntimeException("Failed to get valid input.");
    }
}
