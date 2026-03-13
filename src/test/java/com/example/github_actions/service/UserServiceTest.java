package com.example.github_actions.service;

import com.example.github_actions.entity.User;
import com.example.github_actions.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testSaveUser() {

        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setEmail("john@test.com");

        Mockito.when(userRepository.save(Mockito.any(User.class)))
                .thenReturn(user);

        User savedUser = userService.saveUser(user);

        assertNotNull(savedUser);
        assertEquals("John", savedUser.getName());
    }

    @Test
    void testGetAllUsers() {

        User user1 = new User(1L,"John","john@test.com");
        User user2 = new User(2L,"Jane","jane@test.com");

        when(userRepository.findAll())
                .thenReturn(Arrays.asList(user1,user2));

        List<User> users = userService.getAllUsers();

        assertEquals(2, users.size());

        verify(userRepository,times(1)).findAll();
    }
}
