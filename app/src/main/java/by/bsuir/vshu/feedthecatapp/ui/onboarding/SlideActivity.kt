package by.bsuir.vshu.feedthecatapp.ui.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.bsuir.vshu.feedthecatapp.R
import androidx.viewpager.widget.ViewPager

class SlideActivity : AppCompatActivity() {
    var adapter: SlideViewPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)
        viewPager = findViewById(R.id.viewpager)
        adapter = SlideViewPagerAdapter(this)
        viewPager!!.setAdapter(adapter)
    }



    companion object {
        @JvmField
        var viewPager: ViewPager? = null
    }
}