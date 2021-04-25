package com.macro.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TusRelationshipConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TusRelationshipConfigExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTusUserIdIsNull() {
            addCriterion("tus_user_id is null");
            return (Criteria) this;
        }

        public Criteria andTusUserIdIsNotNull() {
            addCriterion("tus_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andTusUserIdEqualTo(Long value) {
            addCriterion("tus_user_id =", value, "tusUserId");
            return (Criteria) this;
        }

        public Criteria andTusUserIdNotEqualTo(Long value) {
            addCriterion("tus_user_id <>", value, "tusUserId");
            return (Criteria) this;
        }

        public Criteria andTusUserIdGreaterThan(Long value) {
            addCriterion("tus_user_id >", value, "tusUserId");
            return (Criteria) this;
        }

        public Criteria andTusUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tus_user_id >=", value, "tusUserId");
            return (Criteria) this;
        }

        public Criteria andTusUserIdLessThan(Long value) {
            addCriterion("tus_user_id <", value, "tusUserId");
            return (Criteria) this;
        }

        public Criteria andTusUserIdLessThanOrEqualTo(Long value) {
            addCriterion("tus_user_id <=", value, "tusUserId");
            return (Criteria) this;
        }

        public Criteria andTusUserIdIn(List<Long> values) {
            addCriterion("tus_user_id in", values, "tusUserId");
            return (Criteria) this;
        }

        public Criteria andTusUserIdNotIn(List<Long> values) {
            addCriterion("tus_user_id not in", values, "tusUserId");
            return (Criteria) this;
        }

        public Criteria andTusUserIdBetween(Long value1, Long value2) {
            addCriterion("tus_user_id between", value1, value2, "tusUserId");
            return (Criteria) this;
        }

        public Criteria andTusUserIdNotBetween(Long value1, Long value2) {
            addCriterion("tus_user_id not between", value1, value2, "tusUserId");
            return (Criteria) this;
        }

        public Criteria andLevelOneIsNull() {
            addCriterion("level_one is null");
            return (Criteria) this;
        }

        public Criteria andLevelOneIsNotNull() {
            addCriterion("level_one is not null");
            return (Criteria) this;
        }

        public Criteria andLevelOneEqualTo(Long value) {
            addCriterion("level_one =", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneNotEqualTo(Long value) {
            addCriterion("level_one <>", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneGreaterThan(Long value) {
            addCriterion("level_one >", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneGreaterThanOrEqualTo(Long value) {
            addCriterion("level_one >=", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneLessThan(Long value) {
            addCriterion("level_one <", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneLessThanOrEqualTo(Long value) {
            addCriterion("level_one <=", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneIn(List<Long> values) {
            addCriterion("level_one in", values, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneNotIn(List<Long> values) {
            addCriterion("level_one not in", values, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneBetween(Long value1, Long value2) {
            addCriterion("level_one between", value1, value2, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneNotBetween(Long value1, Long value2) {
            addCriterion("level_one not between", value1, value2, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsNull() {
            addCriterion("level_two is null");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsNotNull() {
            addCriterion("level_two is not null");
            return (Criteria) this;
        }

        public Criteria andLevelTwoEqualTo(Long value) {
            addCriterion("level_two =", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoNotEqualTo(Long value) {
            addCriterion("level_two <>", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoGreaterThan(Long value) {
            addCriterion("level_two >", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoGreaterThanOrEqualTo(Long value) {
            addCriterion("level_two >=", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoLessThan(Long value) {
            addCriterion("level_two <", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoLessThanOrEqualTo(Long value) {
            addCriterion("level_two <=", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIn(List<Long> values) {
            addCriterion("level_two in", values, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoNotIn(List<Long> values) {
            addCriterion("level_two not in", values, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoBetween(Long value1, Long value2) {
            addCriterion("level_two between", value1, value2, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoNotBetween(Long value1, Long value2) {
            addCriterion("level_two not between", value1, value2, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andTakeOrderIsNull() {
            addCriterion("take_order is null");
            return (Criteria) this;
        }

        public Criteria andTakeOrderIsNotNull() {
            addCriterion("take_order is not null");
            return (Criteria) this;
        }

        public Criteria andTakeOrderEqualTo(Integer value) {
            addCriterion("take_order =", value, "takeOrder");
            return (Criteria) this;
        }

        public Criteria andTakeOrderNotEqualTo(Integer value) {
            addCriterion("take_order <>", value, "takeOrder");
            return (Criteria) this;
        }

        public Criteria andTakeOrderGreaterThan(Integer value) {
            addCriterion("take_order >", value, "takeOrder");
            return (Criteria) this;
        }

        public Criteria andTakeOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("take_order >=", value, "takeOrder");
            return (Criteria) this;
        }

        public Criteria andTakeOrderLessThan(Integer value) {
            addCriterion("take_order <", value, "takeOrder");
            return (Criteria) this;
        }

        public Criteria andTakeOrderLessThanOrEqualTo(Integer value) {
            addCriterion("take_order <=", value, "takeOrder");
            return (Criteria) this;
        }

        public Criteria andTakeOrderIn(List<Integer> values) {
            addCriterion("take_order in", values, "takeOrder");
            return (Criteria) this;
        }

        public Criteria andTakeOrderNotIn(List<Integer> values) {
            addCriterion("take_order not in", values, "takeOrder");
            return (Criteria) this;
        }

        public Criteria andTakeOrderBetween(Integer value1, Integer value2) {
            addCriterion("take_order between", value1, value2, "takeOrder");
            return (Criteria) this;
        }

        public Criteria andTakeOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("take_order not between", value1, value2, "takeOrder");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andTeamIsNull() {
            addCriterion("team is null");
            return (Criteria) this;
        }

        public Criteria andTeamIsNotNull() {
            addCriterion("team is not null");
            return (Criteria) this;
        }

        public Criteria andTeamEqualTo(Long value) {
            addCriterion("team =", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotEqualTo(Long value) {
            addCriterion("team <>", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamGreaterThan(Long value) {
            addCriterion("team >", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamGreaterThanOrEqualTo(Long value) {
            addCriterion("team >=", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamLessThan(Long value) {
            addCriterion("team <", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamLessThanOrEqualTo(Long value) {
            addCriterion("team <=", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamIn(List<Long> values) {
            addCriterion("team in", values, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotIn(List<Long> values) {
            addCriterion("team not in", values, "team");
            return (Criteria) this;
        }

        public Criteria andTeamBetween(Long value1, Long value2) {
            addCriterion("team between", value1, value2, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotBetween(Long value1, Long value2) {
            addCriterion("team not between", value1, value2, "team");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNull() {
            addCriterion("school is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("school is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(Long value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(Long value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(Long value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(Long value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(Long value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(Long value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<Long> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<Long> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(Long value1, Long value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(Long value1, Long value2) {
            addCriterion("school not between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("modify_date is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("modify_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterion("modify_date =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterion("modify_date <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterion("modify_date >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_date >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterion("modify_date <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("modify_date <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterion("modify_date in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterion("modify_date not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterion("modify_date between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("modify_date not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}