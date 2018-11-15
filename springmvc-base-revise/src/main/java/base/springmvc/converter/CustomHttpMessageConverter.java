package base.springmvc.converter;

import base.springmvc.User;
import base.springmvc.UserForCustomConverter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

/**
 * Package: base.springmvc.converter
 * Author: houzm
 * Date: Created in 2018/9/8 21:02
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class CustomHttpMessageConverter extends AbstractHttpMessageConverter<UserForCustomConverter> {

    public CustomHttpMessageConverter() {
        super(new MediaType("application", "x-houzm", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return UserForCustomConverter.class.isAssignableFrom(clazz);
    }

    @Override
    protected UserForCustomConverter readInternal(Class<? extends UserForCustomConverter> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String stream = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
        String[] split = stream.split("-");
        UserForCustomConverter userForCustomConverter = new UserForCustomConverter();
        userForCustomConverter.setId(split[0]);
        userForCustomConverter.setAge(Integer.valueOf(split[1]));
        userForCustomConverter.setAddress(split[2]);
        try {
            userForCustomConverter.setBirth(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(split[3]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userForCustomConverter.setName(split[5]);
        return userForCustomConverter;
    }

    @Override
    protected void writeInternal(UserForCustomConverter userForCustomConverter, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello "+userForCustomConverter.getName()+" your birthday : "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(userForCustomConverter.getBirth());
        outputMessage.getBody().write(out.getBytes());
    }
}
