package com.rizal.listdataproject.adapter

import com.rizal.listdataproject.helper.ApiInterface
import retrofit2.Response

class UserRepository (private val apiInterface: ApiInterface) {
    fun getAllData() = apiInterface.getAllData()
}