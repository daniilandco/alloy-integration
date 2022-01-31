package com.github.daniilandco.alloyintegration;

import com.github.daniilandco.alloyintegration.controller.EvaluationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTests
public class AlloyIntegrationApplicationTests {
    @Autowired
    private EvaluationController evaluationController;

    @Test
    public void contextLoader() {
        assertNotNull(evaluationController);
    }
}
