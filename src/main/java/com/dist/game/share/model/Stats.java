package com.dist.game.share.model;

import java.io.Serializable;
import java.util.Date;

public class Stats implements Serializable {

    private Date start;
    private Date finish;

    private int wrong;
    private int right;
}
