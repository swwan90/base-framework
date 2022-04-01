package com.swwan.research.design.complex.autoward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swwan
 * @date 2022/4/1 - 22:07
 */
@RestController
public class testController {

    @Autowired
    private ShapeBeanFactory factory;

    @GetMapping("/drawMyShape")
    public String drawMyShape() {
        shapeBeanFactoryDraw();
        return "success";
    }

    private void shapeBeanFactoryDraw() {
        String circle = SettingTypeEnum.CIRCLE.implement;
        Shape shape = factory.getShape(circle);
        shape.draw();
    }
}
