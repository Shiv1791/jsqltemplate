package com.knoldus.jsql

import net.sf.jsqlparser.JSQLParserException
import net.sf.jsqlparser.parser.CCJSqlParserUtil

object SqlParser {
  def parseSql(sql: String): String =
    try {
      CCJSqlParserUtil.parse(sql).toString
    } catch {
      case e: JSQLParserException =>
        e.printStackTrace()
        throw new Exception("Did not parsed the query")
    }
}