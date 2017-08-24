package com.bquiz.raipur.ecellapp2k17.BQuizNew.api;

import com.bquiz.raipur.ecellapp2k17.BQuizNew.model.data.SubmitAnswerData;
import com.bquiz.raipur.ecellapp2k17.helper.Urls;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by meghal on 9/8/16.
 */
public interface SubmitAnswerRequestInterface {

    @FormUrlEncoded
    @POST(Urls.REQUEST_SUBMIT_ANSWER)
    Observable<SubmitAnswerData> submitAnswer(@Field("question_id") int questionId, @Field("answer")
            String answer, @Field("access_token") String access_token);

}
