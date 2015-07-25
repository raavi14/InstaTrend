package com.srlabs.instatrend.instatrend;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Sandeep on 7/25/2015.
 */
public class TrendAdapter extends RecyclerView.Adapter<TrendAdapter.TrendViewHolder> {
    private ArrayList<String> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class TrendViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public TrendViewHolder(LinearLayout itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tvTrend);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TrendAdapter(ArrayList<String> mTrendingTopics) {
        mDataset = mTrendingTopics;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TrendAdapter.TrendViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LinearLayout v =(LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trend_card_view, parent, false);
        return new TrendViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(TrendViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
