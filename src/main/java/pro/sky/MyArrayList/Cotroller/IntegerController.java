package pro.sky.MyArrayList.Cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.MyArrayList.Interface.IntegerList;
import pro.sky.MyArrayList.Interface.StringList;
import pro.sky.MyArrayList.Service.IntegerService;

public class IntegerController {
    private final IntegerService integerService;

    public IntegerController(IntegerService integerService) {
        this.integerService = integerService;
    }

    @GetMapping(path = "/integer/num")
    public Integer num () {
        return integerService.num();
    }

    // Добавление элемента. Вернуть добавленный элемент в качестве результата выполнения.
    @GetMapping(path = "/integer/add", params = "item")
    public Integer add (@RequestParam Integer item) {
        return integerService.add(item);
    }

    // Добавление элемента на определенную позицию списка. Если выходит за пределы фактического количества элементов или массива,
    // выбросить исключение. Вернуть добавленный элемент в качестве результата выполнения.
    @GetMapping(path = "/integer/add")
    public Integer add(@RequestParam int index, @RequestParam Integer item){
        return integerService.add(index, item);
    }

    // Установить элемент на определенную позицию, затерев существующий. Выбросить исключение, если индекс больше
    // фактического количества элементов или выходит за пределы массива.
    @GetMapping("/integer/set")
    public Integer set(@RequestParam int index, @RequestParam Integer item){
        return integerService.set(index, item);
    }

    // Удаление элемента. Вернуть удаленный элемент или исключение, если подобный элемент отсутствует в списке.
    @GetMapping("/integer/remove")
    public Integer remove(@RequestParam Integer item){
        return integerService.remove(item);
    }

    // Удаление элемента по индексу. Вернуть удаленный элемент или исключение, если подобный элемент отсутствует в списке.
    @GetMapping(path ="/integer/remove", params ="index" )
    public Integer remove(@RequestParam int index){
        return integerService.remove(index);
    }

    // Проверка на существование элемента. Вернуть true/false;
    @GetMapping("/integer/contains")
    public boolean contains(@RequestParam Integer item){
        return integerService.contains(item);
    }

    // Поиск элемента. Вернуть индекс элемента или -1 в случае отсутствия.
    @GetMapping("/integer/indexOf")
    public int indexOf(@RequestParam Integer item){
        return integerService.indexOf(item);
    }

    // Поиск элемента с конца. Вернуть индекс элемента или -1 в случае отсутствия.
    @GetMapping("/integer/lastIndexOf")
    public int lastIndexOf(@RequestParam Integer item){
        return integerService.lastIndexOf(item);
    }

    // Получить элемент по индексу. Вернуть элемент или исключение, если выходит за рамки фактического количества элементов.
    @GetMapping("/integer/get")
    public Integer get(@RequestParam int index){
        return integerService.get(index);
    }

    // Сравнить текущий список с другим. Вернуть true/false или исключение, если передан null.
    @GetMapping("/integer/equals")
    public boolean equals(@RequestParam IntegerList otherList){
        return integerService.equals(otherList);
    }

    // Вернуть фактическое количество элементов.
    @GetMapping("/integer/size")
    public int size(){
        return integerService.size();
    }

    // Вернуть true, если элементов в списке нет, иначе false.
    @GetMapping("/integer/isEmpty")
    public boolean isEmpty(){
        return integerService.isEmpty();
    }

    // Удалить все элементы из списка.
    @GetMapping("/integer/clear")
    public void clear(){
        integerService.clear();
    }

    // Создать новый массив из строк в списке и вернуть его.
    @GetMapping("/integer/toArray")
    public Integer[] toArray(){
        return integerService.toArray();
    }
}
