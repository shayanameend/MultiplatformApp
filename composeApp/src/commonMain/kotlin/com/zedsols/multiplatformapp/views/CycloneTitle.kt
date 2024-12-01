package com.zedsols.multiplatformapp.views

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import multiplatformapp.composeapp.generated.resources.IndieFlower_Regular
import multiplatformapp.composeapp.generated.resources.Res
import multiplatformapp.composeapp.generated.resources.cyclone
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource

@Composable
fun CycloneTitle(modifier: Modifier = Modifier) {
  Text(
    text = stringResource(Res.string.cyclone),
    fontFamily = FontFamily(Font(Res.font.IndieFlower_Regular)),
    style = MaterialTheme.typography.displayLarge
  )
}
