package com.macro.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrsPagesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TrsPagesExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSubNameIsNull() {
            addCriterion("sub_name is null");
            return (Criteria) this;
        }

        public Criteria andSubNameIsNotNull() {
            addCriterion("sub_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubNameEqualTo(String value) {
            addCriterion("sub_name =", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotEqualTo(String value) {
            addCriterion("sub_name <>", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameGreaterThan(String value) {
            addCriterion("sub_name >", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameGreaterThanOrEqualTo(String value) {
            addCriterion("sub_name >=", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameLessThan(String value) {
            addCriterion("sub_name <", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameLessThanOrEqualTo(String value) {
            addCriterion("sub_name <=", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameLike(String value) {
            addCriterion("sub_name like", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotLike(String value) {
            addCriterion("sub_name not like", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameIn(List<String> values) {
            addCriterion("sub_name in", values, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotIn(List<String> values) {
            addCriterion("sub_name not in", values, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameBetween(String value1, String value2) {
            addCriterion("sub_name between", value1, value2, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotBetween(String value1, String value2) {
            addCriterion("sub_name not between", value1, value2, "subName");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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

        public Criteria andShowSchNumIsNull() {
            addCriterion("show_sch_num is null");
            return (Criteria) this;
        }

        public Criteria andShowSchNumIsNotNull() {
            addCriterion("show_sch_num is not null");
            return (Criteria) this;
        }

        public Criteria andShowSchNumEqualTo(Integer value) {
            addCriterion("show_sch_num =", value, "showSchNum");
            return (Criteria) this;
        }

        public Criteria andShowSchNumNotEqualTo(Integer value) {
            addCriterion("show_sch_num <>", value, "showSchNum");
            return (Criteria) this;
        }

        public Criteria andShowSchNumGreaterThan(Integer value) {
            addCriterion("show_sch_num >", value, "showSchNum");
            return (Criteria) this;
        }

        public Criteria andShowSchNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_sch_num >=", value, "showSchNum");
            return (Criteria) this;
        }

        public Criteria andShowSchNumLessThan(Integer value) {
            addCriterion("show_sch_num <", value, "showSchNum");
            return (Criteria) this;
        }

        public Criteria andShowSchNumLessThanOrEqualTo(Integer value) {
            addCriterion("show_sch_num <=", value, "showSchNum");
            return (Criteria) this;
        }

        public Criteria andShowSchNumIn(List<Integer> values) {
            addCriterion("show_sch_num in", values, "showSchNum");
            return (Criteria) this;
        }

        public Criteria andShowSchNumNotIn(List<Integer> values) {
            addCriterion("show_sch_num not in", values, "showSchNum");
            return (Criteria) this;
        }

        public Criteria andShowSchNumBetween(Integer value1, Integer value2) {
            addCriterion("show_sch_num between", value1, value2, "showSchNum");
            return (Criteria) this;
        }

        public Criteria andShowSchNumNotBetween(Integer value1, Integer value2) {
            addCriterion("show_sch_num not between", value1, value2, "showSchNum");
            return (Criteria) this;
        }

        public Criteria andShowCrsNumIsNull() {
            addCriterion("show_crs_num is null");
            return (Criteria) this;
        }

        public Criteria andShowCrsNumIsNotNull() {
            addCriterion("show_crs_num is not null");
            return (Criteria) this;
        }

        public Criteria andShowCrsNumEqualTo(Integer value) {
            addCriterion("show_crs_num =", value, "showCrsNum");
            return (Criteria) this;
        }

        public Criteria andShowCrsNumNotEqualTo(Integer value) {
            addCriterion("show_crs_num <>", value, "showCrsNum");
            return (Criteria) this;
        }

        public Criteria andShowCrsNumGreaterThan(Integer value) {
            addCriterion("show_crs_num >", value, "showCrsNum");
            return (Criteria) this;
        }

        public Criteria andShowCrsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_crs_num >=", value, "showCrsNum");
            return (Criteria) this;
        }

        public Criteria andShowCrsNumLessThan(Integer value) {
            addCriterion("show_crs_num <", value, "showCrsNum");
            return (Criteria) this;
        }

        public Criteria andShowCrsNumLessThanOrEqualTo(Integer value) {
            addCriterion("show_crs_num <=", value, "showCrsNum");
            return (Criteria) this;
        }

        public Criteria andShowCrsNumIn(List<Integer> values) {
            addCriterion("show_crs_num in", values, "showCrsNum");
            return (Criteria) this;
        }

        public Criteria andShowCrsNumNotIn(List<Integer> values) {
            addCriterion("show_crs_num not in", values, "showCrsNum");
            return (Criteria) this;
        }

        public Criteria andShowCrsNumBetween(Integer value1, Integer value2) {
            addCriterion("show_crs_num between", value1, value2, "showCrsNum");
            return (Criteria) this;
        }

        public Criteria andShowCrsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("show_crs_num not between", value1, value2, "showCrsNum");
            return (Criteria) this;
        }

        public Criteria andIncomeRankingIsNull() {
            addCriterion("income_ranking is null");
            return (Criteria) this;
        }

        public Criteria andIncomeRankingIsNotNull() {
            addCriterion("income_ranking is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeRankingEqualTo(Integer value) {
            addCriterion("income_ranking =", value, "incomeRanking");
            return (Criteria) this;
        }

        public Criteria andIncomeRankingNotEqualTo(Integer value) {
            addCriterion("income_ranking <>", value, "incomeRanking");
            return (Criteria) this;
        }

        public Criteria andIncomeRankingGreaterThan(Integer value) {
            addCriterion("income_ranking >", value, "incomeRanking");
            return (Criteria) this;
        }

        public Criteria andIncomeRankingGreaterThanOrEqualTo(Integer value) {
            addCriterion("income_ranking >=", value, "incomeRanking");
            return (Criteria) this;
        }

        public Criteria andIncomeRankingLessThan(Integer value) {
            addCriterion("income_ranking <", value, "incomeRanking");
            return (Criteria) this;
        }

        public Criteria andIncomeRankingLessThanOrEqualTo(Integer value) {
            addCriterion("income_ranking <=", value, "incomeRanking");
            return (Criteria) this;
        }

        public Criteria andIncomeRankingIn(List<Integer> values) {
            addCriterion("income_ranking in", values, "incomeRanking");
            return (Criteria) this;
        }

        public Criteria andIncomeRankingNotIn(List<Integer> values) {
            addCriterion("income_ranking not in", values, "incomeRanking");
            return (Criteria) this;
        }

        public Criteria andIncomeRankingBetween(Integer value1, Integer value2) {
            addCriterion("income_ranking between", value1, value2, "incomeRanking");
            return (Criteria) this;
        }

        public Criteria andIncomeRankingNotBetween(Integer value1, Integer value2) {
            addCriterion("income_ranking not between", value1, value2, "incomeRanking");
            return (Criteria) this;
        }

        public Criteria andShowBookingIsNull() {
            addCriterion("show_booking is null");
            return (Criteria) this;
        }

        public Criteria andShowBookingIsNotNull() {
            addCriterion("show_booking is not null");
            return (Criteria) this;
        }

        public Criteria andShowBookingEqualTo(Integer value) {
            addCriterion("show_booking =", value, "showBooking");
            return (Criteria) this;
        }

        public Criteria andShowBookingNotEqualTo(Integer value) {
            addCriterion("show_booking <>", value, "showBooking");
            return (Criteria) this;
        }

        public Criteria andShowBookingGreaterThan(Integer value) {
            addCriterion("show_booking >", value, "showBooking");
            return (Criteria) this;
        }

        public Criteria andShowBookingGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_booking >=", value, "showBooking");
            return (Criteria) this;
        }

        public Criteria andShowBookingLessThan(Integer value) {
            addCriterion("show_booking <", value, "showBooking");
            return (Criteria) this;
        }

        public Criteria andShowBookingLessThanOrEqualTo(Integer value) {
            addCriterion("show_booking <=", value, "showBooking");
            return (Criteria) this;
        }

        public Criteria andShowBookingIn(List<Integer> values) {
            addCriterion("show_booking in", values, "showBooking");
            return (Criteria) this;
        }

        public Criteria andShowBookingNotIn(List<Integer> values) {
            addCriterion("show_booking not in", values, "showBooking");
            return (Criteria) this;
        }

        public Criteria andShowBookingBetween(Integer value1, Integer value2) {
            addCriterion("show_booking between", value1, value2, "showBooking");
            return (Criteria) this;
        }

        public Criteria andShowBookingNotBetween(Integer value1, Integer value2) {
            addCriterion("show_booking not between", value1, value2, "showBooking");
            return (Criteria) this;
        }

        public Criteria andShowMyIncomeIsNull() {
            addCriterion("show_my_income is null");
            return (Criteria) this;
        }

        public Criteria andShowMyIncomeIsNotNull() {
            addCriterion("show_my_income is not null");
            return (Criteria) this;
        }

        public Criteria andShowMyIncomeEqualTo(Integer value) {
            addCriterion("show_my_income =", value, "showMyIncome");
            return (Criteria) this;
        }

        public Criteria andShowMyIncomeNotEqualTo(Integer value) {
            addCriterion("show_my_income <>", value, "showMyIncome");
            return (Criteria) this;
        }

        public Criteria andShowMyIncomeGreaterThan(Integer value) {
            addCriterion("show_my_income >", value, "showMyIncome");
            return (Criteria) this;
        }

        public Criteria andShowMyIncomeGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_my_income >=", value, "showMyIncome");
            return (Criteria) this;
        }

        public Criteria andShowMyIncomeLessThan(Integer value) {
            addCriterion("show_my_income <", value, "showMyIncome");
            return (Criteria) this;
        }

        public Criteria andShowMyIncomeLessThanOrEqualTo(Integer value) {
            addCriterion("show_my_income <=", value, "showMyIncome");
            return (Criteria) this;
        }

        public Criteria andShowMyIncomeIn(List<Integer> values) {
            addCriterion("show_my_income in", values, "showMyIncome");
            return (Criteria) this;
        }

        public Criteria andShowMyIncomeNotIn(List<Integer> values) {
            addCriterion("show_my_income not in", values, "showMyIncome");
            return (Criteria) this;
        }

        public Criteria andShowMyIncomeBetween(Integer value1, Integer value2) {
            addCriterion("show_my_income between", value1, value2, "showMyIncome");
            return (Criteria) this;
        }

        public Criteria andShowMyIncomeNotBetween(Integer value1, Integer value2) {
            addCriterion("show_my_income not between", value1, value2, "showMyIncome");
            return (Criteria) this;
        }

        public Criteria andDayLimitIsNull() {
            addCriterion("day_limit is null");
            return (Criteria) this;
        }

        public Criteria andDayLimitIsNotNull() {
            addCriterion("day_limit is not null");
            return (Criteria) this;
        }

        public Criteria andDayLimitEqualTo(Integer value) {
            addCriterion("day_limit =", value, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitNotEqualTo(Integer value) {
            addCriterion("day_limit <>", value, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitGreaterThan(Integer value) {
            addCriterion("day_limit >", value, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("day_limit >=", value, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitLessThan(Integer value) {
            addCriterion("day_limit <", value, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitLessThanOrEqualTo(Integer value) {
            addCriterion("day_limit <=", value, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitIn(List<Integer> values) {
            addCriterion("day_limit in", values, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitNotIn(List<Integer> values) {
            addCriterion("day_limit not in", values, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitBetween(Integer value1, Integer value2) {
            addCriterion("day_limit between", value1, value2, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("day_limit not between", value1, value2, "dayLimit");
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