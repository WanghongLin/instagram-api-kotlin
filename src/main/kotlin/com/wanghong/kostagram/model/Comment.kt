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
import java.net.HttpURLConnection

data class Comment(val created_time: Long,
                   val text: String,
                   val from: User,
                   val id: String) {

    companion object {

        /**
         * Get a list of recent comments on a media object.
         */
        fun comments(mediaId: String): List<Comment>? {
            return InstagramAPI.getService().mediaComments(mediaId).execute().body()?.data
        }

        /**
         * Create a comment on a media object with the following rules:
         *
         * * The total length of the comment cannot exceed 300 characters.
         * * The comment cannot contain more than 4 hashtags.
         * * The comment cannot contain more than 1 URL.
         * * The comment cannot consist of all capital letters.
         */
        fun addComment(mediaId: String, text: String): Boolean? {
            return InstagramAPI.getService().mediaAddComment(mediaId, text).execute().body()?.meta?.isSuccessful()
        }

        /**
         * Remove a comment either on the authenticated user's media object or authored by the authenticated user.
         */
        fun removeComment(mediaId: String, commentId: String): Boolean? {
            return InstagramAPI.getService().mediaRemoveComment(mediaId, commentId).execute().body()?.meta?.isSuccessful()
        }

    }
}