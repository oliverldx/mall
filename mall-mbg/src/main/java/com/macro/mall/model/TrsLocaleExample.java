package com.macro.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrsLocaleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TrsLocaleExample() {
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

        public Criteria andText3dIsNull() {
            addCriterion("text_3d is null");
            return (Criteria) this;
        }

        public Criteria andText3dIsNotNull() {
            addCriterion("text_3d is not null");
            return (Criteria) this;
        }

        public Criteria andText3dEqualTo(String value) {
            addCriterion("text_3d =", value, "text3d");
            return (Criteria) this;
        }

        public Criteria andText3dNotEqualTo(String value) {
            addCriterion("text_3d <>", value, "text3d");
            return (Criteria) this;
        }

        public Criteria andText3dGreaterThan(String value) {
            addCriterion("text_3d >", value, "text3d");
            return (Criteria) this;
        }

        public Criteria andText3dGreaterThanOrEqualTo(String value) {
            addCriterion("text_3d >=", value, "text3d");
            return (Criteria) this;
        }

        public Criteria andText3dLessThan(String value) {
            addCriterion("text_3d <", value, "text3d");
            return (Criteria) this;
        }

        public Criteria andText3dLessThanOrEqualTo(String value) {
            addCriterion("text_3d <=", value, "text3d");
            return (Criteria) this;
        }

        public Criteria andText3dLike(String value) {
            addCriterion("text_3d like", value, "text3d");
            return (Criteria) this;
        }

        public Criteria andText3dNotLike(String value) {
            addCriterion("text_3d not like", value, "text3d");
            return (Criteria) this;
        }

        public Criteria andText3dIn(List<String> values) {
            addCriterion("text_3d in", values, "text3d");
            return (Criteria) this;
        }

        public Criteria andText3dNotIn(List<String> values) {
            addCriterion("text_3d not in", values, "text3d");
            return (Criteria) this;
        }

        public Criteria andText3dBetween(String value1, String value2) {
            addCriterion("text_3d between", value1, value2, "text3d");
            return (Criteria) this;
        }

        public Criteria andText3dNotBetween(String value1, String value2) {
            addCriterion("text_3d not between", value1, value2, "text3d");
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

        public Criteria andEnableIsNull() {
            addCriterion("enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Integer value) {
            addCriterion("enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Integer value) {
            addCriterion("enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Integer value) {
            addCriterion("enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Integer value) {
            addCriterion("enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Integer value) {
            addCriterion("enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Integer> values) {
            addCriterion("enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Integer> values) {
            addCriterion("enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Integer value1, Integer value2) {
            addCriterion("enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("enable not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andAutoRegTeacheIsNull() {
            addCriterion("auto_reg_teache is null");
            return (Criteria) this;
        }

        public Criteria andAutoRegTeacheIsNotNull() {
            addCriterion("auto_reg_teache is not null");
            return (Criteria) this;
        }

        public Criteria andAutoRegTeacheEqualTo(Integer value) {
            addCriterion("auto_reg_teache =", value, "autoRegTeache");
            return (Criteria) this;
        }

        public Criteria andAutoRegTeacheNotEqualTo(Integer value) {
            addCriterion("auto_reg_teache <>", value, "autoRegTeache");
            return (Criteria) this;
        }

        public Criteria andAutoRegTeacheGreaterThan(Integer value) {
            addCriterion("auto_reg_teache >", value, "autoRegTeache");
            return (Criteria) this;
        }

        public Criteria andAutoRegTeacheGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_reg_teache >=", value, "autoRegTeache");
            return (Criteria) this;
        }

        public Criteria andAutoRegTeacheLessThan(Integer value) {
            addCriterion("auto_reg_teache <", value, "autoRegTeache");
            return (Criteria) this;
        }

        public Criteria andAutoRegTeacheLessThanOrEqualTo(Integer value) {
            addCriterion("auto_reg_teache <=", value, "autoRegTeache");
            return (Criteria) this;
        }

        public Criteria andAutoRegTeacheIn(List<Integer> values) {
            addCriterion("auto_reg_teache in", values, "autoRegTeache");
            return (Criteria) this;
        }

        public Criteria andAutoRegTeacheNotIn(List<Integer> values) {
            addCriterion("auto_reg_teache not in", values, "autoRegTeache");
            return (Criteria) this;
        }

        public Criteria andAutoRegTeacheBetween(Integer value1, Integer value2) {
            addCriterion("auto_reg_teache between", value1, value2, "autoRegTeache");
            return (Criteria) this;
        }

        public Criteria andAutoRegTeacheNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_reg_teache not between", value1, value2, "autoRegTeache");
            return (Criteria) this;
        }

        public Criteria andQrcodeParentsIsNull() {
            addCriterion("qrcode_parents is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeParentsIsNotNull() {
            addCriterion("qrcode_parents is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeParentsEqualTo(Integer value) {
            addCriterion("qrcode_parents =", value, "qrcodeParents");
            return (Criteria) this;
        }

        public Criteria andQrcodeParentsNotEqualTo(Integer value) {
            addCriterion("qrcode_parents <>", value, "qrcodeParents");
            return (Criteria) this;
        }

        public Criteria andQrcodeParentsGreaterThan(Integer value) {
            addCriterion("qrcode_parents >", value, "qrcodeParents");
            return (Criteria) this;
        }

        public Criteria andQrcodeParentsGreaterThanOrEqualTo(Integer value) {
            addCriterion("qrcode_parents >=", value, "qrcodeParents");
            return (Criteria) this;
        }

        public Criteria andQrcodeParentsLessThan(Integer value) {
            addCriterion("qrcode_parents <", value, "qrcodeParents");
            return (Criteria) this;
        }

        public Criteria andQrcodeParentsLessThanOrEqualTo(Integer value) {
            addCriterion("qrcode_parents <=", value, "qrcodeParents");
            return (Criteria) this;
        }

        public Criteria andQrcodeParentsIn(List<Integer> values) {
            addCriterion("qrcode_parents in", values, "qrcodeParents");
            return (Criteria) this;
        }

        public Criteria andQrcodeParentsNotIn(List<Integer> values) {
            addCriterion("qrcode_parents not in", values, "qrcodeParents");
            return (Criteria) this;
        }

        public Criteria andQrcodeParentsBetween(Integer value1, Integer value2) {
            addCriterion("qrcode_parents between", value1, value2, "qrcodeParents");
            return (Criteria) this;
        }

        public Criteria andQrcodeParentsNotBetween(Integer value1, Integer value2) {
            addCriterion("qrcode_parents not between", value1, value2, "qrcodeParents");
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