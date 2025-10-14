package org

import kotlin.test.Test
import kotlin.test.assertEquals

class wordletest{
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