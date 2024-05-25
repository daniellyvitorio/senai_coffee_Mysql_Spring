package br.com.senai.repositories;

import br.com.senai.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
