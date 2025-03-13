package io.codeforall.bootcamp;

import java.util.Arrays;

public class Machine<T> {
    MonoOperation monoOperation;
    BiOperation biOperation;

    public Machine(MonoOperation monoOperation, BiOperation biOperation) {
        this.monoOperation = monoOperation;
        this.biOperation = biOperation;
    }

    public T useMonoOperation (T something) {
        T result = (T) monoOperation.operationMono(something);
        return result;
    }

    public T useBiOperation (T something, T somethingElse) {
        T result = (T) biOperation.OperationBi(something, somethingElse);
        return result;
    }

    public void setNewOperations (MonoOperation monoOperation, BiOperation operation) {
        this.monoOperation = monoOperation;
        this.biOperation = biOperation;
    }

}
