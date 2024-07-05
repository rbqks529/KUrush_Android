package com.example.myapplication.goal

import HigherGoalItem
import LowerGoalItem
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCompleteBinding


class CompleteFragment : Fragment() {

    lateinit var binding: FragmentCompleteBinding
    private lateinit var higherGoalAdapter: HigherGoalAdapter
    private val higherGoals = ArrayList<HigherGoalItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCompleteBinding.inflate(inflater, container, false)

        binding.ivFloationgButton.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.main_frm, NewGoalFragment()).addToBackStack(null).commit()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupData()
        setupRecyclerView()
    }

    private fun setupData() {
        // 샘플 데이터 추가
        val lowerGoals1 = listOf(
            LowerGoalItem("🏋️", "윗몸 일으키기", 100),
            LowerGoalItem("🏃", "달리기", 100)
        )
        higherGoals.add(HigherGoalItem("운동 목표", 0, lowerGoals1))

        val lowerGoals2 = listOf(
            LowerGoalItem("📚", "독서", 100),
            LowerGoalItem("✍️", "글쓰기", 100)
        )
        higherGoals.add(HigherGoalItem("자기계발 목표", 0, lowerGoals2))

        // 필요에 따라 더 많은 데이터를 추가할 수 있습니다.
    }

    private fun setupRecyclerView() {
        higherGoalAdapter = HigherGoalAdapter(requireContext(), higherGoals)
        binding.rvHigherGoal.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = higherGoalAdapter
        }
    }

}