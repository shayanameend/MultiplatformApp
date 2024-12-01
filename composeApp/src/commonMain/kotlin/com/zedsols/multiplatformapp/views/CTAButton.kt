package com.zedsols.multiplatformapp.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import multiplatformapp.composeapp.generated.resources.Res
import multiplatformapp.composeapp.generated.resources.open_github
import org.jetbrains.compose.resources.stringResource

@Composable
fun CTAButton(modifier: Modifier = Modifier) {
  val uriHandler = LocalUriHandler.current

  TextButton(
    modifier = modifier
      .padding(horizontal = 8.dp, vertical = 4.dp)
      .widthIn(min = 200.dp),
    onClick = { uriHandler.openUri("https://github.com/terrakok") },
  ) {
    Text(stringResource(Res.string.open_github))
  }
}
