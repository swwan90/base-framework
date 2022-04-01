package com.swwan.research.design.complex.autoward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author swwan
 * @date 2022/4/1 - 22:05
 */
@Component
public class ShapeBeanFactory {

    /**
     * 原理：当一个接口有多个实现类的时候，key 为实现类名，value 为实现类对象
     */
    @Autowired
    private Map<String, Shape> shapeMap;

    @Autowired
    private List<Shape> shapeList;

    public Shape getShape(String shapeType) {
        Shape shape = shapeMap.get(shapeType);
        System.out.println(shape);
        return shape;
    }
}
