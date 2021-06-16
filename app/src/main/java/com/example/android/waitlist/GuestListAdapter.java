/*
* Copyright (C) 2016 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.waitlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.waitlist.database.GuestEntry;

import java.util.List;

/**
 * This TaskAdapter creates and binds ViewHolders, that hold the description and priority of a task,
 * to a RecyclerView to efficiently display data.
 */
public class GuestListAdapter extends RecyclerView.Adapter<GuestListAdapter.GuestViewHolder> {

    // Class variables for the List that holds task data and the Context
    private List<GuestEntry> mGuestEntries;
    private Context mContext;

    public GuestListAdapter(Context context){
        this.mContext = context;
    }

    /**
     * Called when ViewHolders are created to fill a RecyclerView.
     *
     * @return A new TaskViewHolder that holds the view for each task
     */
    @Override
    public GuestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the task_layout to a view
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.guest_list_item, parent, false);

        return new GuestViewHolder(view);
    }

    /**
     * Called by the RecyclerView to display data at a specified position in the Cursor.
     *
     * @param holder   The ViewHolder to bind Cursor data to
     * @param position The position of the data in the Cursor
     */
    @Override
    public void onBindViewHolder(GuestViewHolder holder, int position) {
        // Determine the values of the wanted data
        GuestEntry guestEntry = mGuestEntries.get(position);
        String name = guestEntry.getGuestName();
        int partySize = guestEntry.getPartySize();
        int id = guestEntry.getId();

        //Set values
        holder.nameTextView.setText(name);
        holder.partySizeTextView.setText(Integer.toString(partySize));
        holder.itemView.setTag(id);
    }


    /**
     * Returns the number of items to display.
     */
    @Override
    public int getItemCount() {
        if (mGuestEntries == null) {
            return 0;
        }
        return mGuestEntries.size();
    }

    public List<GuestEntry> getTasks() {
        return mGuestEntries;
    }

    /**
     * When data changes, this method updates the list of taskEntries
     * and notifies the adapter to use the new values on it
     */
    public void setTasks(List<GuestEntry> guestEntries) {
        mGuestEntries = guestEntries;
        notifyDataSetChanged();
    }

    // Inner class for creating ViewHolders
    class GuestViewHolder extends RecyclerView.ViewHolder {

        // Class variables for the task description and priority TextViews
        TextView nameTextView;
        TextView partySizeTextView;

        /**
         * Constructor for the TaskViewHolders.
         *
         * @param itemView The view inflated in onCreateViewHolder
         */
        public GuestViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
            partySizeTextView = (TextView) itemView.findViewById(R.id.party_size_text_view);
        }
    }
}