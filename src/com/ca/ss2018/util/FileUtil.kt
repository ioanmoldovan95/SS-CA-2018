package com.ca.ss2018.util

import com.ca.ss2018.model.Participant
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.Exception
import java.util.*

class FileUtil() {

    fun getParticipantsList(file: File): MutableList<Participant> {
        val participants = mutableListOf<Participant>()
        try {
            val fileReader = FileReader(file)
            val buffereReader = BufferedReader(fileReader)
            var line = buffereReader.readLine()
            line = buffereReader.readLine()
            while (line.isNotEmpty()) {
                participants.add(getParticipantFromFileLine(line))
                line = buffereReader.readLine()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return participants
    }

    private fun getParticipantFromFileLine(line: String): Participant {
        val attributes = line.split(",\"")
        val give = line.contains("OFER")
        val receive = line.contains("PRIMESC")
        return Participant(
            attributes[0],
            attributes[1],
            attributes[2],
            attributes[3],
            attributes[4],
            attributes[5],
            attributes[6],
            attributes[7],
            attributes[8],
            attributes[9],
            attributes[10],
            give,
            receive
        )
    }
}