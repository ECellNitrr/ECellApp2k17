package com.example.iket.ecellapp2k17.sponsors.model;


import com.example.iket.ecellapp2k17.sponsors.model.data.SponsHeading;
import com.example.iket.ecellapp2k17.sponsors.view.OnSponsReceived;
import com.example.iket.ecellapp2k17.sponsors.model.data.SponsData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iket on 22/6/17.
 */

public class MockSpons implements SponsProvider{
    @Override
    public void reqSpons(OnSponsReceived onSponsReceived) {
        List<SponsHeading> list=new ArrayList<>();
        List<SponsData> dataList=new ArrayList<>();
//        SponsData data=new SponsData("http://govtjobslatest.org/wp-content/uploads/2015/10/chips-logo.jpg","Chips","www.google.com");
//        dataList.add(data);
//        SponsHeading spons=new SponsHeading(dataList,true,"","Title Sponsors");
//        list.add(spons);
//        List<SponsData> dataList2=new ArrayList<>();
//        data=new SponsData("https://lh3.googleusercontent.com/-6pXiq6KhC5Y/VpNIMgRsueI/AAAAAAAABB0/lNyeFBJkaUY/s2048-Ic42/Startup_901x517.jpg","Startup India","dcd");
//        dataList2.add(data);
//        data=new SponsData("http://www.cmai.asia/digitalindia/img/logo.png","Digital India","dc");
//        dataList2.add(data);
//        spons=new SponsHeading(dataList,true,"","Title Sponsors");
//        list.add(spons);
//        List<SponsData> dataList1=new ArrayList<>();
//        SponsData data1=new SponsData("http://www.endeavourpto.org/wp-content/uploads/2016/08/become-a-sponsor-1.png","Meenahi","www.google.com");
//        dataList1.add(data1);
//        dataList1.add(data1);
//        dataList1.add(data1);
//        dataList1.add(data1);dataList1.add(data1);
//        dataList1.add(data1);
//        dataList1.add(data1);
//        spons=new SponsHeading(dataList,true,"","Title Sponsors");
//        list.add(spons);
        onSponsReceived.onSuccess(list);
    }
}
