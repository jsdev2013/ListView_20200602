package com.jisu.listview_20200601

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.jisu.listview_20200601.adapters.StudentAdapter
import com.jisu.listview_20200601.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

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

            students.removeAt(position)
            studentAdapter.notifyDataSetChanged()
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

        studentAdapter = StudentAdapter(mContext, R.layout.student_list_item, students)
        studentListView.adapter = studentAdapter
    }
}
