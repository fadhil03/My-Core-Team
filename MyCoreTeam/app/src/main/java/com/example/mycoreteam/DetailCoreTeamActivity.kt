package com.example.mycoreteam

import android.content.Intent
import android.content.Intent.EXTRA_USER
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mycoreteam.databinding.ActivityDetailCoreTeamBinding

class DetailCoreTeamActivity : AppCompatActivity() {

    private var newTitle: String = "Detail Core Team"
    private lateinit var binding: ActivityDetailCoreTeamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCoreTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = newTitle
            setDisplayHomeAsUpEnabled(true)
        }

        val user = intent.getParcelableExtra<CoreUser>(EXTRA_USER) as CoreUser

        binding.apply {
            tvItemNameDetail.text = user.name
            tvItemPositionDetail.text = user.position
            tvItemMajorDetail.text = user.major
        }

        Glide.with(this)
            .load(user.avatar)
            .apply(RequestOptions.circleCropTransform())
            .into(binding.imgItemAvatarDetail)


        binding.btnShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val shareUser = "Ikuti kegiatan GDSC UNM bersama ${user.name} sebagai ${user.position}"
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, shareUser)
            startActivity(Intent.createChooser(intent, "Share with..."))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}