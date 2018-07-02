package com.example.lottory01.dao;

import com.example.lottory01.bean.Note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClassName:NoteDao
 * Description:
 */
@Repository
public interface NoteDao extends JpaRepository<Note,String> {
}
