package com.example.iket.ecellapp2k17.blogs.view;

import com.example.iket.ecellapp2k17.blogs.data.BlogData;
import java.util.List;

/**
 * Created by vrihas on 6/21/2017.
 */

public interface OnBlogsReceived {

    void onSuccess(List<BlogData> blogDataList);
    void onFailure();
}
