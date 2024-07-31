package com.kosinov.ping_pong.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Pong {
    private int pong_id;
    private LocalDateTime pong_date_time;

    public Pong() {
    }

    public Pong(int pong_id, LocalDateTime pong_date_time) {
        this.pong_id = pong_id;
        this.pong_date_time = pong_date_time;
    }

    public int getPong_id() {
        return pong_id;
    }

    public void setPong_id(int pong_id) {
        this.pong_id = pong_id;
    }

    public LocalDateTime getPong_date_time() {
        return pong_date_time;
    }

    public void setPong_date_time(LocalDateTime pong_date_time) {
        this.pong_date_time = pong_date_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pong pong = (Pong) o;
        return Objects.equals(pong_id, pong.pong_id) && Objects.equals(pong_date_time, pong.pong_date_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pong_id, pong_date_time);
    }

    @Override
    public String toString() {
        return "Pong{" +
                "pong_id=" + pong_id +
                ", pong_date_time=" + pong_date_time +
                '}';
    }
}
