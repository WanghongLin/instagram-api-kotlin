/*
 * Copyright (C) 2018 mutter
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wanghong.kostagram.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface AuthenticationService {

    @GET
    fun authenticateImplicitly(@Url url: String = "https://api.instagram.com/oauth/authorize/",
                               @Query("client_id") clientId: String,
                               @Query("redirect_uri") redirectUri: String,
                               @Query("response_type") responseType: String = "token",
                               @Query("scope") scope: String? = null) : Call<ResponseBody>
}