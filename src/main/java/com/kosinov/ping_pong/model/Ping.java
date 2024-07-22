package com.kosinov.ping_pong.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Ping {
    private int ping_id;
    private LocalDateTime ping_date_time;

    public Ping() {
    }

    public Ping(int ping_id, LocalDateTime ping_date_time) {
        this.ping_id = ping_id;
        this.ping_date_time = ping_date_time;
    }

    public int getPing_id() {
        return ping_id;
    }

    public void setPing_id(int ping_id) {
        this.ping_id = ping_id;
    }

    public LocalDateTime getPing_date_time() {
        return ping_date_time;
    }

    public void setPing_date_time(LocalDateTime ping_date_time) {
        this.ping_date_time = ping_date_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ping ping = (Ping) o;
        return Objects.equals(ping_id, ping.ping_id) && Objects.equals(ping_date_time, ping.ping_date_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ping_id, ping_date_time);
    }

    @Override
    public String toString() {
        return "Ping{" +
                "ping_id=" + ping_id +
                ", ping_date_time=" + ping_date_time +
                '}';
    }
}
