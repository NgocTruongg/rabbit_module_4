package com.example.exercise_spring_boot.repository;

import com.example.exercise_spring_boot.model.SoccerPlayer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ISoccerPlayerRepository extends PagingAndSortingRepository<SoccerPlayer, Integer> {
    Page<SoccerPlayer> findAllByNameContaining (String name, Pageable pageable);
    List<SoccerPlayer> findAll();
    @Transactional
    @Query(value = "select * from soccer_player where status = 'Đã đăng kí'" , nativeQuery = true)
    List<SoccerPlayer> findAllByStatus();
}
