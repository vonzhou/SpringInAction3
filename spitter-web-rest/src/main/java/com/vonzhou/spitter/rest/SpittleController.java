package com.vonzhou.spitter.rest;

import com.vonzhou.spitter.persistence.Spitter;
import com.vonzhou.spitter.persistence.Spittle;
import com.vonzhou.spitter.service.SpitterService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private final SpitterService spitterService;

    private static final Logger logger = Logger.getLogger(SpittleController.class);

    @Inject
    public SpittleController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    // URL 指代的是资源 而非 动作
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showSpittle(@PathVariable("id") long id, Model model) {
        logger.debug("come on bb.");
        model.addAttribute(spitterService.getSpittleById(id));
        return "spittles/view";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSpittle(@PathVariable("id") long id){
        spitterService.deleteSpittle(id);
    }
}
