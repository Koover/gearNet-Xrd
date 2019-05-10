import application.MainStyle
import application.MainView
import javafx.stage.Stage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import session.Session
import tornadofx.App
import tornadofx.Controller
import tornadofx.launch
import tornadofx.reloadStylesheetsOnFocus

private val session: Session = Session()
fun getSession() = session

fun main(args: Array<String>) {
    gameLoop()
    launch<MyApp>(args)
}

private fun gameLoop() {
    GlobalScope.launch {
        delay(256)
    }
}

class MyApp : App(MainView::class, MainStyle::class) { init {
    reloadStylesheetsOnFocus()
}

    override fun start(stage: Stage) {
        super.start(stage)
        stage.width = 960.0
        stage.height = 720.0
        stage.isResizable = false
    }
}

class MainController : Controller() {
    fun writeToDb(inputValue: String) {
        println("Writing $inputValue to database!")
    }
}
