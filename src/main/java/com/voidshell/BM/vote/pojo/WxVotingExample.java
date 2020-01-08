package com.voidshell.BM.vote.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WxVotingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WxVotingExample() {
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

        public Criteria andVoteIdIsNull() {
            addCriterion("vote_id is null");
            return (Criteria) this;
        }

        public Criteria andVoteIdIsNotNull() {
            addCriterion("vote_id is not null");
            return (Criteria) this;
        }

        public Criteria andVoteIdEqualTo(String value) {
            addCriterion("vote_id =", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotEqualTo(String value) {
            addCriterion("vote_id <>", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdGreaterThan(String value) {
            addCriterion("vote_id >", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdGreaterThanOrEqualTo(String value) {
            addCriterion("vote_id >=", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdLessThan(String value) {
            addCriterion("vote_id <", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdLessThanOrEqualTo(String value) {
            addCriterion("vote_id <=", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdLike(String value) {
            addCriterion("vote_id like", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotLike(String value) {
            addCriterion("vote_id not like", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdIn(List<String> values) {
            addCriterion("vote_id in", values, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotIn(List<String> values) {
            addCriterion("vote_id not in", values, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdBetween(String value1, String value2) {
            addCriterion("vote_id between", value1, value2, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotBetween(String value1, String value2) {
            addCriterion("vote_id not between", value1, value2, "voteId");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openId is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openId is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openId =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openId <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openId >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openId >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openId <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openId <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openId like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openId not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openId in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openId not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openId between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openId not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdIsNull() {
            addCriterion("vote_item_id is null");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdIsNotNull() {
            addCriterion("vote_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdEqualTo(String value) {
            addCriterion("vote_item_id =", value, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdNotEqualTo(String value) {
            addCriterion("vote_item_id <>", value, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdGreaterThan(String value) {
            addCriterion("vote_item_id >", value, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("vote_item_id >=", value, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdLessThan(String value) {
            addCriterion("vote_item_id <", value, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdLessThanOrEqualTo(String value) {
            addCriterion("vote_item_id <=", value, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdLike(String value) {
            addCriterion("vote_item_id like", value, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdNotLike(String value) {
            addCriterion("vote_item_id not like", value, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdIn(List<String> values) {
            addCriterion("vote_item_id in", values, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdNotIn(List<String> values) {
            addCriterion("vote_item_id not in", values, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdBetween(String value1, String value2) {
            addCriterion("vote_item_id between", value1, value2, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVoteItemIdNotBetween(String value1, String value2) {
            addCriterion("vote_item_id not between", value1, value2, "voteItemId");
            return (Criteria) this;
        }

        public Criteria andVotedateIsNull() {
            addCriterion("voteDate is null");
            return (Criteria) this;
        }

        public Criteria andVotedateIsNotNull() {
            addCriterion("voteDate is not null");
            return (Criteria) this;
        }

        public Criteria andVotedateEqualTo(Date value) {
            addCriterion("voteDate =", value, "votedate");
            return (Criteria) this;
        }

        public Criteria andVotedateNotEqualTo(Date value) {
            addCriterion("voteDate <>", value, "votedate");
            return (Criteria) this;
        }

        public Criteria andVotedateGreaterThan(Date value) {
            addCriterion("voteDate >", value, "votedate");
            return (Criteria) this;
        }

        public Criteria andVotedateGreaterThanOrEqualTo(Date value) {
            addCriterion("voteDate >=", value, "votedate");
            return (Criteria) this;
        }

        public Criteria andVotedateLessThan(Date value) {
            addCriterion("voteDate <", value, "votedate");
            return (Criteria) this;
        }

        public Criteria andVotedateLessThanOrEqualTo(Date value) {
            addCriterion("voteDate <=", value, "votedate");
            return (Criteria) this;
        }

        public Criteria andVotedateIn(List<Date> values) {
            addCriterion("voteDate in", values, "votedate");
            return (Criteria) this;
        }

        public Criteria andVotedateNotIn(List<Date> values) {
            addCriterion("voteDate not in", values, "votedate");
            return (Criteria) this;
        }

        public Criteria andVotedateBetween(Date value1, Date value2) {
            addCriterion("voteDate between", value1, value2, "votedate");
            return (Criteria) this;
        }

        public Criteria andVotedateNotBetween(Date value1, Date value2) {
            addCriterion("voteDate not between", value1, value2, "votedate");
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