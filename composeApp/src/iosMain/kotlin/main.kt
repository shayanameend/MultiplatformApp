import androidx.compose.ui.window.ComposeUIViewController
import com.zedsols.multiplatformapp.App
import platform.UIKit.UIViewController

fun makeComposeUIViewController(): UIViewController = ComposeUIViewController {
  App()
}
