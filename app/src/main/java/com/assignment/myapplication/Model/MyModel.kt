package com.assignment.myapplication.Model

class MyModel {
    var url:String
    var content:String
    var auth:String
    var tittle:String
    var date:String

    constructor(url: String, desc: String,auth:String,tittle:String,date:String) {
        this.url = url
        this.content = desc
        this.auth=auth
        this.tittle=tittle
        this.date=date
    }
}