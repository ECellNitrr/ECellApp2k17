package com.example.iket.ecellapp2k17.sponsors.model;


import com.example.iket.ecellapp2k17.sponsors.model.data.ResponseSpons;
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
        List<ResponseSpons> list=new ArrayList<>();
        List<SponsData> dataList=new ArrayList<>();
        SponsData data=new SponsData("http://www.endeavourpto.org/wp-content/uploads/2016/08/become-a-sponsor-1.png","Title Sponsor","www.google.com");
        dataList.add(data);
        dataList.add(data);
        ResponseSpons spons=new ResponseSpons(dataList,"Partners");
        list.add(spons);
        SponsData data1=new SponsData("http://www.endeavourpto.org/wp-content/uploads/2016/08/become-a-sponsor-1.png","Title2","www.google.com");

        spons=new ResponseSpons(dataList,"Sponsors");
        list.add(spons);


        //  data = new SponsData("http://goo.gl/gEgYUd","Sample");
       // dataList.add(data);
       // data = new SponsData("http://goo.gl/gEgYUd","Sample2");
       // dataList.add(data);
        //data = new SponsData("http://goo.gl/gEgYUd","Sample3");
       // dataList.add(data);
        onSponsReceived.onSuccess(list);

    }
}
