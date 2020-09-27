package mk.podcast.com.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_search.*
import mk.padc.share.utils.load
import mk.podcast.com.R
import mk.podcast.com.adapters.CategoryRecyclerAdapter
import mk.podcast.com.datas.vos.GenreVO
import mk.podcast.com.mvp.presenters.CategoryPresenter
import mk.podcast.com.mvp.presenters.impls.CategoryPresenterImpl
import mk.podcast.com.mvp.views.CategoryView
import mk.podcast.com.views.viewpods.EmptyViewPod

class SearchFragment : Fragment(), CategoryView {

    private lateinit var mAdapter: CategoryRecyclerAdapter
    private lateinit var mPresenter: CategoryPresenter
    private lateinit var mEmptyViewPod : EmptyViewPod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       return  inflater.inflate(R.layout.fragment_search, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpViewPod()
        setUpRecyclerView()
        setUpListeners()
        mPresenter.onUiReady(this)
    }
    private fun setUpListeners() {

    }
    private fun setUpViewPod(){
        mEmptyViewPod = search_emptyViewPod as EmptyViewPod
        mEmptyViewPod.setDelegate(mPresenter)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(CategoryPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView() {
        mAdapter = CategoryRecyclerAdapter(mPresenter)
        category_recyclerview.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL,false)
            adapter = mAdapter
            setEmptyView(mEmptyViewPod)
        }
    }

    override fun displayCategoryList(list: List<GenreVO>) {
        mAdapter.setNewData(list.toMutableList())
        if (list.size > 0) list?.get(0).image_url?.let { category_image.load(it) }
    }

    override fun navigateToDetailScreen()
    {}

    override fun showErrorMessage(error: String) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {}
    }
}