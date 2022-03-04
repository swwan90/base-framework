package com.swwan.research.demo.perf;

import cn.hutool.core.collection.CollUtil;
import com.swwan.research.demo.perf.bean.TestCodeData;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author swwan
 * @date 2022/3/4 - 22:38
 */
public class perf02 {

    private void getBadCodeBiz(Integer city, List<TestCodeData> newDataList, List<TestCodeData> oldDataList) {
        if (city != null) {
            // 合并逻辑流程
            this.getCityNotNull(city, newDataList);
        } else {
            getCityNull(newDataList, oldDataList);
        }
    }

    private void getCityNull(List<TestCodeData> newDataList, List<TestCodeData> oldDataList) {

        if (CollUtil.isEmpty(oldDataList) || CollUtil.isEmpty(newDataList)) {
            return;
        }

        List<TestCodeData> oldCollect = oldDataList.stream().filter(data -> data.getIsHoliday() == 1).collect(Collectors.toList());
        List<TestCodeData> newCollect = newDataList.stream().filter(data -> data.getIsHoliday() == 1).collect(Collectors.toList());

        if (CollUtil.isEmpty(newCollect) || CollUtil.isEmpty(oldCollect)) {
            return;
        }

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

    private void getCityNotNull(Integer city, List<TestCodeData> newDataList) {
        if (CollUtil.isEmpty(newDataList)) {
            return;
        }

        TestCodeData newData = newDataList.stream().filter(data -> data.getIsHoliday() == 1).findFirst().orElse(null);
        if (Objects.nonNull(newData)) {
            newData.setCity(city);
        }
    }
}
