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

import com.sun.org.apache.xpath.internal.operations.Bool
import com.wanghong.kostagram.api.InstagramAPI

data class Media(val comments: Count,
            val caption: Caption,
            val likes: Count,
            val link: String,
            val user: User,
            val created_time: Long,
            val images: Images,
            val videos: Images,
            val type: String,
            val users_in_photo: List<UserInPhoto>,
            val filter: String,
            val tags: List<String>,
            val id: String,
            val location: Location) {
    
    companion object {
        fun info(mediaId: String, shortCode: String? = null): Media? {
            if (shortCode != null) {
                return InstagramAPI.getService().mediaInfoShortCode(shortCode).execute().body()?.data
            }
            return InstagramAPI.getService().mediaInfo(mediaId).execute().body()?.data
        }

        /**
         * Search for recent media in a given area.
         *
         * @param lat Latitude of the center search coordinate. If used, lng is required.
         * @param lng Longitude of the center search coordinate. If used, lat is required.
         * @param distance Default is 1km (distance=1000), max distance is 5km.
         */
        fun search(lat: Double, lng: Double, distance: Int = 1000): List<Media>? {
            return InstagramAPI.getService().mediaSearch(lat, lng, distance).execute().body()?.data
        }

        /**
         * Get a list of users who have liked this media.
         */
        fun likes(mediaId: String): List<User>? {
            return InstagramAPI.getService().mediaLikes(mediaId).execute().body()?.data
        }

        /**
         * Set a like on this media by the currently authenticated user.
         */
        fun addLike(mediaId: String): Boolean? {
            return InstagramAPI.getService().mediaAddLike(mediaId).execute().body()?.meta?.isSuccessful()
        }

        /**
         * Remove a like on this media by the currently authenticated user.
         */
        fun removeLike(mediaId: String): Boolean? {
            return InstagramAPI.getService().mediaRemoveLike(mediaId).execute().body()?.meta?.isSuccessful()
        }
    }
}