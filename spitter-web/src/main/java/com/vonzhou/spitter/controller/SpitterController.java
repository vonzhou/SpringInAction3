package com.vonzhou.spitter.controller;

import com.vonzhou.spitter.common.ImageUploadException;
import com.vonzhou.spitter.persistence.Spitter;
import com.vonzhou.spitter.service.SpitterService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;


/**
 * Created by vonzhou on 16/4/20.
 */
@Controller
@RequestMapping("/spitter")   // 根URL
public class SpitterController {

    private final SpitterService spitterService;

    private Logger logger = Logger.getLogger("SpitterController.class");

    @Autowired
    public SpitterController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(value = "spittles", method = RequestMethod.GET)
    public String listSpittlesForSpitter(@RequestParam("spitter") String username, Model model) {
        Spitter spitter = spitterService.getSpitter(username);
        model.addAttribute(spitter);
        model.addAttribute(spitterService.getSpittlesForSpitter(username));

        return "spittles/list";
    }

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String createSpitterProfile(Model model) {
        model.addAttribute(new Spitter());
        return "spitters/edit";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addSpitterFromForm(@Valid Spitter spitter, BindingResult bindingResult,
                                     @RequestParam(value = "image", required = false) MultipartFile image, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "spitters/edit";
        }

        // 保存这个Spitter到数据库中
        spitterService.saveSpitter(spitter);

        //TODO 如何得到项目的根目录
        // session.getServletContext().getContextPath()得到的是诸如/Spitter,而并非实际的路径
        // 通过getRealPath(File.separator)得到项目根目录的路径,在target/project-name-version/ 很容易理解

        String webRootPath = session.getServletContext().getRealPath(File.separator);
        String imageStorePath = webRootPath + "/resources/";
//        System.out.println("webRootPath" + webRootPath);

        try {
            if (!image.isEmpty()) {
                validateImage(image);
                saveImage(imageStorePath + spitter.getId() + ".jpg", image);
            }
        } catch (ImageUploadException e) {
            bindingResult.reject(e.getMessage());
            return "spitters/edit";
        }

        return "redirect:/spitter/" + spitter.getUsername();
    }

    private void validateImage(MultipartFile image) {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new ImageUploadException("Only JPG images accetpted.");
        }
    }

    private void saveImage(String path, MultipartFile image) throws ImageUploadException {

        try {
            File file = new File(path);
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException e) {
            throw new ImageUploadException("Unable to save image to local");
        }
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        // 加入的属性不能为空, IllegalArgumentException: Model object must not be null
        // 所以需要判断处理
        Spitter spitter = spitterService.getSpitter(username);
        spitter = (spitter == null) ? Spitter.FAKE_SPITTER : spitter;
        model.addAttribute(spitter);
        return "spitters/view";
    }

    @RequestMapping(value = "/json/test")
    public
    @ResponseBody
    Spitter getSpitterInJson() {
        Spitter spitter = new Spitter();
        spitter.setUsername("vonzhou");
        spitter.setId(100L);

        return spitter;
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadImage(@RequestParam("name")String name, @RequestParam("desc") String desc, @RequestParam("avatar") MultipartFile file){
        logger.info("Spitter name: " + name + ", desc: " + desc);
        logger.info("Spitter avatar file :" + file.getOriginalFilename());
        return "spitters/view";
    }

}
