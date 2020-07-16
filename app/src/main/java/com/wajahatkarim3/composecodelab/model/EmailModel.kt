package com.wajahatkarim3.composecodelab.model

data class EmailModel (
    var sender: String,
    var subject: String,
    var summary: String,
    var isImportant: Boolean,
    var date: String,
    var isStarred: Boolean = false
)