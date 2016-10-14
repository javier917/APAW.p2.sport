package architecture;

import daos.DaoFactory;
import daos.memory.DaoFactoryMemory;
import http.HttpMethod;
import http.HttpRequest;
import http.HttpResponse;
import upm.jbb.IO;

public class Main {
    private Server server = new Server();

    private HttpRequest request = new HttpRequest();

    public void help() {
        IO.getIO().println("GET **/users");
        IO.getIO().println("GET **/users/search?sport=*");
        IO.getIO().println("POST **/users   body=\"nick:email\"");
        IO.getIO().println("POST **/sports   body=\"name\"");
        IO.getIO().println("PUT **/users/{nick}/sport   body=\"sportName\"");
    }

    public void httpMethod() {
        request.setMethod((HttpMethod) IO.getIO().select(HttpMethod.values(), "Elige método"));
        this.showStatus();
    }

    public void path() {
        request.setPath(IO.getIO().readString("Path"));
        this.showStatus();
    }

    public void addQueryParam() {
        String[] msgs = {"Nombre", "Valor"};
        String[] campos = {"String", "String"};
        Object[] values = IO.getIO().readForm(campos, msgs);
        request.addQueryParam((String) values[0], (String) values[1]);
        this.showStatus();
    }

    public void clearQueryParams() {
        request.clearQueryParams();
        this.showStatus();
    }

    private void showStatus() {
        IO.getIO().setStatusBar(request.toString());
    }

    public void request() {
        IO.getIO().println(request.toString());
        HttpResponse response = server.request(request);
        IO.getIO().println(response);
        IO.getIO().println("---------------------------------------ooo----------------------------------------");
    }

    public void demo() {
        request.setMethod(HttpMethod.POST);
        request.setPath("users");
        request.setBody("uno:uno@gmail.com");
        this.request();
        request.setBody("dos:dos@gmail.com");
        this.request();
        request.setBody("uno:tres@gmail.com");
        this.request();

        request.setMethod(HttpMethod.GET);
        request.setPath("users");
        this.request();
        //request.clearQueryParams();

        request.setMethod(HttpMethod.POST);
        request.setPath("sports");
        request.setBody("tenis");
        this.request();
        request.setBody("tenis");
        this.request();
        request.setBody("ajedrez");
        this.request();

        request.setMethod(HttpMethod.PUT);
        request.setPath("users/uno/sport");
        request.setBody("tenis");
        this.request();
        request.setBody("noDeporte");
        this.request();
        request.setPath("users/dos/sport");
        request.setBody("tenis");
        this.request();
        request.setBody("ajedrez");
        this.request();

        request.setMethod(HttpMethod.GET);
        request.setPath("users/search");
        request.addQueryParam("sport", "tenis");
        this.request();

        request.setMethod(HttpMethod.POST);
        request.setPath("noPath");
        this.request();
    }

    public static void main(String[] args) {
        Main main = new Main();
        IO.getIO().addView(main);
        main.showStatus();
        DaoFactory.setFactory(new DaoFactoryMemory());

    }

}
