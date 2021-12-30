package tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository;

import org.aspectj.weaver.Dump;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class MockitoTest {
  @Test
  void mock() {
    // arrange
    var repository = Mockito.mock(AppointmentRepository.class);
    Mockito.when(repository.count()).thenReturn(1);

    //act
    var actual = repository.count();

    // assert
    Assertions.assertThat(actual)
        .isGreaterThanOrEqualTo(0)
        .isNotNegative();
  }

  @Test
  void mockInput() {
    // arrange
    var mock = Mockito.mock(AppointmentRepository.class);
    //當有人呼叫countByname時，傳任何字串進去時，就會回傳1
    Mockito.when(mock.countByName(Mockito.anyString())).thenReturn(1);
    //如傳入的參數為 hi時，就會回傳2
    Mockito.when(mock.countByName(Mockito.eq("hi"))).thenReturn(2);

    //act input hello
    //傳入字串 "hello"
    var acturl = mock.countByName("hello");
    //Assertions
    //驗證回傳值是否為正整數
    Assertions.assertThat(acturl)
        .isPositive()
        .isEqualTo(1);

    //act input hi
    //    var acturl2 = mock.countByName("hi");
    //Assertions
    Assertions.assertThat(mock.countByName("hi")).isPositive().isEqualTo(2);

  }

  @Test
  void mockThrow() {
    var mock = Mockito.mock(AppointmentRepository.class);
    Mockito.when(mock.countByNameLike(Mockito.anyString())).thenThrow(IllegalStateException.class);

    // act input hello

    var throwable = Assertions.catchThrowable(() -> {
      mock.countByNameLike("hi");
    });
    //assert catch IllegalStateException
    Assertions.assertThat(throwable)
        .isInstanceOf(IllegalStateException.class);

  }

  @Test
  void mockVoidThrow() {
    var mock = Mockito.mock(AppointmentRepository.class);
    //預期要丟錯，針對mock的print
    Mockito.doThrow(IllegalStateException.class).when(mock).print();

    //assert print throw exception
    Assertions.assertThatIllegalStateException()
        .isThrownBy(mock::print);
  }

  @Test
  void spy() {
    //    var repository = new AppointmentRepository();
    //    System.out.println(repository.count()); //-1
    //    var mock = Mockito.mock(AppointmentRepository.class);
    //    System.out.println(mock.count());// 0 回傳int本身的預設值

    var spy = Mockito.spy(AppointmentRepository.class);
    Mockito.doThrow(IllegalStateException.class).when(spy).print();

    // assert print throw IllegalStateException
    Assertions.assertThatIllegalStateException().isThrownBy(spy::print);
    // assert count() return  -1
    Assertions.assertThat(spy.count()).isEqualTo(-1);

  }

  @Test
  void spyVerify() {
    var spy = Mockito.spy(AppointmentRepository.class);

    //act
    spy.call(3);

    //assert

    Mockito.verify(spy, Mockito.times(3)).count();
    //至少要被call一次
    Mockito.verify(spy, Mockito.atLeastOnce()).count();
    //絕對不會被call到print
    Mockito.verify(spy, Mockito.never()).print();
  }

  @Test
  void spyVerifyOrder() {
    var spy = Mockito.spy(AppointmentRepository.class);
    var inOder = Mockito.inOrder(spy);

    //act
    spy.call(3);
    //assert
    inOder.verify(spy).call(3);
    inOder.verify(spy, Mockito.atLeast(2)).count();
  }

  static class AppointmentRepository {
    int count() {
      return -1;
    }

    int countByName(String name) {
      return -1;
    }

    int countByNameLike(String name) {
      return -1;
    }

    void print() {

    }

    void call(int num) {

      for (int i = 0; i < num; i++) {
        count();
      }

    }
  }
}
