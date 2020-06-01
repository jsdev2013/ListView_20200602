package com.jisu.listview_20200601

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){
    val mContext = this

    abstract fun setupEvents()
    abstract fun setValues()
}