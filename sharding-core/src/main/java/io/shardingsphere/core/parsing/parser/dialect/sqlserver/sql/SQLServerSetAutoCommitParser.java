/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.core.parsing.parser.dialect.sqlserver.sql;

import io.shardingsphere.core.parsing.lexer.LexerEngine;
import io.shardingsphere.core.parsing.lexer.token.DefaultKeyword;
import io.shardingsphere.core.parsing.parser.sql.tcl.TCLStatement;
import io.shardingsphere.core.parsing.parser.sql.tcl.begin.BeginTransactionStatement;
import io.shardingsphere.core.parsing.parser.sql.tcl.ignore.IgnoreStatement;
import io.shardingsphere.core.parsing.parser.sql.tcl.set.autocommit.AbstractSetAutoCommitParser;

/**
 * Set auto commit parser for SQLServer.
 *
 * @author maxiaoguang
 */
public final class SQLServerSetAutoCommitParser extends AbstractSetAutoCommitParser {
    
    public SQLServerSetAutoCommitParser(final LexerEngine lexerEngine) {
        super(lexerEngine);
    }
    
    @Override
    public TCLStatement parse() {
        getLexerEngine().nextToken();
        return DefaultKeyword.ON.equals(getLexerEngine().getCurrentToken().getType()) ? new IgnoreStatement() : new BeginTransactionStatement();
    }
}
