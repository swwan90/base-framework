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
public class perf03 {

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

        for (TestCodeData data : newCollect) {
//            if (data.getStartTime() == 0 && data.getEndTime() == 12) {
//                TimeEnum.AM.setCity(data, oldCollect);
//            } else if (data.getStartTime() == 12 && data.getEndTime() == 24) {
//                TimeEnum.PM.setCity(data, oldCollect);
//            } else if (data.getStartTime() == 0 && data.getEndTime() == 24) {
//                TimeEnum.DAY.setCity(data, oldCollect);
//            } else if (data.getTimeUnit().equals(Integer.valueOf(1))) {
//                TimeEnum.HOUR.setCity(data, oldCollect);
//            }
            // 假设 code 变量是从 data 中获取的
            String code = "am";
            TimeEnum.valueOf(code).setCity(data, oldCollect);
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


    public enum TimeEnum {
        AM("am", "上午") {
            @Override
            public void setCity(TestCodeData data, List<TestCodeData> oldCollect) {
                TestCodeData po = oldCollect.stream().filter(p -> p.getStartTime() == 0
                        && (p.getEndTime() == 12 || p.getEndTime() == 24)).findFirst().orElse(null);
                if (null != po) {
                    data.setCity(po.getCity());
                }
            }
        },
        PM("pm", "下午") {
            @Override
            public void setCity(TestCodeData data, List<TestCodeData> oldCollect) {
                TestCodeData po = oldCollect.stream().filter(
                        p -> (p.getStartTime() == 12 || p.getStartTime() == 0)
                                && p.getEndTime() == 24).findFirst().orElse(null);
                if (po != null) {
                    data.setCity(po.getCity());
                }
            }
        },
        DAY("day", "全天") {
            @Override
            public void setCity(TestCodeData data, List<TestCodeData> oldCollect) {
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
                    data.setCity(po.getCity());
                }
            }
        },
        HOUR("hour", "小时") {
            @Override
            public void setCity(TestCodeData data, List<TestCodeData> oldCollect) {
                TestCodeData po = oldCollect.stream().filter(
                        e -> e.getTimeUnit().equals(Integer.valueOf(1))).findFirst().orElse(null);
                if (po != null) {
                    data.setCity(po.getCity());
                }
            }
        };

        private String code;
        private String desc;

        TimeEnum(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public abstract void setCity(TestCodeData data, List<TestCodeData> oldCollect);

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
