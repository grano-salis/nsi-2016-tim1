package org.nsi.alpha.models.viewModels;

import org.nsi.alpha.models.Criteria;

import java.util.Date;

public class CriteriaViewModel {

    private static final long serialVersionUID = 1L;
    Long id;
    String name;
    String description;
    Integer points;
    Date insertDate;
    Date lastUpdateDate;
    Integer criteriaId;

    public CriteriaViewModel(Criteria criteria) {
        id = criteria.getId();
        name = criteria.getName();
        description = criteria.getDescription();
        points = criteria.getPoints();
        insertDate = criteria.getInsertDate();
        lastUpdateDate = criteria.getLastUpdateDate();
        criteriaId = criteria.getCriteriaId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(Integer criteriaId) {
        this.criteriaId = criteriaId;
    }

    @Override
    public String toString() {
        return "CriteriaViewModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", points=" + points +
                ", insertDate=" + insertDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", criteriaId=" + criteriaId +
                '}';
    }
}
