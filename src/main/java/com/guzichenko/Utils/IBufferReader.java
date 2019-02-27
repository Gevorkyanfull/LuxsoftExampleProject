package com.guzichenko.Utils;

import java.io.IOException;

public interface IBufferReader {
    public Long readLong() throws IOException;
    int readInteger();
    String readString() throws IOException;
}
