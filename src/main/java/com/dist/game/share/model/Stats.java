package com.dist.game.share.model;

import java.io.Serializable;
import java.util.Date;

public class Stats implements Serializable {

    private Date start;
    private Date finish;

    private int wrong;
    private int right;

    public void addWrong() {
        this.wrong = this.wrong + 1;
    }

    public void addRight() {
        this.right = this.right + 1;
    }

    public int getRight() {
        return right;
    }

    public int getWrong() {
        return wrong;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public Date getStart() {
        return start;
    }
}
