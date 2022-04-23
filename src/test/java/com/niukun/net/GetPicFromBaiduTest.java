package com.niukun.net;


import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.niukun.net.GetPicFromBaidu.getPicFromCertainURL;

public class GetPicFromBaiduTest {

    @Test
    public void TestGetPicFromCertainURL(){
        try {


            String[] strs = {
                    "https://img5.51tietu.net/pic/2019-090109/utjbstt3u3eutjbstt3u3e.jpg",
                    "https://img5.51tietu.net/pic/2019-090109/utjbstt3u3eutjbstt3u3e.jpg",
                    "https://img5.51tietu.net/pic/2019-090109/5wl4wind4bd5wl4wind4bd.jpg",
                    "https://img5.51tietu.net/pic/2019-090109/rtaflrookkkrtaflrookkk.jpg",
                    "https://img5.51tietu.net/pic/2019-090109/rzbk0fy4qrkrzbk0fy4qrk.jpg",
                    "https://img5.51tietu.net/pic/2019-090109/h2d43mwjj5mh2d43mwjj5m.jpg",
                    "https://img5.51tietu.net/pic/2019-090109/g35g5ydg1e0g35g5ydg1e0.jpg",
                    "https://img5.51tietu.net/pic/2019-090109/4v5czvonmnp4v5czvonmnp.jpg",
                    "https://img5.51tietu.net/pic/2019-090109/svbidfqepmmsvbidfqepmm.jpg",
                    "https://img5.51tietu.net/pic/2019-090109/lub2fzjzavelub2fzjzave.jpg"
            };


            for(int i =0 ;i < strs.length ;i++){
                getPicFromCertainURL(strs[i],"F:\\图片\\daima\\"+i+".jpg");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}