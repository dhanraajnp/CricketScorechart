package com.cricket.webApp.cricketAPP.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
 
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.validator.internal.engine.messageinterpolation.el.MapBasedFunctionMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cricket.webApp.cricketAPP.api.Player;
import com.cricket.webApp.cricketAPP.api.PlayerList;
import com.cricket.webApp.cricketAPP.db.DbConnection;
 
 
@Path("/players")
@Produces(MediaType.APPLICATION_JSON)
public class players {
 
	Statement statement;
	
	ObjectMapper mapper = new ObjectMapper();
    @GET
    public Response getAllPlayerList() throws JsonProcessingException {
    	statement  = DbConnection.connect_mySQL("cricket");
		String query = "select * from players";
		ArrayList<Player> playerList = new ArrayList<>();
		PlayerList players = new PlayerList();
		String responseBody = null;
		try {
			ResultSet rs = statement.executeQuery(query);
			System.out.println(rs.getFetchSize());
			while(rs.next()){
				Player player = new Player();
				player.setPlayerName(rs.getString("PlayerName"));
				player.setPlayerId(rs.getInt("playerId"));
				player.setBirthPlace(rs.getString("Birth_Place"));
				player.setDateOfBirth(rs.getString("DOB"));
				player.setteam(rs.getString("teamName"));
				player.setCenturies(rs.getInt("centuries"));
				player.setDuckOut(rs.getInt("duckOut"));
				player.setFours(rs.getInt("4s"));
				player.setSixs(rs.getInt("6s"));
				player.setTotalRuns(rs.getInt("totalRuns"));
				player.setWickets(rs.getInt("wickets"));
				player.setOvers(rs.getInt("overs"));
				player.setHalfCenturies(rs.getInt("Halfcenturies"));
				player.setBallsFaced(rs.getInt("ballsFaced"));
				playerList.add(player);
			}
			players.setPlayer(playerList);
			return Response.status(200).entity(players).build();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DbConnection.close_MySQL();
		}

    }
 
    @GET
    @Path("/{teamName}")
    public String getTemList(@PathParam("teamName") String teamName) {
    	statement  = DbConnection.connect_mySQL("cricket");
		String query = "select * from players " +
				"where teamName = '"+teamName+"'";
		ArrayList<Player> playerList = new ArrayList<>();
		PlayerList players = new PlayerList();
		String responseBody = null;
		try {
			ResultSet rs = statement.executeQuery(query);
			System.out.println(rs.getFetchSize());
			while(rs.next()){
				Player player = new Player();
				player.setPlayerName(rs.getString("PlayerName"));
				player.setPlayerId(rs.getInt("playerId"));
				player.setBirthPlace(rs.getString("Birth_Place"));
				player.setDateOfBirth(rs.getString("DOB"));
				player.setteam(rs.getString("teamName"));
				player.setCenturies(rs.getInt("centuries"));
				player.setDuckOut(rs.getInt("duckOut"));
				player.setFours(rs.getInt("4s"));
				player.setSixs(rs.getInt("6s"));
				player.setTotalRuns(rs.getInt("totalRuns"));
				player.setWickets(rs.getInt("wickets"));
				player.setOvers(rs.getInt("overs"));
				player.setHalfCenturies(rs.getInt("Halfcenturies"));
				player.setBallsFaced(rs.getInt("ballsFaced"));
				playerList.add(player);					
			}
			players.setPlayer(playerList);
			responseBody = mapper.writeValueAsString(players);			
		} catch (SQLException | JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbConnection.close_MySQL();
		}
    	return responseBody;
    }
    
    @GET
    @Path("/{id}/{lastNam}")
    public String getEmployeeById(@PathParam("id") String id, @PathParam("lastNam") String lastname) {
        return "{\"Name\":\""+id+"\",\"LastName\":\""+lastname+"\"}";
    }
}