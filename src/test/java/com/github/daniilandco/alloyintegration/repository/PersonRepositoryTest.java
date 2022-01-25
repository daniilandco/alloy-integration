package com.github.daniilandco.alloyintegration.repository;

import com.github.daniilandco.alloyintegration.mapper.PersonMapper;
import com.github.daniilandco.alloyintegration.util.MockDataGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MockDataGenerator mockDataGenerator;
    @Autowired
    private PersonMapper personMapper;

    @Test
    public void test() {
    }
}