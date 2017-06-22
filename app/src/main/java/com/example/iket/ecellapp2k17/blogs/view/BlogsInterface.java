package com.example.iket.ecellapp2k17.blogs.view;

import com.example.iket.ecellapp2k17.blogs.model.data.BlogData;
import java.util.List;

/**
 * Created by vrihas on 6/21/2017.
 */

public interface BlogsInterface {

    void setData(List<BlogData> blogDataList);
    void showMessage(String message);
    void ShowProgressBar(boolean show);
}
