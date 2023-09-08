package kg.kerkin.mobitrade.ui.preferenc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kg.kerkin.mobitrade.FtpWebHost
import kg.kerkin.mobitrade.databinding.FragmentNotificationsBinding
import kg.kerkin.mobitrade.databinding.FragmentPreferencBinding
import kotlinx.coroutines.launch

class PreferencFragment : Fragment() {

    private var _binding: FragmentPreferencBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(PreferencViewModel::class.java)

        _binding = FragmentPreferencBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textPreferenc
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        Thread(
            {
                val ftp =
                    FtpWebHost("ftp.sunbell.webhost.kg", 21, "sunbell_siberica", "Roman911NFS")
                textView.text = ftp.FTPisConnect().toString()
            }).start()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}