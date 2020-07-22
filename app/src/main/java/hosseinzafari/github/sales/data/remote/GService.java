/*
 * MIT License
 *
 * Copyright (c) 2020.  Hossein Zafari/novinfar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package hosseinzafari.github.sales.data.remote;
/*

@created in 22/07/2020 - 06:27 AM
@project Sales
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

import java.util.concurrent.TimeUnit;

import hosseinzafari.github.sales.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GService {

    private static final String BASE_URL = "http://192.168.0.4/sales/";
    private static Retrofit retrofit;
    private static OkHttpClient okHtpp;
    private static HttpLoggingInterceptor loggingInterceptor;
    private static Api api;

    private GService() {
    }


    public static Retrofit getRetrofit() {
        synchronized (GService.class) {
            if (retrofit == null) {
                synchronized (GService.class) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .validateEagerly(true)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(getOkHttp()).build();
                }
            }

            return retrofit;
        }
    }

    private static synchronized OkHttpClient getOkHttp() {
        if (okHtpp == null) {
            okHtpp = new OkHttpClient.Builder()
                    .addInterceptor(getLogginInterceptor())
                    .callTimeout(1, TimeUnit.MINUTES)
                    .connectTimeout(2, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .build();
        }

        return okHtpp;
    }

    private static HttpLoggingInterceptor getLogginInterceptor() {
        if (loggingInterceptor == null) {
            loggingInterceptor = new HttpLoggingInterceptor();
            if (BuildConfig.DEBUG) {
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            } else {
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
            }
        }

        return loggingInterceptor;
    }

    public static synchronized Api getApi() {
        if (api == null) {
            api = getRetrofit().create(Api.class);
        }

        return api;
    }
}
