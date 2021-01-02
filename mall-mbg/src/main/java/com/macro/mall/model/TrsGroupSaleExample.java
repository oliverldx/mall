package com.macro.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrsGroupSaleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TrsGroupSaleExample() {
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

        public Criteria andTrsActivityIdIsNull() {
            addCriterion("trs_activity_id is null");
            return (Criteria) this;
        }

        public Criteria andTrsActivityIdIsNotNull() {
            addCriterion("trs_activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrsActivityIdEqualTo(Long value) {
            addCriterion("trs_activity_id =", value, "trsActivityId");
            return (Criteria) this;
        }

        public Criteria andTrsActivityIdNotEqualTo(Long value) {
            addCriterion("trs_activity_id <>", value, "trsActivityId");
            return (Criteria) this;
        }

        public Criteria andTrsActivityIdGreaterThan(Long value) {
            addCriterion("trs_activity_id >", value, "trsActivityId");
            return (Criteria) this;
        }

        public Criteria andTrsActivityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("trs_activity_id >=", value, "trsActivityId");
            return (Criteria) this;
        }

        public Criteria andTrsActivityIdLessThan(Long value) {
            addCriterion("trs_activity_id <", value, "trsActivityId");
            return (Criteria) this;
        }

        public Criteria andTrsActivityIdLessThanOrEqualTo(Long value) {
            addCriterion("trs_activity_id <=", value, "trsActivityId");
            return (Criteria) this;
        }

        public Criteria andTrsActivityIdIn(List<Long> values) {
            addCriterion("trs_activity_id in", values, "trsActivityId");
            return (Criteria) this;
        }

        public Criteria andTrsActivityIdNotIn(List<Long> values) {
            addCriterion("trs_activity_id not in", values, "trsActivityId");
            return (Criteria) this;
        }

        public Criteria andTrsActivityIdBetween(Long value1, Long value2) {
            addCriterion("trs_activity_id between", value1, value2, "trsActivityId");
            return (Criteria) this;
        }

        public Criteria andTrsActivityIdNotBetween(Long value1, Long value2) {
            addCriterion("trs_activity_id not between", value1, value2, "trsActivityId");
            return (Criteria) this;
        }

        public Criteria andGroupNumIsNull() {
            addCriterion("group_num is null");
            return (Criteria) this;
        }

        public Criteria andGroupNumIsNotNull() {
            addCriterion("group_num is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNumEqualTo(Integer value) {
            addCriterion("group_num =", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumNotEqualTo(Integer value) {
            addCriterion("group_num <>", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumGreaterThan(Integer value) {
            addCriterion("group_num >", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_num >=", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumLessThan(Integer value) {
            addCriterion("group_num <", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumLessThanOrEqualTo(Integer value) {
            addCriterion("group_num <=", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumIn(List<Integer> values) {
            addCriterion("group_num in", values, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumNotIn(List<Integer> values) {
            addCriterion("group_num not in", values, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumBetween(Integer value1, Integer value2) {
            addCriterion("group_num between", value1, value2, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumNotBetween(Integer value1, Integer value2) {
            addCriterion("group_num not between", value1, value2, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupHoursIsNull() {
            addCriterion("group_hours is null");
            return (Criteria) this;
        }

        public Criteria andGroupHoursIsNotNull() {
            addCriterion("group_hours is not null");
            return (Criteria) this;
        }

        public Criteria andGroupHoursEqualTo(Integer value) {
            addCriterion("group_hours =", value, "groupHours");
            return (Criteria) this;
        }

        public Criteria andGroupHoursNotEqualTo(Integer value) {
            addCriterion("group_hours <>", value, "groupHours");
            return (Criteria) this;
        }

        public Criteria andGroupHoursGreaterThan(Integer value) {
            addCriterion("group_hours >", value, "groupHours");
            return (Criteria) this;
        }

        public Criteria andGroupHoursGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_hours >=", value, "groupHours");
            return (Criteria) this;
        }

        public Criteria andGroupHoursLessThan(Integer value) {
            addCriterion("group_hours <", value, "groupHours");
            return (Criteria) this;
        }

        public Criteria andGroupHoursLessThanOrEqualTo(Integer value) {
            addCriterion("group_hours <=", value, "groupHours");
            return (Criteria) this;
        }

        public Criteria andGroupHoursIn(List<Integer> values) {
            addCriterion("group_hours in", values, "groupHours");
            return (Criteria) this;
        }

        public Criteria andGroupHoursNotIn(List<Integer> values) {
            addCriterion("group_hours not in", values, "groupHours");
            return (Criteria) this;
        }

        public Criteria andGroupHoursBetween(Integer value1, Integer value2) {
            addCriterion("group_hours between", value1, value2, "groupHours");
            return (Criteria) this;
        }

        public Criteria andGroupHoursNotBetween(Integer value1, Integer value2) {
            addCriterion("group_hours not between", value1, value2, "groupHours");
            return (Criteria) this;
        }

        public Criteria andGroupSaleIsNull() {
            addCriterion("group_sale is null");
            return (Criteria) this;
        }

        public Criteria andGroupSaleIsNotNull() {
            addCriterion("group_sale is not null");
            return (Criteria) this;
        }

        public Criteria andGroupSaleEqualTo(Integer value) {
            addCriterion("group_sale =", value, "groupSale");
            return (Criteria) this;
        }

        public Criteria andGroupSaleNotEqualTo(Integer value) {
            addCriterion("group_sale <>", value, "groupSale");
            return (Criteria) this;
        }

        public Criteria andGroupSaleGreaterThan(Integer value) {
            addCriterion("group_sale >", value, "groupSale");
            return (Criteria) this;
        }

        public Criteria andGroupSaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_sale >=", value, "groupSale");
            return (Criteria) this;
        }

        public Criteria andGroupSaleLessThan(Integer value) {
            addCriterion("group_sale <", value, "groupSale");
            return (Criteria) this;
        }

        public Criteria andGroupSaleLessThanOrEqualTo(Integer value) {
            addCriterion("group_sale <=", value, "groupSale");
            return (Criteria) this;
        }

        public Criteria andGroupSaleIn(List<Integer> values) {
            addCriterion("group_sale in", values, "groupSale");
            return (Criteria) this;
        }

        public Criteria andGroupSaleNotIn(List<Integer> values) {
            addCriterion("group_sale not in", values, "groupSale");
            return (Criteria) this;
        }

        public Criteria andGroupSaleBetween(Integer value1, Integer value2) {
            addCriterion("group_sale between", value1, value2, "groupSale");
            return (Criteria) this;
        }

        public Criteria andGroupSaleNotBetween(Integer value1, Integer value2) {
            addCriterion("group_sale not between", value1, value2, "groupSale");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Long value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Long value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Long> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andBonusIsNull() {
            addCriterion("bonus is null");
            return (Criteria) this;
        }

        public Criteria andBonusIsNotNull() {
            addCriterion("bonus is not null");
            return (Criteria) this;
        }

        public Criteria andBonusEqualTo(Long value) {
            addCriterion("bonus =", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotEqualTo(Long value) {
            addCriterion("bonus <>", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusGreaterThan(Long value) {
            addCriterion("bonus >", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusGreaterThanOrEqualTo(Long value) {
            addCriterion("bonus >=", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusLessThan(Long value) {
            addCriterion("bonus <", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusLessThanOrEqualTo(Long value) {
            addCriterion("bonus <=", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusIn(List<Long> values) {
            addCriterion("bonus in", values, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotIn(List<Long> values) {
            addCriterion("bonus not in", values, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusBetween(Long value1, Long value2) {
            addCriterion("bonus between", value1, value2, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotBetween(Long value1, Long value2) {
            addCriterion("bonus not between", value1, value2, "bonus");
            return (Criteria) this;
        }

        public Criteria andTeacherBonusIsNull() {
            addCriterion("teacher_bonus is null");
            return (Criteria) this;
        }

        public Criteria andTeacherBonusIsNotNull() {
            addCriterion("teacher_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherBonusEqualTo(Long value) {
            addCriterion("teacher_bonus =", value, "teacherBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherBonusNotEqualTo(Long value) {
            addCriterion("teacher_bonus <>", value, "teacherBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherBonusGreaterThan(Long value) {
            addCriterion("teacher_bonus >", value, "teacherBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherBonusGreaterThanOrEqualTo(Long value) {
            addCriterion("teacher_bonus >=", value, "teacherBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherBonusLessThan(Long value) {
            addCriterion("teacher_bonus <", value, "teacherBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherBonusLessThanOrEqualTo(Long value) {
            addCriterion("teacher_bonus <=", value, "teacherBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherBonusIn(List<Long> values) {
            addCriterion("teacher_bonus in", values, "teacherBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherBonusNotIn(List<Long> values) {
            addCriterion("teacher_bonus not in", values, "teacherBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherBonusBetween(Long value1, Long value2) {
            addCriterion("teacher_bonus between", value1, value2, "teacherBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherBonusNotBetween(Long value1, Long value2) {
            addCriterion("teacher_bonus not between", value1, value2, "teacherBonus");
            return (Criteria) this;
        }

        public Criteria andGroupCommissionIsNull() {
            addCriterion("group_commission is null");
            return (Criteria) this;
        }

        public Criteria andGroupCommissionIsNotNull() {
            addCriterion("group_commission is not null");
            return (Criteria) this;
        }

        public Criteria andGroupCommissionEqualTo(Integer value) {
            addCriterion("group_commission =", value, "groupCommission");
            return (Criteria) this;
        }

        public Criteria andGroupCommissionNotEqualTo(Integer value) {
            addCriterion("group_commission <>", value, "groupCommission");
            return (Criteria) this;
        }

        public Criteria andGroupCommissionGreaterThan(Integer value) {
            addCriterion("group_commission >", value, "groupCommission");
            return (Criteria) this;
        }

        public Criteria andGroupCommissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_commission >=", value, "groupCommission");
            return (Criteria) this;
        }

        public Criteria andGroupCommissionLessThan(Integer value) {
            addCriterion("group_commission <", value, "groupCommission");
            return (Criteria) this;
        }

        public Criteria andGroupCommissionLessThanOrEqualTo(Integer value) {
            addCriterion("group_commission <=", value, "groupCommission");
            return (Criteria) this;
        }

        public Criteria andGroupCommissionIn(List<Integer> values) {
            addCriterion("group_commission in", values, "groupCommission");
            return (Criteria) this;
        }

        public Criteria andGroupCommissionNotIn(List<Integer> values) {
            addCriterion("group_commission not in", values, "groupCommission");
            return (Criteria) this;
        }

        public Criteria andGroupCommissionBetween(Integer value1, Integer value2) {
            addCriterion("group_commission between", value1, value2, "groupCommission");
            return (Criteria) this;
        }

        public Criteria andGroupCommissionNotBetween(Integer value1, Integer value2) {
            addCriterion("group_commission not between", value1, value2, "groupCommission");
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