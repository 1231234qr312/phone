package com.example.callproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.callproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val dataList=mutableListOf<MyItem>()
    val adapter = MyAdapter(dataList){
        Onclick(it)
    }
    lateinit var binding:ActivityMainBinding
    val Tag:String="로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        dataList.add(MyItem(R.drawable.face1,"이름1","010-1234-4561"))
        dataList.add(MyItem(R.drawable.face2,"이름2","010-1234-4561"))
        dataList.add(MyItem(R.drawable.face3,"이름3","010-1234-4561"))
        dataList.add(MyItem(R.drawable.face4,"이름4","010-1234-4561"))
        dataList.add(MyItem(R.drawable.face5,"이름5","010-1234-4561"))
        dataList.add(MyItem(R.drawable.face7,"이름7","010-1234-4561"))
        dataList.add(MyItem(R.drawable.face8,"이름8","010-1234-4561"))
        dataList.add(MyItem(R.drawable.face9,"이름9","010-1234-4561"))
        dataList.add(MyItem(R.drawable.face10,"이름10","010-1234-4561"))



        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        Log.d(Tag,"MainActivity onCreate() called")





    }

    fun Onclick(checkedItem:MyItem){
    checkedItem.checkbox=!checkedItem.checkbox
    dataList.sortBy { !it.checkbox }
    Log.d(Tag,"MainActivity onCreate() called")
        adapter.notifyDataSetChanged()
    }

}