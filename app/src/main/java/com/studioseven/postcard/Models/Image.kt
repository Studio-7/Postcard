package com.studioseven.postcard.Models

import android.content.Context
import android.widget.Toast

class Image(var url: String) {

    fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

}
