@file:DependsOn("com.squareup.okhttp3:okhttp:4.7.2")
@file:DependsOn("org.json:json:20200518")

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import kotlin.system.exitProcess

/**
 * Created by Muhammad Aswan Abidin on 03/07/21.
 * Copyright (c) 2021 Aswan Abidin Repository. All rights reserved.
 **/

/* Example Base URL
 * https://api.github.com
 * https://api.spotify.com
 **/

/* Example Endpoints GitHub Apps *
 * /events
 * /feeds
 * /users/google/followers
 * /users/google/following
 **/

/* Example Endpoints Spotify with OAuth Required
 * /v1/me
 * /v1/recommendations
 **/

/* Spotify Documentation *
 * https://developer.spotify.com/documentation/web-api/reference/#endpoint-get-an-album
 **/

println("=================== Welcome to API Endpoints Testing ===================")

println("Please Input Base Url (e.g.: github, spotify) : ")
val baseUrl = readLine()

println("==== Endpoints Available ===")
println("GITHUB : events, feeds, users/google/followers, users/google/following")
println("SPOTIFY : v1/me, v1/recommendations")
println("============================")

println("Please Input Endpoints (see above for endpoint type) : ")
val endpoint = readLine()

println("Please Input OAuth Token (if using API spotify) : ")
val oAuthToken = readLine()

println("================== Fetching data, please wait.... ==================")

val client = OkHttpClient()

fun isBaseUrl(): String {
    return when (baseUrl) {
        HostUrlType.GITHUB.hostUrl -> BaseUrl.GITHUB.url
        HostUrlType.SPOTIFY.hostUrl -> BaseUrl.SPOTIFY.url
        else -> BaseUrl.EMPTY.url
    }
}

val urlPlain = isBaseUrl().plus(endpoint)

fetchData()

fun fetchData() {
    client.newCall(requestHttp()).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            println("==================== Response Failure ====================")
            println(e.message)

            println("=================== Finished API Endpoints Testing ===================")

            exitProcess(1)
        }

        override fun onResponse(call: Call, response: Response) {
            println("==================== Response Success ====================")
            println("URL : $urlPlain")

            val responseBody = response.body?.string()
            println(responseBody)

            println("=================== Finished API Endpoints Testing ===================")

            exitProcess(1)
        }
    })
}

fun isAuthorization(): String {
    return when (baseUrl) {
        HostUrlType.SPOTIFY.hostUrl -> "Bearer ${oAuthToken.orEmpty()}"
        else -> ""
    }
}

/**
 * Functions for providing network request
 */

fun requestHttp(): Request {
    return Request.Builder()
        .url(urlPlain)
        .addHeader("Authorization", isAuthorization())
        .addHeader("Content-Type", "application/json")
        .addHeader("Accept", "application/json")
        .build()
}

enum class BaseUrl {
    GITHUB, SPOTIFY, EMPTY;

    val url: String
        get() = when (this) {
            GITHUB -> "https://api.github.com/"
            SPOTIFY -> "https://api.spotify.com/"
            EMPTY -> ""
        }
}

enum class HostUrlType {
    GITHUB, SPOTIFY;

    val hostUrl: String
        get() = when (this) {
            GITHUB -> "github"
            SPOTIFY -> "spotify"
        }
}
