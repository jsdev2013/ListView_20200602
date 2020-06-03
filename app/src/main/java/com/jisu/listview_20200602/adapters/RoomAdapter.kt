package com.jisu.listview_20200602.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.jisu.listview_20200602.R
import com.jisu.listview_20200602.datas.Room
import kotlin.math.abs

class RoomAdapter(context: Context, resId: Int, list: List<Room>) :ArrayAdapter<Room>(context, resId, list) {

    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        /*converView 변수에 재활용할 뷰가 담겨서  getView가 실행됨
        * 처음에 몇개를 그릴때는 재활용할 뷰가 아직없다(그려둔 갯수가 부족해서)
        * converView 변수가 null일 때만 infalte 하자*/
        if(tempRow == null){
            tempRow = inf.inflate(R.layout.room_list_item, null)
        }

        val row = tempRow!!

        val data = mList.get(position) //val data = mList[position]

        val price = row.findViewById<TextView>(R.id.priceTxt)
        var addressFloor = row.findViewById<TextView>(R.id.addressFloorTxt)
        var discription = row.findViewById<TextView>(R.id.discription)

        price.text = data.getFormattedPrice()
        addressFloor.text = "${data.address}, ${data.getFormattedFloor()} "
        discription.text = data.description

        return row
    }
}