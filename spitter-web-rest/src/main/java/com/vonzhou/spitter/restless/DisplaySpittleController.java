package com.vonzhou.spitter.restless;

import javax.inject.Inject;

import com.vonzhou.spitter.persistence.Spitter;
import com.vonzhou.spitter.persistence.Spittle;
import com.vonzhou.spitter.service.SpitterService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


/**
 *
 */
@Controller
public class DisplaySpittleController {
    private final SpitterService spitterService;

    private static final Logger logger = Logger.getLogger(DisplaySpittleController.class);

    @Inject
    public DisplaySpittleController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    // 显示指定ID的Spittle
    @RequestMapping(value = "/displaySpittle.htm", method = RequestMethod.GET)
    public String showSpittle(@RequestParam("id") long id, Model model) {
        model.addAttribute(spitterService.getSpittleById(id));
        return "spittles/view";
    }

    @RequestMapping(value = "/displaySpittles.htm", method = RequestMethod.GET)
    public String showSpittlesForSpitter(
            @RequestParam("spitterId") long spitterId, Map<String, Object> model) {

        Spitter spitter = spitterService.getSpitter(spitterId);


        // 我这里为了简单起见不查找Spitter,直接根据其ID得到所有的Spittle,是否会存在安全问题??
//        Spitter spitter = Spitter.FAKE_SPITTER;
//        spitter.setId(spitterId);

        List<Spittle> spittles =
                spitterService.getSpittlesForSpitter(spitter);
        model.put("spitter", spitter);
        model.put("spittles", spittles);

        return "spittles/list";
    }
}
