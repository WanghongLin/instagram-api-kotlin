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

const val OUTGOING_FOLLOWS = "follows"
const val OUTGOING_REQUESTED = "requested"
const val OUTGOING_NONE = "none"

const val INCOMING_FOLLOWED_BY = "followed_by"
const val INCOMING_REQUESTED_BY = "requested_by"
const val INCOMING_BLOCKED_BY_YOU = "blocked_by_you"

const val RELATIONSHIP_ACTION_FOLLOW = "follow"
const val RELATIONSHIP_ACTION_UNFOLLOW = "unfollow"
const val RELATIONSHIP_ACTION_APPROVE = "approve"
const val RELATIONSHIP_ACTION_IGNORE = "ignore"

data class Relationship(val outgoing_status: String,
                        val incoming_status: String) {
    companion object {

        /**
         * Get a list of users this user follow
         */
        fun follows(): List<User>? {
            val response = InstagramAPI.getService().usersFollows().execute()
            return response.body()?.data
        }

        /**
         * Get a list of users this user is followed by
         */
        fun followedBy(): List<User>? {
            return InstagramAPI.getService().usersFollowedBy().execute().body()?.data
        }

        /**
         * List the users who have requested to follow
         */
        fun requestedBy(): List<User>? {
            return InstagramAPI.getService().usersRequestedBy().execute().body()?.data
        }

        /**
         * Get information about a relationship to another user
         */
        fun relationship(userId: String): Relationship? {
            return InstagramAPI.getService().usersRelationship(userId).execute().body()?.data
        }

        /**
         * Modify the relationship with target user
         *
         * @param userId the target user id
         * @param action the action to perform, must be one of
         * * [RELATIONSHIP_ACTION_FOLLOW]
         * * [RELATIONSHIP_ACTION_UNFOLLOW]
         * * [RELATIONSHIP_ACTION_APPROVE]
         * * [RELATIONSHIP_ACTION_IGNORE]
         */
        fun relationship(userId: String, action: String): Relationship? {
            return InstagramAPI.getService().usersRelationship(userId, action).execute().body()?.data
        }

    }
}