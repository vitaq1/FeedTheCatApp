package by.bsuir.vshu.feedthecatapp.ui.achievement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import by.bsuir.vshu.feedthecatapp.R
import by.bsuir.vshu.feedthecatapp.domain.model.Achievement


class AchievementFragment : Fragment(),AchievementContract.AchievementView {

    private lateinit var presenter: AchievementContract.AchievementPresenter
    private var table: LinearLayout? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_achievements, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = AchievementPresenter(this)

        table = getView()?.findViewById(R.id.achievementTable)

        presenter.init()
    }

    override fun fillTable(achievements: List<Achievement>) {

        for (item in achievements) {
            val scale = requireContext().resources.displayMetrics.density

            val trHeight = (70 * scale + 0.5f).toInt()
            val lParams = ViewGroup.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, trHeight)
            val tableRow = RelativeLayout(activity).apply {
                layoutParams = lParams
            }

            val params = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            params.marginStart = 50
            params.addRule(RelativeLayout.CENTER_VERTICAL)
            val description = TextView(activity).apply {
                setText(item.description)
                textSize = 20F
                layoutParams = params
            }


            val lp: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams((50 * scale + 0.5f).toInt(), (50 * scale + 0.5f).toInt())
            lp.marginStart = 1000
            lp.topMargin = 40
            val checkImageView = ImageView(activity).apply {
                if (item.passed) setBackgroundResource(R.drawable.check)
                else setBackgroundResource(R.drawable.delete)
                layoutParams = lp
            }


            tableRow.addView(description, 0)
            tableRow.addView(checkImageView, 1)
            table?.addView(tableRow)
        }
    }
}