package tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.rest.ResidentInfo;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResidentInfoRepository extends JpaRepository<ResidentInfoEntity, Long> {

}
