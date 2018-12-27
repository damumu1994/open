package app.service.impl;


import app.model.Test;
import app.repository.TestRepository;
import app.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: lxb
 * @Date: 2018/12/25 0025
 * @Description:
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestRepository testRepository;
    @Override
    public List<Test> getList() {
        return testRepository.findAll();
    }
}
