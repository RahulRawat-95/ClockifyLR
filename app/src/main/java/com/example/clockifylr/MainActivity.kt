package com.example.clockifylr

import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private val myFormat = "hh:mm a" // your own format
    val timeZoneFormat = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSSSS'Z'", Locale.US)
    val sdf = SimpleDateFormat(myFormat, Locale.US)
    private var inTime: Long = 0
    private var outTime: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val messages = ArrayList<String>()

        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        val sinceDate = timeZoneFormat.format(calendar.time)

        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1)

        val untilDate = timeZoneFormat.format(calendar.time)

        RemoteRepoImpl.getCommits(
            BuildConfig.GIT_AUTH_TOKEN,
            "lokeshvinsol",
            sinceDate,
            untilDate,
            {
                for (gitCommit in it) {
                    val message = gitCommit.commit?.message
                    if (message != null)
                        messages.add(message)
                }
            }, {

            }
        )

        tv_in_time.setOnClickListener {
            val mcurrentTime: Calendar = Calendar.getInstance()
            val hour: Int = mcurrentTime.get(Calendar.HOUR_OF_DAY)
            val minute: Int = mcurrentTime.get(Calendar.MINUTE)
            val mTimePicker: TimePickerDialog

            mTimePicker = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { p0, inHour, inMinute ->
                    val datetime = Calendar.getInstance()
                    datetime[Calendar.HOUR_OF_DAY] = inHour
                    datetime[Calendar.MINUTE] = inMinute

                    val formatted_time: String = sdf.format(datetime.getTime())
                    inTime = datetime.timeInMillis
                    tv_show_in_time.text = formatted_time
                }, hour, minute, false
            )
            mTimePicker.setTitle(getString(R.string.set_in_time))
            mTimePicker.show()
        }
        tv_out_time.setOnClickListener {
            val mcurrentTime: Calendar = Calendar.getInstance()
            val hour: Int = mcurrentTime.get(Calendar.HOUR_OF_DAY)
            val minute: Int = mcurrentTime.get(Calendar.MINUTE)
            val mTimePicker: TimePickerDialog

            mTimePicker = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { p0, outHour, outMinute ->
                    val datetime = Calendar.getInstance()
                    datetime[Calendar.HOUR_OF_DAY] = outHour
                    datetime[Calendar.MINUTE] = outMinute

                    val formatted_time: String = sdf.format(datetime.getTime())
                    outTime = datetime.timeInMillis
                    tv_show_out_time.text = formatted_time
                }, hour, minute, false
            )
            mTimePicker.setTitle(getString(R.string.set_out_time))
            mTimePicker.show()
        }
    }
}
