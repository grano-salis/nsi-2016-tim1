package org.nsi.alpha.models.viewModels;

import org.nsi.alpha.models.CvItem;

import java.util.Date;

public class CvItemViewModel {

    Long id;
    String name;
    String description;
    Date startDate;
    Date endDate;
    Date insertDate;
    Date lastUpdateDate;
    Integer criteriaId;
    Integer cvId;
    Integer statusId;

    public CvItemViewModel(CvItem cvItem) {
        id = cvItem.getId();
        name = cvItem.getName();
        description = cvItem.getDescription();
        startDate = cvItem.getStartDate();
        endDate = cvItem.getEndDate();
        insertDate = cvItem.getInsertDate();
        lastUpdateDate = cvItem.getLastUpdateDate();
        criteriaId = cvItem.getCriteriaId();
        cvId = cvItem.getCvId();
        statusId = cvItem.getStatusId();
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

    @Override
    public String toString() {
        return "CvItemViewModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", insertDate=" + insertDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", criteriaId=" + criteriaId +
                ", cvId=" + cvId +
                ", statusId=" + statusId +
                '}';
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
}
