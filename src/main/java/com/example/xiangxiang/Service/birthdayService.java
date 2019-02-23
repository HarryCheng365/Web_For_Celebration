package com.example.xiangxiang.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.xiangxiang.Dao.BirthdayRepository;
import com.example.xiangxiang.Entity.Entity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class birthdayService {
    @Resource
    private BirthdayRepository birthdayRepository;
    private String suffix = "";

    public String handleMessage(String string){
        JSONObject jsonObject=JSONObject.parseObject(string);

        Entity entity = new Entity(jsonObject.getString("message"),jsonObject.getString("name"));
       Entity entity1= birthdayRepository.save(entity);
        return "success";


    }

}
