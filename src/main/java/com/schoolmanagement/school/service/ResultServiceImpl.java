package com.schoolmanagement.school.service;

import com.schoolmanagement.school.entity.Result;
import com.schoolmanagement.school.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("resultServiceImpl")
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultRepository resultRepository;

    @Override
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    @Override
    public Result findByRollNumber(Integer rollNumber) {
        return resultRepository.findByRollNumber(rollNumber);
    }

    @Override
    public Result saveResult(Result result) {
        return resultRepository.save(result);
    }
}
