package com.example.clockifylr

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

/**
 * Created by Lokesh Mudgal on 5/3/20.
 */


class GitCommits {
    @SerializedName("sha")
    @Expose
    var sha: String? = null

    @SerializedName("node_id")
    @Expose
    var nodeId: String? = null

    @SerializedName("commit")
    @Expose
    var commit: Commit? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null

    @SerializedName("comments_url")
    @Expose
    var commentsUrl: String? = null

    @SerializedName("author")
    @Expose
    var author: Author_? = null

    @SerializedName("committer")
    @Expose
    var committer: Committer_? = null

    @SerializedName("parents")
    @Expose
    var parents: List<Parent>? = null

}

class Author {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("date")
    @Expose
    var date: String? = null

}

class Author_ {
    @SerializedName("login")
    @Expose
    var login: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("node_id")
    @Expose
    var nodeId: String? = null

    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String? = null

    @SerializedName("gravatar_id")
    @Expose
    var gravatarId: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null

    @SerializedName("followers_url")
    @Expose
    var followersUrl: String? = null

    @SerializedName("following_url")
    @Expose
    var followingUrl: String? = null

    @SerializedName("gists_url")
    @Expose
    var gistsUrl: String? = null

    @SerializedName("starred_url")
    @Expose
    var starredUrl: String? = null

    @SerializedName("subscriptions_url")
    @Expose
    var subscriptionsUrl: String? = null

    @SerializedName("organizations_url")
    @Expose
    var organizationsUrl: String? = null

    @SerializedName("repos_url")
    @Expose
    var reposUrl: String? = null

    @SerializedName("events_url")
    @Expose
    var eventsUrl: String? = null

    @SerializedName("received_events_url")
    @Expose
    var receivedEventsUrl: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("site_admin")
    @Expose
    var siteAdmin: Boolean? = null

}

class Commit {
    @SerializedName("author")
    @Expose
    var author: Author? = null

    @SerializedName("committer")
    @Expose
    var committer: Committer? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("tree")
    @Expose
    var tree: Tree? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("comment_count")
    @Expose
    var commentCount: Int? = null

    @SerializedName("verification")
    @Expose
    var verification: Verification? = null

}

class Committer {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("date")
    @Expose
    var date: String? = null

}

class Committer_ {
    @SerializedName("login")
    @Expose
    var login: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("node_id")
    @Expose
    var nodeId: String? = null

    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String? = null

    @SerializedName("gravatar_id")
    @Expose
    var gravatarId: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null

    @SerializedName("followers_url")
    @Expose
    var followersUrl: String? = null

    @SerializedName("following_url")
    @Expose
    var followingUrl: String? = null

    @SerializedName("gists_url")
    @Expose
    var gistsUrl: String? = null

    @SerializedName("starred_url")
    @Expose
    var starredUrl: String? = null

    @SerializedName("subscriptions_url")
    @Expose
    var subscriptionsUrl: String? = null

    @SerializedName("organizations_url")
    @Expose
    var organizationsUrl: String? = null

    @SerializedName("repos_url")
    @Expose
    var reposUrl: String? = null

    @SerializedName("events_url")
    @Expose
    var eventsUrl: String? = null

    @SerializedName("received_events_url")
    @Expose
    var receivedEventsUrl: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("site_admin")
    @Expose
    var siteAdmin: Boolean? = null

}

class Parent {
    @SerializedName("sha")
    @Expose
    var sha: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null

}

class Tree {
    @SerializedName("sha")
    @Expose
    var sha: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

}

class Verification {
    @SerializedName("verified")
    @Expose
    var verified: Boolean? = null

    @SerializedName("reason")
    @Expose
    var reason: String? = null

    @SerializedName("signature")
    @Expose
    var signature: Any? = null

    @SerializedName("payload")
    @Expose
    var payload: Any? = null

}