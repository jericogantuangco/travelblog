package com.example.travelblog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.travelblog.databinding.ActivityBlogDetailsBinding

private const val IMAGE_URL = "https://bitbucket.org/dmytrodanylyk/travel-blog-resources/raw/3436e16367c8ec2312a0644bebd2694d484eb047/images/sydney_image.jpg"

private const val AVATAR_URL = "https://bitbucket.org/dmytrodanylyk/travel-blog-resources/raw/3436e16367c8ec2312a0644bebd2694d484eb047/avatars/avatar1.jpg"

class BlogDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityBlogDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load(IMAGE_URL)
            .into(binding.imageMain)

        Glide.with(this)
            .load(AVATAR_URL)
            .transform(CircleCrop())
            .into(binding.imageAvatar)

        binding.imageMain.setImageResource(R.drawable.sydney_image)
        binding.imageAvatar.setImageResource(R.drawable.avatar)

        binding.textTitle.text = "G'day from Sydney"
        binding.textDate.text = "August 2, 2019"
        binding.textAuthor.text = "Grayson Wells"
        binding.textRating.text = "4.4"
        binding.textViews.text = "(2687 views)"
        binding.textDescription.text = "Australia is one of the most popular travel destinations in the world."

        binding.ratingBar.rating = 4.4f

        binding.imageBack.setOnClickListener{ finish() }
    }
}