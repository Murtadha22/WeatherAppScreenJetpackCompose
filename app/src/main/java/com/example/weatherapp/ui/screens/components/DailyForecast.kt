package com.example.weatherapp.ui.screens.components

import androidlead.weatherappui.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.weatherapp.ui.theme.ColorGradient1
import com.example.weatherapp.ui.theme.ColorGradient2
import com.example.weatherapp.ui.theme.ColorGradient3
import com.example.weatherapp.ui.theme.ColorTextSecondary
import com.example.weatherapp.ui.theme.ColorTextSecondaryVariant
import com.example.weatherapp.ui.theme.ColorWindForecast

@Composable
fun DailyForecast(
    modifier: Modifier = Modifier,
    forecast: String = "Cloudy Day",
    date: String = "Friday, 22 Nov",
    degree: String = "21",
    weatherDescription: String = "It feels chilly"
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ) {
        val (background, image, forecastText, dateText, forecastValue, windIcons) = createRefs()

        GradientBackground(
            modifier = Modifier.constrainAs(background) {
                linkTo(start = parent.start, end = parent.end)
                linkTo(top = parent.top, bottom = parent.bottom, topMargin = 24.dp)
                height = Dimension.fillToConstraints
            }
        )

        WeatherImage(
            imageRes = R.drawable.img_sub_rain,
            modifier = Modifier
                .height(175.dp)
                .constrainAs(image) {
                    start.linkTo(parent.start, margin = 4.dp)
                    top.linkTo(parent.top)
                }
        )

        Text(
            text = forecast,
            style = MaterialTheme.typography.titleLarge,
            color = ColorTextSecondary,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.constrainAs(forecastText) {
                start.linkTo(parent.start, margin = 24.dp)
                top.linkTo(image.bottom)
            }
        )

        Text(
            text = date,
            style = MaterialTheme.typography.bodyMedium,
            color = ColorTextSecondaryVariant,
            modifier = Modifier.constrainAs(dateText) {
                start.linkTo(forecastText.start)
                top.linkTo(forecastText.bottom)
            }
        )

        ForecastValue(
            degree = degree,
            description = weatherDescription,
            modifier = Modifier.constrainAs(forecastValue) {
                end.linkTo(parent.end, margin = 24.dp)
                linkTo(top = image.top, bottom = image.bottom)
            }
        )

        WindIcons(
            modifier = Modifier.constrainAs(windIcons) {
                end.linkTo(parent.end, margin = 24.dp)
                top.linkTo(forecastText.top)
            }
        )
    }
}

@Composable
private fun GradientBackground(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    listOf(ColorGradient1, ColorGradient2, ColorGradient3)
                ),
                shape = RoundedCornerShape(32.dp)
            )
    )
}

@Composable
private fun WeatherImage(modifier: Modifier = Modifier, imageRes: Int) {
    Image(
        painter = painterResource(imageRes),
        contentDescription = null,
        contentScale = ContentScale.FillHeight,
        modifier = modifier
    )
}

@Composable
private fun ForecastValue(
    modifier: Modifier = Modifier,
    degree: String,
    description: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Text(
                text = degree,
                style = TextStyle(
                    brush = Brush.linearGradient(
                        listOf(Color.White, Color.White.copy(alpha = 0.3f))
                    ),
                    fontSize = 75.sp,
                    fontWeight = FontWeight.Black
                ),
                modifier = Modifier.padding(end = 16.dp, top = 5.dp)
            )
            Text(
                text = "°",
                style = TextStyle(
                    brush = Brush.linearGradient(
                        listOf(Color.White, Color.White.copy(alpha = 0.3f))
                    ),
                    fontSize = 65.sp,
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier.padding(top = 2.dp)
            )
        }
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = ColorTextSecondaryVariant
        )
    }
}

@Composable
private fun WindIcons(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_wind),
            contentDescription = null,
            modifier = Modifier.size(60.dp),
            tint = ColorWindForecast
        )
        Icon(
            painter = painterResource(R.drawable.ic_frosty),
            contentDescription = null,
            modifier = Modifier.size(60.dp),
            tint = ColorWindForecast
        )
    }
}