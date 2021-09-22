package edu.bu.projectportal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), EditProjectListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailFragment.newInstance())
                .commitNow()
        }
    }

    override fun editProj(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, EditFragment.newInstance())
            .commitNow()

    }

    override fun editProjDone(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DetailFragment.newInstance())
            .commitNow()
    }
}