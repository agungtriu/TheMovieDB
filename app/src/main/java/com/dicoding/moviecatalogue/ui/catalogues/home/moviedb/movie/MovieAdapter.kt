package com.dicoding.moviecatalogue.ui.catalogues.home.moviedb.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.databinding.ItemsCatalogueBinding
import com.dicoding.moviecatalogue.ui.catalogues.detail.DetailActivity

class MovieAdapter :
    PagedListAdapter<CatalogueEntity, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CatalogueEntity>() {
            override fun areItemsTheSame(
                oldItem: CatalogueEntity,
                newItem: CatalogueEntity
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: CatalogueEntity,
                newItem: CatalogueEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    class MovieViewHolder(private val binding: ItemsCatalogueBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: CatalogueEntity) {
            with(binding) {
                textviewItemscatalogueTitle.text = movies.title
                textviewItemscatalogueScore.text = movies.score
                textviewItemscatalogueRelease.text = movies.release
                textviewItemscatalogueOverview.text = movies.overview
                Glide.with(itemView.context)
                    .load(movies.poster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgItemscataloguePoster)

                itemView.setOnClickListener {
                    val intent = Intent(it.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movies)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding =
            ItemsCatalogueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movies = getItem(position)
        if (movies != null) {
            holder.bind(movies)
        }
    }
}