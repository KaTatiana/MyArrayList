package pro.sky.MyArrayList.Service;

import org.springframework.stereotype.Service;
import pro.sky.MyArrayList.Interface.StringList;

import java.util.Arrays;
import java.util.Objects;

@Service
public class ArrayListService implements StringList {

    private static final int sizeMas = 10;
    private static String[] stringMas = new String[sizeMas];

    public ArrayListService(){
        for(int i=0; i<sizeMas; i++){
            stringMas[i]=null;
        }
    }

    @Override
    public Integer num() {
        return sizeMas(stringMas);
    }

    // Добавление элемента. Вернуть добавленный элемент в качестве результата выполнения.
    @Override
    public String add(String item) {
        int pos = sizeMas(stringMas);
        stringMas[pos] = item;
        return item;
    }

    // Добавление элемента на определенную позицию списка. Если выходит за пределы фактического количества элементов или массива,
    // выбросить исключение. Вернуть добавленный элемент в качестве результата выполнения.
    @Override
    public String add(int index, String item) {

        if (index < stringMas.length) {
            int gapIndex;
            for (gapIndex=index; gapIndex<stringMas.length;gapIndex++){
                if(stringMas[gapIndex]==null){
                    break;
                }
            }
            if(gapIndex>=stringMas.length){
                throw new IllegalArgumentException("Массив заполнен");
            }
            int i = gapIndex-1;
            while (i >= index) {
                stringMas[i + 1] = stringMas[i];
                i--;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы фактического количества элементов");
        }
        stringMas[index] = item;
        return stringMas[index];
    }

    // Установить элемент на определенную позицию, затерев существующий. Выбросить исключение, если индекс больше
    // фактического количества элементов или выходит за пределы массива.
    @Override
    public String set(int index, String item) {
        if (index >= sizeMas) {
            throw new ArrayIndexOutOfBoundsException("Индекс больше" +
                    " фактического количества элементов или выходит за пределы массива");
        }
        stringMas[index] = item;
        return item;
    }

    // Удаление элемента. Вернуть удаленный элемент или исключение, если подобный элемент отсутствует в списке.
    @Override
    public String remove(String item) {
        int i = 0;
        int size = sizeMas(stringMas);
        while (i < size) {
            if (stringMas[i].equals(item)) {
                stringMas[i] = null;
                break;
            }
            i++;
        }
        if (i == size) {
            throw new IndexOutOfBoundsException("Элемент отсутствует в списке");
        }
        return item;
    }

    // Удаление элемента по индексу. Вернуть удаленный элемент или исключение, если подобный элемент отсутствует в списке.
    @Override
    public String remove(int index) {
        if (index < stringMas.length) {
            if(stringMas[index]==null){
                throw new IllegalArgumentException("Отсутствует элемент для удаления");
            }
            String item;
            item = stringMas[index];
            stringMas[index] = null;
            return item;
        } else {
            throw new IndexOutOfBoundsException("Индекс выходит за границы");
        }
    }

    // Проверка на существование элемента. Вернуть true/false;
    @Override
    public boolean contains(String item) {
        for (String stringMa : stringMas) {
            if (stringMa.equals(item)) {
                return true;
            }
        }
        return false;
    }

    // Поиск элемента. Вернуть индекс элемента или -1 в случае отсутствия.
    @Override
    public int indexOf(String item) {
        for (int i = 0; i < stringMas.length; i++) {
            if (stringMas[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    // Поиск элемента с конца. Вернуть индекс элемента или -1 в случае отсутствия.
    @Override
    public int lastIndexOf(String item) {
        return sizeMas(stringMas);
    }

    // Получить элемент по индексу. Вернуть элемент или исключение, если выходит за рамки фактического количества элементов.
    @Override
    public String get(int index) {
        if (index >= sizeMas) {
            throw new ArrayIndexOutOfBoundsException("Индекс больше" +
                    " фактического количества элементов или выходит за пределы массива");
        }
        return stringMas[index];
    }

    // Сравнить текущий список с другим. Вернуть true/false или исключение, если передан null.
    @Override
    public boolean equals(StringList otherList) {
        if(otherList==null){
            throw new IllegalArgumentException("Передан null");
        }
        return Objects.equals(Arrays.toString(stringMas), otherList.toString());
    }

    // Вернуть фактическое количество элементов.
    @Override
    public int size() {
        return sizeMas(stringMas);
    }

    // Вернуть true, если элементов в списке нет, иначе false.
    @Override
    public boolean isEmpty() {
        return stringMas.length == 0;
    }

    // Удалить все элементы из списка.
    @Override
    public void clear() {
        stringMas = new String[sizeMas];
    }

    // Создать новый массив из строк в списке и вернуть его.
    @Override
    public String[] toArray() {
        String[] stringMasNew = new String[sizeMas];
        System.arraycopy(stringMas, 0, stringMasNew, 0, stringMas.length);
        return stringMasNew;
    }

    public Integer sizeMas(String[] theArray){
        int counter=0;
        for (String s : theArray) {
            if (s != null) {
                counter++;
            }
        }

        return counter;
    }
}


