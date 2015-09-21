/*
 * Copyright (c) 2002-2015 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with
 * separate copyright notices and license terms. Your use of the source
 * code for these subcomponents is subject to the terms and
 * conditions of the subcomponent's license, as noted in the LICENSE file.
 *
 */

package org.neo4j.ogm.session.request;


import org.neo4j.ogm.cypher.query.GraphModelQuery;
import org.neo4j.ogm.cypher.query.GraphRowModelQuery;
import org.neo4j.ogm.cypher.query.RowModelQuery;
import org.neo4j.ogm.cypher.query.RowModelQueryWithStatistics;
import org.neo4j.ogm.cypher.statement.ParameterisedStatement;
import org.neo4j.ogm.model.GraphModel;
import org.neo4j.ogm.session.response.Neo4jResponse;
import org.neo4j.ogm.session.result.GraphRowModel;
import org.neo4j.ogm.session.result.RowModel;
import org.neo4j.ogm.session.result.RowQueryStatisticsResult;

import java.util.List;

/**
 * @author Vince Bickers
 * @author Luanne Misquitta
 */
public interface RequestHandler {

    Neo4jResponse<GraphModel> execute(GraphModelQuery qry);
    Neo4jResponse<RowModel> execute(RowModelQuery query);
    Neo4jResponse<GraphRowModel> execute(GraphRowModelQuery query);
    Neo4jResponse<String> execute(ParameterisedStatement statement);
    Neo4jResponse<String> execute(List<ParameterisedStatement> statementList);
    Neo4jResponse<RowQueryStatisticsResult> execute(RowModelQueryWithStatistics query);
}
