package com.swwan.research.demo.perf.demo01.bean;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author swwan
 * @date 2022/3/4 - 22:30
 */
public class BadCodeDemo {

    private void getBadCodeBiz(Integer city, List<TestCodeData> newDataList, List<TestCodeData> oldDataList) {
        if (city != null) {

            if (newDataList != null && newDataList.size() > 0) {
                TestCodeData newData = newDataList.stream().filter(p -> {
                    if (p.getIsHoliday() == 1) {
                        return true;
                    }
                    return false;
                }).findFirst().orElse(null);
                if (newData != null) {
                    newData.setCity(city);
                }
            }

        } else {

            if (oldDataList != null && newDataList != null) {
                List<TestCodeData> oldCollect = oldDataList.stream().filter(p -> {
                    if (p.getIsHoliday() == 1) {
                        return true;
                    }
                    return false;

                }).collect(Collectors.toList());
                List<TestCodeData> newCollect = newDataList.stream().filter(p -> {
                    if (p.getIsHoliday() == 1) {
                        return true;
                    }
                    return false;
                }).collect(Collectors.toList());

                if (newCollect != null && newCollect.size() > 0 && oldCollect != null && oldCollect.size() > 0) {
                    for (TestCodeData newPO : newCollect) {
                        if (newPO.getStartTime() == 0 && newPO.getEndTime() == 12) {
                            TestCodeData po = oldCollect.stream().filter(p -> p.getStartTime() == 0
                                    && (p.getEndTime() == 12 || p.getEndTime() == 24)).findFirst().orElse(null);
                            if (po != null) {
                                newPO.setCity(po.getCity());
                            }
                        } else if (newPO.getStartTime() == 12 && newPO.getEndTime() == 24) {
                            TestCodeData po = oldCollect.stream().filter(
                                    p -> (p.getStartTime() == 12 || p.getStartTime() == 0)
                                            && p.getEndTime() == 24).findFirst().orElse(null);
                            if (po != null) {
                                newPO.setCity(po.getCity());
                            }
                        } else if (newPO.getStartTime() == 0 && newPO.getEndTime() == 24) {
                            TestCodeData po = oldCollect.stream().filter(
                                    p -> p.getStartTime() == 0 && p.getEndTime() == 24).findFirst().orElse(null);
                            if (po == null) {
                                po = oldCollect.stream().filter(
                                        p -> p.getStartTime() == 0 && p.getEndTime() == 12).findFirst().orElse(null);
                            }
                            if (po == null) {
                                po = oldCollect.stream().filter(
                                        p -> p.getStartTime() == 12 && p.getEndTime() == 24).findFirst().orElse(null);
                            }
                            if (po != null) {
                                newPO.setCity(po.getCity());
                            }
                        } else if (newPO.getTimeUnit().equals(Integer.valueOf(1))) {
                            TestCodeData po = oldCollect.stream().filter(
                                    e -> e.getTimeUnit().equals(Integer.valueOf(1))).findFirst().orElse(null);
                            if (po != null) {
                                newPO.setCity(po.getCity());
                            }
                        }
                    }
                }
            }
        }
    }

}
