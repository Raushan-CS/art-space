package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf(0) }
    val imageResource = when (result) {
        0 -> R.drawable.mona_lisa
        1 -> R.drawable.the_starry_night
        2 -> R.drawable.the_kiss
        3 -> R.drawable.the_garden_of_earthly_delights
        4 -> R.drawable.the_birth_of_venus
        5 -> R.drawable.girl_with_a_pearl_earring
        6 -> R.drawable.arrangement_in_grey_and_black_no__1
        7 -> R.drawable.les_demoiselles_davignon
        8 -> R.drawable.the_arnolfini_portrait
        else -> R.drawable.sunday_afternoon_on_the_island_of_la_grande_jatte
    }

    val artNames = when (result) {
        0 -> R.string.mona_lisa
        1 -> R.string.the_starry_night
        2 -> R.string.the_kiss
        3 -> R.string.the_garden_of_earthly_delights
        4 -> R.string.the_birth_of_venus
        5 -> R.string.girl_with_a_pearl_earring
        6 -> R.string.arrangement_in_grey_and_black_no__1
        7 -> R.string.les_demoiselles_davignon
        8 -> R.string.the_arnolfini_portrait
        else -> R.string.sunday_afternoon_on_the_island_of_la_grande_jatte
    }

    val artist = when (result) {
        0 -> R.string.mona_lisa_artist
        1 -> R.string.the_starry_night_artist
        2 -> R.string.the_kiss_artist
        3 -> R.string.the_garden_of_earthly_delights_artist
        4 -> R.string.the_birth_of_venus_artist
        5 -> R.string.girl_with_a_pearl_earring_artist
        6 -> R.string.arrangement_in_grey_and_black_no__1_artist
        7 -> R.string.les_demoiselles_davignon_artist
        8 -> R.string.the_arnolfini_portrait_artist
        else -> R.string.sunday_afternoon_on_the_island_of_la_grande_jatte_artist
    }

    val artYear = when (result) {
        0 -> R.string.mona_lisa_year
        1 -> R.string.the_starry_night_year
        2 -> R.string.the_kiss_year
        3 -> R.string.the_garden_of_earthly_delights_year
        4 -> R.string.the_birth_of_venus_year
        5 -> R.string.girl_with_a_pearl_earring_year
        6 -> R.string.arrangement_in_grey_and_black_no__1_year
        7 -> R.string.les_demoiselles_davignon_year
        8 -> R.string.the_arnolfini_portrait_year
        else -> R.string.sunday_afternoon_on_the_island_of_la_grande_jatte_year
    }

    val imageModifier = Modifier
        .padding(bottom = 30.dp, top = 30.dp)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .verticalScroll(state = rememberScrollState())
    ) {
        Text(
            text = "Art Space",
            fontSize = 30.sp,
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily.Cursive,
            modifier = modifier
                .padding(top = 15.dp, start = 14.dp, end = 7.dp)
                .align(Alignment.Start)
        )

        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = modifier
                .padding(top = 30.dp, start = 19.dp, end = 19.dp, bottom = 17.dp)

        ) {
            Text(
                text = stringResource(artNames),
                fontSize = 30.sp,
                lineHeight = 35.sp,
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.SansSerif,
                modifier = modifier
                    .padding(top = 7.dp, start = 7.dp, end = 7.dp)
            )
            Row {
                Text(
                    text = stringResource(artist),
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Default,
                    modifier = modifier
                        .padding(start = 7.dp, bottom = 7.dp)
                )

                Text(
                    text =",(" + stringResource(artYear) + ")",
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    modifier = modifier
                        .padding(end = 7.dp, bottom = 7.dp)
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(bottom = 17.dp)
        ) {
            Button(onClick = {
                if (result > 0) {
                    result = (result - 1) % 10
                } else {
                    result += 10
                }
            },
                colors = ButtonDefaults.buttonColors(Color(107, 112, 166))
            ) {
                Text(stringResource(R.string.previous))
            }

            Spacer(modifier.width(16.dp))

            Button(onClick = {result = ((result + 1)%10)},
                colors = ButtonDefaults.buttonColors(Color(107, 112, 166))
                ) {
                Text(stringResource(R.string.next))
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}