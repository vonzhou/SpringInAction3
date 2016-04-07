package com.vonzhou.spitter.service;

import static java.lang.Math.*;
import static java.util.Collections.*;

import java.util.List;

import com.vonzhou.spitter.persistence.Spitter;
import com.vonzhou.spitter.persistence.SpitterDao;
import com.vonzhou.spitter.persistence.Spittle;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component("spitterService")
@Transactional(propagation = Propagation.REQUIRED)
public class SpitterServiceImpl implements SpitterService {

    public void saveSpitter(Spitter spitter) {
        if (spitter.getId() == null) {
            spitterDao.addSpitter(spitter);
        } else {
            spitterDao.saveSpitter(spitter);
        }

        //throw new HibernateException("Simulate Error Oops..");
    }

    public void saveSpittle(Spittle spittle) {
        spitterDao.saveSpittle(spittle);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Spittle> getRecentSpittles(int count) {
        List<Spittle> recentSpittles =
                spitterDao.getRecentSpittle();

        reverse(recentSpittles);

        return recentSpittles.subList(0,
                min(49, recentSpittles.size()));
    }


    @Autowired
    SpitterDao spitterDao;

    public Spitter getSpitter(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public void startFollowing(Spitter follower, Spitter followee) {
        // TODO Auto-generated method stub

    }

    public Spitter getSpitter(String username) {
        return spitterDao.getSpitterByUsername(username);
    }

    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        return spitterDao.getSpittlesForSpitter(spitter);
    }

    public List<Spittle> getSpittlesForSpitter(String username) {
        Spitter spitter = spitterDao.getSpitterByUsername(username);
        return getSpittlesForSpitter(spitter);
    }

    public List<Spitter> getAllSpitters() {
        return spitterDao.findAllSpitters();
    }

    public void deleteSpittle(long id) {
        spitterDao.deleteSpittle(id);
    }

    public Spittle getSpittleById(long id) {
        return spitterDao.getSpittleById(id);
    }
}
