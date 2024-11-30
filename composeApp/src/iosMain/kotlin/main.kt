import androidx.compose.ui.window.ComposeUIViewController
import com.zedsols.multiplatformapp.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
