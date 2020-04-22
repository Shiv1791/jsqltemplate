#JSqlParser
JSqlParser is a SQL statement parser. It translates SQLs in a traversable hierarchy of Java classes. JSqlParser is not limited to one database but provides support for a lot of specials of Oracle, SqlServer, MySQL, PostgreSQL ... To name some, it has support for Oracles join syntax using (+), PostgreSQLs cast syntax using ::, relational operators like != and so on.

#Alternatives to JSqlParser?
General SQL Parser looks pretty good, with extended SQL syntax (like PL/SQL and T-SQL) and java + .NET APIs. The tool is commercial (license available online), with a free download option.

#How to use JSql parser
Method name : `parseSql(sql: String)`
1. Created the method(parseSql) which takes the database query as a string.
2. It return the `SqlNode` if the database query is syntactically correct.
3. If the query query is looks good and not syntactically correct then it will throw exception.
4. JSql parser is not limited to one database.