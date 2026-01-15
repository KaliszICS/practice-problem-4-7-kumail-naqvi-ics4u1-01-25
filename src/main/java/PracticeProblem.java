/**
 * Throwing appropriate exceptions for invalid inputs
 * @author Kumail
 * @version 1.0
 */
public class PracticeProblem {
    /**
     * Validates an age
     *
     * @param age input age
     * @return true if valid
     * @throws IllegalArgumentException if age is negative or greater than 150
     */
    public static boolean validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (age > 150) {
            throw new IllegalArgumentException("Age must be realistic");
        }
        return true;
    }

    /**
     * Withdraws an amount from a balance
     *
     * @param amount  amount to withdraw
     * @param balance current balance
     * @return new balance
     * @throws IllegalArgumentException if amount is <= 0
     * @throws IllegalStateException  if withdrawal makes balance negative
     */
    public static double withdraw(double amount, double balance) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (balance - amount < 0) {
            throw new IllegalStateException("Insufficient funds");
        }
        return balance - amount;
    }

    /**
     * Returns an element from array at given index
     *
     * @param array input array
     * @param index index to access
     *  @return  element at index
     * @throws NullPointerException   if array is null
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public static int getElement(int[] array, int index) {
        if (array == null) {
            throw new NullPointerException("Array cannot be null");
        }
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return array[index];
    }
    /**
     * Validates an email string and returns the trimmed email
     *
     * @param email input email
     * @return trimmed email
     * @throws IllegalArgumentException if email is null/empty or formatis invalid
     */
    public static String validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        String trimmed = email.trim();
        int atIndex = trimmed.indexOf('@');

        if (atIndex < 0) {
            throw new IllegalArgumentException("Invalid email format");
        }
        int dotAfterAt = trimmed.indexOf('.', atIndex + 1);
        if (dotAfterAt < 0) {
            throw new IllegalArgumentException("Invalid email format");
        }
        return trimmed;
    }
}