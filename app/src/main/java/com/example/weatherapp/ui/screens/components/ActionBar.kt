package com.example.weatherapp.ui.screens.components

import androidlead.weatherappui.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.theme.*

@Composable
fun ActionBar(
    modifier: Modifier = Modifier,
    location: String = "Amman",
    profileImage: Int = R.drawable.murtadhaprofile1
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ShadowedButton(
            iconRes = R.drawable.ic_control,
            size = 48.dp,
            contentSize = 20.dp
        )
        LocationInfo(location = location)
        ProfileImage(profileImage = profileImage)
    }
}

@Composable
fun ShadowedButton(
    modifier: Modifier = Modifier,
    iconRes: Int,
    size: Dp = 48.dp,
    contentSize: Dp = 20.dp
) {
    Surface(
        modifier = modifier
            .size(size)
            .customShadow(
                color = Color.Black,
                alpha = 0.15f,
                shadowRadius = 16.dp,
                borderRadius = size,
                offsetY = 4.dp
            ),
        color = ColorSurface,
        shape = CircleShape
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(iconRes),
                contentDescription = null,
                modifier = Modifier.size(contentSize)
            )
        }
    }
}

@Composable
fun ProfileImage(
    modifier: Modifier = Modifier,
    profileImage: Int,
    borderSize: Int = 50
) {
    Box(
        modifier = modifier
            .size(borderSize.dp)
            .border(
                width = 1.5.dp,
                color = ColorSurface,
                shape = CircleShape
            )
            .customShadow(
                color = ColorImageShadow,
                alpha = 0.7f,
                shadowRadius = 16.dp,
                borderRadius = borderSize.dp,
                offsetY = 6.dp
            )
    ) {
        Image(
            painter = painterResource(profileImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )
    }
}

@Composable
fun LocationInfo(
    modifier: Modifier = Modifier,
    location: String
) {
    Column(
        modifier = modifier.padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_location_pin),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.height(18.dp)
            )
            Text(
                text = location,
                style = MaterialTheme.typography.titleLarge,
                color = ColorTextPrimary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

//@Composable
//fun ProgressBar(
//    modifier: Modifier = Modifier,
//    text: String = "Updating •"
//) {
//    Box(
//        modifier = modifier
//            .background(
//                brush = Brush.linearGradient(
//                    colorStops = arrayOf(
//                        0f to ColorGradient1,
//                        0.25f to ColorGradient2,
//                        1f to ColorGradient3
//                    )
//                ),
//                shape = RoundedCornerShape(8.dp)
//            )
//            .padding(vertical = 2.dp, horizontal = 10.dp)
//    ) {
//        Text(
//            text = text,
//            style = MaterialTheme.typography.labelSmall,
//            color = ColorTextPrimaryVariant
//        )
//    }
//}