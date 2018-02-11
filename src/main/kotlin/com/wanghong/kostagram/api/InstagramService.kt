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

import com.wanghong.kostagram.response.*
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by mutter on 2/7/18.
 */
interface InstagramService {

    @GET("users/{userId}")
    fun usersInfo(@Path("userId") userId: String): Call<UserResponse>

    @GET("users/{userId}/media/recent")
    fun usersRecentMedia(@Path("userId") userId: String): Call<MediaListResponse>

    @GET("users/{userId}/media/liked")
    fun usersLikedMedia(@Path("userId") userId: String): Call<MediaListResponse>

    @GET("users/search")
    fun usersSearch(@Query("q") query: String): Call<UserListResponse>

    @GET("users/self/follows")
    fun usersFollows(): Call<UserListResponse>

    @GET("users/self/followed-by")
    fun usersFollowedBy(): Call<UserListResponse>

    @GET("users/self/requested-by")
    fun usersRequestedBy(): Call<UserListResponse>

    @GET("users/{userId}/relationship")
    fun usersRelationship(@Path("userId") userId: String): Call<RelationshipResponse>

    @POST("users/{userId}/relationship")
    fun usersRelationship(@Path("userId") userId: String,
                          @Query("action") action: String) : Call<RelationshipResponse>

    @GET("media/{mediaId}")
    fun mediaInfo(@Path("mediaId") mediaId: String): Call<MediaResponse>

    @GET("media/shortcode/{shortCode}")
    fun mediaInfoShortCode(@Path("shortCode") shortCode: String): Call<MediaResponse>

    @GET("media/search")
    fun mediaSearch(@Query("lat") lat: Double,
                    @Query("lng") lng: Double,
                    @Query("distance") distance: Int = 1000): Call<MediaListResponse>

    @GET("media/{mediaId}/comments")
    fun mediaComments(@Path("mediaId") mediaId: String): Call<CommentListResponse>

    @POST("media/{mediaId}/comments")
    fun mediaAddComment(@Path("mediaId") mediaId: String,
                        @Query("text") text: String): Call<GenericResponse>

    @DELETE("media/{mediaId}/comments/{commentId}")
    fun mediaRemoveComment(@Path("mediaId") mediaId: String,
                           @Path("commentId") commentId: String): Call<GenericResponse>

    @GET("media/{mediaId}/likes")
    fun mediaLikes(@Path("mediaId") mediaId: String): Call<UserListResponse>

    @POST("media/{mediaId}/likes")
    fun mediaAddLike(@Path("mediaId") mediaId: String): Call<GenericResponse>

    @DELETE("media/{mediaId}/likes")
    fun mediaRemoveLike(@Path("mediaId") mediaId: String): Call<GenericResponse>

    @GET("tags/{tagName}")
    fun tagsInfo(@Path("tagName") tagName: String): Call<TagResponse>

    @GET("tags/{tagName}/media/recent")
    fun tagsRecentMedia(@Path("tagName") tagName: String,
                        @Query("max_tag_id") maxTagId: String? = null,
                        @Query("min_tag_id") minTagId: String? = null): Call<MediaListResponse>

    @GET("tags/search")
    fun tagsSearch(@Query("q") query: String): Call<TagListResponse>

    @GET("locations/{locationId}")
    fun locationsInfo(@Path("locationId") locationId: String): Call<LocationResponse>

    @GET("locations/{locationId}/media/recent")
    fun locationsRecentMedia(@Path("locationId") locationId: String,
                             @Query("max_id") maxId: String? = null,
                             @Query("min_id") minId: String? = null): Call<MediaListResponse>

    @GET("locations/search")
    fun locationsSearch(@Query("lat") lat: Double,
                        @Query("lng") lng: Double,
                        @Query("distance") distance: Int = 500,
                        @Query("facebook_places_id") facebook_places_id: String? = null): Call<LocationListResponse>

}