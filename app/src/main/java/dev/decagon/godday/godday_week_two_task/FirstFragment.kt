package dev.decagon.godday.godday_week_two_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// constant serves as a key in saving and retrieving the current argument from the Bundle
private const val ARG_PARAM1 = "KEY"

class FirstFragment : Fragment() {

    // properties of the class
    private var param1: Int? = null     // this is used to keep track of the current position of the fragment in the stack
    private lateinit var fragmentText: TextView

    // a factory method for instantiating the class with a parameter
    companion object {
        fun newInstance(param1: Int) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // checks if there's a saved value in the Bundle and retrieves it
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment and update its text with the current position in the stack
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        fragmentText = view.findViewById(R.id.tvFirstFragment)
        fragmentText.text = getString(R.string.fragmentValue, param1)
        return view
    }

}
