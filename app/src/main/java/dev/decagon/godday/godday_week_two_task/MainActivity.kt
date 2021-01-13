package dev.decagon.godday.godday_week_two_task

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView

private const val KEY = "KEY"      // This KEY is used to save the orientationChangeCount in saveInstanceState

class MainActivity : AppCompatActivity() {

    // Declaring the properties of the class
    private lateinit var showState: TextView
    private lateinit var showOrient: TextView
    private val handler = Handler()
    private var orientationChangeCount = - 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check if there is a saved Instance, if there is, the orientationChangeCount is updated with the saved value
        savedInstanceState?.let {
            orientationChangeCount = it.getInt(KEY)
        }

        // Check the current orientation of the screen and display it on the screen
        val orientation = this.resources.configuration.orientation
        showOrient = findViewById(R.id.mode)

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            orientationChangeCount += 1
            showOrient.text = getString(R.string.screenMode, "Portrait $orientationChangeCount")
        } else {
            orientationChangeCount += 1
            showOrient.text = getString(R.string.screenMode, "Landscape $orientationChangeCount")
        }

        // show the current activity lifecycle using handler to delay the message
        showState = findViewById(R.id.state)
        handler.postDelayed({showState.text = getString(R.string.currentState, "onCreate")}, 0)
    }

    // show the current activity lifecycle using handler to delay the message
    override fun onStart() {
        super.onStart()
        showState = findViewById(R.id.state)
        handler.postDelayed({showState.text = getString(R.string.currentState, "onStart")}, 2000)
    }

    // show the current activity lifecycle using handler to delay the message
    override fun onResume() {
        super.onResume()
        showState = findViewById(R.id.state)
        handler.postDelayed({showState.text = getString(R.string.currentState, "onResume")}, 3000)
    }

    // show the current activity lifecycle
    override fun onPause() {
        super.onPause()
        showState = findViewById(R.id.state)
        showState.text = getString(R.string.currentState, "OnPause")
    }

    // show the current activity lifecycle using handler to delay the message
    override fun onStop() {
        super.onStop()
        showState = findViewById(R.id.state)
        handler.postDelayed({showState.text = getString(R.string.currentState, "onStop")}, 2000)
    }

    // save the current orientationChangeCount before the current activity is destroyed
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY, orientationChangeCount)
    }

    // show the current activity lifecycle using handler to delay the message
    override fun onDestroy() {
        super.onDestroy()
        showState = findViewById(R.id.state)
        handler.postDelayed({showState.text = getString(R.string.currentState, "onDestroy")}, 0)
    }

    // show the current activity lifecycle using handler to delay the message
    override fun onRestart() {
        super.onRestart()
        showState = findViewById(R.id.state)
        handler.postDelayed({showState.text = getString(R.string.currentState, "onRestart")}, 1000)
    }

    // This method opened the second activity using intent when the user clicks on the implementation 2 button
    fun openActivity2(v: View) {
        val intent = Intent(this, Activity2::class.java)
        startActivity(intent)
    }


}