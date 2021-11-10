package tw.com.fcb.mimosa.examples.gettingstarted;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ErrorRepository extends JpaRepository<ErrorMsg, String>{
         Optional<ErrorMsg> findByCode(String code);
}

