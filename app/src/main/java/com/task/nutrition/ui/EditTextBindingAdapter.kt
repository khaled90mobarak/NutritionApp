package com.task.nutrition.ui

import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("app:textwatcher")
fun watcher(view: EditText, textWatcher: TextWatcher){
view.addTextChangedListener(textWatcher)
}