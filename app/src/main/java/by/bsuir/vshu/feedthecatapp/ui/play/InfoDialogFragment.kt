package by.bsuir.vshu.feedthecatapp.ui.play

import by.bsuir.vshu.feedthecatapp.R

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class InfoDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Лабораторная работа № 1")
                .setMessage("Шустовский Виталий\n951008")
                .setIcon(R.drawable.info)
                .setPositiveButton("Close") {
                        dialog, id ->  dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
