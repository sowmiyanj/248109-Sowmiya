package bankproxy;

import java.util.Scanner;
import java.util.function.Function;

public class RetryUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static <T> T retryInput(String prompt, Function<String, T> parser, int maxRetries) {
        int attempts = 0;
        while (attempts < maxRetries) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return parser.apply(input);
            } catch (Exception e) {
                attempts++;
                AppLogger.error("Invalid input, attempts left: " + (maxRetries - attempts), e);
                if (attempts >= maxRetries) {
                    throw new RuntimeException("Maximum retries exceeded.");
                }
                System.out.println("Invalid input, try again.");
            }
        }
        throw new RuntimeException("Failed to get valid input.");
    }
}

