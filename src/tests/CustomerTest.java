package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import myBankClasses.Customer;

public class CustomerTest {
    Customer cust1;

    @BeforeEach
    void start() {
        cust1 = new Customer("Stepan", "Shavrin");
    }
    @AfterEach
    void end(){
        cust1 = null;
    }

    @Test
    void openAccountTest(){
        assertTrue(cust1.openAccount(123));
        assertFalse(cust1.openAccount(12345));
    }

    @Test
    void closeAccountTest(){
        assertFalse(cust1.closeAccount());
        cust1.openAccount(12345);
        assertTrue(cust1.closeAccount());
    }

    @Test
    void fullNameTest(){
        assertEquals("Stepan Shavrin", cust1.fullName());
    }

    @Test
    void withdrawFromCurrentAccountTest(){
        assertFalse(cust1.withdrawFromCurrentAccount(10));
        cust1.openAccount(123);
        cust1.addMoneyToCurrentAccount(10000);
        assertTrue(cust1.withdrawFromCurrentAccount(345));
    }

    @Test
    void addMoneyToCurrentAccountTest(){
        assertFalse(cust1.addMoneyToCurrentAccount(1000));
        cust1.openAccount(123);
        assertTrue(cust1.addMoneyToCurrentAccount(3));
    }
}
