package br.com.senai.repositories;

import br.com.senai.models.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {


}
