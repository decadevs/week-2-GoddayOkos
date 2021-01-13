package dev.decagon.godday.godday_week_two_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity2 : AppCompatActivity() {

    // properties of the class
    private val manager = supportFragmentManager
    private lateinit var addFragment: Button
    private lateinit var removeFragment: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        addFragment = findViewById(R.id.btnFragment1)
        addFragment.setOnClickListener { action() }    // action() is called whenever this button is clicked

        removeFragment = findViewById(R.id.btnFragment2)
        removeFragment.setOnClickListener {            // the topmost fragment is removed from the stack whenever this button is clicked
            manager.popBackStack()
        }
    }

    // this method adds a new instance of fragment to the activity whenever the addFragment button is clicked
    private fun action() {
        val count = manager.backStackEntryCount + 1
        manager.beginTransaction().apply {
            add(R.id.flFragment, FirstFragment.newInstance(count))
            addToBackStack(null)
            commit()
        }
    }
}