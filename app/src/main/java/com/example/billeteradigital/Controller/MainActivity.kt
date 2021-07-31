package com.example.billeteradigital.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.billeteradigital.R
import com.example.billeteradigital.SlideAdapter


class MainActivity : AppCompatActivity() {

    private val slideAdapter = SlideAdapter(
        listOf(
            IntroSlide(
                "En movii",
                "Hacemos visibles a los invisibles",
                R.drawable.n
            ),
            IntroSlide(
                "title",
                "description",
                R.drawable.a
            ),
            IntroSlide(
                "title",
                "Hacemos tu vida más fácil",
                R.drawable.p
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager2 = findViewById(R.id.scrollViewPager);
        val slideViewPager: LinearLayout = findViewById(R.id.SlideViewPager);
        val bntNext: Button = findViewById(R.id.buttonNext);
        bntNext.setOnClickListener(View.OnClickListener { view ->
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        })
        viewPager.adapter = slideAdapter;
        setupIndicators();
        setCurrentIndicator(0);
        viewPager.registerOnPageChangeCallback(object :
        ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position);
                Log.v("posocion", position.toString())
                if (position == 2){
                    bntNext.setVisibility(View.VISIBLE)
                }else{
                    bntNext.setVisibility(View.GONE)
                }
            }
        }
        )


    }

    private fun setupIndicators(){
        val slideViewPager: LinearLayout = findViewById(R.id.SlideViewPager);
        val indicators = arrayOfNulls<ImageView>(slideAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.idicator_inactive
                )
                )
                this?.layoutParams = layoutParams
            }
            slideViewPager.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int){
        val slideViewPager: LinearLayout = findViewById(R.id.SlideViewPager);
        val childCount = slideViewPager.childCount
        for(i in 0 until childCount){
            val imageView= slideViewPager.get(i) as ImageView

            if (i == index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.idicator_inactive
                    )
                )
            }
        }
    }
}