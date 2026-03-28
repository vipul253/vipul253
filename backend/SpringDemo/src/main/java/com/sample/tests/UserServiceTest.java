package com.sample.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sample.model.DemoUser;
import com.sample.repository.UserRepository;
import com.sample.service.UserService;

@SpringBootTest
@Transactional // Ensures tests are rolled back after execution
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll(); // Clear the database before each test
    }
    @Test
    public void testImportUsersFromCsv() throws IOException {
        // Ensure the database is empty initially
        assertEquals(0, userRepository.count());

        // Perform the import operation
        userService.importUsersFromCsv();

        // Verify the data was imported correctly
        List<DemoUser> users = userRepository.findAll();
        assertFalse(users.isEmpty());
        assertEquals(3, users.size()); // Assuming 3 entries in users.csv
        assertEquals("John", users.get(0).getFirstName());
    }
}