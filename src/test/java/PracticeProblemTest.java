import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

public class PracticeProblemTest {
        // ==================== PROBLEM 1: Bank Account PracticeProblem.withdrawal ====================
    
    @Test
    public void testWithdrawValidAmount() {
        try {
            double result = PracticeProblem.withdraw(50.0, 100.0);
            assertEquals(50.0, result, 0.01);
        } catch (NoSuchMethodError | Exception e) {
            fail("withdraw method not implemented or threw unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testWithdrawNegativeAmount() {
        try {
            PracticeProblem.withdraw(-10.0, 100.0);
            fail("Should have thrown IllegalArgumentException for negative amount");
        } catch (IllegalArgumentException e) {
            assertTrue("Exception message should mention positive or negative", 
                      e.getMessage().toLowerCase().contains("positive") || 
                      e.getMessage().toLowerCase().contains("negative"));
        } catch (NoSuchMethodError e) {
            fail("withdraw method not implemented");
        } catch (Exception e) {
            fail("Wrong exception type thrown. Expected IllegalArgumentException, got: " + e.getClass().getName());
        }
    }
    
    @Test
    public void testWithdrawZeroAmount() {
        try {
            PracticeProblem.withdraw(0.0, 100.0);
            fail("Should have thrown IllegalArgumentException for zero amount");
        } catch (IllegalArgumentException e) {
            // Test passes
        } catch (NoSuchMethodError e) {
            fail("withdraw method not implemented");
        } catch (Exception e) {
            fail("Wrong exception type thrown. Expected IllegalArgumentException, got: " + e.getClass().getName());
        }
    }
    
    @Test
    public void testWithdrawInsufficientFunds() {
        try {
            PracticeProblem.withdraw(150.0, 100.0);
            fail("Should have thrown IllegalStateException for insufficient funds");
        } catch (IllegalStateException e) {
            assertTrue("Exception message should mention funds or balance", 
                      e.getMessage().toLowerCase().contains("fund") || 
                      e.getMessage().toLowerCase().contains("balance"));
        } catch (NoSuchMethodError e) {
            fail("withdraw method not implemented");
        } catch (Exception e) {
            fail("Wrong exception type thrown. Expected IllegalStateException, got: " + e.getClass().getName());
        }
    }
    
    // ==================== PROBLEM 2: Age Validator ====================
    
    @Test
    public void testValidateAgeValid() {
        try {
            boolean result = PracticeProblem.validateAge(25);
            assertTrue("Valid age should return true", result);
        } catch (NoSuchMethodError | Exception e) {
            fail("validateAge method not implemented or threw unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testValidateAgeNegative() {
        try {
            PracticeProblem.validateAge(-5);
            fail("Should have thrown IllegalArgumentException for negative age");
        } catch (IllegalArgumentException e) {
            assertTrue("Exception message should mention negative", 
                      e.getMessage().toLowerCase().contains("negative"));
        } catch (NoSuchMethodError e) {
            fail("validateAge method not implemented");
        } catch (Exception e) {
            fail("Wrong exception type thrown. Expected IllegalArgumentException, got: " + e.getClass().getName());
        }
    }
    
    @Test
    public void testValidateAgeTooHigh() {
        try {
            PracticeProblem.validateAge(200);
            fail("Should have thrown IllegalArgumentException for unrealistic age");
        } catch (IllegalArgumentException e) {
            assertTrue("Exception message should mention realistic or maximum", 
                      e.getMessage().toLowerCase().contains("realistic") || 
                      e.getMessage().toLowerCase().contains("150"));
        } catch (NoSuchMethodError e) {
            fail("validateAge method not implemented");
        } catch (Exception e) {
            fail("Wrong exception type thrown. Expected IllegalArgumentException, got: " + e.getClass().getName());
        }
    }
    
    @Test
    public void testValidateAgeBoundary() {
        try {
            boolean result = PracticeProblem.validateAge(150);
            assertTrue("Age of 150 should be valid", result);
        } catch (NoSuchMethodError | Exception e) {
            fail("validateAge method not implemented or threw unexpected exception: " + e.getMessage());
        }
    }
    
    // ==================== PROBLEM 3: Array Index Checker ====================
    
    @Test
    public void testGetElementValid() {
        try {
            int[] nums = {10, 20, 30};
            int result = PracticeProblem.getElement(nums, 1);
            assertEquals(20, result);
        } catch (NoSuchMethodError | Exception e) {
            fail("getElement method not implemented or threw unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testGetElementNullArray() {
        try {
            PracticeProblem.getElement(null, 0);
            fail("Should have thrown NullPointerException for null array");
        } catch (NullPointerException e) {
            assertTrue("Exception message should mention null or array", 
                      e.getMessage() != null && 
                      (e.getMessage().toLowerCase().contains("null") || 
                       e.getMessage().toLowerCase().contains("array")));
        } catch (NoSuchMethodError e) {
            fail("getElement method not implemented");
        } catch (Exception e) {
            fail("Wrong exception type thrown. Expected NullPointerException, got: " + e.getClass().getName());
        }
    }
    
    @Test
    public void testGetElementIndexTooHigh() {
        try {
            int[] nums = {10, 20, 30};
            PracticeProblem.getElement(nums, 5);
            fail("Should have thrown IndexOutOfBoundsException for index >= length");
        } catch (IndexOutOfBoundsException e) {
            // Test passes
        } catch (NoSuchMethodError e) {
            fail("getElement method not implemented");
        } catch (Exception e) {
            fail("Wrong exception type thrown. Expected IndexOutOfBoundsException, got: " + e.getClass().getName());
        }
    }
    
    @Test
    public void testGetElementNegativeIndex() {
        try {
            int[] nums = {10, 20, 30};
            PracticeProblem.getElement(nums, -1);
            fail("Should have thrown IndexOutOfBoundsException for negative index");
        } catch (IndexOutOfBoundsException e) {
            // Test passes
        } catch (NoSuchMethodError e) {
            fail("getElement method not implemented");
        } catch (Exception e) {
            fail("Wrong exception type thrown. Expected IndexOutOfBoundsException, got: " + e.getClass().getName());
        }
    }
    
    // ==================== PROBLEM 4: Email Validator ====================
    
    @Test
    public void testValidateEmailValid() {
        try {
            String result = PracticeProblem.validateEmail("user@example.com");
            assertEquals("user@example.com", result);
        } catch (NoSuchMethodError | Exception e) {
            fail("validateEmail method not implemented or threw unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testValidateEmailWithSpaces() {
        try {
            String result = PracticeProblem.validateEmail("  user@example.com  ");
            assertEquals("user@example.com", result.trim());
        } catch (NoSuchMethodError | Exception e) {
            fail("validateEmail method not implemented or threw unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testValidateEmailNull() {
        try {
            PracticeProblem.validateEmail(null);
            fail("Should have thrown IllegalArgumentException for null email");
        } catch (IllegalArgumentException e) {
            assertTrue("Exception message should mention empty or null", 
                      e.getMessage().toLowerCase().contains("empty") || 
                      e.getMessage().toLowerCase().contains("null"));
        } catch (NoSuchMethodError e) {
            fail("validateEmail method not implemented");
        } catch (Exception e) {
            fail("Wrong exception type thrown. Expected IllegalArgumentException, got: " + e.getClass().getName());
        }
    }
    
    @Test
    public void testValidateEmailEmpty() {
        try {
            PracticeProblem.validateEmail("");
            fail("Should have thrown IllegalArgumentException for empty email");
        } catch (IllegalArgumentException e) {
            assertTrue("Exception message should mention empty", 
                      e.getMessage().toLowerCase().contains("empty"));
        } catch (NoSuchMethodError e) {
            fail("validateEmail method not implemented");
        } catch (Exception e) {
            fail("Wrong exception type thrown. Expected IllegalArgumentException, got: " + e.getClass().getName());
        }
    }
    
    @Test
    public void testValidateEmailNoAtSymbol() {
        try {
            PracticeProblem.validateEmail("notanemail");
            fail("Should have thrown IllegalArgumentException for missing @ symbol");
        } catch (IllegalArgumentException e) {
            assertTrue("Exception message should mention invalid or format", 
                      e.getMessage().toLowerCase().contains("invalid") || 
                      e.getMessage().toLowerCase().contains("format"));
        } catch (NoSuchMethodError e) {
            fail("validateEmail method not implemented");
        } catch (Exception e) {
            fail("Wrong exception type thrown. Expected IllegalArgumentException, got: " + e.getClass().getName());
        }
    }
    
    @Test
    public void testValidateEmailNoDotAfterAt() {
        try {
            PracticeProblem.validateEmail("missing@domain");
            fail("Should have thrown IllegalArgumentException for missing dot after @");
        } catch (IllegalArgumentException e) {
            assertTrue("Exception message should mention invalid or format", 
                      e.getMessage().toLowerCase().contains("invalid") || 
                      e.getMessage().toLowerCase().contains("format"));
        } catch (NoSuchMethodError e) {
            fail("validateEmail method not implemented");
        } catch (Exception e) {
            fail("Wrong exception type thrown. Expected IllegalArgumentException, got: " + e.getClass().getName());
        }
    }
}
