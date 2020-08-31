package mk.podcast.com.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_download.view.*
import mk.podcast.com.R
import mk.podcast.com.adapters.DownloadRecyclerAdapter
import mk.podcast.com.datas.vos.PodcastVO
import mk.podcast.com.mvp.presenters.DownloadPresenter
import mk.podcast.com.mvp.presenters.impls.DownloadPresenterImpl
import mk.podcast.com.mvp.views.DownloadView


class DownloadFragment : Fragment(), DownloadView {

    private lateinit var mAdapter: DownloadRecyclerAdapter
    private lateinit var mPresenter: DownloadPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_download, container, false)
        setUpPresenter()
        setUpRecyclerView(view)
        setUpListeners()
        mPresenter.onUiReady(this)

        return view
    }
    private fun setUpListeners() {

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DownloadPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    private fun setUpRecyclerView(view: View)  {
        mAdapter = DownloadRecyclerAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        view.download_podcast_recyclerview?.layoutManager = linearLayoutManager
        view.download_podcast_recyclerview?.adapter = mAdapter
    }


    override fun displayDownloadPodcastList(list: List<PodcastVO>) {
        mAdapter.setNewData(list.toMutableList())
    }

    override fun navigateToDetailScreen() {}
    override fun showErrorMessage(error: String) {

    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DownloadFragment().apply {}
    }
}