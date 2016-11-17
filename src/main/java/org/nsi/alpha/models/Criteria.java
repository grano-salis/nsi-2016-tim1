package org.nsi.alpha.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by ekusundzija on 17/11/16.
 */

@Entity
@Table(name = "CRITERIA", schema = "NSI01")
public class Criteria {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID")
    Long id;

    @Column(name="NAME")
    String name;
    @Column(name="DESCRIPTION")
    String description;
    @Column(name="POINTS")
    Integer points;
    @Column(name="INSERT_DATE")
    Date insertDate;
    @Column(name="LAST_UPDATE_DATE")
    Date lastUpdateDate;
    @Column(name="CRITERIA_ID")
    Integer criteriaId;

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
        return "Criteria{" +
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
