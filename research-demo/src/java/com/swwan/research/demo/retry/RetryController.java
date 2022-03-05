package com.swwan.research.demo.retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swwan
 * @date 2022/3/6 - 0:30
 */
@RestController
@RequestMapping("/retry")
public class RetryController {

    @Autowired
    private RetryService retryService;

    @GetMapping("/test01")
    public void test01() {
        retryService.devide(2, 1);
        retryService.devide(2, 0);
    }
}
