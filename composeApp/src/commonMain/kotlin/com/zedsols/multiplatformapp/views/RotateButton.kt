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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zedsols.multiplatformapp.theme.LocalCycloneIsRotating
import multiplatformapp.composeapp.generated.resources.Res
import multiplatformapp.composeapp.generated.resources.ic_rotate_right
import multiplatformapp.composeapp.generated.resources.run
import multiplatformapp.composeapp.generated.resources.stop
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun RotateButton(modifier: Modifier = Modifier) {
  var isRotating by LocalCycloneIsRotating.current

  ElevatedButton(
    modifier = modifier
      .padding(horizontal = 8.dp, vertical = 4.dp)
      .widthIn(min = 200.dp),
    onClick = { isRotating = !isRotating }) {

    val text = if (isRotating) Res.string.stop else Res.string.run

    Icon(vectorResource(Res.drawable.ic_rotate_right), contentDescription = null)
    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
    Text(stringResource(text))
  }
}
