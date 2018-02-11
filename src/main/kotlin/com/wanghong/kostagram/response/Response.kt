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

package com.wanghong.kostagram.response

import com.wanghong.kostagram.model.*

open class Response {
    lateinit var meta: Meta
}

data class GenericResponse(val data: String) : Response()

data class UserResponse(val data: User) : Response()
data class UserListResponse(val data: List<User>) : Response()

data class MediaResponse(val data: Media) : Response()
data class MediaListResponse(val data: List<Media>) : Response()

data class LocationResponse(val data: Location) : Response()
data class LocationListResponse(val data: List<Location>) : Response()

data class TagResponse(val data: Tag) : Response()
data class TagListResponse(val data: List<Tag>) : Response()

data class RelationshipResponse(val data: Relationship) : Response()

data class CommentListResponse(val data: List<Comment>) : Response()