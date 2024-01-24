package hello.typeconverter.converter;

import org.springframework.core.convert.converter.Converter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringToIntegerConverter implements Converter<String, Integer>{
	
	@Override
	public Integer convert(String source) {
		log.info("convert source={}",source);
		return Integer.valueOf(source);
	}
	
	

}
