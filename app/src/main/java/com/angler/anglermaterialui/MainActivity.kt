package com.angler.anglermaterialui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val collapsingToolbarLayout: CollapsingToolbarLayout =
            findViewById(R.id.collapsingToolbarLayout)
        collapsingToolbarLayout.title = "CHIDAMBARABALAJI"

        fab = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Edit Profile Clicked", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val appBarLayout = findViewById<AppBarLayout>(R.id.appBarLayout)
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (Math.abs(verticalOffset) == appBarLayout.totalScrollRange) {
                // Collapsed
                fab.hide(object : OnVisibilityChangedListener() {
                    override fun onHidden(fab: FloatingActionButton?) {
                        super.onHidden(fab)
                        // Do something when FAB is hidden
                    }
                })
            } else if (verticalOffset == 0) {
                // Expanded
                fab.show()
            } else {
                // Somewhere in between
            }
        })
    }
}
