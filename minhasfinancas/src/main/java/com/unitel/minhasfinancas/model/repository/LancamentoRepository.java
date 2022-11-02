package com.unitel.minhasfinancas.model.repository;
import com.unitel.minhasfinancas.model.enums.TipoLancamento;
import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unitel.minhasfinancas.model.entity.Lancamento;
 
public interface LancamentoRepository extends JpaRepository<Lancamento, Long >  {
    
    @Query( value = " select sum(L.valor) from Lancamento L join L.usuario u"
    + " where u.id =:idUsuario and L.tipo =:tipo group by u")
    BigDecimal obterSaldoPorTipoLancamentoUsuario(@Param("idUsuario") Long idUsuario, @Param("tipo") TipoLancamento tipo);
}
