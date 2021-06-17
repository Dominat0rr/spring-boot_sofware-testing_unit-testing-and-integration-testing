package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootTest
class DemoApplicationTests {

	Calculator calc = new Calculator();

	@Test
	void itShouldAddNumbers() {
		// given
		int n1 = 10;
		int n2 = 20;

		// when
		int result = calc.add(n1, n2);

		// then
		int expected = 30;
		assertThat(result).isEqualTo(expected);
	}

	static class Calculator {
		int add(int a, int b) {
			return a + b;
		}
	}

}
