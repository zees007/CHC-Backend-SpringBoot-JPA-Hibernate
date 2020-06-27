package com.chc.tanda.concepthubclassessbackend.repositories;

import com.chc.tanda.concepthubclassessbackend.customRepo.CustomCRUDRepository;
import com.chc.tanda.concepthubclassessbackend.model.Faculty;
import com.chc.tanda.concepthubclassessbackend.model.Gallary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GallaryRepository extends CustomCRUDRepository<Gallary, Integer> {

    @Query(value = "select * from GALLARY " +
            "where id=:id " +
            "and retired=0 "
            , nativeQuery = true)
    Gallary findAllValid(@Param("id") Integer id);

    @Query(value = "select * from GALLARY " + "where retired=0 "+
            "ORDER by id asc", nativeQuery = true)
    List<Gallary> findByValidSortedCreated();

}
