package com.example.xiangxiang.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.xiangxiang.Dao.BirthdayRepository;
import com.example.xiangxiang.Service.birthdayService;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/birthday")
public class BirthdayController {

    @Autowired
    BirthdayRepository birthdayRepository;
    @Resource
    private birthdayService birthdayService;

    private static final Logger LOG = LoggerFactory.getLogger(BirthdayController.class);

    @RequestMapping(value="/",method= RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping(value="/",method= RequestMethod.POST)
    public ModelAndView index2(String string){
        birthdayService.handleMessage(string);
        return new ModelAndView("index");
    }


    @RequestMapping(value = "/message", method = RequestMethod.POST)
    @ResponseBody
    public String handleMessage(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",request.getParameter("name"));
        jsonObject.put("message",request.getParameter("message"));
        System.out.println(jsonObject);
        birthdayService.handleMessage(jsonObject.toString());

        return "success";




    }


}