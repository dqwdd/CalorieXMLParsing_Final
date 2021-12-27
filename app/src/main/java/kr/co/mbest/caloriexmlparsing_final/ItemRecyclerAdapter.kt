package kr.co.mbest.caloriexmlparsing_final

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apipractice.json.Item


class ItemRecyclerAdapter(
    val mContext: Context,
    val mList: List<Item>) :
    RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder>() {

    class ItemViewHolder(val mContext: Context, view : View) : RecyclerView.ViewHolder(view) {

        val textView = view.findViewById<TextView>(R.id.tv_desk_kor)
        val textView2 = view.findViewById<TextView>(R.id.tv_serving_wt)
        val textView3 = view.findViewById<TextView>(R.id.tv_nutr_cont1)
        val textView4 = view.findViewById<TextView>(R.id.tv_nutr_cont3)

        fun bind( context: Context, data: Item ) {
            textView.text =data.DESC_KOR
            textView2.text =data.SERVING_WT
            textView3.text =data.NUTR_CONT1
            textView4.text =data.NUTR_CONT3
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_colorie_data_list, parent, false)
        return ItemViewHolder(mContext, view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = mList[position]
        holder.bind(mContext, data)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}