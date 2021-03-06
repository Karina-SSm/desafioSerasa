package com.br.Serasa.desafioSerasa.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.springframework.util.StreamUtils;

public class ResourceUtil {
	
	public static String getContentFromResource(String resourceName) {
        try {
            InputStream stream = ResourceUtil.class.getResourceAsStream(resourceName);
            return StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
