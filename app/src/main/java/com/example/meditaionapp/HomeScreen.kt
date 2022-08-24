package com.example.meditaionapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditaionapp.ui.theme.*

@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()

            ChipSection(listOf("Sweet Sleep", "Insomnia", "Depression"))

            DailyThoughts()

            FeaturesSection(
                listOf(
                    Feature(
                        "Sleep meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3,
                    ),

                    Feature(
                        "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3,
                    ),

                    Feature(
                        "Night island",
                        R.drawable.ic_moon,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3,
                    ),

                    Feature(
                        "Calming Sounds",
                        R.drawable.ic_music,
                        Beige1,
                        Beige2,
                        Beige3,
                    ),
                )
            )

        }
        BottomMenu(
            items = listOf(
                BottomMenuItem("Home", R.drawable.ic_home),
                BottomMenuItem("Meditate", R.drawable.ic_bubble),
                BottomMenuItem("Sleep", R.drawable.ic_moon),
                BottomMenuItem("Music", R.drawable.ic_music),
                BottomMenuItem("Profile", R.drawable.ic_profile),
            ),
            modifier = Modifier.align(Alignment.BottomCenter)
        )

    }
}

@Composable
fun GreetingSection(name: String = "Philipp") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 36.dp, start = 16.dp, end = 16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good morning, $name",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.body1
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ChipSection(chips: List<String>) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow(modifier = Modifier.padding(vertical = 20.dp)) {
        items(chips.size) {
            Box(modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                .clickable {
                    selectedChipIndex = it
                }
                .clip(RoundedCornerShape(10.dp))
                .background(if (selectedChipIndex == it) ButtonBlue else DarkerButtonBlue)
            ) {
                Text(
                    text = chips[it],
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )
            }
        }
    }

}

@Composable
fun DailyThoughts() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = LightRed)
            .padding(vertical = 20.dp, horizontal = 16.dp)
            .fillMaxWidth(),
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Daily Thoughts", style = MaterialTheme.typography.h2)
            Text(text = "Meditation * 3-10 min", color = TextWhite)
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(color = ButtonBlue)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(12.dp),
            )
        }

    }
}

@ExperimentalFoundationApi
@Composable
fun FeaturesSection(features: List<Feature>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Featured",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(16.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                FeatureItem(features[it])
            }
        }
    }
}

@Composable
fun FeatureItem(feature: Feature) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(path = mediumColoredPath, color = feature.mediumColor)
            drawPath(path = lightColoredPath, color = feature.lightColor)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h2,
                lineHeight = 26.sp,
                modifier = Modifier.align(
                    Alignment.TopStart
                )
            )
            Icon(
                painter = painterResource(id = feature.icon),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { }
                    .align(Alignment.BottomEnd)
                    .background(
                        ButtonBlue
                    )
                    .padding(vertical = 6.dp, horizontal = 15.dp))
        }
    }
}

@Composable
fun BottomMenu(
    items: List<BottomMenuItem>,
    modifier: Modifier = Modifier,
    activeLabelColor: Color = Color.White,
    inActiveLabelColor: Color = AquaBlue,
    activeIconColor: Color = Color.White,
    activeColor: Color = ButtonBlue,
    initialSelectedIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedIndex)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(vertical = 10.dp, horizontal = 5.dp)
            .fillMaxWidth()
            .background(DeepBlue),

        ) {
        items.forEachIndexed { index, item ->
            CustomBottomMenuItem(
                item,
                modifier,
                activeLabelColor,
                inActiveLabelColor,
                activeIconColor,
                activeColor,
                index == selectedItemIndex,
            ) {
                selectedItemIndex = index
            }
        }
    }

}

@Composable
fun CustomBottomMenuItem(
    item: BottomMenuItem,
    modifier: Modifier = Modifier,
    activeLabelColor: Color = Color.White,
    inActiveLabelColor: Color = AquaBlue,
    activeIconColor: Color = Color.White,
    activeColor: Color = ButtonBlue,
    selected: Boolean = false,
    onItemClick: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(top = 8.dp)
            .clickable {
                onItemClick()
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .clip(
                    RoundedCornerShape(
                        10.dp
                    )
                )
                .background(if (selected) activeColor else DeepBlue)
                .padding(10.dp)

        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (selected) activeIconColor else inActiveLabelColor,
                modifier = modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            style = MaterialTheme.typography.body1,
            color = if (selected) activeLabelColor else inActiveLabelColor,
            modifier = modifier.padding(top = 4.dp)
        )
    }
}
