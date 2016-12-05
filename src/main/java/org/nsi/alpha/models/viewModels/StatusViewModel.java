package org.nsi.alpha.models.viewModels;

import org.nsi.alpha.models.Status;

public class StatusViewModel {

    Long id;
    String value;

    public StatusViewModel(Status status) {
        id = status.getId();
        value = status.getValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StatusViewModel{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
