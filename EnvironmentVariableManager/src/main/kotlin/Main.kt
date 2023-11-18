import CommandManager.*
import SystemManager.*

fun main(args: Array<String>) {
    println("Start EnvironmentVariableManager")
    when(GetOperationSystem()){
        "Mac" -> {
            println("The Operating System is Mac")
            MacCommands().SetNewVariable(EnvironmenVariable("", ""))
        }
        "Windows" -> {
            println("The Operating System is Windows")
            WindowsCommands().GetAllVariables()
        }
        else -> {
            println("No matching driver")
        }
    }
}