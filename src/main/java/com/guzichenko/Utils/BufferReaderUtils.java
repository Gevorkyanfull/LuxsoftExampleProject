package com.guzichenko.Utils;

import java.io.BufferedReader;
import java.io.IOException;

public class BufferReaderUtils implements IBufferReader {
    private BufferedReader br;

    public BufferReaderUtils(BufferedReader br) {
        this.br = br;
    }

    public Long readLong() throws IOException {
        return Long.parseLong(br.readLine());
    }

    @Override
    public int readInteger() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Input number please!!");
            return readInteger();
        }
    }

    @Override
    public String readString() throws IOException {
        return br.readLine();
    }
}
