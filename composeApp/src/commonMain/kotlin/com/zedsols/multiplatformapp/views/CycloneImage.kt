package com.zedsols.multiplatformapp.views

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.isActive
import multiplatformapp.composeapp.generated.resources.Res
import multiplatformapp.composeapp.generated.resources.ic_cyclone
import org.jetbrains.compose.resources.vectorResource

@Composable
fun CycloneImage(
  modifier: Modifier = Modifier,
  isRotating: MutableState<Boolean>
) {
  val target = 360f
  val rotate = remember { Animatable(0f) }

  if (isRotating.value) {
    LaunchedEffect(Unit) {
      while (isActive) {
        val remaining = (target - rotate.value) / target

        rotate.animateTo(
          target,
          animationSpec = tween((1_000 * remaining).toInt(), easing = LinearEasing)
        )

        rotate.snapTo(0f)
      }
    }
  }

  Image(
    modifier = modifier
      .size(250.dp)
      .padding(16.dp)
      .run { rotate(rotate.value) },
    imageVector = vectorResource(Res.drawable.ic_cyclone),
    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
    contentDescription = null
  )
}
