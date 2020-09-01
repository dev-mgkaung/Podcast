package mk.podcast.com.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.app_content_scrolling.*
import mk.podcast.com.R
import mk.podcast.com.activities.DetailActivity
import mk.podcast.com.adapters.PodcastRecyclerAdapter
import mk.podcast.com.datas.vos.PlayListVO
import mk.podcast.com.mvp.presenters.MainPresenter
import mk.podcast.com.mvp.presenters.impls.MainPresenterImpl
import mk.podcast.com.mvp.views.MainView
import mk.podcast.com.views.viewpods.EmptyViewPod

class HomeFragment : Fragment(), MainView {

    private lateinit var mAdapter: PodcastRecyclerAdapter
    private lateinit var mPresenter: MainPresenter
    private lateinit var mEmptyViewPod : EmptyViewPod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      return   inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpViewPod()
        setUpRecyclerView()
        setUpListeners()
        mPresenter.onUiReady(this)
    }

    private fun setUpViewPod(){
        mEmptyViewPod = emptyViewPod as EmptyViewPod
        mEmptyViewPod.setDelegate(mPresenter)
    }
    private fun setUpListeners() {}

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView()  {
        mAdapter = PodcastRecyclerAdapter(mPresenter)
        podcast_recyclerview.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL,false)
            adapter = mAdapter
            setEmptyView(mEmptyViewPod)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {}
    }

    override fun displayPodcastList(list: List<PlayListVO>) {
        mAdapter.setNewData(list.toMutableList())
    }

    override fun navigateToDetailScreen(episodeID : String) {
        startActivity(DetailActivity.newIntent(activity as Context,episodeID))
    }

    override fun showErrorMessage(error: String) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }
}