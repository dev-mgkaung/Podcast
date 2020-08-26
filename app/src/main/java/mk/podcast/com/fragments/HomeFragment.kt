package mk.podcast.com.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.app_content_scrolling.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import mk.podcast.com.R
import mk.podcast.com.activities.DetailActivity
import mk.podcast.com.activities.MainActivity
import mk.podcast.com.adapters.PodcastRecyclerAdapter
import mk.podcast.com.datas.vos.PodcastVO
import mk.podcast.com.mvp.presenters.MainPresenter
import mk.podcast.com.mvp.presenters.impls.MainPresenterImpl
import mk.podcast.com.mvp.views.MainView

class HomeFragment : Fragment(), MainView {

    private lateinit var mAdapter: PodcastRecyclerAdapter
    private lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_home, container, false)
        setUpPresenter()
        setUpRecyclerView(view)
        setUpListeners()
        mPresenter.onUiReady(this)

        return view
    }

    private fun setUpListeners() {

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }




    private fun setUpRecyclerView(view: View)  {
        mAdapter = PodcastRecyclerAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        view.podcast_recyclerview?.layoutManager = linearLayoutManager
        view.podcast_recyclerview?.adapter = mAdapter
    }



    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {}
    }

    override fun displayPodcastList(list: List<PodcastVO>) {
        mAdapter.setNewData(list.toMutableList())
    }

    override fun navigateToDetailScreen() {
        startActivity(activity?.let { DetailActivity.newIntent(it) })
    }
}