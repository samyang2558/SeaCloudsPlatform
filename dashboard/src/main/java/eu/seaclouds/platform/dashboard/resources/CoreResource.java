/*
 *  Copyright 2014 SeaClouds
 *  Contact: SeaClouds
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */

package eu.seaclouds.platform.dashboard.resources;

import com.google.gson.JsonObject;
import eu.seaclouds.platform.dashboard.config.DeployerFactory;
import eu.seaclouds.platform.dashboard.config.MonitorFactory;
import eu.seaclouds.platform.dashboard.config.PlannerFactory;
import eu.seaclouds.platform.dashboard.config.SlaFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class CoreResource {
    private DeployerFactory deployerFactory;
    private MonitorFactory monitorFactory;
    private PlannerFactory plannerFactory;
    private SlaFactory slaFactory;


    public CoreResource(DeployerFactory deployerFactory, MonitorFactory monitorFactory, PlannerFactory plannerFactory, SlaFactory slaFactory) {
        this.deployerFactory = deployerFactory;
        this.monitorFactory = monitorFactory;
        this.plannerFactory = plannerFactory;
        this.slaFactory = slaFactory;
    }

    @GET
    @Path("about")
    public Response getSeaCloudsInformation(){
        JsonObject jsonResponse = new JsonObject();

        jsonResponse.addProperty("deployerEndpoint", deployerFactory.getEndpoint());
        jsonResponse.addProperty("monitoringManagerEndpoint", monitorFactory.getEndpoint());
        jsonResponse.addProperty("graphiteEndpoint", monitorFactory.getGraphiteEndpoint());
        jsonResponse.addProperty("grafanaEndpoint", monitorFactory.getGrafanaEndpoint());
        jsonResponse.addProperty("plannerEndpoint", plannerFactory.getEndpoint());
        jsonResponse.addProperty("slaEndpoint", slaFactory.getEndpoint());

        return Response.ok(jsonResponse.toString()).build();
    }
}