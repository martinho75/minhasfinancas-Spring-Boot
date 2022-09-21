package com.unitel.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitel.minhasfinancas.model.entity.lancamento;
 
public interface LancamentoRepository extends JpaRepository<lancamento, Long >  {
    
}
