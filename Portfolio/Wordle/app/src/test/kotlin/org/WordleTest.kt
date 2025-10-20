package org

import kotlin.test.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class wordletest{
    @Test
    fun yesValid(){
        val result=isValid("apple")
        assert(result)
    }
    @Test
    fun readlist(){
        val result=readWordList("test.txt")
        assertEquals(listOf("abcde","apple"),result)
    }
    @Test
    fun pickword(){
        val list=mutableListOf("apple","banan","asdfg")
        val word=pickRandomWord(list)
        assert(word in mutableListOf("apple","banan","asdfg"))
    }
    @Test
    fun perfectMatch(){
        val result=evaluateGuess("apple", "apple")
        assertEquals(listOf(1,1,1,1,1),result)
    }
    fun partMatch(){
        val result=evaluateGuess("apple", "adapt")
        assertEquals(listOf(2,0,2,0,0),result)
    }
    fun noMatch(){
        val result=evaluateGuess("apple", "ddddd")
        assertEquals(listOf(0,0,0,0,0),result)
    }
}