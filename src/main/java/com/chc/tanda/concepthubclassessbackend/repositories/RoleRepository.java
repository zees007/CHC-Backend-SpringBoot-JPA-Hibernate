package com.chc.tanda.concepthubclassessbackend.repositories;

import com.chc.tanda.concepthubclassessbackend.customRepo.CustomCRUDRepository;
import com.chc.tanda.concepthubclassessbackend.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends CustomCRUDRepository<Role, Integer> {

    @Query(value = "select * from ROLE_MODEL " +
            "where id=:id " +
            "and retired=0 "
            , nativeQuery = true)
    Role findFirstValidById(@Param("id") Integer id);
}
