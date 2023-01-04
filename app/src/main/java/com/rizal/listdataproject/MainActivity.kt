package com.rizal.listdataproject

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rizal.listdataproject.adapter.UserAdapter
import com.rizal.listdataproject.adapter.UserRepository
import com.rizal.listdataproject.databinding.ActivityMainBinding
import com.rizal.listdataproject.helper.ApiInterface
import com.rizal.listdataproject.viewmodel.MainViewModel
import com.rizal.listdataproject.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    private val retrofitService = ApiInterface.getInstance()
    private val adapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(UserRepository(retrofitService))
        )[MainViewModel::class.java]

        binding.rvUser.layoutManager = LinearLayoutManager(this)
        binding.rvUser.adapter = adapter

        viewModel.getAllData()

        viewModel.userList.observe(this) {
            Log.d(TAG, "onCreate: $it")
            adapter.setUserList(it)
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(applicationContext, it, Toast.LENGTH_LONG).show()
        }
    }
}