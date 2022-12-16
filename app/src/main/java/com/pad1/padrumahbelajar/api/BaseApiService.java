package com.pad1.padrumahbelajar.api;

import com.pad1.padrumahbelajar.model.KelasResponse;
import com.pad1.padrumahbelajar.model.QuestionResponse;
import com.pad1.padrumahbelajar.model.QuizResponse;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BaseApiService {
    @FormUrlEncoded
    @POST("akun/login")
    Call<ResponseBody> loginRequest(@Field("username") String username,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("akun/register")
    Call<ResponseBody> registerRequest(@Field("nama") String nama,
                                    @Field("email") String email,@Field("username") String username,
                                       @Field("password1") String password1,@Field("password2") String password2,@Field("role") String role);

    @GET("guru/kelas/getall")
    Call<KelasResponse> kelasRequest();

    @GET("guru/quiz/getquiz")
    Call<QuizResponse> quizRequest();

    @GET("guru/quiz/destroy/{token}")
    Call<ResponseBody> quizListDelete(@Path("token") String token);

    @GET("guru/question/getquestion/{token}")
    Call<QuestionResponse> questionRequest(@Path("token") String token);

    @FormUrlEncoded
    @POST("guru/quiz/addquiz")
    Call<ResponseBody> quizRequest(@Field("namaQuiz") String namaQuiz, @Field("mataPelajaran") String mataPelajaran);

    @FormUrlEncoded
    @POST("guru/question/addquestion")
    Call<ResponseBody> questionRequest(@Field("token") String token,@Field("question") String question, @Field("a") String a, @Field("b") String b, @Field("c") String c,
                                       @Field("d") String d, @Field("e") String e, @Field("jawaban") String jawaban);

    @FormUrlEncoded
    @POST("guru/question/deletequestion")
    Call<ResponseBody> quizDelete(@Field("token") String token, @Field("num") int num);

    @FormUrlEncoded
    @POST("guru/nilai/storenilai")
    Call<ResponseBody> storeNilai(@Field("tokenMurid") String tokenMurid, @Field("tokenQuiz") String tokenQuiz
            , @Field("studentAnswer") String studentAnswer);

}
