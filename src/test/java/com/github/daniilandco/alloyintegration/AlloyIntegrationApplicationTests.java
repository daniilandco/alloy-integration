package com.github.daniilandco.alloyintegration;

import com.github.daniilandco.alloyintegration.controller.EvaluationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@TestPropertySource(properties = {
        "ALLOY_USERNAME=dpDD6z4olOSI7N4fMCsAlKjFa7reBYhu",
        "ALLOY_PASSWORD=oJm3niQX1Pdy4z675kefEIKBgFn9tQ45",
        "MONGO_USERNAME=daniilandco",
        "MONGO_PASSWORD=3n3KS26XrSPnk3f"
})
@SpringBootTest
class AlloyIntegrationApplicationTests {
    @Autowired
    private EvaluationController evaluationController;

    @Test
    public void contextLoader() {
        assertThat(evaluationController).isNotNull();
    }
}
