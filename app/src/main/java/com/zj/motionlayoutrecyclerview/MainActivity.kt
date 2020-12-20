package com.zj.motionlayoutrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val data1 = arrayListOf<ContactPerson>(
        ContactPerson("Cherry Lilly, US", R.drawable.ic_user_lady2, "Today is rainy."),
        ContactPerson("Michel Trade, UK", R.drawable.ic_user_man1, "A year passed again"),
        ContactPerson(
            "Allen Jack, Germany",
            R.drawable.ic_user_lady1,
            "Tomorrow is sunny\uD83C\uDF1E"
        ),
        ContactPerson(
            "Jimmy Peter, Japan",
            R.drawable.ic_user_man2,
            "We never like what we have.."
        ),
        ContactPerson("Sandy Joke, Canada", R.drawable.ic_user_man1, "Now, I remind of you")
    )

    private val data2 = arrayListOf<ContactPerson>(
        ContactPerson("Cherry Lilly, US", R.drawable.ic_user_lady2, "Today is rainy."),
        ContactPerson("Michel Trade, UK", R.drawable.ic_user_man1, "A year passed again"),
        ContactPerson(
            "Allen Jack, Germany",
            R.drawable.ic_user_lady1,
            "Tomorrow is sunny\uD83C\uDF1E"
        ),
        ContactPerson(
            "Jimmy Peter, Japan",
            R.drawable.ic_user_man2,
            "We never like what we have.."
        ),
    ).reversed()

    private val data3 = arrayListOf<ContactPerson>(
        ContactPerson("Michel Trade, UK", R.drawable.ic_user_man1, "A year passed again"),
        ContactPerson(
            "Allen Jack, Germany",
            R.drawable.ic_user_lady1,
            "Tomorrow is sunny\uD83C\uDF1E"
        ),
        ContactPerson("Sandy Joke, Canada", R.drawable.ic_user_man1, "Now, I remind of you")
    )

    private val data4 = arrayListOf<ContactPerson>(
        ContactPerson("Cherry Lilly, US", R.drawable.ic_user_lady2, "Today is rainy."),
        ContactPerson(
            "Allen Jack, Germany",
            R.drawable.ic_user_lady1,
            "Tomorrow is sunny\uD83C\uDF1E"
        ),
        ContactPerson(
            "Jimmy Peter, Japan",
            R.drawable.ic_user_man2,
            "We never like what we have.."
        ),
        ContactPerson("Sandy Joke, Canada", R.drawable.ic_user_man1, "Now, I remind of you")
    ).reversed()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result = mutableListOf<Any>()
        result.add("title1")
        result.addAll(data1)
        result.add("title2")
        result.addAll(data2)
        result.add("title3")
        result.addAll(data3)
        result.add("title4")
        result.addAll(data4)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MotionListAdapter(this, result as ArrayList<Any>)
        recyclerView.adapter = adapter
    }
}