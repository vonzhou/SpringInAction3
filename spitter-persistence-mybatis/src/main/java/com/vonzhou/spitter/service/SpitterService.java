package com.vonzhou.spitter.service;

import com.vonzhou.spitter.domain.Spitter;
import com.vonzhou.spitter.mappers.SpitterMapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vonzhou on 16/7/12.
 */
@Service(value = "spitterService")
@Transactional
public class SpitterService {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<Spitter> findAllSpitters() {
        try{
            SpitterMapper spitterMapper = sqlSessionTemplate.getMapper(SpitterMapper.class);
            return spitterMapper.findAllSpitters();
        }catch (Exception e){
            System.out.println("----------------------------");
            System.out.println(e.getCause());
            System.out.println("+++++++++++++++++++++++++++++");
        }
        return null;
    }
}
