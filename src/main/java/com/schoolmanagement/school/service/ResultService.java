package com.schoolmanagement.school.service;

import com.schoolmanagement.school.entity.Result;

import java.util.List;

public interface ResultService {
    public List<Result> getAllResults();

    public Result findByRollNumber(Integer rollNumber);

    public Result saveResult(Result result);


}
