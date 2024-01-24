package hello.typeconverter.formatter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;

public class FormattingConversionServiceTest {
	
	@Test
	void formattingConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		conversionService.addConverter(new StringToIpPortConverter());
		conversionService.addConverter(new IpPortToStringConverter());
		
		conversionService.addFormatter(new MyNumberFormatter());
		
		IpPort ipPort = conversionService.convert("127.0.0.1:8080",IpPort.class);
		Assertions.assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1",8080));
		
		Assertions.assertThat(conversionService.convert(1000,String.class)).isEqualTo("1,000");
		Assertions.assertThat(conversionService.convert("1,000",Long.class)).isEqualTo(1000L);
		
		
	}
}
