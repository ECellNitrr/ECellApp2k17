package com.example.iket.ecellapp2k17.about_us.model;

import com.example.iket.ecellapp2k17.about_us.model.data.AboutUsData;
import com.example.iket.ecellapp2k17.about_us.view.OnAboutusReceived;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrihas on 6/23/2017.
 */

public class MockAboutUs implements AboutUsProvider{

    @Override
    public void requestData(OnAboutusReceived onAboutusReceived) {
        List<AboutUsData> dataList=new ArrayList<>();
        AboutUsData data = new AboutUsData("abc@gmail.com","http://social-media-for-development.org/wp-content/uploads/2012/11/blogging.jpg","Abhik Sarkar","Overall Coordinator");
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        onAboutusReceived.onSuccess(dataList);
    }
}
