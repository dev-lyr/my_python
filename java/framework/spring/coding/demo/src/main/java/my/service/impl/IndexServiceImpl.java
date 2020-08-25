package my.service.impl;

import org.springframework.stereotype.Service;
import my.service.IndexService;

/**
 * Created by yueran.lyr on 2016/9/17.
 */
@Service
public class IndexServiceImpl implements IndexService{
    public String getIndex() {
        return "hello world";
    }
}
