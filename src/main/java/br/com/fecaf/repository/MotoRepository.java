package br.com.fecaf.repository;

import br.com.fecaf.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoRepository extends JpaRepository<Moto, Long> {
}
