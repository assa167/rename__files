package org.src;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input file name");
        String fileName = scanner.nextLine();
        scanner.close();

        String directoryPath = "/Users/daniil_admin/Desktop/India_original_creo/Clean_metadata/News_hindi"; // path directory with files for rename
        int fileNumber = 1; // first number file

        File directory = new File(directoryPath);
        File[] filesInDirectory = directory.listFiles();
        for (File videoFile : filesInDirectory) {
            if (!videoFile.isDirectory()) {
                String fileExtension = getFileExtension(videoFile.getName());

                String newFileName = fileName + "_" + fileNumber + fileExtension;
                File newFile = new File(directoryPath + "/" + newFileName);

                boolean isRenamed = videoFile.renameTo(newFile);
                if (isRenamed) {
                    System.out.println("File " + videoFile.getName() + " successfully rename at " + newFileName);
                    fileNumber++;
                } else {
                    System.out.println("Failed to rename file " + videoFile.getName());
                }
            }
        }
    }

    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex == -1) {
            return "";
        }
        return fileName.substring(dotIndex);
    }
}