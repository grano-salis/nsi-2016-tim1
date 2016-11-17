package org.nsi.alpha.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ekusundzija on 17/11/16.
 */


@Entity
@Table(name = "STATUS", schema = "NSI01")
public class Status {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name="ID")
    Long id;
    @Column(name="VALUE")
    String value;

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
        return "Status{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
