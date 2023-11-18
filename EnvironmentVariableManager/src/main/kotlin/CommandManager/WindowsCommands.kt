package CommandManager

import CommandManager.*
import java.io.BufferedReader
import java.io.InputStreamReader

class WindowsCommands
{
    fun SetNewVariable(variable: EnvironmenVariable)
    {
        val command: String = "setx ${variable.name} ${variable.value}"
        ExecuteCommand(command)
    }

    fun DeleteVariableByName(name: String)
    {
        val command: String = "setx $name=''"
        ExecuteCommand(command)
    }

    fun ShowAllVariables()
    {

    }

    fun GetAllVariables(): List<EnvironmenVariable>
    {
        val variables = mutableListOf<EnvironmenVariable>()

        try
        {
            val command: String = "val command = \"cmd /c set\""
            val process = ProcessBuilder(command.split("\\s".toRegex())).redirectErrorStream(true).start()

            val reader = BufferedReader(InputStreamReader(process.inputStream))
            var line: String?

            while (reader.readLine().also { line = it } != null)
            {
                // Die Umgebungsvariablen haben das Format "NAME=WERT"
                val parts = line?.split("=")
                if (parts != null && parts.size == 2) {
                    val name = parts[0]
                    val value = parts[1]
                    variables.add(EnvironmenVariable(name, value))
                }

                process.waitFor()
                reader.close()
            }
        }
        catch (e: Exception)
        {
            e.printStackTrace()
        }

        return variables
    }
}