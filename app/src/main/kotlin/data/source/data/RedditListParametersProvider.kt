package com.oleeja.reditclient.data.source.data

data class RedditListParametersProvider (
    var subreddit: String = "all",
    var time: String = "day",
    var maxCount: Int = 50,
    var countOnPage: Int = 10,
    var after : String = ""
)