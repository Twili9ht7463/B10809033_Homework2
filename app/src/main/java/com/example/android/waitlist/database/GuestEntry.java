package com.example.android.waitlist.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "guest")
public class GuestEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String guestName;
    private int partySize;

    public GuestEntry(){}

    @Ignore
    public GuestEntry(String guestName, int partySize) {
        this.guestName = guestName;
        this.partySize = partySize;
    }

    public GuestEntry(int id, String guestName, int partySize) {
        this.id = id;
        this.guestName = guestName;
        this.partySize = partySize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getPartySize() {
        return partySize;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }
}
