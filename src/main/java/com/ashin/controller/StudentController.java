package com.ashin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Created by AshinLiang on 2017/7/6.
 */
public class StudentController {

    static Logger log = LoggerFactory.getLogger(StudentController.class);

    public static void main(String[] args) {
        StudentController studentController = new StudentController();

        log.debug("ashin:{}","debug");
        log.info("ashin:{}","info");
        log.error("ashin:{}","error");
    }
}
