package base.springmvc.serializable;

import java.text.SimpleDateFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Package: base.springmvc.serializable
 * Author: houzm
 * Date: Created in 2018/9/7 13:05
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class JsonObjectConverterMapper extends ObjectMapper {

    private static final long serialVersionUID = 673826917023137319L;
    private ThreadLocal<SimpleDateFormat> localSdf =new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return null;
        }
    };

    public SimpleDateFormat getDateFormat() {
        SimpleDateFormat df = (SimpleDateFormat) localSdf.get();
        if (df == null) {
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            localSdf.set(df);
        }
        return df;
    }
    public JsonObjectConverterMapper(){
        //设置null值不参与序列化(字段不被显示)
//        this.setSerializationInclusion(Include.NON_NULL);
        // 禁用空对象转换json校验
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //驼峰命名法转换为小写加下划线
//		this.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

        this.setDateFormat(getDateFormat());
    }
}
