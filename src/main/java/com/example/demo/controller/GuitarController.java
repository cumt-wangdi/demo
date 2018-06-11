package com.example.demo.controller;

import com.example.demo.dao.MySqlite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuitarController {
    @Autowired
    private MySqlite mySqlite;

    @GetMapping("/findAll")
    public String findAll(Model model){
        //mySqlite.createTable();
        for (int i=0;i<5;i++)
            mySqlite.insertData(i+"b");
        model.addAttribute("persons",mySqlite.findAllGuitar());
        return "list";
    }

}
