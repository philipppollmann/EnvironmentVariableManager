package CommandManager

import java.lang.Exception
import java.io.BufferedReader
import java.io.InputStreamReader


fun ExecuteCommand(command: String){
    try
    {
        val process = ProcessBuilder(command.split("\\s".toRegex())).redirectErrorStream(true).start()

        val reader =BufferedReader(InputStreamReader(process.inputStream))
        var line: String?

        while (reader.readLine().also { line = it } != null )
        {
            println(line)
        }

        val exitCode = process.waitFor()
        println("\nExited with error code $exitCode")
    }
    catch (e: Exception)
    {
        e.printStackTrace()
    }

}