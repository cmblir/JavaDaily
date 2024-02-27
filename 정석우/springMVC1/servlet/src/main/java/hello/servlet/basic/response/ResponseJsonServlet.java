package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.servlet.basic.HelloData;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Content-Type : application/json;charset=utf-8
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		HelloData helloData = new HelloData();
		helloData.setUsername("kim");
		helloData.setAge(20);
		
		//{"username":"kim", "age":20}
		String result = objectMapper.writeValueAsString(helloData);
		response.getWriter().write(result);
	}

}
