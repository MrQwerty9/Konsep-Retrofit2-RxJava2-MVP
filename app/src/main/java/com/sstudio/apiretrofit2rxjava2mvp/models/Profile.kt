package com.sstudio.apiretrofit2rxjava2mvp.models

import com.google.gson.annotations.SerializedName

data class Profile (
    @SerializedName("name")
    var nameProfile: String?

)