package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;


/**
 * 회원 목록 조회: GET /mapping/users
 * 회원 등록: POST /mapping/users
 * 회원 조회: GET /mapping/users/id1
 * 회원 수정: PATCH /mapping/users/id1
 * 회원 삭제: DELETE /mapping/users/id1
 */

@RestController //클래스 레벨에 매핑 정보를 두면 메서드 레벨에서 해당 정보를 조합해서 사용한다.
@RequestMapping("/mapping/users")
public class MappingClassController {
    @GetMapping
    public String users(){
        return "get user";
    }
    @PostMapping
    public String addUser(){
        return "post user";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId){
        return "update userId = "+userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId){
        return "update userId = " + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        return "delete userId = " + userId;
    }



}
