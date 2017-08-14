package com.example.iket.ecellapp2k17.blogs.model;

import com.example.iket.ecellapp2k17.blogs.model.data.BlogData;
import com.example.iket.ecellapp2k17.blogs.model.data.BlogFeed;
import com.example.iket.ecellapp2k17.blogs.view.OnBlogsReceived;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iket on 22/6/17.
 */

public class MockBlogs implements BlogsProvider{
    @Override
    public void requestBlogs(OnBlogsReceived onBlogsReceived) {
        List<BlogData> dataList=new ArrayList<>();
        BlogData data=new BlogData("Title 1","Iket","05/12/2016","Let’s tackle the primary question. What is Entrepreneurship? According to Google, entrepreneurship is the activity of setting up a business or businesses, taking on financial risks in the hope of making a profit. This summarizes the entire concept very efficiently. Using this definition, an entrepreneur is a person of very high aptitude who pioneers change, possessing characteristics found in only a minuscule fraction of the population.\n" +
                "\n" +
                "Tackling the next question in mind, What is Rural Entrepreneurship? Entrepreneurship based on the welfare and upbringing of the rural areas is Rural entrepreneurship. It is a pretty straight forward definition. However, it has a much deeper meaning to it.The fundamental role is to provide employment opportunities and consequently, applying a check on migration. Industries in rural areas are mostly micro or tiny in structure and quick yielding. In other words, their gestation period is much less as compared to large scale industries. Rural industries are also labour intensive and provide substantial employment opportunities to rural folks of all age groups. Few examples of such type of industries are Food Processing industry, Poultry industry, cottage and handicrafts industry, etc. This also helps in balanced regional growth and promotion of artistic activities.","https://www.facebook.com/esummitnitrr/photos/a.598795036959910.1073741829.583106968528717/598795060293241/?type=3&theater");
        dataList.add(data);
        data=new BlogData("Title 2","User 2","05/10/2016","Hello, lets get started!!","http://social-media-for-development.org/wp-content/uploads/2012/11/blogging.jpg");
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        onBlogsReceived.onSuccess(dataList);
    }
}
