package Reto1;

import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(600);
        return "Control térmico: temperatura estable (22°C).";
    }
}