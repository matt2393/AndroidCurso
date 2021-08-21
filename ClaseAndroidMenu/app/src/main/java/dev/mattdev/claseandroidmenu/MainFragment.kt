package dev.mattdev.claseandroidmenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.mattdev.claseandroidmenu.databinding.FragmentMainBinding

class MainFragment: Fragment() {

    companion object {
        val TAG = MainFragment::getTag.name
        private const val TITLE = "TIT"
        private const val DESC = "DEs"
        fun newInstance(title: String, desc: String) = MainFragment().apply {
            arguments = Bundle().apply {
                putString(TITLE, title)
                putString(DESC, desc)
            }
        }
    }

    private var binding: FragmentMainBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        var tit = ""
        var desc = ""
        arguments?.let {
            tit = it.getString(TITLE, "")
            desc = it.getString(DESC, "")
        }

        binding?.textTitleMain?.text = tit
        binding?.textDescMain?.text = desc

        return binding?.root
    }
}