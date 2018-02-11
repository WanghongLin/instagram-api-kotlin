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

/**
 * Created by mutter on 2/7/18.
 */
class EndPoints {

    companion object {

        const val AUTH_SCOPE_BASIC = "basic"
        const val AUTH_SCOPE_PUBLIC_CONTENT = "public_content"
        const val AUTH_SCOPE_FOLLOWER_LIST = "follower_list"
        const val AUTH_SCOPE_COMMENTS = "comments"
        const val AUTH_SCOPE_RELATIONSHIPS = "relationships"
        const val AUTH_SCOPE_LIKES = "likes"

        const val AUTH_SCOPE_FULL = AUTH_SCOPE_BASIC + "+" + AUTH_SCOPE_PUBLIC_CONTENT + "+" +
                AUTH_SCOPE_FOLLOWER_LIST + "+" + AUTH_SCOPE_COMMENTS + "+" +
                AUTH_SCOPE_RELATIONSHIPS + "+" + AUTH_SCOPE_LIKES

        const val BASE_URL = "https://api.instagram.com/v1/"
        lateinit var ACCESS_TOKEN : String

        fun initialize(accessToken: String) {
            ACCESS_TOKEN = accessToken
        }
    }
}