package com.example.iket.ecellapp2k17.about_us.model;

import com.example.iket.ecellapp2k17.about_us.model.data.TeamData;
import com.example.iket.ecellapp2k17.about_us.model.data.TeamList;
import com.example.iket.ecellapp2k17.about_us.view.OnAboutusReceived;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrihas on 6/23/2017.
 */

public class MockAboutUs implements TeamProvider {

    @Override
    public void requestData(OnAboutusReceived onAboutusReceived) {
        List<TeamData> dataList=new ArrayList<>();
        TeamData data = new TeamData("abc@gmail.com","https://upload.wikimedia.org/wikipedia/commons/b/b3/Sundar_Pichai_%28cropped%29.jpg","Abhik Sarkar","Overall");
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
        TeamList teamList=new TeamList(dataList,true,"Error in server");
        onAboutusReceived.onSuccess(teamList);
    }
}
