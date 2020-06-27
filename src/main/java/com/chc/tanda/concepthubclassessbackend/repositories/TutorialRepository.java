package com.chc.tanda.concepthubclassessbackend.repositories;

import com.chc.tanda.concepthubclassessbackend.customRepo.CustomCRUDRepository;
import com.chc.tanda.concepthubclassessbackend.model.LatestUpdate;
import com.chc.tanda.concepthubclassessbackend.model.StudentRegistration;
import com.chc.tanda.concepthubclassessbackend.model.Testimonial;
import com.chc.tanda.concepthubclassessbackend.model.Tutorials;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 21, 2020
 */
public interface TutorialRepository extends CustomCRUDRepository<Tutorials, Integer> {

    @Query(value = "select * from TUTORIALS " +
            "where id=:id " +
            "and retired=0 "
            , nativeQuery = true)
    Tutorials findAllValid(@Param("id") Integer id);

    @Query(value = "select * from TUTORIALS " + "where retired=0 "+
            "ORDER by id desc ", nativeQuery = true)
    List<Tutorials> findByValidSortedCreated();

    @Query(value = "select * from TUTORIALS where id=:id ",
            nativeQuery = true)
    Tutorials findValidById(@Param("id") Integer id);


}
