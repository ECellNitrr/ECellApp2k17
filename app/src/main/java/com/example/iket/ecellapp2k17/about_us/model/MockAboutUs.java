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
        AboutUsData data = new AboutUsData("abc@gmail.com","https://upload.wikimedia.org/wikipedia/commons/b/b3/Sundar_Pichai_%28cropped%29.jpg","Abhik Sarkar");
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
