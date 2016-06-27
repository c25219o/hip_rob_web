package jp.co.opst.hip_rob.service;

import jp.co.opst.hip_rob.dao.WordListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YuiIshino on 2016/06/27.
 */
@Service
public class WordService {

    @Autowired
    private WordListDao dao;
}
