package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormContollerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListContollerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveContollerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {
    //key는 url 이고, url에 따라 controller 호출할 것임
    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormContollerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveContollerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListContollerV2());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV2");

        String RequestURI = request.getRequestURI(); //localhost:8080 뒷부분 받아온다.

        ControllerV2 recentController = controllerMap.get(RequestURI);
        //예외 처리
        if(recentController == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }


        MyView view = recentController.process(request, response);
        view.render(request, response);
    }
}
