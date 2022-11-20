package pro.sky.MyArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.MyArrayList.Service.IntegerService;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class IntegerServiceTest {
    @InjectMocks
    private IntegerService integerService;

    @BeforeEach
    public void beforeEach(){
        integerService.add(1);
        integerService.add(3);
        integerService.add(5);
        integerService.add(2);
        integerService.add(7);
    }

    @ParameterizedTest
    @MethodSource("paramsItem")
    public void addPositiveTest(Integer item){
        assertThat(integerService.add(item)).isEqualTo(5);
    }


    @ParameterizedTest
    @MethodSource("paramsIndexItem")
    public void addPositiveTest(int index, Integer item) {
        assertThat(integerService.add(index, item)).isEqualTo(6);
    }

    @ParameterizedTest
    @MethodSource("paramsIndexItem")
    public void setPositiveTest(int index, Integer item){
        assertThat(integerService.set(index, item)).isEqualTo(6);
    }

    @ParameterizedTest
    @MethodSource("paramsIndexItemOut")
    public void setNegativeTest(int index, Integer item){
        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
                .isThrownBy(()->integerService.set(index, item));
    }

    @ParameterizedTest
    @MethodSource("paramsItem")
    public void removePositiveTest(Integer item){
        assertThat(integerService.remove(item)).isEqualTo(5);
    }

    @ParameterizedTest
    @MethodSource("paramsItemRemoveNegative")
    public void removeNegativeTest(Integer item){
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()->integerService.remove(item));
    }

    @ParameterizedTest
    @MethodSource("paramsIndex")
    public void removePositiveTest(int index){
        assertThat(integerService.remove(index)).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource("paramsItem")
    public void containsPositiveTest(Integer item){
        assertThat(integerService.contains(item)).isEqualTo(true);
    }

    @ParameterizedTest
    @MethodSource("paramsItem")
    public void indexOfPositiveTest(Integer item){
        assertThat(integerService.indexOf(item)).isEqualTo(2);
    }

    @ParameterizedTest
    @MethodSource("paramsItem")
    public void lastIndexOfPositiveTest(Integer item){
        assertThat(integerService.lastIndexOf(item)).isEqualTo(5);
    }

    @ParameterizedTest
    @MethodSource("paramsIndex")
    public void getPositiveTest(int index){
        assertThat(integerService.get(index)).isEqualTo(1);
    }


    @ParameterizedTest
    @MethodSource("paramsItem")
    public void sizePositiveTest(){
        assertThat(integerService.size()).isEqualTo(5);
    }

    @ParameterizedTest
    @MethodSource("paramsItem")
    public void isEmptyPositiveTest(){
        assertThat(integerService.isEmpty()).isEqualTo(false);
    }



    public static Stream<Arguments> paramsItem() {
        return Stream.of(
                Arguments.of(5)
        );
    }
    public static Stream<Arguments> paramsIndexItem() {
        return Stream.of(
                Arguments.of(0,6)
        );
    }
    public static Stream<Arguments> paramsIndexItemOut() {
        return Stream.of(
                Arguments.of(11,7)
        );
    }
    public static Stream<Arguments> paramsIndex() {
        return Stream.of(
                Arguments.of(0)
        );
    }
    public static Stream<Arguments> paramsItemRemoveNegative() {
        return Stream.of(
                Arguments.of(9)
        );
    }


}
