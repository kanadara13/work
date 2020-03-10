package com.example.work.domain

class SaveRequest : Validator {
    var url : String = ""

    override fun validate() {
        if (url.isEmpty()) { throw IllegalArgumentException("필수값 누락입니다")}
        if (!url.startsWith("http")) {throw IllegalArgumentException("http 로 시작해야 합니다")}
    }
}
