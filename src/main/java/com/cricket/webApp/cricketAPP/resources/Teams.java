package com.cricket.webApp.cricketAPP.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.cricket.webApp.cricketAPP.api.Team;
import com.cricket.webApp.cricketAPP.api.TeamList;
import com.cricket.webApp.cricketAPP.db.DbConnection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by jayavardhans on 25/1/17.
 */

@Path("/teams")
@Produces(MediaType.APPLICATION_JSON)
public class Teams {
    Statement statement;
    ObjectMapper mapper = new ObjectMapper();

    @GET

    public Response getteamsList() {
        statement = DbConnection.connect_mySQL("cricket");
        String query = "select * from teams";
        ArrayList<Team> teamList = new ArrayList<>();
        TeamList teams = new TeamList();
        String responseBody = null;
        try {
            ResultSet rs = statement.executeQuery(query);
            System.out.println(rs.getFetchSize());
            while (rs.next()) {
                Team team = new Team();
                team.setTeamid(rs.getInt(1));
                team.setTeamName(rs.getString(2));
                team.setCreatedDate(rs.getString(3));
                teamList.add(team);
            }
            teams.setTeams(teamList);
            return Response.status(200).entity(teams).build();
        } catch (SQLException e) {
            return Response.status(200).entity("Something went wrong").build();
        }
    }
}
