drop table if exists trs_course;

/*==============================================================*/
/* Table: trs_course                                            */
/*==============================================================*/
create table trs_course
(
   id                   bigint not null auto_increment,
   trs_school_id        bigint comment '培训机构',
   name                 varchar(100) comment '名称',
   price                varchar(255) comment '原价',
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
    school_id            bigint,
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
    crs_act_id           bigint,
    sch_act_id           bigint,
    name                 varchar(100) comment '活动名称',
    price                varchar(255) comment '活动价格',
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
    course_id            bigint,
    course_num           int comment '库存',
    apply_num            int comment '报名数',
    sort                 int comment '排序',
    create_date          datetime comment '创建时间',
    modify_date          datetime comment '修改时间',
    primary key (id)
);

alter table trs_course_activity comment '课程活动';
