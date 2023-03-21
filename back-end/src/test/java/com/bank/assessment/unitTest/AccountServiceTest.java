package com.bank.assessment.unitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;

import com.bank.assessment.entities.Account;
import com.bank.assessment.repositories.AccountRepo;
import com.bank.assessment.services.AccountServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
  
  // LocalDate currentDate = LocalDate.now();
  // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  // String formattedDate = currentDate.format(formatter);

  // @Mock
  // private LocalDate mockDate = LocalDate.of(2022, 3, 21);
  
  // @Mock 
  // private DateTimeFormatter mockFormatter = mock(DateTimeFormatter.class);

  @Mock
  private AccountRepo accountRepo;

  @InjectMocks
  private AccountServiceImpl accountService;


  @Test
  void testAddAccount() {
    Account input = new Account("1232ss", "current", "ruben", "wilson", 200.00, "1/2/12");
    
    when(accountRepo.save(input)).thenReturn(input);

    Account output = accountService.addAccount(input);

    assertNotNull(output);
    assertEquals(input, output);
  }

  @Test
  void testAddAccountCatchesError() {

    when(accountRepo.save(null)).thenThrow(new RuntimeException());
    
    Account output = accountService.addAccount(null);

    assertNull(output);
  }

  @Test
  void testAccountNumGenerator_savingsAccount() {
    Account account = new Account(null, "savingsAccount", "ruben", "wilson", 200.00, null);

    String accountNum = accountService.generateAccountNum(account);

    assertNotNull(accountNum);
    assertEquals(accountNum.substring(0, 3), "S3V");
    assertEquals(13, accountNum.length());
  }

  @Test
  void testAccountNumGenerator_currentAccount() {
    Account account = new Account(null, "currentAccount", "ruben", "wilson", 200.00, null);

    String accountNum = accountService.generateAccountNum(account);

    assertNotNull(accountNum);
    assertEquals(accountNum.substring(0, 3), "C6N");
    assertEquals(13, accountNum.length());
  }

  

  @Test
  void createsNewSavingsAccount(){
    

    Account account = new Account(null, "savingsAccount", "ruben", "wilson", 200.00, null);

    Account output = accountService.createAccount(account);


    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String date =  currentDate.format(formatter);

    assertNotNull(output.getAccountNum());
    assertEquals(output.getAccountNum().substring(0, 3), "S3V");
    assertEquals(output.getType(), "savingsAccount");
    assertEquals(output.getFirstName(), "ruben");
    assertEquals(output.getSurname(), "wilson");
    assertEquals(output.getBalance(), 200);
    assertEquals(output.getDate().getClass(), String.class);
    assertEquals(output.getDate(), date);


  }


}
