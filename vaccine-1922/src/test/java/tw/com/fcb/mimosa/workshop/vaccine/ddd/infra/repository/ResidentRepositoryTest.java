package tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import tw.com.fcb.mimosa.test.MimosaTest;

import java.util.List;
import java.util.Objects;

@MimosaTest
@Transactional
class ResidentRepositoryTest {

  @Autowired
  ResidentRepository repository;
  ResidentEntity entity;

  //@BeforeEach每次進來都會執行這段 arrange
  @BeforeEach
  void arrange() {
    entity = new ResidentEntity();
    entity.setPhoneNo("0987123456");
    entity.setChooses(List.of());
    entity.setCancels(List.of());
  }

  @Test
  void generateId() {
    // arrange

    //act
    repository.save(entity);
    //assert
    Assertions.assertThat(entity)
        .extracting("id")
        .matches(Objects::nonNull);

  }

  @Test
  void generateLastModifiedDate() {
    //arrange

    //act
    repository.save(entity);
    // assert
    Assertions.assertThat(entity)
        .extracting(ResidentEntity::getLastModifiedDate)
        .matches(Objects::nonNull);

  }

  @Commit
  //做完後真的會commit
  @Test
  void curd() {
    //create
    var id = repository.save(entity).getId();
    Assertions.assertThat(id).isNotNull().isPositive();

    //read
    var found = repository.findById(id);
    Assertions.assertThat(found)
        .isPresent()
        .get()
        .extracting(ResidentEntity::getPhoneNo)
        .isEqualTo("0987123456");
    //update
    entity.setNhiNo("1234567890");
    repository.save(entity);
    // find by id
    found = repository.findById(id);
    //assert phoneNo,nhiNo
    Assertions.assertThat(found)
        .isPresent()
        .get()
        .extracting(ResidentEntity::getPhoneNo, ResidentEntity::getNhiNo)
        .contains("0987123456", "1234567890");
    //delete
    repository.deleteById(id);
    //find by id
    //    var delete = repository.findById(id);
    // assert isEmpty
    Assertions.assertThat(repository.findById(id))
        .isEmpty();
  }

}
