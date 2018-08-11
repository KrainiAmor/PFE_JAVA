package org.sid.DAO;

import org.sid.entites.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface OperationRepastory extends JpaRepository<Operation, Long> {
	@Query("select o from Operation o where o.compte.code=:x order by o.dateOpe desc")
	public Page<Operation> listoper(@Param("x")String codeCpte,Pageable pageable);

}
