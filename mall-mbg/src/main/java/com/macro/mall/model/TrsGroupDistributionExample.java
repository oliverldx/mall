package com.macro.mall.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrsGroupDistributionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TrsGroupDistributionExample() {
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

        public Criteria andLevelOneBonusIsNull() {
            addCriterion("level_one_bonus is null");
            return (Criteria) this;
        }

        public Criteria andLevelOneBonusIsNotNull() {
            addCriterion("level_one_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andLevelOneBonusEqualTo(BigDecimal value) {
            addCriterion("level_one_bonus =", value, "levelOneBonus");
            return (Criteria) this;
        }

        public Criteria andLevelOneBonusNotEqualTo(BigDecimal value) {
            addCriterion("level_one_bonus <>", value, "levelOneBonus");
            return (Criteria) this;
        }

        public Criteria andLevelOneBonusGreaterThan(BigDecimal value) {
            addCriterion("level_one_bonus >", value, "levelOneBonus");
            return (Criteria) this;
        }

        public Criteria andLevelOneBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("level_one_bonus >=", value, "levelOneBonus");
            return (Criteria) this;
        }

        public Criteria andLevelOneBonusLessThan(BigDecimal value) {
            addCriterion("level_one_bonus <", value, "levelOneBonus");
            return (Criteria) this;
        }

        public Criteria andLevelOneBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("level_one_bonus <=", value, "levelOneBonus");
            return (Criteria) this;
        }

        public Criteria andLevelOneBonusIn(List<BigDecimal> values) {
            addCriterion("level_one_bonus in", values, "levelOneBonus");
            return (Criteria) this;
        }

        public Criteria andLevelOneBonusNotIn(List<BigDecimal> values) {
            addCriterion("level_one_bonus not in", values, "levelOneBonus");
            return (Criteria) this;
        }

        public Criteria andLevelOneBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_one_bonus between", value1, value2, "levelOneBonus");
            return (Criteria) this;
        }

        public Criteria andLevelOneBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_one_bonus not between", value1, value2, "levelOneBonus");
            return (Criteria) this;
        }

        public Criteria andLevelTwoBonusIsNull() {
            addCriterion("level_two_bonus is null");
            return (Criteria) this;
        }

        public Criteria andLevelTwoBonusIsNotNull() {
            addCriterion("level_two_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andLevelTwoBonusEqualTo(BigDecimal value) {
            addCriterion("level_two_bonus =", value, "levelTwoBonus");
            return (Criteria) this;
        }

        public Criteria andLevelTwoBonusNotEqualTo(BigDecimal value) {
            addCriterion("level_two_bonus <>", value, "levelTwoBonus");
            return (Criteria) this;
        }

        public Criteria andLevelTwoBonusGreaterThan(BigDecimal value) {
            addCriterion("level_two_bonus >", value, "levelTwoBonus");
            return (Criteria) this;
        }

        public Criteria andLevelTwoBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("level_two_bonus >=", value, "levelTwoBonus");
            return (Criteria) this;
        }

        public Criteria andLevelTwoBonusLessThan(BigDecimal value) {
            addCriterion("level_two_bonus <", value, "levelTwoBonus");
            return (Criteria) this;
        }

        public Criteria andLevelTwoBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("level_two_bonus <=", value, "levelTwoBonus");
            return (Criteria) this;
        }

        public Criteria andLevelTwoBonusIn(List<BigDecimal> values) {
            addCriterion("level_two_bonus in", values, "levelTwoBonus");
            return (Criteria) this;
        }

        public Criteria andLevelTwoBonusNotIn(List<BigDecimal> values) {
            addCriterion("level_two_bonus not in", values, "levelTwoBonus");
            return (Criteria) this;
        }

        public Criteria andLevelTwoBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_two_bonus between", value1, value2, "levelTwoBonus");
            return (Criteria) this;
        }

        public Criteria andLevelTwoBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_two_bonus not between", value1, value2, "levelTwoBonus");
            return (Criteria) this;
        }

        public Criteria andGroupDistributionIsNull() {
            addCriterion("group_distribution is null");
            return (Criteria) this;
        }

        public Criteria andGroupDistributionIsNotNull() {
            addCriterion("group_distribution is not null");
            return (Criteria) this;
        }

        public Criteria andGroupDistributionEqualTo(Integer value) {
            addCriterion("group_distribution =", value, "groupDistribution");
            return (Criteria) this;
        }

        public Criteria andGroupDistributionNotEqualTo(Integer value) {
            addCriterion("group_distribution <>", value, "groupDistribution");
            return (Criteria) this;
        }

        public Criteria andGroupDistributionGreaterThan(Integer value) {
            addCriterion("group_distribution >", value, "groupDistribution");
            return (Criteria) this;
        }

        public Criteria andGroupDistributionGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_distribution >=", value, "groupDistribution");
            return (Criteria) this;
        }

        public Criteria andGroupDistributionLessThan(Integer value) {
            addCriterion("group_distribution <", value, "groupDistribution");
            return (Criteria) this;
        }

        public Criteria andGroupDistributionLessThanOrEqualTo(Integer value) {
            addCriterion("group_distribution <=", value, "groupDistribution");
            return (Criteria) this;
        }

        public Criteria andGroupDistributionIn(List<Integer> values) {
            addCriterion("group_distribution in", values, "groupDistribution");
            return (Criteria) this;
        }

        public Criteria andGroupDistributionNotIn(List<Integer> values) {
            addCriterion("group_distribution not in", values, "groupDistribution");
            return (Criteria) this;
        }

        public Criteria andGroupDistributionBetween(Integer value1, Integer value2) {
            addCriterion("group_distribution between", value1, value2, "groupDistribution");
            return (Criteria) this;
        }

        public Criteria andGroupDistributionNotBetween(Integer value1, Integer value2) {
            addCriterion("group_distribution not between", value1, value2, "groupDistribution");
            return (Criteria) this;
        }

        public Criteria andTeacherLoneBonusIsNull() {
            addCriterion("teacher_lone_bonus is null");
            return (Criteria) this;
        }

        public Criteria andTeacherLoneBonusIsNotNull() {
            addCriterion("teacher_lone_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherLoneBonusEqualTo(BigDecimal value) {
            addCriterion("teacher_lone_bonus =", value, "teacherLoneBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLoneBonusNotEqualTo(BigDecimal value) {
            addCriterion("teacher_lone_bonus <>", value, "teacherLoneBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLoneBonusGreaterThan(BigDecimal value) {
            addCriterion("teacher_lone_bonus >", value, "teacherLoneBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLoneBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("teacher_lone_bonus >=", value, "teacherLoneBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLoneBonusLessThan(BigDecimal value) {
            addCriterion("teacher_lone_bonus <", value, "teacherLoneBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLoneBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("teacher_lone_bonus <=", value, "teacherLoneBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLoneBonusIn(List<BigDecimal> values) {
            addCriterion("teacher_lone_bonus in", values, "teacherLoneBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLoneBonusNotIn(List<BigDecimal> values) {
            addCriterion("teacher_lone_bonus not in", values, "teacherLoneBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLoneBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("teacher_lone_bonus between", value1, value2, "teacherLoneBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLoneBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("teacher_lone_bonus not between", value1, value2, "teacherLoneBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLtwoBonusIsNull() {
            addCriterion("teacher_ltwo_bonus is null");
            return (Criteria) this;
        }

        public Criteria andTeacherLtwoBonusIsNotNull() {
            addCriterion("teacher_ltwo_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherLtwoBonusEqualTo(BigDecimal value) {
            addCriterion("teacher_ltwo_bonus =", value, "teacherLtwoBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLtwoBonusNotEqualTo(BigDecimal value) {
            addCriterion("teacher_ltwo_bonus <>", value, "teacherLtwoBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLtwoBonusGreaterThan(BigDecimal value) {
            addCriterion("teacher_ltwo_bonus >", value, "teacherLtwoBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLtwoBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("teacher_ltwo_bonus >=", value, "teacherLtwoBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLtwoBonusLessThan(BigDecimal value) {
            addCriterion("teacher_ltwo_bonus <", value, "teacherLtwoBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLtwoBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("teacher_ltwo_bonus <=", value, "teacherLtwoBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLtwoBonusIn(List<BigDecimal> values) {
            addCriterion("teacher_ltwo_bonus in", values, "teacherLtwoBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLtwoBonusNotIn(List<BigDecimal> values) {
            addCriterion("teacher_ltwo_bonus not in", values, "teacherLtwoBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLtwoBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("teacher_ltwo_bonus between", value1, value2, "teacherLtwoBonus");
            return (Criteria) this;
        }

        public Criteria andTeacherLtwoBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("teacher_ltwo_bonus not between", value1, value2, "teacherLtwoBonus");
            return (Criteria) this;
        }

        public Criteria andBindLevelTimeIsNull() {
            addCriterion("bind_level_time is null");
            return (Criteria) this;
        }

        public Criteria andBindLevelTimeIsNotNull() {
            addCriterion("bind_level_time is not null");
            return (Criteria) this;
        }

        public Criteria andBindLevelTimeEqualTo(Integer value) {
            addCriterion("bind_level_time =", value, "bindLevelTime");
            return (Criteria) this;
        }

        public Criteria andBindLevelTimeNotEqualTo(Integer value) {
            addCriterion("bind_level_time <>", value, "bindLevelTime");
            return (Criteria) this;
        }

        public Criteria andBindLevelTimeGreaterThan(Integer value) {
            addCriterion("bind_level_time >", value, "bindLevelTime");
            return (Criteria) this;
        }

        public Criteria andBindLevelTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("bind_level_time >=", value, "bindLevelTime");
            return (Criteria) this;
        }

        public Criteria andBindLevelTimeLessThan(Integer value) {
            addCriterion("bind_level_time <", value, "bindLevelTime");
            return (Criteria) this;
        }

        public Criteria andBindLevelTimeLessThanOrEqualTo(Integer value) {
            addCriterion("bind_level_time <=", value, "bindLevelTime");
            return (Criteria) this;
        }

        public Criteria andBindLevelTimeIn(List<Integer> values) {
            addCriterion("bind_level_time in", values, "bindLevelTime");
            return (Criteria) this;
        }

        public Criteria andBindLevelTimeNotIn(List<Integer> values) {
            addCriterion("bind_level_time not in", values, "bindLevelTime");
            return (Criteria) this;
        }

        public Criteria andBindLevelTimeBetween(Integer value1, Integer value2) {
            addCriterion("bind_level_time between", value1, value2, "bindLevelTime");
            return (Criteria) this;
        }

        public Criteria andBindLevelTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("bind_level_time not between", value1, value2, "bindLevelTime");
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

        public Criteria andDistributionAfterBuyIsNull() {
            addCriterion("distribution_after_buy is null");
            return (Criteria) this;
        }

        public Criteria andDistributionAfterBuyIsNotNull() {
            addCriterion("distribution_after_buy is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionAfterBuyEqualTo(Integer value) {
            addCriterion("distribution_after_buy =", value, "distributionAfterBuy");
            return (Criteria) this;
        }

        public Criteria andDistributionAfterBuyNotEqualTo(Integer value) {
            addCriterion("distribution_after_buy <>", value, "distributionAfterBuy");
            return (Criteria) this;
        }

        public Criteria andDistributionAfterBuyGreaterThan(Integer value) {
            addCriterion("distribution_after_buy >", value, "distributionAfterBuy");
            return (Criteria) this;
        }

        public Criteria andDistributionAfterBuyGreaterThanOrEqualTo(Integer value) {
            addCriterion("distribution_after_buy >=", value, "distributionAfterBuy");
            return (Criteria) this;
        }

        public Criteria andDistributionAfterBuyLessThan(Integer value) {
            addCriterion("distribution_after_buy <", value, "distributionAfterBuy");
            return (Criteria) this;
        }

        public Criteria andDistributionAfterBuyLessThanOrEqualTo(Integer value) {
            addCriterion("distribution_after_buy <=", value, "distributionAfterBuy");
            return (Criteria) this;
        }

        public Criteria andDistributionAfterBuyIn(List<Integer> values) {
            addCriterion("distribution_after_buy in", values, "distributionAfterBuy");
            return (Criteria) this;
        }

        public Criteria andDistributionAfterBuyNotIn(List<Integer> values) {
            addCriterion("distribution_after_buy not in", values, "distributionAfterBuy");
            return (Criteria) this;
        }

        public Criteria andDistributionAfterBuyBetween(Integer value1, Integer value2) {
            addCriterion("distribution_after_buy between", value1, value2, "distributionAfterBuy");
            return (Criteria) this;
        }

        public Criteria andDistributionAfterBuyNotBetween(Integer value1, Integer value2) {
            addCriterion("distribution_after_buy not between", value1, value2, "distributionAfterBuy");
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