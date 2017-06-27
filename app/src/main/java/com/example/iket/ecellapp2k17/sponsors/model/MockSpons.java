package com.example.iket.ecellapp2k17.sponsors.model;

import com.example.iket.ecellapp2k17.blogs.model.BlogsProvider;
import com.example.iket.ecellapp2k17.blogs.model.data.BlogData;
import com.example.iket.ecellapp2k17.blogs.view.OnBlogsReceived;
import com.example.iket.ecellapp2k17.sponsors.view.OnSponsReceived;
import com.example.iket.ecellapp2k17.sponsors.view.SponsData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iket on 22/6/17.
 */

public class MockSpons implements SponsProvider{
    @Override
    public void reqSpons(OnSponsReceived onSponsReceived) {
        List<SponsData> dataList=new ArrayList<>();
        SponsData data=new SponsData("http://www.endeavourpto.org/wp-content/uploads/2016/08/become-a-sponsor-1.png","1");
        dataList.add(data);
        onSponsReceived.onSuccess(dataList);
    }
}
