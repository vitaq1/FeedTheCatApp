package by.bsuir.vshu.feedthecatapp.ui.play

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import by.bsuir.vshu.feedthecatapp.R
import by.bsuir.vshu.feedthecatapp.ui.onboarding.SlideActivity
import com.airbnb.lottie.LottieAnimationView

class PlayFragment : Fragment(), PlayContract.PlayView {

    private lateinit var presenter: PlayContract.PlayPresenter

    private var tapsTextView: TextView? = null
    private var feedButton: Button? = null
    private var heartAnimationView: LottieAnimationView? = null
    private var shareButton: ImageView? = null
    private var infoButton: ImageView? = null
    private var helpButton: ImageView? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_play, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = PlayPresenter(this)
        tapsTextView = getView()?.findViewById(R.id.tapsText)
        feedButton = getView()?.findViewById<Button>(R.id.feedButton)?.apply { setOnClickListener { feedAction() } }
        heartAnimationView = getView()?.findViewById(R.id.heartAnim)
        shareButton = getView()?.findViewById<ImageView>(R.id.shareButton)?.apply { setOnClickListener { shareAction()} }
        infoButton = getView()?.findViewById<ImageView>(R.id.infoButton)?.apply { setOnClickListener { infoAction()} }
        helpButton = getView()?.findViewById<ImageView>(R.id.helpButton)?.apply { setOnClickListener { showHelpActivity()} }

        presenter.init()
    }



    override fun setTaps(text: String) {
        tapsTextView?.setText(text)
    }

    override fun feedAction() {
        presenter.onFeedButtonPressed()
    }

    override fun playCatAnimation() {
        heartAnimationView?.playAnimation()
    }

    override fun shareAction() {
        presenter.onShareButtonPressed()
    }

    override fun infoAction() {
        presenter.onInfoButtonPressed()
    }

    override fun helpAction() {
        presenter.onHelpButtonPressed()
    }

    override fun showShareActivity(s: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, s)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    override fun showInfoDialogFragment() {
        val infoFragment = InfoDialogFragment()
        val manager: FragmentManager = requireActivity().supportFragmentManager

        val transaction: FragmentTransaction = manager.beginTransaction()
        infoFragment.show(transaction, "dialog") 
    }

    override fun showHelpActivity() {
        val intent = Intent(activity, SlideActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }


}