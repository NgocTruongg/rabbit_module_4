package com.example.service;

import com.example.dto.SongDTO;
import com.example.model.Song;

import java.util.List;

public interface ISongService {
    List<SongDTO> findAll();

    void createSong(Song song);

    void updateSong (Song song);

    Song findById(int id);

}
