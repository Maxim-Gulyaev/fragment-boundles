package android.maxim.fragmentboundles

import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    fun changeColorAndText()

    fun toAnotherFragment()

    fun goBack()

}