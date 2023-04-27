package org.lab_7.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class SharedMemory {
    private final List<Token> tokens;
    private boolean finish = true;
    private boolean stop = true;

    public SharedMemory(int n) {
        var tokensList = new ArrayList<>(IntStream.rangeClosed(1, n * n * n).mapToObj(Token::new).toList());
        Collections.shuffle(tokensList);
        tokens = tokensList;
    }

    public synchronized List<Token> extractTokens(int howMany) {
        Random random = new Random();
        List<Token> extracted = new ArrayList<>();
        for(int i = 0; i < howMany; i++) {
            if(tokens.isEmpty())
                break;
            extracted.add(tokens.get(random.nextInt(tokens.size())));
        }
        return extracted;
    }

    public synchronized void setFinish(boolean value) {
        this.finish = value;
    }

    public synchronized boolean getFinish() {
        return finish;
    }

    public synchronized void setStop(boolean value) {
        this.stop = value;
    }

    public synchronized boolean getStop() {
        return stop;
    }
}
