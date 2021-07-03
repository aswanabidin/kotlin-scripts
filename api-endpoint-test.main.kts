@file:DependsOn("com.squareup.okhttp3:okhttp:4.7.2")
@file:DependsOn("org.json:json:20200518")

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.internal.and
import org.json.JSONObject
import java.io.IOException
import java.util.UUID
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
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
 
/* Example Endpoints Spotify with OAuth Required * {id} is spotify ID of the album *
 * /v1/albums
 * /v1/albums/{id}
 * /v1/albums/{id}/tracks
 **/
  
/* Spotify Documentation *
 * https://developer.spotify.com/documentation/web-api/reference/#endpoint-get-an-album
 **/

println("=================== Welcome to API Endpoints Testing ===================")

println("Please Input Base Url (e.g.: github, spotify) : ")
val baseUrl = readLine()

println("Please Input Endpoints (e.g.: /events, /v1/albums) :")
val endpoint = readLine()

println("Please Input OAuth Token (if using API spotify") :")
val oAuthToken = readLine()


println("================== Fetching data, please wait.... ==================")

val client = OkHttpClient()
