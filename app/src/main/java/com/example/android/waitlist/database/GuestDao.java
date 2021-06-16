package com.example.android.waitlist.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface GuestDao {

    @Query("SELECT * FROM guest")
    List<GuestEntry> loadAllGuests();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertGuest(GuestEntry guestEntry);

    @Delete
    void deleteGuest(GuestEntry guestEntry);

    // COMPLETED (1) Create a Query method named loadTaskById that receives an int id and returns a TaskEntry Object
    // The query for this method should get all the data for that id in the task table
    @Query("SELECT * FROM guest WHERE id = :id")
    GuestEntry loadGuestById(int id);
}
