package com.schoolmanagement.school.controller;

import com.schoolmanagement.school.entity.Result;
import com.schoolmanagement.school.service.ResultService;
import com.schoolmanagement.school.service.ResultServiceImpl;
import com.schoolmanagement.school.service.ResultServiceImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {

    @Autowired
    @Qualifier("resultServiceImpl")
    private ResultService resultService;

    @GetMapping(value = "/result")
    public List<Result> getResult() {
        return resultService.getAllResults();
    }

    @GetMapping(value = "/{rollnumber}")
    public Result findByRollNumber(@PathVariable(value = "rollnumber") Integer rollnumber) {
        return resultService.findByRollNumber(rollnumber);
    }

    @PostMapping("/addresult")
    public Result addResult(@Validated @RequestBody Result result) {
        return resultService.saveResult(result);
    }
}
