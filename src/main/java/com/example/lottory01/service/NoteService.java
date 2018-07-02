package com.example.lottory01.service;

import com.example.lottory01.bean.Note;

import java.util.List;

/**
 * ClassName:NoteService
 * Description:
 */
public interface NoteService {
    void save(Note note);

    List<Note> findAll();

    Note findOne(String nid);
}
