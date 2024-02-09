import java.io.IOException;

abstract class Number {
    public abstract void sum() throws IOException;

    public abstract void sub() throws IOException;

    public abstract void div() throws IOException;

    public abstract void mul() throws IOException;

    public abstract int getResult();

    public abstract String getStringResult();
}
