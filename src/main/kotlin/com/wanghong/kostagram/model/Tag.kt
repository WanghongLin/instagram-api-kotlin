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

data class Tag(val media_count: Int,
               val name: String) {

    companion object {

        /**
         * Get information about a tag object.
         */
        fun tagInfo(tagName: String): Tag? {
            return InstagramAPI.getService().tagsInfo(tagName).execute().body()?.data
        }

        /**
         * Get a list of recently tagged media.
         */
        fun tagRecentMedia(tagName: String, maxTagId: String? = null, minTagId: String? = null): List<Media>? {
            return InstagramAPI.getService().tagsRecentMedia(tagName, maxTagId, minTagId).execute().body()?.data
        }

        /**
         * Search for tags by name.
         *
         * @param query A valid tag name without a leading #. (eg. snowy, nofilter)
         */
        fun tagSearch(query: String): List<Tag>? {
            return InstagramAPI.getService().tagsSearch(query).execute().body()?.data
        }
    }
}