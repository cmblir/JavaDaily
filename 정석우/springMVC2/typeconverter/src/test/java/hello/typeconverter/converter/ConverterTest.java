package hello.typeconverter.converter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.typeconverter.type.IpPort;

public class ConverterTest {

	
	@Test
	void stringToInteger() {
		StringToIntegerConverter converter = new StringToIntegerConverter();
		Integer result = converter.convert("10");
		Assertions.assertThat(result).isEqualTo(10);
	}
	
	@Test
	void IntegerToString() {
		IntegerToStringConverter converter = new IntegerToStringConverter();
		String result = converter.convert(10);
		Assertions.assertThat(result).isEqualTo("10");
	}
	
	@Test
	void IpPortToString() {
		IpPortToStringConverter converter = new IpPortToStringConverter();
		IpPort ipPort = new IpPort("127.0.0.1",8808);
		String result = converter.convert(ipPort);
		Assertions.assertThat(result).isEqualTo("127.0.0.1:8808");
	}
	
	@Test
	void StringToIpPort() {
		StringToIpPortConverter converter = new StringToIpPortConverter();
		String source = "127.0.0.1:8080";
		IpPort result = converter.convert(source);
		Assertions.assertThat(result).isEqualTo(new IpPort("127.0.0.1",8080));
	}
}
