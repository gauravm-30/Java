package com.example.streamdata.controllers;

import com.example.streamdata.models.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RequestMapping("/api/stream")
@RestController
public class StreamDataController {
    @GetMapping(value="/data")
    public ResponseEntity<StreamingResponseBody> streamData() throws IOException {
        System.out.println(""+Thread.currentThread().getName());
    StreamingResponseBody responseBody =
        outputStream -> {
          System.out.println(outputStream.toString()+" "+ outputStream.getClass());
          System.out.println(
              "Inside StreamingResponseBody: "
                  + Thread.currentThread().getName()
                  + ", "
                  + Thread.currentThread().getThreadGroup());
          for (int i = 1; i <= 800; i++) {
            try {
              Thread.sleep(10);
              outputStream.write(("Data stream line - " + i + "\n").getBytes());
              outputStream.flush();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        };
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(responseBody);
    }

    @GetMapping("/json")
    public ResponseEntity<StreamingResponseBody> streamJson() {
        int maxRecords = 100;
        StreamingResponseBody responseBody = responseStream -> {
            for (int i = 1; i <= maxRecords; i++) {
                Student st = new Student("Name" + i, i);
                ObjectMapper mapper = new ObjectMapper();

                String jsonString = mapper.writeValueAsString(st) +"\n";
                responseStream.write(jsonString.getBytes());
                responseStream.flush();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_NDJSON)
//                .contentType(MediaType.APPLICATION_NDJSON)
                /* We can use application_stream_json or application_ndjson*/
                .body(responseBody);

                /*Definition: NDJSON is a format for storing or streaming structured data where each record (or object) is represented as a single line of valid JSON, separated by newline characters (\n).
Purpose: NDJSON is convenient for scenarios where data can be processed one record at a time. It’s commonly used for bulk data operations and streaming large datasets.*/
    }

    @GetMapping("/textfile")
    public ResponseEntity<StreamingResponseBody> streamContentAsFile() {
        StreamingResponseBody responseBody = response -> {
            for (int i = 1; i <= 1000; i++) {
                response.write(("Data stream line - " + i + "\n").getBytes());
                response.flush();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=test_data.txt")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(responseBody);
    }

    @GetMapping("/pdfFile")
    public ResponseEntity<StreamingResponseBody> streamPdfFile() throws FileNotFoundException {
        String fileName = "Technicalsand.com sample data.pdf";
        File file = ResourceUtils.getFile("classpath:static/" + fileName);
        StreamingResponseBody responseBody = outputStream -> {
            Files.copy(file.toPath(), outputStream);
        };
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Downloaded_" + fileName)
                .contentType(MediaType.APPLICATION_PDF)
                .body(responseBody);
    }

    @GetMapping(value = "/csv")
    public ResponseEntity<StreamingResponseBody> getCsvFile() {
        StreamingResponseBody stream = output -> {
            Writer writer = new BufferedWriter(new OutputStreamWriter(output));
            writer.write("name,rollNo"+"\n");
            for (int i = 1; i <= 10000; i++) {
                Student st = new Student("Name" + i, i);
                writer.write(st.getName() + "," + st.getRollNo() + "\n");
                writer.flush();
            }
        };
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data.csv")
                .contentType(MediaType.TEXT_PLAIN)
                .body(stream);
    }

    @GetMapping(value = "/zip")
    public ResponseEntity<StreamingResponseBody> getZipFileStream() {
        StreamingResponseBody stream = output -> writeToStream(output);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.zip")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(stream);
    }

    public void writeToStream(OutputStream os) throws IOException {
        ZipOutputStream zipOut = new ZipOutputStream(new BufferedOutputStream(os));
        ZipEntry e = new ZipEntry("data.csv");
        zipOut.putNextEntry(e);
        Writer writer = new BufferedWriter(new OutputStreamWriter(zipOut, Charset.forName("UTF-8").newEncoder()));
        for (int i = 1; i <= 1000; i++) {
            Student st = new Student("Name" + i, i);
            writer.write(st.getName() + "," + st.getRollNo() + "\n");
            writer.flush();
        }
        if (writer != null) {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
//
//    // Read data from a file (e.g., /path/to/example/file)
//    InputStream inputStream = new FileInputStream(new File("/path/to/example/file"));
//
//    // Create a StreamingResponseBody
//    StreamingResponseBody responseBody = outputStream -> {
//        byte[] buffer = new byte[1024];
//        int bytesRead;
//        while ((bytesRead = inputStream.read(buffer)) != -1) {
//            outputStream.write(buffer, 0, bytesRead);
//        }
//        inputStream.close();
//    };