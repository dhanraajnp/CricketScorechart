package com.cricket.webApp.cricketAPP;

import com.cricket.webApp.cricketAPP.resources.Teams;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import com.cricket.webApp.cricketAPP.resources.players;

import io.dropwizard.Application;
import io.dropwizard.Bundle;
import io.dropwizard.servlets.assets.AssetServlet;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class apiApplication extends Application<com.cricket.webApp.cricketAPP.apiConfiguration> {
	
    public static void main(final String[] args) throws Exception {
    	new apiApplication().run(args);
    }

    @Override
    public String getName() {
        return "api";
    }

    @Override
    public void initialize(final Bootstrap<apiConfiguration> bootstrap) {
        // TODO: application initialization
    	
    	    	
    }

    @Override
    public void run(final apiConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    	environment.jersey().register(new players());
        environment.jersey().register(new Teams());
    	
    }

}
