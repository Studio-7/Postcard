package com.studioseven.postcard.Activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.studioseven.postcard.Adapters.ImageAdapter
import com.studioseven.postcard.Fragments.ExploreFragment
import com.studioseven.postcard.Fragments.HomeFragment
import com.studioseven.postcard.Models.Image
import com.studioseven.postcard.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_postcard.*


class MainActivity : AppCompatActivity() {

    val fragment1: Fragment = HomeFragment()
    val fragment2: Fragment = ExploreFragment()
    val fragment3: Fragment = ProfileFragment()
    val fm = supportFragmentManager
    var active = fragment1

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                fm.beginTransaction().hide(active).show(fragment1).commit();
                active = fragment1;
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                fm.beginTransaction().hide(active).show(fragment2).commit();
                active = fragment2;
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                fm.beginTransaction().hide(active).show(fragment3).commit();
                active = fragment3;
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.studioseven.postcard.R.layout.activity_main)

        fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit()
        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit()
        fm.beginTransaction().add(R.id.main_container,fragment1, "1").commit()

        /*Picasso.get().load("https://ichef.bbci.co.uk/news/660/cpsprodpb/E9DF/production/_96317895_gettyimages-164067218.jpg")
            .into(postImage)*/

        val images: List<Image> = listOf(Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRh8mC7z2hVvA9ljM1NtgyxfROwyTGCcFOKYIXHSGxi__1KjX5m"),
                                    Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrAzB3dynTfZ4CioA56_XksdHsXMZUZgv4HfSb5O9js5BBjEix"),
                                    Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRd1Fh2z2i8_IzYyPhXgWMjaPMPNPcgYOQIMVwGrsRqGA2M1OoTlg"),
                                    Image("https://www.washingtonpost.com/resizer/oLrhvDHWXoe3ycLXTe0PAcZlejk=/960x0/arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/AWN2OZ75JQYHZOBKZAQL5NROZU.jpg"),
                                    Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS19FFqjUfKyZnx6K7g_YmnWQqHZ86ZodzbhDgwtQFH2rohNTvE"),
                                    Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRd1Fh2z2i8_IzYyPhXgWMjaPMPNPcgYOQIMVwGrsRqGA2M1OoTlg"))

        /*imageScroll.layoutManager = GridLayoutManager(this, 2)*/
        imageScroll.adapter = ImageAdapter(images)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
