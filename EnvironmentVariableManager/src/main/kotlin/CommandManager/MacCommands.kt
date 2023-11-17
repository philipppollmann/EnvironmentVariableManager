package CommandManager

class MacCommands {
    fun SetNewVariable(variable: EnvironmenVariable)
    {
        val command: String = "export ${variable.name}=${variable.value}"
        ExecuteCommand(command)
    }

    fun DeleteVariableByName(variableName: String)
    {

    }

    fun ShowAllVariables(): String
    {
        return ""
    }
}