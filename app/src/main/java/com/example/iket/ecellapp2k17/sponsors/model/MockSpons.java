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
        SponsData data=new SponsData("http://www.endeavourpto.org/wp-content/uploads/2016/08/become-a-sponsor-1.png","Meenakshi","www.google.com");
        dataList.add(data);
        SponsHeading spons=new SponsHeading(dataList,"Title Sponsors");
        list.add(spons);
        dataList.add(data);
        spons=new SponsHeading(dataList,"Associate Sponsors");
        list.add(spons);
        List<SponsData> dataList1=new ArrayList<>();
        SponsData data1=new SponsData("http://www.endeavourpto.org/wp-content/uploads/2016/08/become-a-sponsor-1.png","Meenahi","www.google.com");
        dataList1.add(data1);
        dataList1.add(data1);
        dataList1.add(data1);
        dataList1.add(data1);dataList1.add(data1);
        dataList1.add(data1);
        dataList1.add(data1);
        spons=new SponsHeading(dataList1,"Sponsors");
        list.add(spons);
        onSponsReceived.onSuccess(list);

    }
}
