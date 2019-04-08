package com.iesb.teologiadebolso.util

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import com.iesb.teologiadebolso.R

class DialogUtil {
    companion object {
        fun MsgShort(context: Context, msg: String){
            Toast.makeText(context,msg, Toast.LENGTH_SHORT).show()
        }

        fun MsgLong(context: Context, msg: String){
            Toast.makeText(context,msg, Toast.LENGTH_LONG).show()
        }

        fun MsgDialogOK(context: Context, title: String, message:String){
            val alert = AlertDialog.Builder(context)
            alert.setTitle(title)
            alert.setMessage(message)
            alert.setNeutralButton(context.getText(R.string.ok), null)
            alert.show()
        }
    }
}