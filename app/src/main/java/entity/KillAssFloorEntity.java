package entity;

import entity.KillAssEntity;

/**
 * Created by shanliang on 2018/3/30.
 * 楼层实体，每个楼层最终封装成此
 */

public class KillAssFloorEntity {
    public int type = 1;
    public String title_content = "";
    public KillAssEntity leftKaEntity;
    public KillAssEntity rightKaEntity;

}
