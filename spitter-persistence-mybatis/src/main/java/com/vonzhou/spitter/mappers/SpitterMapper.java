package com.vonzhou.spitter.mappers;

import com.vonzhou.spitter.domain.Spitter;

import java.util.List;

/**
 * Created by vonzhou on 16/7/12.
 */
public interface SpitterMapper {
    List<Spitter> findAllSpitters();
}
