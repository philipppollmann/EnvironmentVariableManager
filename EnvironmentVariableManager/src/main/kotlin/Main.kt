import CommandManager.*
import SystemManager.*

fun main(args: Array<String>) {
    println("Start EnvironmentVariableManager")
    when(GetOperationSystem()){
        "Mac" -> {
            println("The Operating System is Mac")
            MacCommands()
        }
        "Windows" -> {
            println("The Operating System is Windows")
            WindowsCommands()
        }
        else -> {
            println("No matching driver")
        }
    }
}