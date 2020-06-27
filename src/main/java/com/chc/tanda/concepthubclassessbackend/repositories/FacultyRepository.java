package com.chc.tanda.concepthubclassessbackend.repositories;

import com.chc.tanda.concepthubclassessbackend.customRepo.CustomCRUDRepository;
import com.chc.tanda.concepthubclassessbackend.model.Faculty;
import com.chc.tanda.concepthubclassessbackend.model.StudentRegistration;
import com.chc.tanda.concepthubclassessbackend.model.Testimonial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacultyRepository extends CustomCRUDRepository<Faculty, Integer> {

    @Query(value = "select * from FACULTY " +
            "where id=:id " +
            "and retired=0 "
            , nativeQuery = true)
    Faculty findAllValid(@Param("id") Integer id);

    @Query(value = "select * from FACULTY " + "where retired=0 "+
            "ORDER by id asc", nativeQuery = true)
    List<Faculty> findByValidSortedCreated();
}
