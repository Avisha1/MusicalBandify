package com.example.android.musicalbandify.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.android.musicalbandify.R;
import com.example.android.musicalbandify.data_objects.Image;

import java.util.ArrayList;

/**
 * Created by Ehud on 3/16/2018.
 */

public class ImagesAdapter extends BaseAdapter{

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Image> images;
    private boolean mIsGrid;

    public ImagesAdapter(Context context, ArrayList<Image> images, boolean isGrid) {
        this.mContext = context;
        this.mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.images = images;
        this.mIsGrid = isGrid;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Image getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate our row and find our views!
        ViewHolder holder;
        if (convertView == null) {
            /*
            if (mIsGrid) {
                convertView = mInflater.inflate(R.layout.grid_friend, parent, false);
            } else {
                convertView = mInflater.inflate(R.layout.li_friend, parent, false);
            }
            */
            convertView = mInflater.inflate(R.layout.taps_image, parent, false);

            holder = onCreateViewHolder(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Getting the data for this specific row!
        Image image = getItem(position);

        // Bind View image view holder
        onBindViewHolder(holder, image);

        return convertView;
    }

    private ViewHolder onCreateViewHolder(View convertView) {
        ViewHolder holder = new ViewHolder();
        holder.img = (ImageView) convertView.findViewById(R.id.tap_img);
        convertView.setTag(holder);
        return holder;
    }

    private void onBindViewHolder(final ViewHolder holder, Image image) {

        // Get Image resource url
        holder.img.setImageResource(image.getImageResource());

        // Remove Button when the user press on the button
        holder.img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                holder.img.clearAnimation();
                holder.img.setVisibility(v.GONE);
            }
        });

        if (image.isVisible()) {
            //Animation fadeIn = fadeIn();
            //holder.img.startAnimation(fadeIn);
            holder.img.setVisibility(View.VISIBLE);
        } else {
            //Animation fadeOut = fadeOut();
            //holder.img.startAnimation(fadeOut);
            holder.img.setVisibility(View.GONE);
        }
    }

    private static class ViewHolder {
        public ImageView img;
    }

    // Use for animation - currently depricated

    private Animation fadeIn() {

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(200);
        return fadeIn;
    }

    private Animation fadeOut() {

        Animation fadeOut = new AlphaAnimation(0, 1);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //add this
        fadeOut.setStartOffset(500);
        fadeOut.setDuration(200);
        return fadeOut;
    }
}
