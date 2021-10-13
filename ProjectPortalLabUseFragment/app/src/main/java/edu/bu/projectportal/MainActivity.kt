package edu.bu.projectportal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), EditProjectListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            //executing the add fragment transaction when the container is not null
            findViewById<FragmentContainerView>(R.id.container)?.let { frameLayout ->
                supportFragmentManager.beginTransaction()
                    .add(frameLayout.id, DetailFragment.newInstance())
                    .commitNow()
            }
        }
    }

    override fun editProj(){
        findViewById<FragmentContainerView>(R.id.container)?.let { frameLayout ->
            supportFragmentManager.beginTransaction()
                .replace(frameLayout.id, EditFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }

    }

    override fun editProjDone(){
        findViewById<FragmentContainerView>(R.id.container)?.let { frameLayout ->
            supportFragmentManager.beginTransaction()
                .replace(frameLayout.id, DetailFragment.newInstance())
                .commitNow()
        }
    }
}