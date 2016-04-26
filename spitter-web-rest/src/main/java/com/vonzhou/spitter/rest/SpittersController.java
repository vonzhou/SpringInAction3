package com.vonzhou.spitter.rest;

import java.util.List;

import javax.inject.Inject;

import com.vonzhou.spitter.persistence.Spitter;
import com.vonzhou.spitter.persistence.Spittle;
import com.vonzhou.spitter.service.SpitterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/spitters")
public class SpittersController {
    private SpitterService spitterService;

    @Inject
    public SpittersController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(value = "/{spitterName}/spittles", method = RequestMethod.GET)
    @ResponseBody
    public List<Spittle> spittlesForSpitter(
            @PathVariable("spitterName") String spitterName) {
        Spitter spitter = spitterService.getSpitter(spitterName);
        return spitterService.getSpittlesForSpitter(spitter);
    }
}
