package com.example.xiangxiang.Dao;

import com.example.xiangxiang.Entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthdayRepository extends JpaRepository<Entity,Integer> {

    Entity findByName(String name);

}
