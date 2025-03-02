package co.santyx.npl;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void apiLetterBank() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:8080/v1/letter-bank?q=abcabdef",
				String.class)).contains("abcabdef", "abcdef");
	}

    @Test
	void sort() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:8080/v1/sort?q=azhufrnjfe",
				String.class)).contains("azhufrnjfe ", "aeffhjnruz");
	}
}
