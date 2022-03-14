package com.manhattan.services.implementations;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.manhattan.models.dtos.CategoryJsonReadDto;
import com.manhattan.services.interfaces.FileService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

import static com.manhattan.utils.CommonConstants.CATEGORIES_FILE;
import static com.manhattan.utils.CommonConstants.RESOURCE_FILE_PATH;

@Service
public class FileServiceImpl implements FileService {
    private final Gson gson;

    public FileServiceImpl(Gson gson) {
        this.gson = gson;
    }

    @Override
    public <T> T[] readFile(String filePath, Class<?> clazz) throws IOException {
        try (JsonReader jsonReader =
                     new JsonReader(
                             new InputStreamReader(
                                     new FileInputStream(filePath)))) {
            return gson.fromJson(jsonReader, clazz);
        }
    }

    @Override
    public <T> void writeToFile(String filePath, T record) throws IOException {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath))) {
            String result = gson.toJson(record);
            writer.write(result);
            writer.flush();
        }
    }
}
