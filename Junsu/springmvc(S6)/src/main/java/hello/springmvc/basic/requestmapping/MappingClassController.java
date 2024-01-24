package hello.springmvc.basic.requestmapping;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {


    @GetMapping
    public String user(){
        return "get user";
    }


    @PostMapping("/{userId}")
    public String addUser(){
        return "post user";
    }


    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get userId = " + userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update userId = " + userId;
    }

    @DeleteMapping("/{userId}")
    public String delUser(@PathVariable String userId) {
        return "delete userId = " + userId;
    }
}
