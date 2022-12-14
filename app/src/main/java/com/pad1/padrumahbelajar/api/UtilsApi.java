package com.pad1.padrumahbelajar.api;

public class UtilsApi {
    public static final String BASE_URL_API = "https://learnwithacruz.my.id/PAD1/public/api/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
