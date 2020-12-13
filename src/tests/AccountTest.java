package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import myBankClasses.Account;

public class AccountTest {
    Account acc1;

    @BeforeEach
    void start(){
        acc1 = new Account(1);
    }

    @AfterEach
    void end(){
        acc1 = null;
    }

    @Test
    void addTest(){
        assertEquals(true, acc1.add(123));
        assertEquals(false, acc1.add(0));
        assertEquals(false, acc1.add(-345));
    }

    @Test
    void withdrawTest(){
        acc1.add(1000);
        assertEquals(true, acc1.withdraw(1000));
        acc1.add(1000);
        assertEquals(true, acc1.withdraw(875));
        assertEquals(false, acc1.withdraw(0));
        assertEquals(false, acc1.withdraw(5000));
    }
}
