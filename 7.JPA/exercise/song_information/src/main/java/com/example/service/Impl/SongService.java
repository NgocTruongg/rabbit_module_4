package com.example.service.Impl;

import com.example.dto.SongDTO;
import com.example.model.Song;
import com.example.repository.ISongRepository;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<SongDTO> findAll() {
        return null;
    }

    @Override
    public void createSong(Song song) {
        iSongRepository.save(song);

    }

    @Override
    public void updateSong(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return iSongRepository.findById(id).get();
    }
}
