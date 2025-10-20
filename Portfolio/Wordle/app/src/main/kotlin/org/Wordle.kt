package org

import java.io.File
import kotlin.random.Random

fun isValid(word: String): Boolean {
    return (word.length==5)
}

fun readWordList(filename: String): MutableList<String>{
    val word=File(filename).readLines().toMutableList()
    return word
}

fun pickRandomWord(words: MutableList<String>): String{
    val question=words.random()
    words.remove(question)
    return question
}

fun obtainGuess(attempt: Int): String{
    println("attempt "+attempt+" Please guess a 5 characters word: ")
    return  readln().lowercase()
}

fun evaluateGuess(guess: String, target: String): List<Int> = buildList{
    val guessList= guess.toList()
    val targetList= target.toList()
    for(n in 0..guessList.size-1){
        var count=0
        for(i in 0..targetList.size-1){
                if(guessList[n]==targetList[i]){
                    count=count+1
                    continue
                }
            }
        if(guessList[n]==targetList[n]){
            add(1)
            continue
        }
        else if(count>0) {
            add(2)
        }
        else {
            add(0)
         }
        
    }
}

fun displayGuess(guess: String, matches: List<Int>): Boolean{
    val green = "\u001B[32m"
    val yellow = "\u001B[33m"
    val gray = "\u001B[90m"
    val reset = "\u001B[0m"
    var count=0
    println(guess)
    for(n in 0..4){
        if(matches[n]==1){
            print("${green}${guess.substring(n,n+1)} ${reset}")
            count=count+1
        }
        else if(matches[n]==2){
            print("${yellow}${guess.substring(n,n+1)} ${reset}")
        }
        else{
            print("${gray}${guess.substring(n,n+1)} ${reset}")
        }
    }
    if(count==5){
        return true
    }
    println("")
    return  false
}