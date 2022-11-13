package pro.sky.MyArrayList.Cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.MyArrayList.Interface.StringList;
import pro.sky.MyArrayList.Service.ArrayListService;

@RestController
public class ArrayListController {
    private final ArrayListService arrayListService;

    public ArrayListController(ArrayListService arrayListService) {
        this.arrayListService = arrayListService;
    }

    @GetMapping(path = "/arrayList/num")
    public Integer num () {
        return arrayListService.num();
    }

    // Добавление элемента. Вернуть добавленный элемент в качестве результата выполнения.
    @GetMapping(path = "/arrayList/add", params = "item")
    public String add (@RequestParam String item) {
        return arrayListService.add(item);
    }

    // Добавление элемента на определенную позицию списка. Если выходит за пределы фактического количества элементов или массива,
    // выбросить исключение. Вернуть добавленный элемент в качестве результата выполнения.
    @GetMapping(path = "/arrayList/add")
    public String add(@RequestParam int index, @RequestParam String item){
        return arrayListService.add(index, item);
    }

    // Установить элемент на определенную позицию, затерев существующий. Выбросить исключение, если индекс больше
    // фактического количества элементов или выходит за пределы массива.
    @GetMapping("/arrayList/set")
    String set(@RequestParam int index, @RequestParam String item){
        return arrayListService.set(index, item);
    }

    // Удаление элемента. Вернуть удаленный элемент или исключение, если подобный элемент отсутствует в списке.
    @GetMapping("/arrayList/remove")
    public String remove(@RequestParam String item){
        return arrayListService.remove(item);
    }

    // Удаление элемента по индексу. Вернуть удаленный элемент или исключение, если подобный элемент отсутствует в списке.
    @GetMapping(path ="/arrayList/remove", params ="index" )
    public String remove(@RequestParam int index){
        return arrayListService.remove(index);
    }

    // Проверка на существование элемента. Вернуть true/false;
    @GetMapping("/arrayList/contains")
    boolean contains(@RequestParam String item){
        return arrayListService.contains(item);
    }

    // Поиск элемента. Вернуть индекс элемента или -1 в случае отсутствия.
    @GetMapping("/arrayList/indexOf")
    int indexOf(@RequestParam String item){
        return arrayListService.indexOf(item);
    }

    // Поиск элемента с конца. Вернуть индекс элемента или -1 в случае отсутствия.
    @GetMapping("/arrayList/lastIndexOf")
    int lastIndexOf(@RequestParam String item){
        return arrayListService.lastIndexOf(item);
    }

    // Получить элемент по индексу. Вернуть элемент или исключение, если выходит за рамки фактического количества элементов.
    @GetMapping("/arrayList/get")
    String get(@RequestParam int index){
        return arrayListService.get(index);
    }

    // Сравнить текущий список с другим. Вернуть true/false или исключение, если передан null.
    @GetMapping("/arrayList/equals")
    boolean equals(@RequestParam StringList otherList){
        return arrayListService.equals(otherList);
    }

    // Вернуть фактическое количество элементов.
    @GetMapping("/arrayList/size")
    int size(){
        return arrayListService.size();
    }

    // Вернуть true, если элементов в списке нет, иначе false.
    @GetMapping("/arrayList/isEmpty")
    boolean isEmpty(){
        return arrayListService.isEmpty();
    }

    // Удалить все элементы из списка.
    @GetMapping("/arrayList/clear")
    void clear(){
        arrayListService.clear();
    }

    // Создать новый массив из строк в списке и вернуть его.
    @GetMapping("/arrayList/toArray")
    String[] toArray(){
        return arrayListService.toArray();
    }
}
