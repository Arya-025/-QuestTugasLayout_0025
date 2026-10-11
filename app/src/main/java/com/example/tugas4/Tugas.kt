package com.example.tugas4

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class MahasiswaCard(
    @StringRes val name: Int,
    @StringRes val nim: Int? = null,
    @StringRes val address: Int,
    @ColorRes val cardColor: Int,
    @ColorRes val addressColor: Int,
    val useScriptFont: Boolean = false
)


private val daftarMahasiswa = listOf(
    MahasiswaCard(
        name = R.string.name_reyhan,
        nim = R.string.nim_reyhan,
        address = R.string.address_reyhan,
        cardColor = R.color.card_gray,
        addressColor = R.color.yellow,
        useScriptFont = true
    ),
    MahasiswaCard(
        name = R.string.name_arthur,
        nim = R.string.nim_arthur,
        address = R.string.address_arthur,
        cardColor = R.color.card_purple,
        addressColor = R.color.yellow
    ),
    MahasiswaCard(
        name = R.string.name_leon,
        nim = R.string.nim_leon,
        address = R.string.address_leon,
        cardColor = R.color.card_blue,
        addressColor = R.color.text_white
    ),

)
