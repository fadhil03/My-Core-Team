package com.example.mycoreteam

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoreUser(
    var name: String?,
    var position: String?,
    var major: String?,
    var avatar: Int?
) : Parcelable
