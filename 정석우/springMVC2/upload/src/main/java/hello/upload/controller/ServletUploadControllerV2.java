package hello.upload.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/servlet/v2")
public class ServletUploadControllerV2 {
	
	
	@Value("${file.dir}")
	private String fileDir;

	@GetMapping("/upload")
	public String newFile() {
		return "upload-form";
	}
	
	@PostMapping("/upload")
	public String saveFileV1(HttpServletRequest request) throws IOException, ServletException {
		log.info("request={}",request);
		
		String itemName = request.getParameter("itemName");
		log.info("itemName = {}",itemName);
		
		Collection<Part> parts = request.getParts();
		log.info("parts={}",parts);
		
		for(Part part : parts) {
			log.info("============== PART ==============");
			log.info("name={}",part.getName());
			Collection<String> headerNames = part.getHeaderNames();
			for(String headerName : headerNames) {
				log.info("header {} : {}" ,headerName,part.getHeader(headerName));
			}
			
			
			//편의 메소드
			log.info("sumittedFileName = {}",part.getSubmittedFileName());
			log.info("size={}",part.getSize());
			
			//데이터 읽기
			InputStream inputStream = part.getInputStream();
			String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
			//log.info("body={}",body);
			
			//파일에 저장하기
			if(StringUtils.hasText(part.getSubmittedFileName())) {
				String fullPath = fileDir + part.getSubmittedFileName();
				log.info("파일 저장 fullpath = {}",fullPath);
				part.write(fullPath);
			}
		}
		
		return "upload-form";
		
	}
	
}
