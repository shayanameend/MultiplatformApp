package com.zedsols.multiplatformapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zedsols.multiplatformapp.theme.AppTheme
import com.zedsols.multiplatformapp.views.CTAButton
import com.zedsols.multiplatformapp.views.CycloneImage
import com.zedsols.multiplatformapp.views.CycloneTitle
import com.zedsols.multiplatformapp.views.RotateButton
import com.zedsols.multiplatformapp.views.ThemeButton

@Composable
internal fun App() = AppTheme {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .windowInsetsPadding(WindowInsets.safeDrawing)
      .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    val isRotating = remember { mutableStateOf(false) }

    CycloneTitle()
    CycloneImage(isRotating = isRotating)
    RotateButton(isRotating = isRotating)
    ThemeButton()
    CTAButton()
  }
}
