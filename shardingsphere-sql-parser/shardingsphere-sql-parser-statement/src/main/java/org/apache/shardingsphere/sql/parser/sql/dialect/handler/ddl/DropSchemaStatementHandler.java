/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.sql.parser.sql.dialect.handler.ddl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.shardingsphere.sql.parser.sql.common.statement.ddl.DropSchemaStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.handler.SQLStatementHandler;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.opengauss.OpenGaussStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.opengauss.ddl.OpenGaussDropSchemaStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.postgresql.PostgreSQLStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.postgresql.ddl.PostgreSQLDropSchemaStatement;

/**
 * Drop schema statement handler for different dialect SQL statements.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DropSchemaStatementHandler implements SQLStatementHandler {
    
    /**
     * Judge whether SQL statement is contains cascade or not.
     *
     * @param dropSchemaStatement drop schema statement
     * @return SQL statement contains cascade or not
     */
    public static boolean containsCascade(final DropSchemaStatement dropSchemaStatement) {
        if (dropSchemaStatement instanceof PostgreSQLStatement) {
            return ((PostgreSQLDropSchemaStatement) dropSchemaStatement).isContainsCascade();
        }
        if (dropSchemaStatement instanceof OpenGaussStatement) {
            return ((OpenGaussDropSchemaStatement) dropSchemaStatement).isContainsCascade();
        }
        return false;
    }
}
