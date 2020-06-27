package com.chc.tanda.concepthubclassessbackend.repositories;

import com.chc.tanda.concepthubclassessbackend.customRepo.CustomCRUDRepository;
import com.chc.tanda.concepthubclassessbackend.model.Achievement;
import com.chc.tanda.concepthubclassessbackend.model.Faculty;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 13, 2020
 */
public interface AchievementRepository extends CustomCRUDRepository<Achievement, Integer> {

    @Query(value = "select * from ACHIEVEMENT " +
            "where id=:id " +
            "and retired=0 "
            , nativeQuery = true)
    Achievement findAllValid(@Param("id") Integer id);

    @Query(value = "select * from ACHIEVEMENT " + "where retired=0 "+
            "ORDER by id desc", nativeQuery = true)
    List<Achievement> findByValidSortedCreated();
}
