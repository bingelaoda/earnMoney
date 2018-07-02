package com.example.lottory01.service.impl;

import com.example.lottory01.bean.Note;
import com.example.lottory01.dao.NoteDao;
import com.example.lottory01.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:NoteServiceImpl
 * Description:
 */
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteDao noteDao;

    @Override
    public void save(Note note) {
        noteDao.save(note);
    }

    @Override
    public List<Note> findAll() {
        return noteDao.findAll();
    }

    @Override
    public Note findOne(String nid) {
        return noteDao.findOne(nid);
    }
}
