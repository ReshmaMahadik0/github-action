package com.example.github_actions;

import com.example.github_actions.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@org.springframework.boot.autoconfigure.EnableAutoConfiguration(
		exclude = {DataSourceAutoConfiguration.class}
)
@ActiveProfiles("test")
class GithubActionsApplicationTests {

	@MockBean
	private UserRepository userRepository;
	@Test
	void contextLoads() {
	}

}
