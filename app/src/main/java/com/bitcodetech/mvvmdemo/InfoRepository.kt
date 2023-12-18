package com.bitcodetech.mvvmdemo

import java.util.Random

class InfoRepository {

    fun fetchInfo() : String{
        return "${Random().nextInt()}"
    }

}