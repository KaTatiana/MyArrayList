package pro.sky.MyArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.MyArrayList.Interface.StringList;
import pro.sky.MyArrayList.Service.ArrayListService;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class ArrayListServiceTest {

    @InjectMocks
    private ArrayListService arrayListService;

    @BeforeEach
    public void beforeEach(){
    //String[] stringMas={
        arrayListService.add("Jingle bells, jingle bells");
        arrayListService.add("Jingle all the way");
        arrayListService.add("Oh, what fun it is to ride");
        arrayListService.add("In a one-horse open sleigh");
        arrayListService.add("Dashing through the snow");
        arrayListService.add("In a one-horse open sleigh");
        arrayListService.add("O'er the fields we go");
      //  arrayListService.add("Laughing all the way");
       // arrayListService.add("Bells on bob-tail ring");
      //  arrayListService.add("Making our spirits bright");
    //};
    }

    @ParameterizedTest
    @MethodSource("paramsItem")
    public void addPositiveTest(String item){
        assertThat(arrayListService.add(item)).isEqualTo("Jingle bells, jingle bells");
    }

    @ParameterizedTest
    @MethodSource("paramsIndexItem")
    public void addPositiveTest(int index, String item) {
        assertThat(arrayListService.add(index, item)).isEqualTo("Jingle bells, jingle bells");
    }

    @ParameterizedTest
    @MethodSource("paramsIndexItem")
    public void setPositiveTest(int index, String item){
        assertThat(arrayListService.set(index, item)).isEqualTo("Jingle bells, jingle bells");
    }

    @ParameterizedTest
    @MethodSource("paramsIndexItemOut")
    public void setNegativeTest(int index, String item){
        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
               .isThrownBy(()->arrayListService.set(index, item));
    }

    @ParameterizedTest
    @MethodSource("paramsItem")
    public void removePositiveTest(String item){
        assertThat(arrayListService.remove(item)).isEqualTo("Jingle bells, jingle bells");
    }

    @ParameterizedTest
    @MethodSource("paramsItemRemoveNegative")
    public void removeNegativeTest(String item){
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()->arrayListService.remove(item));
    }

    @ParameterizedTest
    @MethodSource("paramsIndex")
    public void removePositiveTest(int index){
        assertThat(arrayListService.remove(index)).isEqualTo("Jingle bells, jingle bells");
    }

    @ParameterizedTest
    @MethodSource("paramsItem")
    public void containsPositiveTest(String item){
        assertThat(arrayListService.contains(item)).isEqualTo(true);
    }

    @ParameterizedTest
    @MethodSource("paramsItem")
    public void indexOfPositiveTest(String item){
        assertThat(arrayListService.indexOf(item)).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("paramsItem")
    public void lastIndexOfPositiveTest(String item){
        assertThat(arrayListService.lastIndexOf(item)).isEqualTo(7);
    }

    @ParameterizedTest
    @MethodSource("paramsIndex")
    public void getPositiveTest(int index){
        assertThat(arrayListService.get(index)).isEqualTo("Jingle bells, jingle bells");
    }


    @ParameterizedTest
    @MethodSource("paramsItem")
    public void sizePositiveTest(){
        assertThat(arrayListService.size()).isEqualTo(7);
    }

    @ParameterizedTest
    @MethodSource("paramsItem")
    public void isEmptyPositiveTest(){
        assertThat(arrayListService.isEmpty()).isEqualTo(false);
    }

    @Test
    public void clearPositiveTest(){
        //assertThat(arrayListService.clear()).isEqualTo(stringMas.length==0);
    }

    //String[] toArray();

    public static Stream<Arguments> paramsItem() {
        return Stream.of(
                Arguments.of("Jingle bells, jingle bells")
        );
    }
    public static Stream<Arguments> paramsIndexItem() {
        return Stream.of(
                Arguments.of(0,"Jingle bells, jingle bells")
        );
    }
    public static Stream<Arguments> paramsIndexItemOut() {
        return Stream.of(
                Arguments.of(11,"Jingle bells, jingle bells")
                );
    }
    public static Stream<Arguments> paramsIndex() {
        return Stream.of(
                Arguments.of(0)
        );
    }
    public static Stream<Arguments> paramsItemRemoveNegative() {
        return Stream.of(
                Arguments.of("Making our spirits bright")
        );
    }

}
