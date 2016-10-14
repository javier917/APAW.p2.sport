package architecture;

import api.SportResource;
import api.UserResource;
import exceptions.InvalidRequestException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public class Dispatcher {

    private UserResource userResource = new UserResource();

    private SportResource sportResource = new SportResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        switch (request.getPath()) {
        case "users":
            response.setBody(userResource.userList().toString());
            response.setStatus(HttpStatus.OK);
            break;
        case "users/search":
            String sport = request.getParams().get("sport");
            if (sport != null) {
                try {
                    response.setBody(userResource.usersBySport(sport).toString());
                } catch (Exception e) {
                    this.responseError(response, e);
                }
            } else {
                responseError(response, new InvalidRequestException(request.getPath()));
            }
            response.setStatus(HttpStatus.OK);
            break;
        default:
            responseError(response, new InvalidRequestException(request.getPath()));
            response.setStatus(HttpStatus.BAD_REQUEST);
            break;
        }
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        switch (request.getPath()) {
        case "users":
            String nick = request.getBody().split(":")[0];
            String email = request.getBody().split(":")[1];
            try {
                userResource.createUser(nick, email);
                response.setStatus(HttpStatus.CREATED);
            } catch (Exception e) {
                this.responseError(response, e);
            }
            break;
        case "sports":
            try {
                sportResource.createSport(request.getBody());
                response.setStatus(HttpStatus.CREATED);
            } catch (Exception e) {
                this.responseError(response, e);
            }
            break;
        default:
            responseError(response, new InvalidRequestException(request.getPath()));
            response.setStatus(HttpStatus.BAD_REQUEST);
            break;
        }
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        if ("users".equals(request.paths()[0]) && "sport".equals(request.paths()[2])) {
            try {
                String sport = request.getBody();
                userResource.addSport(request.paths()[1], sport);
                response.setStatus(HttpStatus.OK);
            } catch (Exception e) {
                this.responseError(response, e);
            }
        } else {
            responseError(response, new InvalidRequestException(request.getPath()));
            response.setStatus(HttpStatus.BAD_REQUEST);
        }
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        switch (request.getPath()) {
        default:
            response.setStatus(HttpStatus.BAD_REQUEST);
            responseError(response, new InvalidRequestException(request.getPath()));
            break;
        }
    }
}
