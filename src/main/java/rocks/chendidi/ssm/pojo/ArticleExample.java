package rocks.chendidi.ssm.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andArticleidIsNull() {
            addCriterion("Articleid is null");
            return (Criteria) this;
        }

        public Criteria andArticleidIsNotNull() {
            addCriterion("Articleid is not null");
            return (Criteria) this;
        }

        public Criteria andArticleidEqualTo(String value) {
            addCriterion("Articleid =", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotEqualTo(String value) {
            addCriterion("Articleid <>", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidGreaterThan(String value) {
            addCriterion("Articleid >", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidGreaterThanOrEqualTo(String value) {
            addCriterion("Articleid >=", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLessThan(String value) {
            addCriterion("Articleid <", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLessThanOrEqualTo(String value) {
            addCriterion("Articleid <=", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLike(String value) {
            addCriterion("Articleid like", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotLike(String value) {
            addCriterion("Articleid not like", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidIn(List<String> values) {
            addCriterion("Articleid in", values, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotIn(List<String> values) {
            addCriterion("Articleid not in", values, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidBetween(String value1, String value2) {
            addCriterion("Articleid between", value1, value2, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotBetween(String value1, String value2) {
            addCriterion("Articleid not between", value1, value2, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleIsNull() {
            addCriterion("Article is null");
            return (Criteria) this;
        }

        public Criteria andArticleIsNotNull() {
            addCriterion("Article is not null");
            return (Criteria) this;
        }

        public Criteria andArticleEqualTo(String value) {
            addCriterion("Article =", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleNotEqualTo(String value) {
            addCriterion("Article <>", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleGreaterThan(String value) {
            addCriterion("Article >", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleGreaterThanOrEqualTo(String value) {
            addCriterion("Article >=", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleLessThan(String value) {
            addCriterion("Article <", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleLessThanOrEqualTo(String value) {
            addCriterion("Article <=", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleLike(String value) {
            addCriterion("Article like", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleNotLike(String value) {
            addCriterion("Article not like", value, "article");
            return (Criteria) this;
        }

        public Criteria andArticleIn(List<String> values) {
            addCriterion("Article in", values, "article");
            return (Criteria) this;
        }

        public Criteria andArticleNotIn(List<String> values) {
            addCriterion("Article not in", values, "article");
            return (Criteria) this;
        }

        public Criteria andArticleBetween(String value1, String value2) {
            addCriterion("Article between", value1, value2, "article");
            return (Criteria) this;
        }

        public Criteria andArticleNotBetween(String value1, String value2) {
            addCriterion("Article not between", value1, value2, "article");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("Title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("Title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("Title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("Title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("Title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("Title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("Title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("Title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("Title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("Title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("Title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("Title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("Title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("Title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createdate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createdate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createdate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createdate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createdate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createdate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createdate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createdate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createdate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createdate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andDaletedateIsNull() {
            addCriterion("daletedate is null");
            return (Criteria) this;
        }

        public Criteria andDaletedateIsNotNull() {
            addCriterion("daletedate is not null");
            return (Criteria) this;
        }

        public Criteria andDaletedateEqualTo(Date value) {
            addCriterion("daletedate =", value, "daletedate");
            return (Criteria) this;
        }

        public Criteria andDaletedateNotEqualTo(Date value) {
            addCriterion("daletedate <>", value, "daletedate");
            return (Criteria) this;
        }

        public Criteria andDaletedateGreaterThan(Date value) {
            addCriterion("daletedate >", value, "daletedate");
            return (Criteria) this;
        }

        public Criteria andDaletedateGreaterThanOrEqualTo(Date value) {
            addCriterion("daletedate >=", value, "daletedate");
            return (Criteria) this;
        }

        public Criteria andDaletedateLessThan(Date value) {
            addCriterion("daletedate <", value, "daletedate");
            return (Criteria) this;
        }

        public Criteria andDaletedateLessThanOrEqualTo(Date value) {
            addCriterion("daletedate <=", value, "daletedate");
            return (Criteria) this;
        }

        public Criteria andDaletedateIn(List<Date> values) {
            addCriterion("daletedate in", values, "daletedate");
            return (Criteria) this;
        }

        public Criteria andDaletedateNotIn(List<Date> values) {
            addCriterion("daletedate not in", values, "daletedate");
            return (Criteria) this;
        }

        public Criteria andDaletedateBetween(Date value1, Date value2) {
            addCriterion("daletedate between", value1, value2, "daletedate");
            return (Criteria) this;
        }

        public Criteria andDaletedateNotBetween(Date value1, Date value2) {
            addCriterion("daletedate not between", value1, value2, "daletedate");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
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