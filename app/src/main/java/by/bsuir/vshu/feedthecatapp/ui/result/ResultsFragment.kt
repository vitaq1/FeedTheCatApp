package by.bsuir.vshu.feedthecatapp.ui.result

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import by.bsuir.vshu.feedthecatapp.R
import by.bsuir.vshu.feedthecatapp.domain.model.Result


class ResultsFragment : Fragment(), ResultsContract.ResultsView {

    private lateinit var presenter: ResultsContract.ResultsPresenter
    private var table: TableLayout? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_result, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        table = getView()?.findViewById(R.id.tableLayout)

        presenter = ResultsPresenter(this)
        presenter.init()

    }

    override fun fillTable(results: List<Result>) {

        var k: Int = 0
        for (result in results) {

            val tableRow = TableRow(activity).apply {  }
            val date = TextView(activity).apply {
                setText(result.date)
                gravity = Gravity.CENTER
                textSize = 20F
            }
            val count = TextView(activity).apply {
                setText(result.count.toString())
                textSize = 20F
                gravity = Gravity.CENTER
            }
            tableRow.addView(date, 0)
            tableRow.addView(count, 1)
            if (k % 2 == 0) tableRow.setBackgroundResource(R.color.yellow)
            else tableRow.setBackgroundResource(R.color.red)
            table?.addView(tableRow)
            k++
        }

    }


}