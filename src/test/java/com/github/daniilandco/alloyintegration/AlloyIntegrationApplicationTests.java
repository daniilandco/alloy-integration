package com.github.daniilandco.alloyintegration;

import com.github.daniilandco.alloyintegration.controller.EvaluationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class AlloyIntegrationApplicationTests {
    @Autowired
    private EvaluationController evaluationController;

    @Test
    public void contextLoader() {
        assertNotNull(evaluationController);
    }
}
