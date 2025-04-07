package io.codeforall.bootcamp;

import io.codeforall.bootcamp.model.SelfOrderKiosk;

public class App {

    private Bootstrap bootstrap = new Bootstrap();

    public void init() {
        this.bootstrap.getSelfOrderKiosk().work();
    }

    public static void main(String[] args) {

        App app = new App();
        app.bootstrap.initObjects();
        app.init();

    }

}
