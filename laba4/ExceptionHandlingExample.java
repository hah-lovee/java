package first_block.laba4;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

class CustomInputMismatchException extends InputMismatchException {
    public CustomInputMismatchException(String message) {
        super(message);
    }
}

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter logWriter = null;

        try {
            logWriter = new PrintWriter(new FileWriter("first_block/laba4/exception_log.txt", true));

            System.out.print("Введите целое число: ");
            String userInput = scanner.nextLine();

            if (!userInput.matches("\\d+")) {
                throw new CustomInputMismatchException("Введено не целое число");
            }

            System.out.println("Вы ввели: " + userInput);

        } catch (CustomInputMismatchException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            logException(logWriter, e);

        } catch (Exception e) {
            System.out.println("Произошла неизвестная ошибка");
            logException(logWriter, e);

        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (logWriter != null) {
                logWriter.close();
            }
        }
    }

    private static void logException(PrintWriter logWriter, Exception e) {
        if (logWriter != null) {
            logWriter.println("Exception: " + e.getClass().getName());
            logWriter.println("Message: " + e.getMessage());
            logWriter.println("StackTrace: ");
            e.printStackTrace(logWriter);
            logWriter.println("\n");
        }
    }
}