package com.example.callproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.callproject.databinding.CheckeditemBinding
import com.example.callproject.databinding.LayoutRecyclerviewItemBinding

const val NOMAL=0
const val CHEKCED=1
class MyAdapter(val mItems: MutableList<MyItem>,val Onclik:(MyItem)->Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holder = if(viewType== CHEKCED){
            Holder2(CheckeditemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }
        else{
           Holder(LayoutRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }

        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item=mItems[position]
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            Onclik(item)
        }


        if(holder is Holder){
            holder.name.text=item.name
            holder.number.text=item.number
            holder.profileImage.setImageResource(item.profile)
        }
        else if (holder is Holder2){
            holder.name.text=item.name
            holder.number.text=item.number
            holder.profileImage.setImageResource(item.profile)
        }
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(val binding: LayoutRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val profileImage = binding.profileImage
        val name = binding.userName
        val number = binding.userNumber
    }
    inner class Holder2(val binding2:CheckeditemBinding):RecyclerView.ViewHolder(binding2.root){
        val profileImage = binding2.profileImage
        val name = binding2.userName
        val number = binding2.userNumber

    }


    override fun getItemViewType(position: Int): Int {
       if( mItems[position].checkbox){
           return CHEKCED
       }
        else{
            return NOMAL
        }



    }
}