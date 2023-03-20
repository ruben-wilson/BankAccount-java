package com.bank.assessment.unitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bank.assessment.entities.Account;
import com.bank.assessment.repositories.AccountRepo;
import com.bank.assessment.services.AccountServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
  
  @Mock
  private AccountRepo accountRepo;

  @InjectMocks
  private AccountServiceImpl accountService;


  @Test
  void testAddAccount() {
    Account input = new Account("1232ss", "ruben", "wilson", 200.00, "1/2/12");
    
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
}
