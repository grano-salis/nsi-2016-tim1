package org.nsi.alpha.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CV_ITEM", schema = "NSI01")
public class CvItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    Long id;

    @Column(name = "NAME")
    String name;

    @Column(name = "DESCRIPTION")
    String description;

    @Column(name = "START_DATE")
    Date startDate;

    @Column(name = "END_DATE")
    Date endDate;

    @Column(name = "INSERT_DATE")
    Date insertDate;

    @Column(name = "LAST_UPDATE_DATE")
    Date lastUpdateDate;

    @Column(name = "CV_ITEM_ID")
    Integer cvItemId;

    @Column(name = "CRITERIA_ID")
    Integer criteriaId;

    @Column(name = "CV_ID")
    Integer cvId;

    @Column(name = "STATUS_ID")
    Integer statusId;

    public CvItem() {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Integer getCvItemId() {
        return cvItemId;
    }

    public void setCvItemId(Integer cvItemId) {
        this.cvItemId = cvItemId;
    }

    public Integer getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(Integer criteriaId) {
        this.criteriaId = criteriaId;
    }

    public Integer getCvId() {
        return cvId;
    }

    public void setCvId(Integer cvId) {
        this.cvId = cvId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "CvItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", insertDate=" + insertDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", cvItemId=" + cvItemId +
                ", criteriaId=" + criteriaId +
                ", cvId=" + cvId +
                ", statusId=" + statusId +
                '}';
    }
}
