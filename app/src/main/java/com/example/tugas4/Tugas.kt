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
    MahasiswaCard(
        name = R.string.name_crish,
        nim = R.string.nim_crish,
        address = R.string.address_crish,
        cardColor = R.color.card_green,
        addressColor = R.color.text_white
    )
)

@Composable
fun ActivitasPertama(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.screen_background))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            Text(
                text = stringResource(R.string.title_prodi),
                modifier = Modifier.padding(top = 72.dp),
                color = colorResource(R.color.text_primary),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.title_universitas),
                modifier = Modifier.padding(bottom = 24.dp),
                color = colorResource(R.color.text_primary),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )


            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(daftarMahasiswa) { data ->
                    ProfilCard(data = data)
                }
            }
        }


        Text(
            text = stringResource(R.string.footer_copyright),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            color = colorResource(R.color.text_primary),
            fontSize = 12.sp
        )
    }
}


@Composable
fun ProfilCard(data: MahasiswaCard, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(colorResource(data.cardColor))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LogoUniversitas()

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.Center
        ) {

            if (data.useScriptFont) {
                Text(
                    text = stringResource(data.name),
                    color = colorResource(R.color.text_white),
                    fontSize = 22.sp,
                    fontFamily = FontFamily.Cursive,
                    fontStyle = FontStyle.Italic
                )
            } else {
                Text(
                    text = stringResource(data.name),
                    color = colorResource(R.color.text_white),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }


            data.nim?.let { nimRes ->
                Spacer(Modifier.height(4.dp))
                Text(
                    text = stringResource(nimRes),
                    color = colorResource(R.color.nim_cyan),
                    fontSize = 14.sp
                )
            }


            Spacer(Modifier.height(4.dp))
            Text(
                text = stringResource(data.address),
                color = colorResource(data.addressColor),
                fontSize = 14.sp
            )
        }

        LogoUniversitas()
    }
}

@Composable
private fun LogoUniversitas() {
    Image(
        painter = painterResource(R.drawable.logo_umy),
        contentDescription = stringResource(R.string.logo_description),
        modifier = Modifier.size(52.dp)
    )
}