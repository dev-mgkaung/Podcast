package mk.podcast.com.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.app_content_scrolling.*
import kotlinx.android.synthetic.main.app_content_scrolling.podcast_recyclerview
import kotlinx.android.synthetic.main.fragment_download.*
import kotlinx.android.synthetic.main.fragment_download.view.*
import mk.podcast.com.R
import mk.podcast.com.adapters.DownloadRecyclerAdapter
import mk.podcast.com.datas.vos.DownloadVO
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
        return inflater.inflate(R.layout.fragment_download, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecyclerView()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DownloadPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    private fun setUpRecyclerView()  {
        mAdapter = DownloadRecyclerAdapter(mPresenter)
        download_podcast_recyclerview.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            adapter = mAdapter
        }
    }


    override fun displayDownloadPodcastList(list: List<DownloadVO>) {
        mAdapter.setNewData(list.toMutableList())
    }

    override fun navigateToDetailScreen() {

    }

    override fun showErrorMessage(error: String) {}

    override fun showLoading() {}

    override fun hideLoading() {}

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DownloadFragment().apply {}
    }
}