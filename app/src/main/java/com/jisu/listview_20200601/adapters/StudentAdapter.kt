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
import java.time.LocalDate
import java.util.*
import kotlin.time.days

class StudentAdapter(context: Context, resId: Int, list: List<Student>) :ArrayAdapter<Student>(context, resId, list) {

    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if(tempRow == null){
            tempRow = inf.inflate(R.layout.student_list_item, null)
        }

        val row = tempRow!!

        val data = mList.get(position)

        val nameAndAgeTxt = row.findViewById<TextView>(R.id.nameAndAgeTxt)
        val genderTxt = row.findViewById<TextView>(R.id.genderTxt)
        val birthTxt = data.birthYear

        // 한국 현재 나이 구하기
        var curTime = System.currentTimeMillis()
        val dateFormat = SimpleDateFormat("yyyy", Locale.KOREAN)
        val curDate = dateFormat.format(curTime)
        val age = (curDate.toInt() - birthTxt + 1).toString()
        val name = data.name

        nameAndAgeTxt.text = "$name ($age)"

        if(data.isMale){
            genderTxt.text = "남성"
        } else {
            genderTxt.text = "여성"
        }

        return row
    }
}