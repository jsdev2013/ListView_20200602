package com.jisu.listview_20200601

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.jisu.listview_20200601.adapters.StudentAdapter
import com.jisu.listview_20200601.datas.Student

class MainActivity : BaseActivity() {

    val students = ArrayList<Student>()
    lateinit var studentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        studentListView.setOnItemClickListener { parent, view, position, id ->
            val clickedStudent = students.get(position)
            Toast.makeText(mContext, clickedStudent.name, Toast.LENGTH_SHORT).show()
        }

        studentListView.setOnItemLongClickListener { parent, view, position, id ->
//            var clickedStudent = students[position]
//            Toast.makeText(mContext, "${clickedStudent.name} 오래 누름", Toast.LENGTH_SHORT).show()
            val alert = AlertDialog.Builder(mContext)
            alert.setTitle("삭제 확인")
            alert.setMessage("정말 이 학생을 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                students.removeAt(position)
                studentAdapter.notifyDataSetChanged()
            })

            alert.setNegativeButton("취소", DialogInterface.OnClickListener { dialog, which -> null })
            alert.show()

            return@setOnItemLongClickListener true
        }
    }

    override fun setValues() {
        students.add(Student("일일일", 1954, true))
        students.add(Student("이이이", 1984, false))
        students.add(Student("삼삼삼", 1987, false))
        students.add(Student("시시시", 1986, false))
        students.add(Student("오오오", 1984, true))
        students.add(Student("육육육", 1981, true))

        studentAdapter = StudentAdapter(mContext, R.layout.room_list_item, students)
        studentListView.adapter = studentAdapter
    }
}
