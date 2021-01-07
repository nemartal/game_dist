package com.dist.game.share.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class User implements Serializable {

    private final String id;
    private final String nickname;

    public User() {
        this.id = UUID.randomUUID().toString();
        this.nickname = "user_" + (new Date().getTime());
    }

    public User(String nickname) {
        this.id = UUID.randomUUID().toString();
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
