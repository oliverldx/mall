package com.macro.mall.portal.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Activities implements Serializable {

    private String id;
    private String pic;
    private List<ActivitySchool> activitySchoolList;
    private List<ActivityCourse> activityCourseList;

    @Data
    public static class ActivityCourse {
        private String id;
        private String name;
        private String pic;
    }

    @Data
    public static class ActivitySchool {
        private String id;
        private String name;
        private String pic;
    }


}
