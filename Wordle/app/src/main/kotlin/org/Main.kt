package org

fun main() {
    var attemptCount=0
    var g:String
    val t=pickRandomWord(readWordList("QuestionBank.txt"))
    while(true){
        attemptCount=attemptCount+1
        g=obtainGuess(attemptCount)
        if(isValid(g)){
            if(displayGuess(g,evaluateGuess(g,t))){
                println("you are correct!")
                break
            }
            else{
                continue
            }
        }
        else{
            println("Please retry")
        }
    }

}
