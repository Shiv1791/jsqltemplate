package com.knoldus.jsql

import org.scalatest.{Matchers, WordSpec}

class SqlParserSpec extends WordSpec with Matchers {

  val insertQuery: String =
    s"""INSERT INTO test_table (id, name, ownerId, creation_time, periodicity, expiry_time, last_refreshed, query, orig_query, description, additional_info, last_edit_timestamp, load, load_category, enabled, system, intel, system_state, system_error, score) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::system_state_type, ?, ?)""".stripMargin


  val selectQuery: String =
    s"""SELECT id, last_refreshed, load, load_category, enabled, system, intel, system_state, system_error, translated_query, definition_uuid_, definition_uid FROM query.test_table WHERE query.test_table.uid = ?""".stripMargin


  val updateQuery: String =
    s"""UPDATE query.test_table SET system_state = 'Blocked'::system_state_type, system_error = 123, enabled = FALSE WHERE uid = '0000'::uuid""".stripMargin


  val invalidQuery: String =
    s"""CREATE TABLE TEST (userId uuid) DISTRIBUTED BY userId""".stripMargin


  "SqlParser" should {
    "parse insert successfully: " in {
      SqlParser.parseSql(insertQuery) shouldBe insertQuery
    }
    "parse update successfully: " in {
      SqlParser.parseSql(updateQuery) shouldBe updateQuery
    }
    "parse select successfully: " in {
      SqlParser.parseSql(selectQuery) shouldBe selectQuery
    }

    "throw exception when parse invalid query: " in {
      val throwsException = intercept[Exception] {
        SqlParser.parseSql(invalidQuery)
      }
      assert(throwsException.getMessage === s"Did not parsed the query")
    }

  }
}
