package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //컴포넌트 스캔의 대상이 된다.
public class ItemRepository {
    private static final Map<Long, Item> store = new HashMap<>(); //static
    private static long sequance = 0L; //static

    public Item save(Item item) {
        item.setId(++sequance);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values()); //ArrayList에 값을 넣어도 실제 Map은 변하지 않아서 안전
    }

    //설계상 ParamDTO 같은거 만드는게 좋음 (id는 사용되지 않으므로,,!)
    public void update(Long itemId, Item updateParam) {
        Item currentItem = findById(itemId);
        currentItem.setItemName(updateParam.getItemName());
        currentItem.setPrice(updateParam.getPrice());
        currentItem.setQuantity(updateParam.getQuantity());
    }
    public void clearStore(){
        store.clear();
    }
}