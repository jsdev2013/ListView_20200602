package com.jisu.listview_20200601.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.jisu.listview_20200601.R
import com.jisu.listview_20200601.datas.Student
import java.text.SimpleDateFormat
import java.util.*

class StudentAdapter(context: Context, resId: Int, list: List<Student>) :ArrayAdapter<Student>(context, resId, list) {

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

        val data = mList.get(position)

        val nameAndAgeTxt = row.findViewById<TextView>(R.id.nameAndAgeTxt)
        val genderTxt = row.findViewById<TextView>(R.id.genderTxt)
        val birthTxt = data.birthYear

        // 한국 현재 나이 구하기
        var curTime = System.currentTimeMillis()
        val dateFormat = SimpleDateFormat("yyyy", Locale.KOREAN)
        val curYear = dateFormat.format(curTime)
//        val age = (curYear.toInt() - birthTxt + 1).toString()
//        val name = data.name
//        nameAndAgeTxt.text = "$name ($age)"

        nameAndAgeTxt.text = "${data.name} (${data.getKoreanAge(curYear.toInt())})"

        if(data.isMale){
            genderTxt.text = "남성"
        } else {
            genderTxt.text = "여성"
        }

        return row
    }
}