package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    //controller에서 리턴 값으로 문자를 반환하면 viewResolver가 화면을 찾아서 처리한다.
    //  스프링 부트 템플릿 엔진 기본 viewName 매핑
    //  resources:templates/ +{ViewName}+ .html
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
    //@ResponseBody를 사용하면 viewResolver를 사용하지 않음
    //대신에 HTTP 의 BODY에 문자 내용을 직접 반환(Html Body Tag 말고..)
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;
    }
    //ResponseBody 사용 + 객체 반환
    //객체가 JSON으로 반환된다.

    /*
    @ResponseBody를 사용
      > HTTP의 BODY에 문자 내용을 직접 반환
      > viewResolver 대신에 HttpMessageConverter가 동작
      > 기본 문자 처리 : StringHttpMessageConverter
      > 기본 객체 처리 : MappingJackson2HttpMessageConverter


     */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체를 반환
    }
    static class Hello{
        private String name;
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }



}
