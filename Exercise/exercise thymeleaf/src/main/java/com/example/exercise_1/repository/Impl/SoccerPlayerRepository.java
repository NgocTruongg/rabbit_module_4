package com.example.exercise_1.repository.Impl;

import com.example.exercise_1.model.SoccerPlayer;
import com.example.exercise_1.repository.ISoccerPlayerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SoccerPlayerRepository implements ISoccerPlayerRepository {
    private static List<SoccerPlayer> soccerPlayerList = new ArrayList<>();

//    static {
//        soccerPlayerList.add(new SoccerPlayer(1, "SC-01", "Ngô Ngọc Trường", "10/09/1998", "Chuyên nghiệp", "Tiền vệ",
//                "https://tophinhanhdep.com/wp-content/uploads/2021/11/Lionel-Messi-4K-Wallpapers.jpg"));
//        soccerPlayerList.add(new SoccerPlayer(2, "SC-02", "Phạm Văn Đồng", "10/09/1997", "Dự bị", "Thủ môn",
//                "https://i.pinimg.com/originals/22/a6/6e/22a66ef9fc1067375df29ee4fd04954b.jpg"));
//        soccerPlayerList.add(new SoccerPlayer(3, "SC-03", "Trần Trọng Nghĩa", "10/09/2004", "Chuyên nghiệp", "Hậu vệ",
//                "https://wallpapers.com/images/hd/neymar-4k-black-edit-qynvgya5qho767e7.jpg"));
//    }

    @Override
    public List<SoccerPlayer> findAll() {
        List<SoccerPlayer> soccerPlayerList = BaseRepository.entityManager
                .createQuery("select s from SoccerPlayer as s", SoccerPlayer.class).getResultList();
        return soccerPlayerList;
    }

    @Override
    public SoccerPlayer findById(int id) {
       SoccerPlayer soccerPlayer = BaseRepository.entityManager
               .find(SoccerPlayer.class,id);
       return soccerPlayer;
    }

    @Override
    public void deleteSoccer(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        entityTransaction.commit();
    }

    @Override
    public void create(SoccerPlayer soccerPlayer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(soccerPlayer);
        entityTransaction.commit();
    }

    @Override
    public void update(SoccerPlayer soccerPlayer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(soccerPlayer);
        entityTransaction.commit();
    }
}
