package com.online.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@PropertySource(value = { "classpath:application.properties" })
public class FileUpload {

	@Value("${uploadPath}")
	String uploadPath;

	protected String upload(MultipartFile file) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");

		String date = dateFormat.format(new Date());

		String name = date + file.getOriginalFilename().replace(' ', '-');

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				File dir = new File(uploadPath + "/prpoduct");
				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(dir + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				return "prpoduct/" + name;
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
}
