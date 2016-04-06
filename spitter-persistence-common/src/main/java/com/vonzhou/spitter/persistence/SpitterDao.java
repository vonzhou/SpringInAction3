package com.vonzhou.spitter.persistence;


import com.vonzhou.spitter.Spitter;
import com.vonzhou.spitter.Spittle;

import java.util.List;


public interface SpitterDao {
    void addSpitter(Spitter spitter);

    void saveSpitter(Spitter spitter);

    Spitter getSpitterById(long id);

    List<Spittle> getRecentSpittle();

    void saveSpittle(Spittle spittle);

    List<Spittle> getSpittlesForSpitter(Spitter spitter);

    Spitter getSpitterByUsername(String username);

    void deleteSpittle(long id);

    Spittle getSpittleById(long id);

    List<Spitter> findAllSpitters();
}
