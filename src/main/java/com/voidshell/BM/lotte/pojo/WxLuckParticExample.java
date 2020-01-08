package com.voidshell.BM.lotte.pojo;

import java.util.ArrayList;
import java.util.List;

public class WxLuckParticExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WxLuckParticExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLotteidIsNull() {
            addCriterion("lotteId is null");
            return (Criteria) this;
        }

        public Criteria andLotteidIsNotNull() {
            addCriterion("lotteId is not null");
            return (Criteria) this;
        }

        public Criteria andLotteidEqualTo(String value) {
            addCriterion("lotteId =", value, "lotteid");
            return (Criteria) this;
        }

        public Criteria andLotteidNotEqualTo(String value) {
            addCriterion("lotteId <>", value, "lotteid");
            return (Criteria) this;
        }

        public Criteria andLotteidGreaterThan(String value) {
            addCriterion("lotteId >", value, "lotteid");
            return (Criteria) this;
        }

        public Criteria andLotteidGreaterThanOrEqualTo(String value) {
            addCriterion("lotteId >=", value, "lotteid");
            return (Criteria) this;
        }

        public Criteria andLotteidLessThan(String value) {
            addCriterion("lotteId <", value, "lotteid");
            return (Criteria) this;
        }

        public Criteria andLotteidLessThanOrEqualTo(String value) {
            addCriterion("lotteId <=", value, "lotteid");
            return (Criteria) this;
        }

        public Criteria andLotteidLike(String value) {
            addCriterion("lotteId like", value, "lotteid");
            return (Criteria) this;
        }

        public Criteria andLotteidNotLike(String value) {
            addCriterion("lotteId not like", value, "lotteid");
            return (Criteria) this;
        }

        public Criteria andLotteidIn(List<String> values) {
            addCriterion("lotteId in", values, "lotteid");
            return (Criteria) this;
        }

        public Criteria andLotteidNotIn(List<String> values) {
            addCriterion("lotteId not in", values, "lotteid");
            return (Criteria) this;
        }

        public Criteria andLotteidBetween(String value1, String value2) {
            addCriterion("lotteId between", value1, value2, "lotteid");
            return (Criteria) this;
        }

        public Criteria andLotteidNotBetween(String value1, String value2) {
            addCriterion("lotteId not between", value1, value2, "lotteid");
            return (Criteria) this;
        }

        public Criteria andLotteitemidIsNull() {
            addCriterion("lotteItemId is null");
            return (Criteria) this;
        }

        public Criteria andLotteitemidIsNotNull() {
            addCriterion("lotteItemId is not null");
            return (Criteria) this;
        }

        public Criteria andLotteitemidEqualTo(String value) {
            addCriterion("lotteItemId =", value, "lotteitemid");
            return (Criteria) this;
        }

        public Criteria andLotteitemidNotEqualTo(String value) {
            addCriterion("lotteItemId <>", value, "lotteitemid");
            return (Criteria) this;
        }

        public Criteria andLotteitemidGreaterThan(String value) {
            addCriterion("lotteItemId >", value, "lotteitemid");
            return (Criteria) this;
        }

        public Criteria andLotteitemidGreaterThanOrEqualTo(String value) {
            addCriterion("lotteItemId >=", value, "lotteitemid");
            return (Criteria) this;
        }

        public Criteria andLotteitemidLessThan(String value) {
            addCriterion("lotteItemId <", value, "lotteitemid");
            return (Criteria) this;
        }

        public Criteria andLotteitemidLessThanOrEqualTo(String value) {
            addCriterion("lotteItemId <=", value, "lotteitemid");
            return (Criteria) this;
        }

        public Criteria andLotteitemidLike(String value) {
            addCriterion("lotteItemId like", value, "lotteitemid");
            return (Criteria) this;
        }

        public Criteria andLotteitemidNotLike(String value) {
            addCriterion("lotteItemId not like", value, "lotteitemid");
            return (Criteria) this;
        }

        public Criteria andLotteitemidIn(List<String> values) {
            addCriterion("lotteItemId in", values, "lotteitemid");
            return (Criteria) this;
        }

        public Criteria andLotteitemidNotIn(List<String> values) {
            addCriterion("lotteItemId not in", values, "lotteitemid");
            return (Criteria) this;
        }

        public Criteria andLotteitemidBetween(String value1, String value2) {
            addCriterion("lotteItemId between", value1, value2, "lotteitemid");
            return (Criteria) this;
        }

        public Criteria andLotteitemidNotBetween(String value1, String value2) {
            addCriterion("lotteItemId not between", value1, value2, "lotteitemid");
            return (Criteria) this;
        }

        public Criteria andParticidIsNull() {
            addCriterion("particId is null");
            return (Criteria) this;
        }

        public Criteria andParticidIsNotNull() {
            addCriterion("particId is not null");
            return (Criteria) this;
        }

        public Criteria andParticidEqualTo(String value) {
            addCriterion("particId =", value, "particid");
            return (Criteria) this;
        }

        public Criteria andParticidNotEqualTo(String value) {
            addCriterion("particId <>", value, "particid");
            return (Criteria) this;
        }

        public Criteria andParticidGreaterThan(String value) {
            addCriterion("particId >", value, "particid");
            return (Criteria) this;
        }

        public Criteria andParticidGreaterThanOrEqualTo(String value) {
            addCriterion("particId >=", value, "particid");
            return (Criteria) this;
        }

        public Criteria andParticidLessThan(String value) {
            addCriterion("particId <", value, "particid");
            return (Criteria) this;
        }

        public Criteria andParticidLessThanOrEqualTo(String value) {
            addCriterion("particId <=", value, "particid");
            return (Criteria) this;
        }

        public Criteria andParticidLike(String value) {
            addCriterion("particId like", value, "particid");
            return (Criteria) this;
        }

        public Criteria andParticidNotLike(String value) {
            addCriterion("particId not like", value, "particid");
            return (Criteria) this;
        }

        public Criteria andParticidIn(List<String> values) {
            addCriterion("particId in", values, "particid");
            return (Criteria) this;
        }

        public Criteria andParticidNotIn(List<String> values) {
            addCriterion("particId not in", values, "particid");
            return (Criteria) this;
        }

        public Criteria andParticidBetween(String value1, String value2) {
            addCriterion("particId between", value1, value2, "particid");
            return (Criteria) this;
        }

        public Criteria andParticidNotBetween(String value1, String value2) {
            addCriterion("particId not between", value1, value2, "particid");
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

        public Criteria andItemnameIsNull() {
            addCriterion("itemName is null");
            return (Criteria) this;
        }

        public Criteria andItemnameIsNotNull() {
            addCriterion("itemName is not null");
            return (Criteria) this;
        }

        public Criteria andItemnameEqualTo(String value) {
            addCriterion("itemName =", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotEqualTo(String value) {
            addCriterion("itemName <>", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameGreaterThan(String value) {
            addCriterion("itemName >", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameGreaterThanOrEqualTo(String value) {
            addCriterion("itemName >=", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLessThan(String value) {
            addCriterion("itemName <", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLessThanOrEqualTo(String value) {
            addCriterion("itemName <=", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLike(String value) {
            addCriterion("itemName like", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotLike(String value) {
            addCriterion("itemName not like", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameIn(List<String> values) {
            addCriterion("itemName in", values, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotIn(List<String> values) {
            addCriterion("itemName not in", values, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameBetween(String value1, String value2) {
            addCriterion("itemName between", value1, value2, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotBetween(String value1, String value2) {
            addCriterion("itemName not between", value1, value2, "itemname");
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