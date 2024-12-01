package com.zedsols.multiplatformapp.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zedsols.multiplatformapp.theme.LocalThemeIsDark
import multiplatformapp.composeapp.generated.resources.Res
import multiplatformapp.composeapp.generated.resources.ic_dark_mode
import multiplatformapp.composeapp.generated.resources.ic_light_mode
import multiplatformapp.composeapp.generated.resources.theme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun ThemeButton(modifier: Modifier = Modifier) {
  var isDark by LocalThemeIsDark.current

  val icon = remember(isDark) {
    if (isDark) Res.drawable.ic_light_mode
    else Res.drawable.ic_dark_mode
  }

  ElevatedButton(
    modifier = modifier
      .padding(horizontal = 8.dp, vertical = 4.dp)
      .widthIn(min = 200.dp),
    onClick = { isDark = !isDark }
  ) {
    Icon(vectorResource(icon), contentDescription = null)
    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
    Text(stringResource(Res.string.theme))
  }
}
