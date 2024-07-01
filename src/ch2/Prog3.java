package ch2;

import java.io.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Prog3 {
    public static void main(String[] args) throws IOException {

        String s = processFile((br) -> br.lines().collect(Collectors.joining("\n")));
        System.out.println(s);
    }

    private static String processFile(BufferReaderProcessor bufferReaderProcessor) throws IOException {
        String filePath = "src/test.properties";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            return bufferReaderProcessor.process(bufferedReader);
        }
    }
}

@FunctionalInterface
interface BufferReaderProcessor{
    String process(BufferedReader br) throws IOException;
}