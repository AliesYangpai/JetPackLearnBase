package com.alie.navigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.alie.navigation.Const
import com.alie.navigation.R



/**
 * A simple [Fragment] subclass.
 * Use the [MsgFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MsgFragment : Fragment() {
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(Const.FG_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(activity?.applicationContext,param1, Toast.LENGTH_SHORT).show()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_msg, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MsgFragment().apply {
                arguments = Bundle().apply {
                    putString(Const.FG_KEY, param1)
                }
            }
    }
}