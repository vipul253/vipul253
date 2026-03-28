package com.sample.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.opencsv.bean.CsvToBeanBuilder;
import com.sample.model.DemoUser;
import com.sample.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;

    public void importUsersFromCsv() throws IOException {
        try (Reader reader = new FileReader(new ClassPathResource("users.csv").getFile())) {
            List<DemoUser> users = new CsvToBeanBuilder(reader)
                    .withType(DemoUser.class)
                    .build()
                    .parse();
            userRepository.saveAll(users);
        }
    }

    public List<DemoUser> findAllUsers() {
        return userRepository.findAll();
    }
}
