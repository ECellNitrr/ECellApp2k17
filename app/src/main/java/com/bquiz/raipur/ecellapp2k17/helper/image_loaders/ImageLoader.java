package com.bquiz.raipur.ecellapp2k17.helper.image_loaders;

import android.widget.ImageView;
import android.widget.ProgressBar;

import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by samveg on 25/6/17.
 */

public interface ImageLoader {

    void loadImage(String url, ImageView imageView, AVLoadingIndicatorView progressBar);
    void load_circular_image(String url, ImageView imageView,AVLoadingIndicatorView progressBar);

}
