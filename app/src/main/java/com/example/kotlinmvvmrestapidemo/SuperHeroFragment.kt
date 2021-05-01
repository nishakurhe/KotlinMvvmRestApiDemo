package com.example.kotlinmvvmrestapidemo

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvmrestapidemo.adapters.SuperHeroAdapter
import com.example.kotlinmvvmrestapidemo.databinding.LayFragmentSuperheroBinding
import com.example.kotlinmvvmrestapidemo.viewmodels.SuperHeroViewModel

@Suppress("DEPRECATION")
class SuperHeroFragment : Fragment(){

    private lateinit var superHeroViewModel:SuperHeroViewModel
    private lateinit var adapter:SuperHeroAdapter
    private lateinit var binding: LayFragmentSuperheroBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
      binding = DataBindingUtil.inflate(inflater, R.layout.lay_fragment_superhero, container,false)
        val view = binding.root
        view.setOnClickListener {  }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        superHeroViewModel = ViewModelProvider(this).get(SuperHeroViewModel::class.java)

        if (context!!.isConnectedToNetwork()) {
            superHeroViewModel.init()

            // Observe data changes here

            superHeroViewModel.isDownloading.observe(viewLifecycleOwner, Observer {
                if (it) showProgressBar()
                else hideeProgressBar()
            })

            superHeroViewModel.mSuperHeros!!.observe(viewLifecycleOwner, Observer {
                adapter = SuperHeroAdapter(superHeroViewModel.mSuperHeros!!.value!!)
                binding.recyclerView.adapter = adapter
                binding.recyclerView.layoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
            })
        }
        else Toast.makeText(context!!, "No internet connection..", Toast.LENGTH_SHORT).show()
    }

    private fun showProgressBar() { binding.progressBar.visibility = View.VISIBLE }
    private fun hideeProgressBar() {  binding.progressBar.visibility = View.GONE  }

    fun Context.isConnectedToNetwork(): Boolean {
        val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return connectivityManager?.activeNetworkInfo?.isConnectedOrConnecting ?: false
    }
}