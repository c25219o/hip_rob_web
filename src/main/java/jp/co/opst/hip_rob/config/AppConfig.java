package jp.co.opst.hip_rob.config;

import jp.co.opst.hip_rob.referee.LengthLimitReferee;
import jp.co.opst.hip_rob.referee.StandardReferee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by YuiIshino on 2016/06/28.
 */
@Configuration
public class AppConfig {

    @Bean
    @Qualifier("standardReferee")
    public StandardReferee standardReferee() {
        return new StandardReferee();
    }

    @Bean
    @Qualifier("lengthLimitReferee")
    public LengthLimitReferee lengthLimitReferee() {
        return new LengthLimitReferee();
    }
}
