package br.com.devops.miranda.oladevopsme;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class AmazonS3BucketService {
       private S3Client buildS3Client() {
            return S3Client.builder()
                    .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
                    .region(Region.SA_EAST_1)
                    .build();
        }

        public String uploadArquivo(MultipartFile file) {
            File fileObj = convertMultiPartFileToFile(file);
            String fileName = LocalDate.now() + file.getOriginalFilename() + UUID.randomUUID();

            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket("meu-bucket-brabinho")
                    .key(fileName)
                    .build();

            buildS3Client().putObject(request, RequestBody.fromFile(fileObj));
            fileObj.delete();
            return "Upload do arquivo  : " + fileName;
        }


        private File convertMultiPartFileToFile(MultipartFile file) {
            File converted = new File(file.getOriginalFilename());
            try (FileOutputStream fileOut = new FileOutputStream(converted)) {
                fileOut.write(file.getBytes());
            } catch (IOException e) {

            }
            return converted;
        }

    }

