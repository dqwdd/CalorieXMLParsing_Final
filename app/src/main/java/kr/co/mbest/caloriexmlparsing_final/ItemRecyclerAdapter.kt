package kr.co.mbest.caloriexmlparsing_final

import android.content.Context
import android.util.EventLogTags
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apipractice.json.Item

private const val Big = 0
private const val Small = 1

class ItemRecyclerAdapter(
    val mContext: Context,
    val mList: List<Item>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    class BigViewHolder(val mContext: Context, view : View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.big_tv_desk_kor)
        fun bind( context: Context, data: Item ) {
            textView.text =data.DESC_KOR
        }
    }

    class SmallViewHolder(val mContext: Context, view : View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.tv_desk_kor)
        fun bind( context: Context, data: Item ) {
            textView.text =data.BGN_YEAR
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == Big) {
            val view = LayoutInflater.from(mContext).inflate(R.layout.item_colorie_data_list_big, parent, false)
            return BigViewHolder(mContext, view)
        }
        else {
            val view = LayoutInflater.from(mContext).inflate(R.layout.item_colorie_data_list, parent, false)
            return SmallViewHolder(mContext, view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == Big) {
            (holder as BigViewHolder).bind(mContext, mList[position])
        }
        else {
            (holder as SmallViewHolder).bind(mContext, mList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(mList[0] == mList[position]) { Big }
        else { Small }
    }

    override fun getItemCount(): Int {
        return mList.size
    }


}

/*
    class ItemViewHolder(val mContext: Context, view : View) : RecyclerView.ViewHolder(view) {

        val textView = view.findViewById<TextView>(R.id.tv_desk_kor)

        fun bind( context: Context, data: Item ) {
            textView.text =data.DESC_KOR
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        if (mList.)
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_colorie_data_list_big, parent, false)
        return ItemViewHolder(mContext, view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = mList[position]
        holder.bind(mContext, data)
    }

    override fun getItemCount(): Int {
        return mList.size
    }
 */