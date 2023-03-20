package com.bank.assessment.unitTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bank.assessment.entities.User;
import com.bank.assessment.repositories.UserRepo;
import com.bank.assessment.services.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImlTest {

  @Mock
  private UserRepo userRepo;
  
  @InjectMocks
  private UserServiceImpl userService;

  @BeforeEach
  public void setUp() {

    // UserService userService = this.userService;
  }
 
  @Test
  void testAddUser() {
    User input = new User("name", "surname", "email", "password");
    when(userRepo.save(input)).thenReturn(input);

    User output = userService.addUser(input);

    assertNotNull(output);
    assertEquals(input, output);
  }

  @Test
  void testAddlUserCatchesError() {

    when(userRepo.save(null)).thenThrow(new RuntimeException());
    
    User output = userService.addUser(null);

    assertNull(output);
  }

  @Test
  void testLoadUsers() {
    User user0 = new User("name", "surname", "email", "password");    User user1 = new User("name", "surname", "email", "password");    User user2 = new User("name", "surname", "email", "password");
    List<User> userList = Arrays.asList(user0, user1, user2);

    when(userRepo.findAll()).thenReturn(userList);

    List<User> output = userService.loadAllUsers();

    assertNotNull(output);
    assertTrue(output instanceof List<User>);
    assertEquals(output, userList);
  }

  @Test
  void testFindByEmail() {

    User user = new User("name", "surname", "email", "password");
    when(userRepo.findByEmail("email")).thenReturn(user);

    User output = userService.findUserByEmail("email");

    assertNotNull(output);
    assertTrue(output instanceof User);
    assertEquals(output, user);
  }

  @Test
  void testLoginCorrectPassword() {
    User user = new User("email", "123");

    when(userRepo.findByEmail("email")).thenReturn(user);

    User output = userService.login(user.getEmail(), user.getPassword());

    assertNotNull(output);
    assertTrue(output instanceof User);
    assertEquals(output, user);
  }

  @Test
  void testLoginIncorrectPassword() {
    User user = new User("email", "123");

    when(userRepo.findByEmail("email")).thenReturn(user);

    User output = userService.login("email", "WrongPassword");

    assertNull(output);
  }

  @Test
  void testLoginIncorrectEmail() {
    when(userService.findUserByEmail("email")).thenReturn(null);

    User output = userService.login("email", "123");

    assertNull(output);
  }
  
}
