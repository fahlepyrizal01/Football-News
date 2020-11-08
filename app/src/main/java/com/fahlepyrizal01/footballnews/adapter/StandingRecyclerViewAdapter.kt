package com.fahlepyrizal01.footballnews.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fahlepyrizal01.core.domain.model.Standing
import com.fahlepyrizal01.core.utils.Resource.EMPTY_STRING
import com.fahlepyrizal01.footballnews.R
import kotlinx.android.synthetic.main.item_standing.view.*

class StandingRecyclerViewAdapter : RecyclerView.Adapter<StandingRecyclerViewAdapter.ViewHolder>() {

    private val listData = mutableListOf<Standing>()
    private var team = EMPTY_STRING

    companion object {
        const val FIRST_POSITION = 0
        const val SUBTRACTION_AND_INCREMENT_NUMBER = 1
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_standing, viewGroup, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position == FIRST_POSITION) {
            holder.bind(listData[position])
        } else {
            holder.bind(listData[position - SUBTRACTION_AND_INCREMENT_NUMBER])
        }
    }

    override fun getItemCount(): Int =
        if (listData.isNotEmpty()) listData.size + SUBTRACTION_AND_INCREMENT_NUMBER else listData.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(standing: Standing) = with(itemView) {
            if (adapterPosition == FIRST_POSITION) {
                tv_team_item_standing.text =
                    context.getString(R.string.standings_text_view_team_label)
                tv_played_item_standing.text =
                    context.getString(R.string.standings_text_view_played_label)
                tv_win_item_standing.text =
                    context.getString(R.string.standings_text_view_win_label)
                tv_draw_item_standing.text =
                    context.getString(R.string.standings_text_view_draw_label)
                tv_loss_item_standing.text =
                    context.getString(R.string.standings_text_view_loss_label)
                tv_goal_item_standing.text =
                    context.getString(R.string.standings_text_view_goal_label)
                tv_total_item_standing.text =
                    context.getString(R.string.standings_text_view_total_label)

                Typeface.BOLD.apply {
                    tv_team_item_standing.setTypeface(null, this)
                    tv_played_item_standing.setTypeface(null, this)
                    tv_win_item_standing.setTypeface(null, this)
                    tv_draw_item_standing.setTypeface(null, this)
                    tv_loss_item_standing.setTypeface(null, this)
                    tv_goal_item_standing.setTypeface(null, this)
                    tv_total_item_standing.setTypeface(null, this)
                }
            } else {
                team = "${standing.name} (${standing.teamid})"
                tv_team_item_standing.text = team
                tv_played_item_standing.text = standing.played.toString()
                tv_win_item_standing.text = standing.win.toString()
                tv_draw_item_standing.text = standing.draw.toString()
                tv_loss_item_standing.text = standing.loss.toString()
                tv_goal_item_standing.text = standing.goalsfor.toString()
                tv_total_item_standing.text = standing.total.toString()

                Typeface.NORMAL.apply {
                    tv_team_item_standing.setTypeface(null, this)
                    tv_played_item_standing.setTypeface(null, this)
                    tv_win_item_standing.setTypeface(null, this)
                    tv_draw_item_standing.setTypeface(null, this)
                    tv_loss_item_standing.setTypeface(null, this)
                    tv_goal_item_standing.setTypeface(null, this)
                    tv_total_item_standing.setTypeface(null, this)
                }
            }
        }
    }

    fun setData(newListData: List<Standing>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }
}