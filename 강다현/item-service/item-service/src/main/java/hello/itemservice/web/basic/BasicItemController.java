package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {
    private final ItemRepository itemRepository;

    //    @Autowired 생성자 하나라서 생략 가능
//    public BasicItemController(ItemRepository itemRepository){
//        this.itemRepository = itemRepository;
//    }
    //아이템 목록 출력
    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }
    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 10));
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable("itemId")long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }
    @GetMapping("/add")
    public String addItemV1(){
        return "basic/addForm";
    }
//    @PostMapping("/add")
    public String save(@RequestParam("itemName")String itemName,
                       @RequestParam("price")int price,
                       @RequestParam("quantity")Integer quantity,
                       Model model) {
        Item item = new Item();
        item.setItemName(itemName);
        item.setQuantity(quantity);
        item.setPrice(price);
        itemRepository.save(item);

        model.addAttribute("item", item);
        return "basic/item";
    }
//    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item) {
        itemRepository.save(item);
//        model.addAttribute("item", item); //자동 추가, 생략 가능

        return "basic/item";
    }
//    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item) {
        itemRepository.save(item);
//        model.addAttribute("item", item); //자동 추가, 생략 가능

        return "basic/item";
    }
    @PostMapping("/add")
    public String addItemV4(Item item) {
        itemRepository.save(item);
        return "basic/item";
    }


    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable("itemId") long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable("itemId") long itemId, @ModelAttribute Item item ) {
        itemRepository.update(itemId,item);
        return "redirect:/basic/items/{itemId}";

    }
}
