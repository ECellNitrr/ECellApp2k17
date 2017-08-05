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
        AboutUsData data = new AboutUsData("VISION","Vision of E-Cell..!!","http://social-media-for-development.org/wp-content/uploads/2012/11/blogging.jpg","test","test","This is Vision Body.");
        dataList.add(data);
//        data = new AboutUsData("TEAM","Team of E-Cell..!!");
        dataList.add(data);
//        data = new AboutUsData("CONTACT US","Contact of E-Cell..!!");
        dataList.add(data);
//        data = new AboutUsData("ABOUT US","About E-Cell..!!");
        dataList.add(data);
//        data = new AboutUsData("PAST","Past of E-Cell..!!");
        dataList.add(data);
//        data = new AboutUsData("JUST FOR YOU","For you specially..!!");
        dataList.add(data);

        onAboutusReceived.onSuccess(dataList);
    }
}
