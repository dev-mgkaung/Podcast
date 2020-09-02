package mk.podcast.com.fragments

import android.app.Activity
import android.app.DownloadManager
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.app_content_scrolling.*
import kotlinx.android.synthetic.main.full_media_play_user_data_view.*
import kotlinx.android.synthetic.main.podcast_appbar.*
import mk.padc.share.utils.load
import mk.podcast.com.R
import mk.podcast.com.activities.DetailActivity
import mk.podcast.com.adapters.PodcastRecyclerAdapter
import mk.podcast.com.datas.vos.DataVO
import mk.podcast.com.datas.vos.PlayListVO
import mk.podcast.com.datas.vos.RandomPodcastVO
import mk.podcast.com.mvp.presenters.MainPresenter
import mk.podcast.com.mvp.presenters.impls.MainPresenterImpl
import mk.podcast.com.mvp.views.MainView
import mk.podcast.com.utils.startDownloading
import mk.podcast.com.views.viewpods.EmptyViewPod
import java.util.jar.Manifest

class HomeFragment : Fragment(), MainView {

    private lateinit var mAdapter: PodcastRecyclerAdapter
    private lateinit var mPresenter: MainPresenter
    private lateinit var mEmptyViewPod : EmptyViewPod

    private val TAG = "Permission"
    private val PERMISSION_REQUEST_CODE = 101
    private var allowpermission=false
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
    fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(
            activity as Activity,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission to write external storage denied")
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(activity as Activity, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), PERMISSION_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {

                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(activity as Activity, "Permission Denied", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(activity as Activity, "Permission Granted", Toast.LENGTH_SHORT).show()
                    allowpermission=true
                }
            }
        }
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
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            adapter = mAdapter
            setEmptyView(mEmptyViewPod)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment().apply {}
    }

    override fun displayPodcastList(list: List<PlayListVO>) {
        mAdapter.setNewData(list.toMutableList())
    }

    override fun displayRandomPodcastData(data: RandomPodcastVO) {
        detail.text= Html.fromHtml(data.description)
        title.text=data.title
        subtitle.text=Html.fromHtml(data.description)
        mediaImageView.load(data.image)
    }

    override fun navigateToDetailScreen(episodeID: String) {
        startActivity(DetailActivity.newIntent(activity as Context, episodeID))
    }


    override fun selectedDownloadPodcastItem(data: DataVO) {
        setupPermissions()
        if(allowpermission)
        {
        Toast.makeText(context, "Start Downloading ${data.title}", Toast.LENGTH_SHORT).show()
        context?.let { startDownloading(it,data) }
        }
    }

    override fun showErrorMessage(error: String) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }
}