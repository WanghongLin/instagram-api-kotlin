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

package com.wanghong.kostagram.model

import com.wanghong.kostagram.api.InstagramAPI

/**
 * Created by mutter on 2/7/18.
 */
data class User(val id: String,
                val username: String,
                val full_name: String,
                val first_name: String,
                val last_name: String,
                val profile_picture: String,
                val bio: String,
                val website: String,
                val is_business: Boolean,
                val type: String,
                val counts: UserCount) {

    companion object {

        /**
         * Get information about a user
         *
         * @param userId the user id, return the owner of access token if ignore
         * @return a user
         */
        fun info(userId: String = "self"): User? {
            val response = InstagramAPI.getService().usersInfo(userId).execute()
            return response.body()?.data
        }

        /**
         * Get most recent media of a user
         *
         * @param userId the user id
         * @return media list
         */
        fun recentMedia(userId: String = "self"): List<Media>? {
            val response = InstagramAPI.getService().usersRecentMedia(userId).execute()
            return response.body()?.data
        }

        /**
         * Get the recent media liked by user (the owner of access token)
         *
         * @return a media list liked by user
         */
        fun likedMedia(): List<Media>? {
            val response = InstagramAPI.getService().usersLikedMedia("self").execute()
            return response.body()?.data
        }

        fun search(query: String): List<User>? {
            val response = InstagramAPI.getService().usersSearch(query).execute()
            return response.body()?.data
        }
    }
}