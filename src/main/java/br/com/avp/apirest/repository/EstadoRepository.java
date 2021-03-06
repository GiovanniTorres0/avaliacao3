package br.com.avp.apirest.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avp.apirest.modelo.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

	List<Estado> findByNome(String nome);

	List<Estado> findByRegiao(String regiao);


}
