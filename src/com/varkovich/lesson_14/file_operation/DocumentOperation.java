package com.varkovich.lesson_14.file_operation;

import com.varkovich.lesson_14.utils.DocumentValidationState;
import com.varkovich.lesson_14.validator.DocumentValidator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class DocumentOperation {

    public static void generateReportFiles(File file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
        DocumentValidationState documentValidationState;
        Path path;

        for (int i = 0; i < lines.size(); i++) {
            documentValidationState = DocumentValidator.validateDocument(lines.get(i));

            if (documentValidationState != DocumentValidationState.VALID_DOCUMENT) {
                path = Paths.get("resources/Invalid_Documents");
                if (!path.toFile().exists()) {
                    Files.createFile(path);
                }
                Files.write(
                        path,
                        (lines.get(i) + " - " + documentValidationState.getMessage() + "\n").getBytes(),
                        StandardOpenOption.APPEND);

            } else {
                if (lines.get(i).startsWith("docnum")) {
                    path = Paths.get("resources/Docnum_Documents");
                } else {
                    path = Paths.get("resources/Contract_Documents");
                }
                if (!path.toFile().exists()) {
                    Files.createFile(path);
                }
                Files.write(
                        path,
                        (lines.get(i)+"\n").getBytes(),
                        StandardOpenOption.APPEND);
            }
        }
    }
}
