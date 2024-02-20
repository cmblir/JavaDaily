package hello.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

/**
 * 뷰의 이름과 뷰를 렌더링 할때 필요한 model 객체를 가지고 있다.
 * model 은 단순히 map으로 되어 있으므로 컨트롤러에서 뷰에 필요한 데이터를 key.value로 넣어주면 된다.
 */

public class ModelView {
    private String viewName;
    private Map<String, Object> model = new HashMap<>();

    public ModelView(String viewName){
        this.viewName = viewName;
    }
    public String getViewName() {
        return viewName;
    }
    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
    public Map<String, Object> getGetModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
