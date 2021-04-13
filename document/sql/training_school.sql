drop table if exists trs_course;

/*==============================================================*/
/* Table: trs_course                                            */
/*==============================================================*/
create table trs_course
(
   id                   bigint not null auto_increment,
   trs_school_id        bigint comment '培训机构',
   name                 varchar(100) comment '名称',
   price                decimal comment '原价',
   description          text comment '介绍',
   pic                  varchar(255) comment '图片',
   create_date          datetime comment '创建时间',
   modify_date          datetime comment '修改时间',
   status               int(1) default 0 comment '状态',
   primary key (id)
);

alter table trs_course comment '课程';


drop table if exists trs_school;

/*==============================================================*/
/* Table: trs_school                                            */
/*==============================================================*/
create table trs_school
(
    id                   bigint not null auto_increment,
    name                 varchar(100) comment '机构名称',
    contact_name         varchar(100) comment '联系人',
    contact_no           varchar(15) comment '联系方式',
    logo                 varchar(255) comment '机构logo',
    sub_school           text comment '分校名称',
    video                varchar(255) comment '机构视频',
    description          text comment '介绍',
    Latlongitude         varchar(50) comment '地图标注',
    create_date          datetime comment '创建时间',
    modify_date          datetime comment '修改时间',
    status               int(1) default 0 comment '状态',
    primary key (id)
);

alter table trs_school comment '培训机构';


drop table if exists trs_school_activity;

/*==============================================================*/
/* Table: trs_school_activity                                   */
/*==============================================================*/
create table trs_school_activity
(
    id                   bigint not null auto_increment,
    trs_school_id            bigint,
    trs_activity_id      bigint,
    course_num           int comment '可选课程数量',
    sort                 int comment '排序',
    create_date          datetime comment '创建时间',
    modify_date          datetime comment '修改时间',
    primary key (id)
);

alter table trs_school_activity comment '机构活动';



drop table if exists trs_activity;

/*==============================================================*/
/* Table: trs_activity                                          */
/*==============================================================*/
create table trs_activity
(
    id                   bigint not null auto_increment,
    name                 varchar(100) comment '活动名称',
    price                decimal comment '活动价格',
    sales_num            int comment '销售数量',
    course_num           int comment '课程数量',
    description          text comment '介绍',
    qrcode               varchar(255) comment '访问二维码',
    end_date             datetime comment '结束时间',
    start_date           datetime comment '开始时间',
    create_date          datetime comment '创建时间',
    modify_date          datetime comment '修改时间',
    status               int(1) default 1 comment '状态',
    choose_all_course    int(1) default 0 comment '是否需要选足课程',
    gift_num             int comment '赠品可选数量限制',
    lucky_draw           int(1) default 0 comment '是否开启抽奖',
    school_mark          int(1) default 0 comment '是否开启机构评分',
    primary key (id)
);

alter table trs_activity comment '活动';


drop table if exists trs_course_activity;

/*==============================================================*/
/* Table: trs_course_activity                                   */
/*==============================================================*/
create table trs_course_activity
(
    id                   bigint not null auto_increment,
    trs_course_id            bigint,
    trs_activity_id      bigint,
    course_num           int comment '库存',
    apply_num            int comment '报名数',
    sort                 int comment '排序',
    create_date          datetime comment '创建时间',
    modify_date          datetime comment '修改时间',
    primary key (id)
);

alter table trs_course_activity comment '课程活动';

drop table if exists trs_pages;

/*==============================================================*/
/* Table: trs_pages                                             */
/*==============================================================*/
create table trs_pages
(
    id                   bigint not null auto_increment,
    trs_activity_id      bigint,
    name                 varchar(255) comment '分享页商品标题',
    sub_name             varchar(255) comment '分享标题',
    sort                 int(1) comment '排序',
    swipe_pic            text comment '分享页顶部轮播图片',
    create_date          datetime comment '创建时间',
    modify_date          datetime comment '修改时间',
    show_sch_num         int comment '首页学校显示数量',
    top_pic              text comment '主页面顶部图片',
    share_pic            text comment '分享图片',
    description          text comment '分享描述',
    show_crs_num         int comment '首页课程显示数量',
    background_color     text comment '背景颜色',
    income_ranking       int(1) default 0 comment '收入排行榜',
    show_booking         int(1) default 0 comment '是否显示报名数',
    audio                text comment '音频文件',
    buttom_text          text comment '分享海报底部文字',
    show_my_income       int(1) default 0 comment '分享页显示我的收入',
    day_limit            int comment '倒计时天数',
    primary key (id)
);

alter table trs_pages comment '页面';


drop table if exists trs_group_distribution;

/*==============================================================*/
/* Table: trs_group_distribution                                */
/*==============================================================*/
create table trs_group_distribution
(
    id                   bigint not null auto_increment,
    trs_activity_id      bigint,
    level_one_bonus      decimal comment '一级返利',
    level_two_bonus      decimal comment '二级返利',
    group_distribution   int(1) default 0 comment '分销',
    teacher_lone_bonus   decimal comment '教师一级返利',
    teacher_ltwo_bonus   decimal comment '教师二级返利',
    bind_level_time      int(1) default 0 comment '上下级绑定时间',
    create_date          datetime comment '创建时间',
    modify_date          datetime comment '修改时间',
    distribution_after_buy int(1) default 0 comment '是否购买才可以分销',
    primary key (id)
);

alter table trs_group_distribution comment '分销';


drop table if exists trs_gift;

/*==============================================================*/
/* Table: trs_gift                                              */
/*==============================================================*/
create table trs_gift
(
    id                   bigint not null auto_increment,
    trs_activity_id      bigint,
    name                 varchar(255) comment '名称',
    sponsor_name         varchar(255) comment '赞助商名称',
    pic                  text comment '商品图片',
    num                  int comment '数量',
    price                decimal comment '价值',
    sponsor_address      text comment '商家地址',
    validate_time        datetime comment '有效期',
    description          text comment '介绍',
    create_date          datetime comment '创建时间',
    modify_date          datetime comment '修改时间',
    primary key (id)
);

alter table trs_gift comment '赠品';



drop table if exists trs_locale;

/*==============================================================*/
/* Table: trs_locale                                            */
/*==============================================================*/
create table trs_locale
(
    id                   bigint not null auto_increment,
    trs_activity_id      bigint,
    name                 varchar(255) comment '活动名称',
    text_3d              varchar(255) comment '3D图形文字',
    link                 text comment '活动连接',
    create_date          datetime comment '创建时间',
    modify_date          datetime comment '修改时间',
    enable               int(1) default 0 comment '是否开启',
    auto_reg_teache      int(1) default 0 comment '开启二维码自动注册老师',
    qrcode_parents       int(1) default 0 comment '开启家长组二维码',
    primary key (id)
);

alter table trs_locale comment '现场';




drop table if exists trs_group_sale;

/*==============================================================*/
/* Table: trs_group_sale                                        */
/*==============================================================*/
create table trs_group_sale
(
    id                   bigint not null auto_increment,
    trs_activity_id      bigint,
    group_num            int comment '库存',
    group_hours          int comment '报名数',
    group_sale           int(1) default 0 comment '是否开启拼团',
    price                decimal comment '拼团价格',
    bonus                decimal comment '拼团分销奖金',
    teacher_bonus        decimal comment '教师拼团分销奖金',
    group_commission     int(1) default 0 comment '成团及佣金',
    create_date          datetime comment '创建时间',
    modify_date          datetime comment '修改时间',
    primary key (id)
);

alter table trs_group_sale comment '课程活动';


drop table if exists tus_user;

/*==============================================================*/
/* Table: tus_user                                              */
/*==============================================================*/
create table tus_user
(
    id                   bigint not null auto_increment comment 'ID',
    user_id              varchar(10) comment '用户ID',
    pic                  text comment '头像',
    nick_name            varchar(100) comment '昵称',
    level                char(1) comment '等级',
    balance              decimal comment '余额',
    sex                  int(1) comment '性别',
    name                 varchar(100) comment '姓名',
    mobile               varchar(15) comment '手机号',
    take_order           char(1) comment '是否下单',
    invite_people_count  int comment '邀请人数',
    create_date          datetime comment '注册时间',
    modify_date          datetime comment '修改时间',
    parent_level_one     bigint comment '上一级',
    parent_level_two     bigint comment '上二级',
    province             varchar(10) comment '省',
    city                 varchar(10) comment '市',
    primary key (id)
);

alter table tus_user comment '用户';

drop table if exists tus_capital_record;

/*==============================================================*/
/* Table: tus_capital_record                                    */
/*==============================================================*/
create table tus_capital_record
(
    id                   bigint not null auto_increment comment 'ID',
    tus_id               bigint comment 'ID',
    money                decimal comment '金额',
    description          text comment '备注',
    create_date          datetime comment '注册时间',
    modify_date          datetime comment '修改时间',
    primary key (id)
);

alter table tus_capital_record comment '资金记录';

drop table if exists tus_promotion_poster;

/*==============================================================*/
/* Table: tus_promotion_poster                                  */
/*==============================================================*/
create table tus_promotion_poster
(
    id                   bigint not null auto_increment comment 'ID',
    tus_id               bigint comment 'ID',
    poster               text comment '海报',
    primary key (id)
);

alter table tus_promotion_poster comment '推广海报';
