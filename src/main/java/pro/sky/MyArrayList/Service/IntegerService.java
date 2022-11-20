package pro.sky.MyArrayList.Service;

import pro.sky.MyArrayList.Interface.IntegerList;
import pro.sky.MyArrayList.Interface.StringList;

import java.util.Arrays;
import java.util.Objects;

public class IntegerService implements IntegerList {
    private static final int sizeMas = 10;
    private static Integer[] intMas = new Integer[sizeMas];

    public IntegerService(){
        for(int i=0; i<sizeMas; i++){
            intMas[i]=null;
        }
    }

    @Override
    public Integer num() {
        return sizeMas(intMas);
    }

    // Добавление элемента. Вернуть добавленный элемент в качестве результата выполнения.
    @Override
    public Integer add(Integer item) {
        int pos = sizeMas(intMas);
        intMas[pos] = item;
        return intMas[pos];
    }

    // Добавление элемента на определенную позицию списка. Если выходит за пределы фактического количества элементов или массива,
    // выбросить исключение. Вернуть добавленный элемент в качестве результата выполнения.
    @Override
    public Integer add(int index, Integer item) {

        if (index < intMas.length) {
            int gapIndex;
            for (gapIndex=index; gapIndex< intMas.length; gapIndex++){
                if(intMas[gapIndex]==null){
                    break;
                }
            }
            if(gapIndex>= intMas.length){
                throw new IllegalArgumentException("Массив заполнен");
            }
            int i = gapIndex-1;
            while (i >= index) {
                intMas[i + 1] = intMas[i];
                i--;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы фактического количества элементов");
        }
        intMas[index] = item;
        return intMas[index];
    }

    // Установить элемент на определенную позицию, затерев существующий. Выбросить исключение, если индекс больше
    // фактического количества элементов или выходит за пределы массива.
    @Override
    public Integer set(int index, Integer item) {
        if (index >= sizeMas) {
            throw new ArrayIndexOutOfBoundsException("Индекс больше" +
                    " фактического количества элементов или выходит за пределы массива");
        }
        intMas[index] = item;
        return item;
    }

    // Удаление элемента. Вернуть удаленный элемент или исключение, если подобный элемент отсутствует в списке.
    @Override
    public Integer remove(Integer item) {
        int i = 0;
        int size = sizeMas(intMas);
        while (i < size) {
            if (intMas[i].equals(item)) {
                intMas[i] = null;
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
    public Integer remove(int index) {
        if (index < intMas.length) {
            if(intMas[index]==null){
                throw new IllegalArgumentException("Отсутствует элемент для удаления");
            }
            Integer item;
            item = intMas[index];
            intMas[index] = null;
            return item;
        } else {
            throw new IndexOutOfBoundsException("Индекс выходит за границы");
        }
    }


    // Проверка на существование элемента. Вернуть true/false;
    @Override
    public boolean contains(Integer item) {
        sort(intMas);
        return binarySearch(intMas, item);
    }

    // Поиск элемента. Вернуть индекс элемента или -1 в случае отсутствия.
    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < intMas.length; i++) {
            if (intMas[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    // Поиск элемента с конца. Вернуть индекс элемента или -1 в случае отсутствия.
    @Override
    public int lastIndexOf(Integer item) {
        return sizeMas(intMas);
    }

    // Получить элемент по индексу. Вернуть элемент или исключение, если выходит за рамки фактического количества элементов.
    @Override
    public Integer get(int index) {
        if (index >= sizeMas) {
            throw new ArrayIndexOutOfBoundsException("Индекс больше" +
                    " фактического количества элементов или выходит за пределы массива");
        }
        return intMas[index];
    }

    // Сравнить текущий список с другим. Вернуть true/false или исключение, если передан null.
    @Override
    public boolean equals(IntegerList otherList) {
        if(otherList==null){
            throw new IllegalArgumentException("Передан null");
        }
        return Objects.equals(Arrays.toString(intMas), otherList.toString());
    }

    // Вернуть фактическое количество элементов.
    @Override
    public int size() {
        return sizeMas(intMas);
    }

    // Вернуть true, если элементов в списке нет, иначе false.
    @Override
    public boolean isEmpty() {
        return intMas.length == 0;
    }

    // Удалить все элементы из списка.
    @Override
    public void clear() {
        intMas = new Integer[sizeMas];
    }

    // Создать новый массив из строк в списке и вернуть его.
    @Override
    public Integer[] toArray() {
        Integer[] stringMasNew = new Integer[sizeMas];
        System.arraycopy(intMas, 0, stringMasNew, 0, intMas.length);
        return stringMasNew;
    }

    public Integer sizeMas(Integer[] theArray){
        int counter=0;
        for (Integer s : theArray) {
            if (s != null) {
                counter++;
            }
        }
        return counter;
    }
    private void sort(Integer[] arr){
        for (int i = 1; i < sizeMas(intMas); i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
private boolean binarySearch(Integer[] arr, Integer item){
    int min = 0;
    int max = arr.length - 1;

    while (min <= max) {
        int mid = (min + max) / 2;

        if (Objects.equals(item, arr[mid])) {
            return true;
        }

        if (item < arr[mid]) {
            max = mid - 1;
        } else {
            min = mid + 1;
        }
    }
    return false;
}
}
