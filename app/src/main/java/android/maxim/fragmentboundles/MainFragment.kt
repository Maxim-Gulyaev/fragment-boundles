package android.maxim.fragmentboundles

import android.content.Context
import android.maxim.fragmentboundles.databinding.FragmentMainBinding
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.javafaker.Faker
import kotlin.properties.Delegates
import kotlin.random.Random

class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var randomText: String
    private var randomColor by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        randomColor = savedInstanceState?.getInt(KEY_COLOR) ?: -Random.nextInt(0xffffff)
        randomText = savedInstanceState?.getString(KEY_TEXT) ?: Faker().rickAndMorty().quote()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView")
        binding = FragmentMainBinding.inflate(layoutInflater)
        binding.frColor.setBackgroundColor(randomColor)
        binding.tvText.text = randomText
        binding.btnChange.setOnClickListener{ changeColorAndText() }
        binding.btnToAnotherFragment.setOnClickListener { goToAnotherActivity() }
        return binding.root
    }

    private fun changeColorAndText() {
        navigator().changeColorAndText()
    }

    private fun goToAnotherActivity() {
        navigator().toAnotherFragment()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COLOR, randomColor)
        outState.putString(KEY_TEXT, randomText)
    }

    companion object {
        private const val TAG = "TAG"
        private const val KEY_COLOR = "KEY_COLOR"
        private const val KEY_TEXT = "KEY_TEXT"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach")
    }
}