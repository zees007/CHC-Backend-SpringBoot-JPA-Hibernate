package com.chc.tanda.concepthubclassessbackend.repositories;

import com.chc.tanda.concepthubclassessbackend.customRepo.CustomCRUDRepository;
import com.chc.tanda.concepthubclassessbackend.model.Achievement;
import com.chc.tanda.concepthubclassessbackend.model.AchievementScore;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 13, 2020
 */
public interface AchievementScoreRepository extends CustomCRUDRepository<AchievementScore, Integer> {

    @Query(value = "select * from ACHIEVEMENT_SCORE " +
            "where id=:id " +
            "and retired=0 "
            , nativeQuery = true)
    AchievementScore findAllValid(@Param("id") Integer id);

    @Query(value = "select * from ACHIEVEMENT_SCORE " + "where retired=0 "+
            "ORDER by id asc", nativeQuery = true)
    List<AchievementScore> findByValidSortedCreated();


}
