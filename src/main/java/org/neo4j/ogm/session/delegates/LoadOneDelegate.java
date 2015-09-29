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
package org.neo4j.ogm.session.delegates;

import org.neo4j.ogm.cypher.query.AbstractRequest;
import org.neo4j.ogm.cypher.query.GraphModelRequest;
import org.neo4j.ogm.session.response.model.GraphModel;
import org.neo4j.ogm.session.Capability;
import org.neo4j.ogm.session.Neo4jSession;
import org.neo4j.ogm.session.request.strategy.QueryStatements;
import org.neo4j.ogm.session.response.Response;

/**
 * @author Vince Bickers
 */
public class LoadOneDelegate implements Capability.LoadOne {

    private Neo4jSession session;

    public LoadOneDelegate(Neo4jSession session) {
        this.session = session;
    }

    @Override
    public <T> T load(Class<T> type, Long id) {
        return load(type, id, 1);
    }

    @Override
    public <T> T load(Class<T> type, Long id, int depth) {
        QueryStatements queryStatements = session.queryStatementsFor(type);
        AbstractRequest qry = queryStatements.findOne(id,depth);
        try (Response<GraphModel> response = session.requestHandler().execute((GraphModelRequest) qry)) {
            return session.responseHandler().loadById(type, response, id);
        }
    }


}
