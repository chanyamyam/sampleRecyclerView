package com.clean.samplerecyclerview

import android.graphics.Rect
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.clean.samplerecyclerview.adapter.SampleAdapter
import com.clean.samplerecyclerview.databinding.ActivityMainBinding
import com.clean.samplerecyclerview.model.Samplemodel

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: SampleAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSampleRecyclerView()
    }
    // sampleRecyclerView 초기화
    private fun initSampleRecyclerView() {

        adapter = SampleAdapter()

        // 리스트 간격 설정
        val spaceDecoration = VerticalSpaceItemDecoration(20)
        binding.sampleRecyclerView.addItemDecoration(spaceDecoration)


        // 리스트 사이에 구분선 추가
        /*val dividerItemDecoration =
            DividerItemDecoration(binding.sampleRecyclerView.context, LinearLayoutManager(this).orientation)

        binding.sampleRecyclerView.addItemDecoration(dividerItemDecoration)*/

        // RecyclerView에 linearManager와 adapter 할당후 리스트 정보 넣어줌
        binding.sampleRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.sampleRecyclerView.adapter = adapter

        val sampleList = List(N){Samplemodel("${it}번째 이름","이것은 ${it}번째 정보입니다.")} // sample list
        adapter.submitList(sampleList)

    }

    //  간격 class
    inner class VerticalSpaceItemDecoration(private val verticalSpaceHeight: Int) :
        RecyclerView.ItemDecoration() {

        override fun getItemOffsets(
            outRect: Rect, view: View, parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.bottom = verticalSpaceHeight
        }
    }
    companion object {
        private val N = 100 // 리스트 개수 N
    }

}