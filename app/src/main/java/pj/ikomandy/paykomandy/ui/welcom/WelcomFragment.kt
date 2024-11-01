package pj.ikomandy.paykomandy.ui.welcom

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pj.ikomandy.paykomandy.R
import pj.ikomandy.paykomandy.databinding.FragmentWelcomBinding

/**
 * An example full-screen fragment that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class WelcomFragment : Fragment() {

    private var _binding: FragmentWelcomBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as? AppCompatActivity)?.supportActionBar?.hide()
        // Inflate le layout pour ce fragment
        // Assurez-vous que le mode plein écran est activé
        activity?.window?.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        (activity as? AppCompatActivity)?.window?.decorView?.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

        _binding = FragmentWelcomBinding.inflate(inflater, container, false)
        return binding.root
       // return inflater.inflate(R.layout.fragment_welcom, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configure le clic du bouton pour rediriger vers SecondFragment
        binding.signInButton.setOnClickListener {
            findNavController().navigate(R.id.navigation_login)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        // Réactiver l'ActionBar quand on quitte le fragment
        (activity as? AppCompatActivity)?.supportActionBar?.show()
    }
}