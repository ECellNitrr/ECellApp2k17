package com.example.iket.ecellapp2k17.helper.image_loaders;

import android.widget.ImageView;

/**
 * Created by samveg on 25/6/17.
 */

public interface ImageLoader {

    void loadImage(String url, ImageView imageView);
    void load_circular_image(String url, ImageView imageView);

}
