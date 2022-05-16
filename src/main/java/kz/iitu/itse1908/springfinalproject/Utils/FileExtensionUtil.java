package kz.iitu.itse1908.springfinalproject.Utils;

import java.util.Optional;

public class FileExtensionUtil {
    public static Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }
}
