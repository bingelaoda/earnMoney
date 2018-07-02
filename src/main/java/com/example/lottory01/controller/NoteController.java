package com.example.lottory01.controller;

import com.example.lottory01.bean.Note;
import com.example.lottory01.bean.User;
import com.example.lottory01.service.NoteService;
import com.example.lottory01.utils.UUIDUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * ClassName:bbsController
 * Description:
 */
@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/bbsIndex")
    public String bbsIndex(Model model){
        //展示所有的评论
       List<Note> notes =  noteService.findAll();

       model.addAttribute("notes",notes);


        return "bbs_index";
    }
    @PostMapping("/addNote")
    public String addNote(Note note, HttpSession httpSession){
        //1.参数
        String id = UUIDUtils.getId();
        note.setNid(id);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY年MM月dd日 HH:mm:ss E");
        String format = simpleDateFormat.format(date);

        note.setTime(format);

        User user = (User) httpSession.getAttribute("user");
        note.setUsername(user.getUsername());
        //2.调用方法
        noteService.save(note);
        //3.返回
        return "redirect:bbsIndex";
    }
    @GetMapping("/noteDetail")
    public String noteDetail(String nid,Model model){
        Note note = noteService.findOne(nid);
        System.out.println("111"+note);
        model.addAttribute("note",note);
        return "noteDetail";
    }


}
