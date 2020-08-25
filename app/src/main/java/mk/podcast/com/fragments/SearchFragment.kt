package mk.podcast.com.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_search.view.*
import mk.podcast.com.R
import mk.podcast.com.adapters.CategoryRecyclerAdapter
import mk.podcast.com.datas.vos.CategoryVO
import mk.podcast.com.mvp.presenters.CategoryPresenter
import mk.podcast.com.mvp.presenters.impls.CategoryPresenterImpl
import mk.podcast.com.mvp.views.CategoryView

class SearchFragment : Fragment(), CategoryView {

    private lateinit var mAdapter: CategoryRecyclerAdapter
    private lateinit var mPresenter: CategoryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_search, container, false)
        setUpPresenter()
        setUpRecyclerView(view)
        setUpListeners()
        mPresenter.onUiReady(this)
        return view;
    }

    private fun setUpListeners() {

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(CategoryPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView(view: View) {
        mAdapter = CategoryRecyclerAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        view.category_recyclerview?.layoutManager = linearLayoutManager

        view.category_recyclerview?.adapter = mAdapter
    }

    override fun displayCategoryList(list: List<CategoryVO>) {
        mAdapter.setNewData(list.toMutableList())
    }

    override fun navigateToDetailScreen() {

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {}
    }
}