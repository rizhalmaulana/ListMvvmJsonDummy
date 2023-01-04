package com.rizal.listdataproject.helper

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.rizal.listdataproject.model.User

class UserResponse {
    @SerializedName("data")
    @Expose
    private var data: User?= null

    fun getData(): User? {
        return data
    }

    fun setData(data: User?) {
        this.data = data
    }

}