package com.tool.wst.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FileService {

    @Value("${location.path}")
    String locationPath;

    /* 폴더 생성.*/
    public void isExistFolder(String url){
        File file = new File(url);
        System.out.println(url);
        if(!file.exists()){ //폴더가 존재하지 않으면.
            file.mkdir();
        }
    }
    
    /* 파일 업로드*/
    /**
        baseUrl : 이미지 경로.
        ex) /user
            /mail
     **/
    public List<String> uploadFile(MultipartFile multipartFile, String baseUrl){
        // 0. [ (uuidFileName), (uuidUrl)]
        List<String> responses = new ArrayList<>();
        //0-1. make directory
        isExistFolder(locationPath+baseUrl+"/");

        /// 1. UUID 생성.
        UUID uuid = UUID.randomUUID();

        // 2. 새로운 파일 이름 만들기
        // ex) 198192419saf.jpg
        String uuidFileName = uuid.toString() + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        responses.add(uuidFileName);


        // 3. url생성.
        // ex) /file/user/198192419saf.jpg
        String uuidURl = "/file"+baseUrl+"/"+ uuidFileName;
        responses.add(uuidURl);

        // 4. upLoad
        // ex) file:///C:/pmt/user/198192419saf.jpg
        String localUploadUrl = locationPath + baseUrl + "/"+ uuidFileName;
        try {
            FileOutputStream fos = new FileOutputStream(localUploadUrl);
            fos.write(multipartFile.getBytes());
            fos.close();;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return responses;
    }
    



}
