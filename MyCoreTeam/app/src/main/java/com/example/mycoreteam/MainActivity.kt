package com.example.mycoreteam

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycoreteam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<CoreUser>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvUsers.setHasFixedSize(true)

        list.apply {
            clear()
            list.addAll(listData)
        }
        showRecyclerList()
    }

    private val listData: ArrayList<CoreUser>
        @SuppressLint("Recycle")
        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataPosition = resources.getStringArray(R.array.position)
            val dataMajor = resources.getStringArray(R.array.major)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)

            val listUser = ArrayList<CoreUser>()
            for (i in dataName.indices){
                val user = CoreUser(
                    dataName[i],
                    dataPosition[i],
                    dataMajor[i],
                    dataAvatar.getResourceId(i,-1)
                )
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerList() {
        binding.rvUsers.layoutManager = LinearLayoutManager(this)

        val listUserAdapter = ListUserAdapter(list)
        binding.rvUsers.adapter = listUserAdapter
    }
}