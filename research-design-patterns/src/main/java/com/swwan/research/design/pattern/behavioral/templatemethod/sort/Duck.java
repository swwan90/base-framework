package com.swwan.research.design.pattern.behavioral.templatemethod.sort;

import cn.hutool.core.util.NumberUtil;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @author swwan
 * @date 2022/4/8 - 22:59
 */
@ToString
@AllArgsConstructor
public class Duck implements Comparable<Duck> {

    String name;
    int weight;

    @Override
    public int compareTo(Duck object) {
        Duck otherDuck = object;

        return NumberUtil.compare(this.weight, otherDuck.weight);
    }
}
