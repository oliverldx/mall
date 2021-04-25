package com.macro.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TosOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TosOrderExample() {
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("total_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("total_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(Long value) {
            addCriterion("total_money =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(Long value) {
            addCriterion("total_money <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(Long value) {
            addCriterion("total_money >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("total_money >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(Long value) {
            addCriterion("total_money <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(Long value) {
            addCriterion("total_money <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<Long> values) {
            addCriterion("total_money in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<Long> values) {
            addCriterion("total_money not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(Long value1, Long value2) {
            addCriterion("total_money between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(Long value1, Long value2) {
            addCriterion("total_money not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andDistributionMoneyIsNull() {
            addCriterion("distribution_money is null");
            return (Criteria) this;
        }

        public Criteria andDistributionMoneyIsNotNull() {
            addCriterion("distribution_money is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionMoneyEqualTo(Long value) {
            addCriterion("distribution_money =", value, "distributionMoney");
            return (Criteria) this;
        }

        public Criteria andDistributionMoneyNotEqualTo(Long value) {
            addCriterion("distribution_money <>", value, "distributionMoney");
            return (Criteria) this;
        }

        public Criteria andDistributionMoneyGreaterThan(Long value) {
            addCriterion("distribution_money >", value, "distributionMoney");
            return (Criteria) this;
        }

        public Criteria andDistributionMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("distribution_money >=", value, "distributionMoney");
            return (Criteria) this;
        }

        public Criteria andDistributionMoneyLessThan(Long value) {
            addCriterion("distribution_money <", value, "distributionMoney");
            return (Criteria) this;
        }

        public Criteria andDistributionMoneyLessThanOrEqualTo(Long value) {
            addCriterion("distribution_money <=", value, "distributionMoney");
            return (Criteria) this;
        }

        public Criteria andDistributionMoneyIn(List<Long> values) {
            addCriterion("distribution_money in", values, "distributionMoney");
            return (Criteria) this;
        }

        public Criteria andDistributionMoneyNotIn(List<Long> values) {
            addCriterion("distribution_money not in", values, "distributionMoney");
            return (Criteria) this;
        }

        public Criteria andDistributionMoneyBetween(Long value1, Long value2) {
            addCriterion("distribution_money between", value1, value2, "distributionMoney");
            return (Criteria) this;
        }

        public Criteria andDistributionMoneyNotBetween(Long value1, Long value2) {
            addCriterion("distribution_money not between", value1, value2, "distributionMoney");
            return (Criteria) this;
        }

        public Criteria andGroupTimeIsNull() {
            addCriterion("group_time is null");
            return (Criteria) this;
        }

        public Criteria andGroupTimeIsNotNull() {
            addCriterion("group_time is not null");
            return (Criteria) this;
        }

        public Criteria andGroupTimeEqualTo(Date value) {
            addCriterion("group_time =", value, "groupTime");
            return (Criteria) this;
        }

        public Criteria andGroupTimeNotEqualTo(Date value) {
            addCriterion("group_time <>", value, "groupTime");
            return (Criteria) this;
        }

        public Criteria andGroupTimeGreaterThan(Date value) {
            addCriterion("group_time >", value, "groupTime");
            return (Criteria) this;
        }

        public Criteria andGroupTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("group_time >=", value, "groupTime");
            return (Criteria) this;
        }

        public Criteria andGroupTimeLessThan(Date value) {
            addCriterion("group_time <", value, "groupTime");
            return (Criteria) this;
        }

        public Criteria andGroupTimeLessThanOrEqualTo(Date value) {
            addCriterion("group_time <=", value, "groupTime");
            return (Criteria) this;
        }

        public Criteria andGroupTimeIn(List<Date> values) {
            addCriterion("group_time in", values, "groupTime");
            return (Criteria) this;
        }

        public Criteria andGroupTimeNotIn(List<Date> values) {
            addCriterion("group_time not in", values, "groupTime");
            return (Criteria) this;
        }

        public Criteria andGroupTimeBetween(Date value1, Date value2) {
            addCriterion("group_time between", value1, value2, "groupTime");
            return (Criteria) this;
        }

        public Criteria andGroupTimeNotBetween(Date value1, Date value2) {
            addCriterion("group_time not between", value1, value2, "groupTime");
            return (Criteria) this;
        }

        public Criteria andGroupOrderNoIsNull() {
            addCriterion("group_order_no is null");
            return (Criteria) this;
        }

        public Criteria andGroupOrderNoIsNotNull() {
            addCriterion("group_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andGroupOrderNoEqualTo(Integer value) {
            addCriterion("group_order_no =", value, "groupOrderNo");
            return (Criteria) this;
        }

        public Criteria andGroupOrderNoNotEqualTo(Integer value) {
            addCriterion("group_order_no <>", value, "groupOrderNo");
            return (Criteria) this;
        }

        public Criteria andGroupOrderNoGreaterThan(Integer value) {
            addCriterion("group_order_no >", value, "groupOrderNo");
            return (Criteria) this;
        }

        public Criteria andGroupOrderNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_order_no >=", value, "groupOrderNo");
            return (Criteria) this;
        }

        public Criteria andGroupOrderNoLessThan(Integer value) {
            addCriterion("group_order_no <", value, "groupOrderNo");
            return (Criteria) this;
        }

        public Criteria andGroupOrderNoLessThanOrEqualTo(Integer value) {
            addCriterion("group_order_no <=", value, "groupOrderNo");
            return (Criteria) this;
        }

        public Criteria andGroupOrderNoIn(List<Integer> values) {
            addCriterion("group_order_no in", values, "groupOrderNo");
            return (Criteria) this;
        }

        public Criteria andGroupOrderNoNotIn(List<Integer> values) {
            addCriterion("group_order_no not in", values, "groupOrderNo");
            return (Criteria) this;
        }

        public Criteria andGroupOrderNoBetween(Integer value1, Integer value2) {
            addCriterion("group_order_no between", value1, value2, "groupOrderNo");
            return (Criteria) this;
        }

        public Criteria andGroupOrderNoNotBetween(Integer value1, Integer value2) {
            addCriterion("group_order_no not between", value1, value2, "groupOrderNo");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andGroupTypeIsNull() {
            addCriterion("group_type is null");
            return (Criteria) this;
        }

        public Criteria andGroupTypeIsNotNull() {
            addCriterion("group_type is not null");
            return (Criteria) this;
        }

        public Criteria andGroupTypeEqualTo(Integer value) {
            addCriterion("group_type =", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeNotEqualTo(Integer value) {
            addCriterion("group_type <>", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeGreaterThan(Integer value) {
            addCriterion("group_type >", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_type >=", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeLessThan(Integer value) {
            addCriterion("group_type <", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeLessThanOrEqualTo(Integer value) {
            addCriterion("group_type <=", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeIn(List<Integer> values) {
            addCriterion("group_type in", values, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeNotIn(List<Integer> values) {
            addCriterion("group_type not in", values, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeBetween(Integer value1, Integer value2) {
            addCriterion("group_type between", value1, value2, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("group_type not between", value1, value2, "groupType");
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