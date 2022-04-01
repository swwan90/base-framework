package com.swwan.research.design.complex.autoward;

import org.springframework.stereotype.Service;

/**
 * @author swwan
 * @date 2022/4/1 - 22:01
 */
@Service
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
