# instagram-api-kotlin

Instagram open api [endpoints](!https://www.instagram.com/developer/endpoints/) wrapper in kotlin.

This library is not in released state, be careful to use.

```
repositories {
    // ...
    maven { 
        url 'https://dl.bintray.com/wanghonglin/maven/' 
    }
    // ...
}

dependencies {
    // ...
    compile 'com.wanghong.kostagram:instagram-api-kotlin:0.0.1'
    // ...
}
```

### Some example codes
```kotlin
val accessToken // get your access token
EndPoints.initialize(accessToken)

// user endpoints
User.info()
User.recentMedia()
User.search("query")

// media endpoints
Media.info("mediaId")
Media.search("query")
Media.addLike("mediaId")
Media.removeLike("mediaId")

// comment endpoints
Comment.addComment("mediaId", "text")
// ...

// location endpoints
Location.info("locationId")

// tag endpoints
Tag.tagInfo("tagName")

// ...
// see com.wanghong.kostagram.model for more endpoints
```
All the endpoints are called in synchronized mode, thus will block current thread.