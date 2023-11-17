package SystemManager

import CommandManager.WindowsCommands

fun GetOperationSystem(): String
{
    val operatingSystem = System.getProperty("os.name")

    return when {
        operatingSystem.contains("Win") -> "Windows"
        operatingSystem.contains("Mac") || operatingSystem.contains("Darwin") -> "Mac"
        operatingSystem.contains("Nix") || operatingSystem.contains("Nux") || operatingSystem.contains("Mux") || operatingSystem.contains("Bsd") -> "Unix/Linux"
        else -> "Other"
    }
}