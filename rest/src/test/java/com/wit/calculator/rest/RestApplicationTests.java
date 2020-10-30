package com.wit.calculator.rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
class RestApplicationTests {

	@Autowired
	private RestApplication restApplication;

	@ParameterizedTest
	@MethodSource("provideSumTestCases")
	void testSum(String a, String b, String expected) {
		Assertions.assertEquals(expected, restApplication.sum(a,b).getBody());
	}

	private static Stream<Arguments> provideSumTestCases() {
		return Stream.of(
				Arguments.of(null, null, "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("", "", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("1", "", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("", "1", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("a", "1", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("1", "a", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("0", "1", "{\"result\":1}"),
				Arguments.of("1", "0", "{\"result\":1}"),
				Arguments.of("1", "2", "{\"result\":3}"),
				Arguments.of("1.0", "2", "{\"result\":3.0}"),
				Arguments.of("1.1", "2.2", "{\"result\":3.3}"),
				Arguments.of("1.11", "2.2", "{\"result\":3.31}"),
				Arguments.of("1", "-2", "{\"result\":-1}"),
				Arguments.of("1.111111111111111111", "2.2222222222222222222222222222", "{\"result\":3.333333}")
		);
	}

	@ParameterizedTest
	@MethodSource("provideSubTestCases")
	void sub(String a, String b, String expected) {
		Assertions.assertEquals(expected, restApplication.sub(a,b).getBody());
	}

	private static Stream<Arguments> provideSubTestCases() {
		return Stream.of(
				Arguments.of(null, null, "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("", "", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("1", "", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("", "1", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("a", "1", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("1", "a", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("0", "1", "{\"result\":-1}"),
				Arguments.of("1", "0", "{\"result\":1}"),
				Arguments.of("1", "2", "{\"result\":-1}"),
				Arguments.of("1.0", "2", "{\"result\":-1.0}"),
				Arguments.of("1.1", "2.2", "{\"result\":-1.1}"),
				Arguments.of("1.11", "2.2", "{\"result\":-1.09}"),
				Arguments.of("1", "-2", "{\"result\":3}"),
				Arguments.of("1.111111111111111111", "2.2222222222222222222222222222", "{\"result\":-1.111111}")
		);
	}

	@ParameterizedTest
	@MethodSource("provideMulTestCases")
	void mul(String a, String b, String expected) {
		Assertions.assertEquals(expected, restApplication.mul(a,b).getBody());
	}

	private static Stream<Arguments> provideMulTestCases() {
		return Stream.of(
				Arguments.of(null, null, "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("", "", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("1", "", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("", "1", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("a", "1", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("1", "a", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("0", "1", "{\"result\":0}"),
				Arguments.of("1", "0", "{\"result\":0}"),
				Arguments.of("1", "2", "{\"result\":2}"),
				Arguments.of("1.0", "2", "{\"result\":2.0}"),
				Arguments.of("1.1", "2.2", "{\"result\":2.42}"),
				Arguments.of("1.11", "2.2", "{\"result\":2.442}"),
				Arguments.of("1", "-2", "{\"result\":-2}"),
				Arguments.of("1.111111111111111111", "2.2222222222222222222222222222", "{\"result\":2.469136}")
		);
	}

	@ParameterizedTest
	@MethodSource("provideDivTestCases")
	void div(String a, String b, String expected) {
		Assertions.assertEquals(expected, restApplication.div(a,b).getBody());
	}

	private static Stream<Arguments> provideDivTestCases() {
		return Stream.of(
				Arguments.of(null, null, "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("", "", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("1", "", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("", "1", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("a", "1", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("1", "a", "{\"result\":\"Invalid Number(s)\"}"),
				Arguments.of("0", "1", "{\"result\":0}"),
				Arguments.of("1", "0", "{\"result\":\"Invalid Division\"}"),
				Arguments.of("1", "2", "{\"result\":0.5}"),
				Arguments.of("1.0", "2", "{\"result\":0.5}"),
				Arguments.of("1.1", "2.2", "{\"result\":0.5}"),
				Arguments.of("1.11", "2.2", "{\"result\":0.5045455}"),
				Arguments.of("1", "-2", "{\"result\":-0.5}"),
				Arguments.of("2", "3", "{\"result\":0.6666667}"),
				Arguments.of("1.111111111111111111", "2.2222222222222222222222222222", "{\"result\":0.5000000}")
		);
	}
}
