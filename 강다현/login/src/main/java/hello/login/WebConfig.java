package hello.login;

import hello.login.web.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;


@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean logFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter()); //등록할 필터를 지정한다.
        filterRegistrationBean.setOrder(1); // 필터는 체인으로 동작한다. 따라서 순서가 필요한데, 낮을 수록 먼저 동작한다.
        filterRegistrationBean.addUrlPatterns("/*"); //필터를 적용할 URI 패턴을 지정한다. 한번에 여러 패턴을 지정할 수 있다.
        return filterRegistrationBean;
    }
}
