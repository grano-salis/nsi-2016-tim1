package org.nsi.alpha.models;

/**
 * Created by zlatan on 04/01/2017.
 */
public class CvItemWrapper {

    CvItem item;
    String professorName;

    public CvItemWrapper(CvItem item, String professorName) {
        this.item = item;
        this.professorName = professorName;
    }

    public CvItem getItem() {
        return item;
    }

    public void setItem(CvItem item) {
        this.item = item;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }
}
