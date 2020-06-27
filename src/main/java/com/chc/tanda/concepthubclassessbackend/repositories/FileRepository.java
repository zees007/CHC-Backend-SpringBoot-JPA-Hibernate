package com.chc.tanda.concepthubclassessbackend.repositories;

import com.chc.tanda.concepthubclassessbackend.customRepo.CustomCRUDRepository;
import com.chc.tanda.concepthubclassessbackend.model.File;
import com.chc.tanda.concepthubclassessbackend.model.Gallary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FileRepository extends CustomCRUDRepository<File, Integer> {
    @Query(value = "select * from FILE where id=:id " +
            "and retired=0 ",
            nativeQuery = true)
    File findValidById(@Param("id") Integer id);


}

