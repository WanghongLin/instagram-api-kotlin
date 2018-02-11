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

data class Location(val latitude: Double,
               val longitude: Double,
               val id: String,
               val street_address: String,
               val name: String) {

    companion object {
        /**
         * Get information about a location.
         */
        fun info(locationId: String): Location? {
            return InstagramAPI.getService().locationsInfo(locationId).execute().body()?.data
        }

        /**
         * Get a list of recent media objects from a given location.
         *
         * @param locationId location id
         * @param maxId Return media after this max_id.
         * @param minId Return media before this min_id.
         */
        fun recentMedia(locationId: String, maxId: String? = null, minId: String? = null): List<Media>? {
            return InstagramAPI.getService().locationsRecentMedia(locationId, maxId, minId)
                    .execute().body()?.data
        }

        /**
         * Search for a location by geographic coordinate.
         *
         * @param lat Latitude of the center search coordinate. If used, lng is required.
         * @param lng Longitude of the center search coordinate. If used, lat is required.
         * @param distance Default is 500m (distance=500), max distance is 750.
         * @param facebook_places_id Returns a location mapped off of a Facebook places id. If used, lat and lng are not required.
         */
        fun search(lat: Double, lng: Double, distance: Int = 500, facebook_places_id: String? = null): List<Location>? {
            return InstagramAPI.getService().locationsSearch(lat, lng, distance, facebook_places_id)
                    .execute().body()?.data
        }
    }
}