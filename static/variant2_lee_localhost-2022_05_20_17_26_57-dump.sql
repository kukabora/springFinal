toc.dat                                                                                             0000600 0004000 0002000 00000073113 14241675402 0014451 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP       9                    z            variant2_lee    13.7 (Debian 13.7-0+deb11u1)    13.7 (Debian 13.7-0+deb11u1) n    O           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false         P           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false         Q           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false         R           1262    16384    variant2_lee    DATABASE     a   CREATE DATABASE variant2_lee WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.UTF-8';
    DROP DATABASE variant2_lee;
                postgres    false         ?            1259    16386 
   assesments    TABLE       CREATE TABLE public.assesments (
    id integer NOT NULL,
    taskid integer NOT NULL,
    testresult integer,
    assesmentgrade real DEFAULT 0 NOT NULL,
    graded boolean,
    assessorid integer NOT NULL,
    "assessmentPath" text,
    version bigint DEFAULT 0
);
    DROP TABLE public.assesments;
       public         heap 	   superuser    false         ?            1259    16390    assesments_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.assesments_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.assesments_id_seq;
       public       	   superuser    false    200         S           0    0    assesments_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.assesments_id_seq OWNED BY public.assesments.id;
          public       	   superuser    false    201         ?            1259    16392    groups    TABLE     w   CREATE TABLE public.groups (
    id integer NOT NULL,
    name character varying(255),
    version bigint DEFAULT 0
);
    DROP TABLE public.groups;
       public         heap 	   superuser    false         ?            1259    16582    hibernate_sequence    SEQUENCE     }   CREATE SEQUENCE public.hibernate_sequence
    START WITH 255
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public       	   superuser    false         ?            1259    16395    notifications    TABLE     ?   CREATE TABLE public.notifications (
    id integer NOT NULL,
    creatorid integer NOT NULL,
    recieverid integer NOT NULL,
    text character varying(255) NOT NULL,
    version bigint DEFAULT 0
);
 !   DROP TABLE public.notifications;
       public         heap 	   superuser    false         ?            1259    16398    notifications_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.notifications_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.notifications_id_seq;
       public       	   superuser    false    203         T           0    0    notifications_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.notifications_id_seq OWNED BY public.notifications.id;
          public       	   superuser    false    204         ?            1259    16400    requests_log    TABLE     d  CREATE TABLE public.requests_log (
    id integer NOT NULL,
    createdat timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    remoteaddress character varying(255) NOT NULL,
    requesturl character varying(255) NOT NULL,
    controller character varying(255) NOT NULL,
    requestmethod character varying(255) NOT NULL,
    version bigint DEFAULT 0
);
     DROP TABLE public.requests_log;
       public         heap 	   superuser    false         ?            1259    16407    requests_log_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.requests_log_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.requests_log_id_seq;
       public       	   superuser    false    205         U           0    0    requests_log_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.requests_log_id_seq OWNED BY public.requests_log.id;
          public       	   superuser    false    206         ?            1259    16409    roles    TABLE     v   CREATE TABLE public.roles (
    id integer NOT NULL,
    name character varying(255),
    version bigint DEFAULT 0
);
    DROP TABLE public.roles;
       public         heap 	   superuser    false         ?            1259    16412    role_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.role_id_seq;
       public       	   superuser    false    207         V           0    0    role_id_seq    SEQUENCE OWNED BY     <   ALTER SEQUENCE public.role_id_seq OWNED BY public.roles.id;
          public       	   superuser    false    208         ?            1259    16414    studentsgroup_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.studentsgroup_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.studentsgroup_id_seq;
       public       	   superuser    false    202         W           0    0    studentsgroup_id_seq    SEQUENCE OWNED BY     F   ALTER SEQUENCE public.studentsgroup_id_seq OWNED BY public.groups.id;
          public       	   superuser    false    209         ?            1259    16416    task_groups    TABLE     ?   CREATE TABLE public.task_groups (
    id integer NOT NULL,
    groupid integer NOT NULL,
    taskid integer NOT NULL,
    version bigint DEFAULT 0
);
    DROP TABLE public.task_groups;
       public         heap 	   superuser    false         ?            1259    16419    task_groups_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.task_groups_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.task_groups_id_seq;
       public       	   superuser    false    210         X           0    0    task_groups_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.task_groups_id_seq OWNED BY public.task_groups.id;
          public       	   superuser    false    211         ?            1259    16421    tasks    TABLE     ?   CREATE TABLE public.tasks (
    id integer NOT NULL,
    graderid integer NOT NULL,
    testid integer,
    tasktype character varying(255) NOT NULL,
    taskdescription character varying(255),
    version bigint DEFAULT 0
);
    DROP TABLE public.tasks;
       public         heap 	   superuser    false         ?            1259    16427    tasks_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.tasks_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.tasks_id_seq;
       public       	   superuser    false    212         Y           0    0    tasks_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.tasks_id_seq OWNED BY public.tasks.id;
          public       	   superuser    false    213         ?            1259    16429    testquestions    TABLE     f  CREATE TABLE public.testquestions (
    id integer NOT NULL,
    testid integer NOT NULL,
    questiontext character varying(255) NOT NULL,
    answer1 character varying(255) NOT NULL,
    answer2 character varying(255) NOT NULL,
    answer3 character varying(255) NOT NULL,
    correctanswer character varying(255) NOT NULL,
    version bigint DEFAULT 0
);
 !   DROP TABLE public.testquestions;
       public         heap 	   superuser    false         ?            1259    16435    testquestions_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.testquestions_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.testquestions_id_seq;
       public       	   superuser    false    214         Z           0    0    testquestions_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.testquestions_id_seq OWNED BY public.testquestions.id;
          public       	   superuser    false    215         ?            1259    16437    tests    TABLE     u   CREATE TABLE public.tests (
    id integer NOT NULL,
    creatorid integer NOT NULL,
    version bigint DEFAULT 0
);
    DROP TABLE public.tests;
       public         heap 	   superuser    false         ?            1259    16440    tests_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.tests_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.tests_id_seq;
       public       	   superuser    false    216         [           0    0    tests_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.tests_id_seq OWNED BY public.tests.id;
          public       	   superuser    false    217         ?            1259    16442    users    TABLE     <  CREATE TABLE public.users (
    id integer NOT NULL,
    fname character varying(50) NOT NULL,
    lname character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    password character varying(255) NOT NULL,
    roleid integer NOT NULL,
    groupid integer NOT NULL,
    version bigint DEFAULT 0
);
    DROP TABLE public.users;
       public         heap 	   superuser    false         ?            1259    16445    users_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public       	   superuser    false    218         \           0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public       	   superuser    false    219         ?            1259    16447    usersgradedetails    TABLE     ?   CREATE TABLE public.usersgradedetails (
    id integer NOT NULL,
    userid integer NOT NULL,
    gpa double precision,
    readyassessments integer DEFAULT 0,
    gradedassessments integer DEFAULT 0,
    version bigint DEFAULT 0
);
 %   DROP TABLE public.usersgradedetails;
       public         heap 	   superuser    false         ?            1259    16452    usersgradedetails_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.usersgradedetails_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.usersgradedetails_id_seq;
       public       	   superuser    false    220         ]           0    0    usersgradedetails_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.usersgradedetails_id_seq OWNED BY public.usersgradedetails.id;
          public       	   superuser    false    221         g           2604    16567    assesments id    DEFAULT     n   ALTER TABLE ONLY public.assesments ALTER COLUMN id SET DEFAULT nextval('public.assesments_id_seq'::regclass);
 <   ALTER TABLE public.assesments ALTER COLUMN id DROP DEFAULT;
       public       	   superuser    false    201    200         j           2604    16568 	   groups id    DEFAULT     m   ALTER TABLE ONLY public.groups ALTER COLUMN id SET DEFAULT nextval('public.studentsgroup_id_seq'::regclass);
 8   ALTER TABLE public.groups ALTER COLUMN id DROP DEFAULT;
       public       	   superuser    false    209    202         l           2604    16569    notifications id    DEFAULT     t   ALTER TABLE ONLY public.notifications ALTER COLUMN id SET DEFAULT nextval('public.notifications_id_seq'::regclass);
 ?   ALTER TABLE public.notifications ALTER COLUMN id DROP DEFAULT;
       public       	   superuser    false    204    203         o           2604    16570    requests_log id    DEFAULT     r   ALTER TABLE ONLY public.requests_log ALTER COLUMN id SET DEFAULT nextval('public.requests_log_id_seq'::regclass);
 >   ALTER TABLE public.requests_log ALTER COLUMN id DROP DEFAULT;
       public       	   superuser    false    206    205         q           2604    16571    roles id    DEFAULT     c   ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);
 7   ALTER TABLE public.roles ALTER COLUMN id DROP DEFAULT;
       public       	   superuser    false    208    207         s           2604    16572    task_groups id    DEFAULT     p   ALTER TABLE ONLY public.task_groups ALTER COLUMN id SET DEFAULT nextval('public.task_groups_id_seq'::regclass);
 =   ALTER TABLE public.task_groups ALTER COLUMN id DROP DEFAULT;
       public       	   superuser    false    211    210         u           2604    16573    tasks id    DEFAULT     d   ALTER TABLE ONLY public.tasks ALTER COLUMN id SET DEFAULT nextval('public.tasks_id_seq'::regclass);
 7   ALTER TABLE public.tasks ALTER COLUMN id DROP DEFAULT;
       public       	   superuser    false    213    212         w           2604    16574    testquestions id    DEFAULT     t   ALTER TABLE ONLY public.testquestions ALTER COLUMN id SET DEFAULT nextval('public.testquestions_id_seq'::regclass);
 ?   ALTER TABLE public.testquestions ALTER COLUMN id DROP DEFAULT;
       public       	   superuser    false    215    214         y           2604    16575    tests id    DEFAULT     d   ALTER TABLE ONLY public.tests ALTER COLUMN id SET DEFAULT nextval('public.tests_id_seq'::regclass);
 7   ALTER TABLE public.tests ALTER COLUMN id DROP DEFAULT;
       public       	   superuser    false    217    216         {           2604    16576    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public       	   superuser    false    219    218                    2604    16577    usersgradedetails id    DEFAULT     |   ALTER TABLE ONLY public.usersgradedetails ALTER COLUMN id SET DEFAULT nextval('public.usersgradedetails_id_seq'::regclass);
 C   ALTER TABLE public.usersgradedetails ALTER COLUMN id DROP DEFAULT;
       public       	   superuser    false    221    220         A           2613    16605    16605    BLOB     &   SELECT pg_catalog.lo_create('16605');
 &   SELECT pg_catalog.lo_unlink('16605');
             	   superuser    false         B           2613    16606    16606    BLOB     &   SELECT pg_catalog.lo_create('16606');
 &   SELECT pg_catalog.lo_unlink('16606');
             	   superuser    false         C           2613    16607    16607    BLOB     &   SELECT pg_catalog.lo_create('16607');
 &   SELECT pg_catalog.lo_unlink('16607');
             	   superuser    false         D           2613    16608    16608    BLOB     &   SELECT pg_catalog.lo_create('16608');
 &   SELECT pg_catalog.lo_unlink('16608');
             	   superuser    false         E           2613    16609    16609    BLOB     &   SELECT pg_catalog.lo_create('16609');
 &   SELECT pg_catalog.lo_unlink('16609');
             	   superuser    false         F           2613    16610    16610    BLOB     &   SELECT pg_catalog.lo_create('16610');
 &   SELECT pg_catalog.lo_unlink('16610');
             	   superuser    false         G           2613    16622    16622    BLOB     &   SELECT pg_catalog.lo_create('16622');
 &   SELECT pg_catalog.lo_unlink('16622');
             	   superuser    false         H           2613    16623    16623    BLOB     &   SELECT pg_catalog.lo_create('16623');
 &   SELECT pg_catalog.lo_unlink('16623');
             	   superuser    false         I           2613    16624    16624    BLOB     &   SELECT pg_catalog.lo_create('16624');
 &   SELECT pg_catalog.lo_unlink('16624');
             	   superuser    false         J           2613    16625    16625    BLOB     &   SELECT pg_catalog.lo_create('16625');
 &   SELECT pg_catalog.lo_unlink('16625');
             	   superuser    false         K           2613    16626    16626    BLOB     &   SELECT pg_catalog.lo_create('16626');
 &   SELECT pg_catalog.lo_unlink('16626');
             	   superuser    false         *          0    16386 
   assesments 
   TABLE DATA                 public       	   superuser    false    200       3114.dat ,          0    16392    groups 
   TABLE DATA                 public       	   superuser    false    202       3116.dat -          0    16395    notifications 
   TABLE DATA                 public       	   superuser    false    203       3117.dat /          0    16400    requests_log 
   TABLE DATA                 public       	   superuser    false    205       3119.dat 1          0    16409    roles 
   TABLE DATA                 public       	   superuser    false    207       3121.dat 4          0    16416    task_groups 
   TABLE DATA                 public       	   superuser    false    210       3124.dat 6          0    16421    tasks 
   TABLE DATA                 public       	   superuser    false    212       3126.dat 8          0    16429    testquestions 
   TABLE DATA                 public       	   superuser    false    214       3128.dat :          0    16437    tests 
   TABLE DATA                 public       	   superuser    false    216       3130.dat <          0    16442    users 
   TABLE DATA                 public       	   superuser    false    218       3132.dat >          0    16447    usersgradedetails 
   TABLE DATA                 public       	   superuser    false    220       3134.dat ^           0    0    assesments_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.assesments_id_seq', 18, true);
          public       	   superuser    false    201         _           0    0    hibernate_sequence    SEQUENCE SET     B   SELECT pg_catalog.setval('public.hibernate_sequence', 282, true);
          public       	   superuser    false    222         `           0    0    notifications_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.notifications_id_seq', 3, true);
          public       	   superuser    false    204         a           0    0    requests_log_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.requests_log_id_seq', 133, true);
          public       	   superuser    false    206         b           0    0    role_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.role_id_seq', 5, true);
          public       	   superuser    false    208         c           0    0    studentsgroup_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.studentsgroup_id_seq', 15, true);
          public       	   superuser    false    209         d           0    0    task_groups_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.task_groups_id_seq', 15, true);
          public       	   superuser    false    211         e           0    0    tasks_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.tasks_id_seq', 7, true);
          public       	   superuser    false    213         f           0    0    testquestions_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.testquestions_id_seq', 15, true);
          public       	   superuser    false    215         g           0    0    tests_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.tests_id_seq', 8, true);
          public       	   superuser    false    217         h           0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 85, true);
          public       	   superuser    false    219         i           0    0    usersgradedetails_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.usersgradedetails_id_seq', 15, true);
          public       	   superuser    false    221         L          0    0    BLOBS    BLOBS                             false       3148.dat ?           2606    16466    assesments assesments_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.assesments
    ADD CONSTRAINT assesments_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.assesments DROP CONSTRAINT assesments_pkey;
       public         	   superuser    false    200         ?           2606    16468     notifications notifications_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.notifications
    ADD CONSTRAINT notifications_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.notifications DROP CONSTRAINT notifications_pkey;
       public         	   superuser    false    203         ?           2606    16470    requests_log requests_log_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.requests_log
    ADD CONSTRAINT requests_log_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.requests_log DROP CONSTRAINT requests_log_pkey;
       public         	   superuser    false    205         ?           2606    16472    roles role_name_key 
   CONSTRAINT     N   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT role_name_key UNIQUE (name);
 =   ALTER TABLE ONLY public.roles DROP CONSTRAINT role_name_key;
       public         	   superuser    false    207         ?           2606    16474    roles role_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);
 9   ALTER TABLE ONLY public.roles DROP CONSTRAINT role_pkey;
       public         	   superuser    false    207         ?           2606    16476    groups studentsgroup_name_key 
   CONSTRAINT     X   ALTER TABLE ONLY public.groups
    ADD CONSTRAINT studentsgroup_name_key UNIQUE (name);
 G   ALTER TABLE ONLY public.groups DROP CONSTRAINT studentsgroup_name_key;
       public         	   superuser    false    202         ?           2606    16478    groups studentsgroup_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.groups
    ADD CONSTRAINT studentsgroup_pkey PRIMARY KEY (id);
 C   ALTER TABLE ONLY public.groups DROP CONSTRAINT studentsgroup_pkey;
       public         	   superuser    false    202         ?           2606    16480    task_groups task_groups_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.task_groups
    ADD CONSTRAINT task_groups_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.task_groups DROP CONSTRAINT task_groups_pkey;
       public         	   superuser    false    210         ?           2606    16482    tasks tasks_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.tasks DROP CONSTRAINT tasks_pkey;
       public         	   superuser    false    212         ?           2606    16484     testquestions testquestions_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.testquestions
    ADD CONSTRAINT testquestions_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.testquestions DROP CONSTRAINT testquestions_pkey;
       public         	   superuser    false    214         ?           2606    16486    tests tests_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.tests
    ADD CONSTRAINT tests_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.tests DROP CONSTRAINT tests_pkey;
       public         	   superuser    false    216         ?           2606    16488    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public         	   superuser    false    218         ?           2606    16490 (   usersgradedetails usersgradedetails_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.usersgradedetails
    ADD CONSTRAINT usersgradedetails_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.usersgradedetails DROP CONSTRAINT usersgradedetails_pkey;
       public         	   superuser    false    220         ?           2606    16491 %   assesments assesments_assessorid_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.assesments
    ADD CONSTRAINT assesments_assessorid_fkey FOREIGN KEY (assessorid) REFERENCES public.users(id);
 O   ALTER TABLE ONLY public.assesments DROP CONSTRAINT assesments_assessorid_fkey;
       public       	   superuser    false    2968    200    218         ?           2606    16589 !   assesments assesments_taskid_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.assesments
    ADD CONSTRAINT assesments_taskid_fkey FOREIGN KEY (taskid) REFERENCES public.tasks(id);
 K   ALTER TABLE ONLY public.assesments DROP CONSTRAINT assesments_taskid_fkey;
       public       	   superuser    false    200    212    2962         ?           2606    16501 *   notifications notifications_creatorid_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.notifications
    ADD CONSTRAINT notifications_creatorid_fkey FOREIGN KEY (creatorid) REFERENCES public.users(id);
 T   ALTER TABLE ONLY public.notifications DROP CONSTRAINT notifications_creatorid_fkey;
       public       	   superuser    false    203    218    2968         ?           2606    16506 +   notifications notifications_recieverid_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.notifications
    ADD CONSTRAINT notifications_recieverid_fkey FOREIGN KEY (recieverid) REFERENCES public.users(id);
 U   ALTER TABLE ONLY public.notifications DROP CONSTRAINT notifications_recieverid_fkey;
       public       	   superuser    false    2968    218    203         ?           2606    16511 $   task_groups task_groups_groupid_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.task_groups
    ADD CONSTRAINT task_groups_groupid_fkey FOREIGN KEY (groupid) REFERENCES public.groups(id);
 N   ALTER TABLE ONLY public.task_groups DROP CONSTRAINT task_groups_groupid_fkey;
       public       	   superuser    false    210    202    2950         ?           2606    16516 #   task_groups task_groups_taskid_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.task_groups
    ADD CONSTRAINT task_groups_taskid_fkey FOREIGN KEY (taskid) REFERENCES public.tasks(id);
 M   ALTER TABLE ONLY public.task_groups DROP CONSTRAINT task_groups_taskid_fkey;
       public       	   superuser    false    212    210    2962         ?           2606    16521    tasks tasks_graderid_fkey    FK CONSTRAINT     y   ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_graderid_fkey FOREIGN KEY (graderid) REFERENCES public.users(id);
 C   ALTER TABLE ONLY public.tasks DROP CONSTRAINT tasks_graderid_fkey;
       public       	   superuser    false    2968    218    212         ?           2606    16526    tasks tasks_testid_fkey    FK CONSTRAINT     u   ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_testid_fkey FOREIGN KEY (testid) REFERENCES public.tests(id);
 A   ALTER TABLE ONLY public.tasks DROP CONSTRAINT tasks_testid_fkey;
       public       	   superuser    false    2966    212    216         ?           2606    16531 '   testquestions testquestions_testid_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.testquestions
    ADD CONSTRAINT testquestions_testid_fkey FOREIGN KEY (testid) REFERENCES public.tests(id);
 Q   ALTER TABLE ONLY public.testquestions DROP CONSTRAINT testquestions_testid_fkey;
       public       	   superuser    false    216    2966    214         ?           2606    16536    tests tests_creatorid_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY public.tests
    ADD CONSTRAINT tests_creatorid_fkey FOREIGN KEY (creatorid) REFERENCES public.users(id);
 D   ALTER TABLE ONLY public.tests DROP CONSTRAINT tests_creatorid_fkey;
       public       	   superuser    false    2968    218    216         ?           2606    16541    users users_groupid_fkey    FK CONSTRAINT     x   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_groupid_fkey FOREIGN KEY (groupid) REFERENCES public.groups(id);
 B   ALTER TABLE ONLY public.users DROP CONSTRAINT users_groupid_fkey;
       public       	   superuser    false    2950    202    218         ?           2606    16546    users users_roleid_fkey    FK CONSTRAINT     u   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_roleid_fkey FOREIGN KEY (roleid) REFERENCES public.roles(id);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT users_roleid_fkey;
       public       	   superuser    false    2958    218    207         ?           2606    16551 /   usersgradedetails usersgradedetails_userid_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.usersgradedetails
    ADD CONSTRAINT usersgradedetails_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(id);
 Y   ALTER TABLE ONLY public.usersgradedetails DROP CONSTRAINT usersgradedetails_userid_fkey;
       public       	   superuser    false    2968    220    218                                                                                                                                                                                                                                                                                                                                                                                                                                                             3114.dat                                                                                            0000600 0004000 0002000 00000001046 14241675402 0014250 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.assesments (id, taskid, testresult, assesmentgrade, graded, assessorid, "assessmentPath", version) VALUES (4, 2, NULL, 100, true, 2, NULL, 0);
INSERT INTO public.assesments (id, taskid, testresult, assesmentgrade, graded, assessorid, "assessmentPath", version) VALUES (6, 2, NULL, 50, true, 2, NULL, 0);
INSERT INTO public.assesments (id, taskid, testresult, assesmentgrade, graded, assessorid, "assessmentPath", version) VALUES (18, 1, NULL, 0, false, 2, 'UNSORTED/Homework_on_Mathematical_analysis(2)/admin_admin_(2).png', 0);


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          3116.dat                                                                                            0000600 0004000 0002000 00000000452 14241675402 0014252 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.groups (id, name, version) VALUES (1, 'ITSE-1908R', 0);
INSERT INTO public.groups (id, name, version) VALUES (2, 'ITSE-1909', 0);
INSERT INTO public.groups (id, name, version) VALUES (3, 'ITSE-1907', 0);
INSERT INTO public.groups (id, name, version) VALUES (4, 'UNSORTED', 0);


                                                                                                                                                                                                                      3117.dat                                                                                            0000600 0004000 0002000 00000000155 14241675402 0014253 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.notifications (id, creatorid, recieverid, text, version) VALUES (3, 1, 2, 'string', 0);


                                                                                                                                                                                                                                                                                                                                                                                                                   3119.dat                                                                                            0000600 0004000 0002000 00000105700 14241675402 0014257 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (7, '2022-05-16 14:32:12.069+06', '0:0:0:0:0:0:0:1', '/crud/tests/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (5, '2022-05-14 20:47:30.485+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (9, '2022-05-16 14:42:25.875+06', '0:0:0:0:0:0:0:1', '/crud/tests/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (6, '2022-05-16 14:29:56.845+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (8, '2022-05-16 14:38:14.758+06', '0:0:0:0:0:0:0:1', '/crud/tests/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (15, '2022-05-17 00:30:36.13+06', '0:0:0:0:0:0:0:1', '/crud/tests/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (16, '2022-05-17 09:27:35.902+06', '0:0:0:0:0:0:0:1', '/crud/tests/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (17, '2022-05-17 09:27:42.656+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (18, '2022-05-17 09:27:46.972+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (19, '2022-05-17 09:33:35.02+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (20, '2022-05-17 09:49:23.996+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (21, '2022-05-17 13:51:52.715+06', '0:0:0:0:0:0:0:1', '/crud/users/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (22, '2022-05-17 19:00:44.029+06', '0:0:0:0:0:0:0:1', '/crud/users/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (23, '2022-05-17 19:06:51.244+06', '0:0:0:0:0:0:0:1', '/crud/groups/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (24, '2022-05-17 19:06:58.272+06', '0:0:0:0:0:0:0:1', '/crud/groups/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (25, '2022-05-17 19:06:59.353+06', '0:0:0:0:0:0:0:1', '/crud/groups/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (26, '2022-05-17 19:07:04.111+06', '0:0:0:0:0:0:0:1', '/crud/groups/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (27, '2022-05-17 19:07:12.889+06', '0:0:0:0:0:0:0:1', '/crud/groups/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (28, '2022-05-17 19:07:18.877+06', '0:0:0:0:0:0:0:1', '/crud/groups/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (29, '2022-05-17 19:07:25.955+06', '0:0:0:0:0:0:0:1', '/crud/groups/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (30, '2022-05-17 19:07:32.213+06', '0:0:0:0:0:0:0:1', '/crud/groups/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (31, '2022-05-17 19:07:56.101+06', '0:0:0:0:0:0:0:1', '/crud/groups/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (32, '2022-05-17 19:08:32.185+06', '0:0:0:0:0:0:0:1', '/crud/groups/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (33, '2022-05-17 19:08:32.803+06', '0:0:0:0:0:0:0:1', '/crud/groups/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (34, '2022-05-17 19:10:10.422+06', '0:0:0:0:0:0:0:1', '/crud/groups/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (35, '2022-05-17 19:10:20.512+06', '0:0:0:0:0:0:0:1', '/crud/groups/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (36, '2022-05-17 19:10:28.339+06', '0:0:0:0:0:0:0:1', '/crud/groups/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (37, '2022-05-17 19:13:35.798+06', '0:0:0:0:0:0:0:1', '/crud/groups/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (38, '2022-05-17 19:13:44.684+06', '0:0:0:0:0:0:0:1', '/crud/groups/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (39, '2022-05-17 19:14:03.525+06', '0:0:0:0:0:0:0:1', '/crud/groups/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (40, '2022-05-17 19:14:11.117+06', '0:0:0:0:0:0:0:1', '/crud/groups/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (41, '2022-05-17 19:15:36.645+06', '0:0:0:0:0:0:0:1', '/crud/groups/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (42, '2022-05-17 19:17:12.681+06', '0:0:0:0:0:0:0:1', '/crud/groups/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (43, '2022-05-17 19:17:55.856+06', '0:0:0:0:0:0:0:1', '/crud/groups/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (44, '2022-05-17 19:19:01.559+06', '0:0:0:0:0:0:0:1', '/crud/groups/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (45, '2022-05-17 19:19:10.829+06', '0:0:0:0:0:0:0:1', '/crud/groups/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (46, '2022-05-17 19:19:12.636+06', '0:0:0:0:0:0:0:1', '/crud/groups/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (47, '2022-05-17 19:19:17.737+06', '0:0:0:0:0:0:0:1', '/crud/groups/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (48, '2022-05-17 19:24:18.373+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (49, '2022-05-17 19:24:25.642+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (50, '2022-05-17 19:31:26.684+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (51, '2022-05-17 19:31:42.125+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (52, '2022-05-17 19:43:13.99+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (53, '2022-05-17 19:43:25.948+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (54, '2022-05-17 19:43:45.263+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (55, '2022-05-17 20:28:37.057+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (56, '2022-05-17 20:28:53.328+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (57, '2022-05-17 20:29:01.366+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (58, '2022-05-17 20:29:08.908+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (59, '2022-05-17 20:30:41.725+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (60, '2022-05-17 20:32:23.62+06', '0:0:0:0:0:0:0:1', '/crud/tests/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (61, '2022-05-17 20:32:31.67+06', '0:0:0:0:0:0:0:1', '/crud/tests/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (62, '2022-05-17 20:32:45.608+06', '0:0:0:0:0:0:0:1', '/crud/tests/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (63, '2022-05-17 20:33:00.677+06', '0:0:0:0:0:0:0:1', '/crud/tests/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (64, '2022-05-17 20:33:06.952+06', '0:0:0:0:0:0:0:1', '/crud/tests/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (65, '2022-05-17 20:33:35.659+06', '0:0:0:0:0:0:0:1', '/crud/notifications/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.NotificationController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (66, '2022-05-17 20:34:39.403+06', '0:0:0:0:0:0:0:1', '/crud/notifications/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.NotificationController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (67, '2022-05-17 20:34:43.686+06', '0:0:0:0:0:0:0:1', '/crud/notifications/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.NotificationController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (68, '2022-05-17 20:34:47.456+06', '0:0:0:0:0:0:0:1', '/crud/notifications/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.NotificationController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (69, '2022-05-17 20:39:01.899+06', '0:0:0:0:0:0:0:1', '/crud/assessments/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.AssessmentController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (70, '2022-05-17 20:39:09.904+06', '0:0:0:0:0:0:0:1', '/crud/assessments/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.AssessmentController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (71, '2022-05-17 20:39:18.988+06', '0:0:0:0:0:0:0:1', '/crud/assessments/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.AssessmentController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (72, '2022-05-17 20:41:03.874+06', '0:0:0:0:0:0:0:1', '/crud/tasks/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TaskController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (73, '2022-05-17 20:41:12.157+06', '0:0:0:0:0:0:0:1', '/crud/tasks/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TaskController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (74, '2022-05-17 20:41:15.085+06', '0:0:0:0:0:0:0:1', '/crud/tasks/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TaskController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (75, '2022-05-17 20:41:22.145+06', '0:0:0:0:0:0:0:1', '/crud/tasks/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TaskController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (76, '2022-05-17 20:41:24.406+06', '0:0:0:0:0:0:0:1', '/crud/tasks/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TaskController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (77, '2022-05-17 20:41:28.266+06', '0:0:0:0:0:0:0:1', '/crud/tasks/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TaskController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (78, '2022-05-17 20:43:41.092+06', '0:0:0:0:0:0:0:1', '/crud/roles/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.RoleController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (79, '2022-05-17 20:43:54.132+06', '0:0:0:0:0:0:0:1', '/crud/roles/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.RoleController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (80, '2022-05-17 20:44:03.722+06', '0:0:0:0:0:0:0:1', '/crud/roles/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.RoleController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (81, '2022-05-17 21:08:18.899+06', '0:0:0:0:0:0:0:1', '/crud/roles/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.RoleController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (82, '2022-05-17 21:08:28.839+06', '0:0:0:0:0:0:0:1', '/crud/roles/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.RoleController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (83, '2022-05-17 21:08:33.074+06', '0:0:0:0:0:0:0:1', '/crud/roles/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.RoleController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (84, '2022-05-17 21:08:39.353+06', '0:0:0:0:0:0:0:1', '/crud/roles/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.RoleController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (85, '2022-05-17 21:09:12.531+06', '0:0:0:0:0:0:0:1', '/crud/users/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (86, '2022-05-17 21:09:18.128+06', '0:0:0:0:0:0:0:1', '/crud/users/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (87, '2022-05-17 21:09:22.594+06', '0:0:0:0:0:0:0:1', '/crud/users/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (88, '2022-05-17 21:09:45.918+06', '0:0:0:0:0:0:0:1', '/crud/users/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (89, '2022-05-17 21:09:58.557+06', '0:0:0:0:0:0:0:1', '/crud/users/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (90, '2022-05-19 02:04:57.721+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (91, '2022-05-19 02:06:57.633+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (92, '2022-05-19 02:07:02.688+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (93, '2022-05-19 02:07:09.465+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (94, '2022-05-19 02:07:13.643+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (95, '2022-05-19 02:07:15.841+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (96, '2022-05-19 02:07:17.772+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (97, '2022-05-19 02:07:19.904+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (98, '2022-05-19 02:07:20.778+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (99, '2022-05-19 02:07:25.209+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (100, '2022-05-19 02:07:27.272+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (101, '2022-05-19 02:07:55.788+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (102, '2022-05-19 02:08:00.084+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (103, '2022-05-19 02:08:37.417+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (104, '2022-05-19 02:08:48.128+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (105, '2022-05-19 02:08:53.115+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (106, '2022-05-19 02:09:29.585+06', '0:0:0:0:0:0:0:1', '/crud/tests/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (107, '2022-05-19 02:10:11.344+06', '0:0:0:0:0:0:0:1', '/crud/notifications/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.NotificationController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (108, '2022-05-19 02:10:49.14+06', '0:0:0:0:0:0:0:1', '/crud/assessments/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.AssessmentController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (109, '2022-05-19 02:11:41.089+06', '0:0:0:0:0:0:0:1', '/crud/tasks/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TaskController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (110, '2022-05-19 02:11:49.245+06', '0:0:0:0:0:0:0:1', '/crud/tasks/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TaskController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (111, '2022-05-19 02:11:55.83+06', '0:0:0:0:0:0:0:1', '/crud/tasks/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TaskController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (112, '2022-05-19 02:11:58.638+06', '0:0:0:0:0:0:0:1', '/crud/tasks/delete', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TaskController', 'DELETE', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (113, '2022-05-19 02:12:28.615+06', '0:0:0:0:0:0:0:1', '/crud/users/create', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (114, '2022-05-19 19:45:10.072+06', '0:0:0:0:0:0:0:1', '/crud/users/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (115, '2022-05-19 19:45:11.19+06', '0:0:0:0:0:0:0:1', '/crud/users/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (116, '2022-05-19 19:45:23.049+06', '0:0:0:0:0:0:0:1', '/crud/users/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (117, '2022-05-19 19:45:30.306+06', '0:0:0:0:0:0:0:1', '/crud/users/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (118, '2022-05-19 19:45:36.708+06', '0:0:0:0:0:0:0:1', '/crud/users/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (119, '2022-05-19 19:45:51.518+06', '0:0:0:0:0:0:0:1', '/crud/users/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (120, '2022-05-19 19:46:00.196+06', '0:0:0:0:0:0:0:1', '/crud/users/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (121, '2022-05-19 19:46:10.328+06', '0:0:0:0:0:0:0:1', '/crud/users/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (122, '2022-05-19 19:46:28.61+06', '0:0:0:0:0:0:0:1', '/crud/users/update', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'POST', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (123, '2022-05-19 19:49:32.143+06', '0:0:0:0:0:0:0:1', '/crud/groups/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.GroupController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (124, '2022-05-19 19:49:36.231+06', '0:0:0:0:0:0:0:1', '/crud/testQuestions/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestQuestionsController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (125, '2022-05-19 19:49:41.869+06', '0:0:0:0:0:0:0:1', '/crud/usersGrades/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserGradesController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (126, '2022-05-19 19:49:48.67+06', '0:0:0:0:0:0:0:1', '/crud/tests/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TestController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (127, '2022-05-19 19:49:52.304+06', '0:0:0:0:0:0:0:1', '/crud/notifications/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.NotificationController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (128, '2022-05-19 19:49:57.083+06', '0:0:0:0:0:0:0:1', '/crud/assessments/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.AssessmentController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (129, '2022-05-19 19:50:07.213+06', '0:0:0:0:0:0:0:1', '/crud/tasks/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TaskController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (130, '2022-05-19 19:50:11.969+06', '0:0:0:0:0:0:0:1', '/crud/roles/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.RoleController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (131, '2022-05-19 19:50:17.24+06', '0:0:0:0:0:0:0:1', '/crud/users/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (132, '2022-05-19 19:50:20.175+06', '0:0:0:0:0:0:0:1', '/crud/users/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.UserController', 'GET', 0);
INSERT INTO public.requests_log (id, createdat, remoteaddress, requesturl, controller, requestmethod, version) VALUES (133, '2022-05-19 20:21:06.628+06', '0:0:0:0:0:0:0:1', '/crud/tasks/all', 'class kz.iitu.itse1908.springfinalproject.Controllers.CRUD.TaskController', 'GET', 0);


                                                                3121.dat                                                                                            0000600 0004000 0002000 00000000323 14241675402 0014243 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.roles (id, name, version) VALUES (1, 'ADMIN', 0);
INSERT INTO public.roles (id, name, version) VALUES (2, 'STUDENT', 0);
INSERT INTO public.roles (id, name, version) VALUES (3, 'STAFF', 0);


                                                                                                                                                                                                                                                                                                             3124.dat                                                                                            0000600 0004000 0002000 00000000643 14241675402 0014253 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.task_groups (id, groupid, taskid, version) VALUES (6, 1, 1, 0);
INSERT INTO public.task_groups (id, groupid, taskid, version) VALUES (7, 2, 1, 0);
INSERT INTO public.task_groups (id, groupid, taskid, version) VALUES (8, 3, 1, 0);
INSERT INTO public.task_groups (id, groupid, taskid, version) VALUES (10, 2, 2, 0);
INSERT INTO public.task_groups (id, groupid, taskid, version) VALUES (11, 3, 2, 0);


                                                                                             3126.dat                                                                                            0000600 0004000 0002000 00000000636 14241675402 0014257 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.tasks (id, graderid, testid, tasktype, taskdescription, version) VALUES (1, 2, NULL, 'UPLOAD', 'Homework on Mathematical analysis', 1);
INSERT INTO public.tasks (id, graderid, testid, tasktype, taskdescription, version) VALUES (2, 2, 1, 'TEST', 'JAVA EE midterm', 1);
INSERT INTO public.tasks (id, graderid, testid, tasktype, taskdescription, version) VALUES (7, 1, 1, 'string', 'string', 0);


                                                                                                  3128.dat                                                                                            0000600 0004000 0002000 00000000652 14241675402 0014257 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.testquestions (id, testid, questiontext, answer1, answer2, answer3, correctanswer, version) VALUES (2, 1, 'Global-scope annotation?', '@Bean', '@Session', '@Scope', '@Scope', 0);
INSERT INTO public.testquestions (id, testid, questiontext, answer1, answer2, answer3, correctanswer, version) VALUES (3, 1, 'Name of framework, created upon java EE scaffolding.', 'Flower', 'Laravel', 'Spring', 'Spring', 0);


                                                                                      3130.dat                                                                                            0000600 0004000 0002000 00000000106 14241675402 0014242 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.tests (id, creatorid, version) VALUES (1, 2, 0);


                                                                                                                                                                                                                                                                                                                                                                                                                                                          3132.dat                                                                                            0000600 0004000 0002000 00000001371 14241675402 0014251 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.users (id, fname, lname, email, password, roleid, groupid, version) VALUES (3, 'Alex', 'Lee', '123@123', '$2a$10$NuBeeR0lgrfcjt3cKCCzEutDUUuzkH6axxA7M9JBBICKtT556WjFa', 2, 1, 0);
INSERT INTO public.users (id, fname, lname, email, password, roleid, groupid, version) VALUES (1, 'staffuser', 'staffuser', 'staffuser', '$2a$10$hPhM1I4RhYv.pQ3tpXnVCOQu8dXaXaogC5L.TJ2yT72xxYhpmHigK', 3, 4, 0);
INSERT INTO public.users (id, fname, lname, email, password, roleid, groupid, version) VALUES (2, 'admin', 'admin', 'admin', '$2a$10$kN89w247QSDafWDgdSuA6OtDABGoOmqOUY4xXyT0WghBY1E0sgtcm', 1, 4, 0);
INSERT INTO public.users (id, fname, lname, email, password, roleid, groupid, version) VALUES (282, 'string', 'string', 'afgjiwj', 'string', 1, 1, 1);


                                                                                                                                                                                                                                                                       3134.dat                                                                                            0000600 0004000 0002000 00000000605 14241675402 0014252 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO public.usersgradedetails (id, userid, gpa, readyassessments, gradedassessments, version) VALUES (13, 3, 0, 0, 0, 0);
INSERT INTO public.usersgradedetails (id, userid, gpa, readyassessments, gradedassessments, version) VALUES (14, 1, 0, 0, 0, 0);
INSERT INTO public.usersgradedetails (id, userid, gpa, readyassessments, gradedassessments, version) VALUES (15, 2, 0, 0, 0, 0);


                                                                                                                           blob_16605.dat                                                                                      0000600 0004000 0002000 00000000073 14241675402 0015336 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        UNSORTED/Homework_on_mathematic_analysis(2)/admin_admin_(2)                                                                                                                                                                                                                                                                                                                                                                                                                                                                     blob_16606.dat                                                                                      0000600 0004000 0002000 00000000076 14241675402 0015342 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        UNSORTED/Homework_on_mathematic_analysis(2)/admin_admin_(2)png                                                                                                                                                                                                                                                                                                                                                                                                                                                                  blob_16607.dat                                                                                      0000600 0004000 0002000 00000000076 14241675402 0015343 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        UNSORTED/Homework_on_mathematic_analysis(2)/admin_admin_(2)png                                                                                                                                                                                                                                                                                                                                                                                                                                                                  blob_16608.dat                                                                                      0000600 0004000 0002000 00000000076 14241675402 0015344 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        UNSORTED/Homework_on_mathematic_analysis(2)/admin_admin_(2)png                                                                                                                                                                                                                                                                                                                                                                                                                                                                  blob_16609.dat                                                                                      0000600 0004000 0002000 00000000076 14241675402 0015345 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        UNSORTED/Homework_on_mathematic_analysis(2)/admin_admin_(2)png                                                                                                                                                                                                                                                                                                                                                                                                                                                                  blob_16610.dat                                                                                      0000600 0004000 0002000 00000000077 14241675402 0015336 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        UNSORTED/Homework_on_mathematic_analysis(2)/admin_admin_(2).png                                                                                                                                                                                                                                                                                                                                                                                                                                                                 blob_16622.dat                                                                                      0000600 0004000 0002000 00000000077 14241675402 0015341 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        UNSORTED/Homework_on_mathematic_analysis(2)/admin_admin_(2).png                                                                                                                                                                                                                                                                                                                                                                                                                                                                 blob_16623.dat                                                                                      0000600 0004000 0002000 00000000077 14241675402 0015342 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        UNSORTED/Homework_on_mathematic_analysis(2)/admin_admin_(2).png                                                                                                                                                                                                                                                                                                                                                                                                                                                                 blob_16624.dat                                                                                      0000600 0004000 0002000 00000000005 14241675402 0015332 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        aboba                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           blob_16625.dat                                                                                      0000600 0004000 0002000 00000000000 14241675402 0015326 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        blob_16626.dat                                                                                      0000600 0004000 0002000 00000000157 14241675402 0015344 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        http://localhost:8080staffModule/getAssesment/UNSORTED/Homework_on_Mathematical_analysis(2)/admin_admin_(2).png                                                                                                                                                                                                                                                                                                                                                                                                                 blobs.toc                                                                                           0000600 0004000 0002000 00000000347 14241675402 0015001 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        16605 blob_16605.dat
16606 blob_16606.dat
16607 blob_16607.dat
16608 blob_16608.dat
16609 blob_16609.dat
16610 blob_16610.dat
16622 blob_16622.dat
16623 blob_16623.dat
16624 blob_16624.dat
16625 blob_16625.dat
16626 blob_16626.dat
                                                                                                                                                                                                                                                                                         restore.sql                                                                                         0000600 0004000 0002000 00000054234 14241675402 0015401 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 13.7 (Debian 13.7-0+deb11u1)
-- Dumped by pg_dump version 13.7 (Debian 13.7-0+deb11u1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE variant2_lee;
--
-- Name: variant2_lee; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE variant2_lee WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.UTF-8';


ALTER DATABASE variant2_lee OWNER TO postgres;

\connect variant2_lee

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: assesments; Type: TABLE; Schema: public; Owner: superuser
--

CREATE TABLE public.assesments (
    id integer NOT NULL,
    taskid integer NOT NULL,
    testresult integer,
    assesmentgrade real DEFAULT 0 NOT NULL,
    graded boolean,
    assessorid integer NOT NULL,
    "assessmentPath" text,
    version bigint DEFAULT 0
);


ALTER TABLE public.assesments OWNER TO superuser;

--
-- Name: assesments_id_seq; Type: SEQUENCE; Schema: public; Owner: superuser
--

CREATE SEQUENCE public.assesments_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.assesments_id_seq OWNER TO superuser;

--
-- Name: assesments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: superuser
--

ALTER SEQUENCE public.assesments_id_seq OWNED BY public.assesments.id;


--
-- Name: groups; Type: TABLE; Schema: public; Owner: superuser
--

CREATE TABLE public.groups (
    id integer NOT NULL,
    name character varying(255),
    version bigint DEFAULT 0
);


ALTER TABLE public.groups OWNER TO superuser;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: superuser
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 255
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO superuser;

--
-- Name: notifications; Type: TABLE; Schema: public; Owner: superuser
--

CREATE TABLE public.notifications (
    id integer NOT NULL,
    creatorid integer NOT NULL,
    recieverid integer NOT NULL,
    text character varying(255) NOT NULL,
    version bigint DEFAULT 0
);


ALTER TABLE public.notifications OWNER TO superuser;

--
-- Name: notifications_id_seq; Type: SEQUENCE; Schema: public; Owner: superuser
--

CREATE SEQUENCE public.notifications_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.notifications_id_seq OWNER TO superuser;

--
-- Name: notifications_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: superuser
--

ALTER SEQUENCE public.notifications_id_seq OWNED BY public.notifications.id;


--
-- Name: requests_log; Type: TABLE; Schema: public; Owner: superuser
--

CREATE TABLE public.requests_log (
    id integer NOT NULL,
    createdat timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    remoteaddress character varying(255) NOT NULL,
    requesturl character varying(255) NOT NULL,
    controller character varying(255) NOT NULL,
    requestmethod character varying(255) NOT NULL,
    version bigint DEFAULT 0
);


ALTER TABLE public.requests_log OWNER TO superuser;

--
-- Name: requests_log_id_seq; Type: SEQUENCE; Schema: public; Owner: superuser
--

CREATE SEQUENCE public.requests_log_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.requests_log_id_seq OWNER TO superuser;

--
-- Name: requests_log_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: superuser
--

ALTER SEQUENCE public.requests_log_id_seq OWNED BY public.requests_log.id;


--
-- Name: roles; Type: TABLE; Schema: public; Owner: superuser
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    name character varying(255),
    version bigint DEFAULT 0
);


ALTER TABLE public.roles OWNER TO superuser;

--
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: superuser
--

CREATE SEQUENCE public.role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_id_seq OWNER TO superuser;

--
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: superuser
--

ALTER SEQUENCE public.role_id_seq OWNED BY public.roles.id;


--
-- Name: studentsgroup_id_seq; Type: SEQUENCE; Schema: public; Owner: superuser
--

CREATE SEQUENCE public.studentsgroup_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.studentsgroup_id_seq OWNER TO superuser;

--
-- Name: studentsgroup_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: superuser
--

ALTER SEQUENCE public.studentsgroup_id_seq OWNED BY public.groups.id;


--
-- Name: task_groups; Type: TABLE; Schema: public; Owner: superuser
--

CREATE TABLE public.task_groups (
    id integer NOT NULL,
    groupid integer NOT NULL,
    taskid integer NOT NULL,
    version bigint DEFAULT 0
);


ALTER TABLE public.task_groups OWNER TO superuser;

--
-- Name: task_groups_id_seq; Type: SEQUENCE; Schema: public; Owner: superuser
--

CREATE SEQUENCE public.task_groups_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.task_groups_id_seq OWNER TO superuser;

--
-- Name: task_groups_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: superuser
--

ALTER SEQUENCE public.task_groups_id_seq OWNED BY public.task_groups.id;


--
-- Name: tasks; Type: TABLE; Schema: public; Owner: superuser
--

CREATE TABLE public.tasks (
    id integer NOT NULL,
    graderid integer NOT NULL,
    testid integer,
    tasktype character varying(255) NOT NULL,
    taskdescription character varying(255),
    version bigint DEFAULT 0
);


ALTER TABLE public.tasks OWNER TO superuser;

--
-- Name: tasks_id_seq; Type: SEQUENCE; Schema: public; Owner: superuser
--

CREATE SEQUENCE public.tasks_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tasks_id_seq OWNER TO superuser;

--
-- Name: tasks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: superuser
--

ALTER SEQUENCE public.tasks_id_seq OWNED BY public.tasks.id;


--
-- Name: testquestions; Type: TABLE; Schema: public; Owner: superuser
--

CREATE TABLE public.testquestions (
    id integer NOT NULL,
    testid integer NOT NULL,
    questiontext character varying(255) NOT NULL,
    answer1 character varying(255) NOT NULL,
    answer2 character varying(255) NOT NULL,
    answer3 character varying(255) NOT NULL,
    correctanswer character varying(255) NOT NULL,
    version bigint DEFAULT 0
);


ALTER TABLE public.testquestions OWNER TO superuser;

--
-- Name: testquestions_id_seq; Type: SEQUENCE; Schema: public; Owner: superuser
--

CREATE SEQUENCE public.testquestions_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.testquestions_id_seq OWNER TO superuser;

--
-- Name: testquestions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: superuser
--

ALTER SEQUENCE public.testquestions_id_seq OWNED BY public.testquestions.id;


--
-- Name: tests; Type: TABLE; Schema: public; Owner: superuser
--

CREATE TABLE public.tests (
    id integer NOT NULL,
    creatorid integer NOT NULL,
    version bigint DEFAULT 0
);


ALTER TABLE public.tests OWNER TO superuser;

--
-- Name: tests_id_seq; Type: SEQUENCE; Schema: public; Owner: superuser
--

CREATE SEQUENCE public.tests_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tests_id_seq OWNER TO superuser;

--
-- Name: tests_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: superuser
--

ALTER SEQUENCE public.tests_id_seq OWNED BY public.tests.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: superuser
--

CREATE TABLE public.users (
    id integer NOT NULL,
    fname character varying(50) NOT NULL,
    lname character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    password character varying(255) NOT NULL,
    roleid integer NOT NULL,
    groupid integer NOT NULL,
    version bigint DEFAULT 0
);


ALTER TABLE public.users OWNER TO superuser;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: superuser
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO superuser;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: superuser
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: usersgradedetails; Type: TABLE; Schema: public; Owner: superuser
--

CREATE TABLE public.usersgradedetails (
    id integer NOT NULL,
    userid integer NOT NULL,
    gpa double precision,
    readyassessments integer DEFAULT 0,
    gradedassessments integer DEFAULT 0,
    version bigint DEFAULT 0
);


ALTER TABLE public.usersgradedetails OWNER TO superuser;

--
-- Name: usersgradedetails_id_seq; Type: SEQUENCE; Schema: public; Owner: superuser
--

CREATE SEQUENCE public.usersgradedetails_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usersgradedetails_id_seq OWNER TO superuser;

--
-- Name: usersgradedetails_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: superuser
--

ALTER SEQUENCE public.usersgradedetails_id_seq OWNED BY public.usersgradedetails.id;


--
-- Name: assesments id; Type: DEFAULT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.assesments ALTER COLUMN id SET DEFAULT nextval('public.assesments_id_seq'::regclass);


--
-- Name: groups id; Type: DEFAULT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.groups ALTER COLUMN id SET DEFAULT nextval('public.studentsgroup_id_seq'::regclass);


--
-- Name: notifications id; Type: DEFAULT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.notifications ALTER COLUMN id SET DEFAULT nextval('public.notifications_id_seq'::regclass);


--
-- Name: requests_log id; Type: DEFAULT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.requests_log ALTER COLUMN id SET DEFAULT nextval('public.requests_log_id_seq'::regclass);


--
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);


--
-- Name: task_groups id; Type: DEFAULT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.task_groups ALTER COLUMN id SET DEFAULT nextval('public.task_groups_id_seq'::regclass);


--
-- Name: tasks id; Type: DEFAULT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.tasks ALTER COLUMN id SET DEFAULT nextval('public.tasks_id_seq'::regclass);


--
-- Name: testquestions id; Type: DEFAULT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.testquestions ALTER COLUMN id SET DEFAULT nextval('public.testquestions_id_seq'::regclass);


--
-- Name: tests id; Type: DEFAULT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.tests ALTER COLUMN id SET DEFAULT nextval('public.tests_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Name: usersgradedetails id; Type: DEFAULT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.usersgradedetails ALTER COLUMN id SET DEFAULT nextval('public.usersgradedetails_id_seq'::regclass);


--
-- Name: 16605; Type: BLOB; Schema: -; Owner: superuser
--

SELECT pg_catalog.lo_create('16605');


ALTER LARGE OBJECT 16605 OWNER TO superuser;

--
-- Name: 16606; Type: BLOB; Schema: -; Owner: superuser
--

SELECT pg_catalog.lo_create('16606');


ALTER LARGE OBJECT 16606 OWNER TO superuser;

--
-- Name: 16607; Type: BLOB; Schema: -; Owner: superuser
--

SELECT pg_catalog.lo_create('16607');


ALTER LARGE OBJECT 16607 OWNER TO superuser;

--
-- Name: 16608; Type: BLOB; Schema: -; Owner: superuser
--

SELECT pg_catalog.lo_create('16608');


ALTER LARGE OBJECT 16608 OWNER TO superuser;

--
-- Name: 16609; Type: BLOB; Schema: -; Owner: superuser
--

SELECT pg_catalog.lo_create('16609');


ALTER LARGE OBJECT 16609 OWNER TO superuser;

--
-- Name: 16610; Type: BLOB; Schema: -; Owner: superuser
--

SELECT pg_catalog.lo_create('16610');


ALTER LARGE OBJECT 16610 OWNER TO superuser;

--
-- Name: 16622; Type: BLOB; Schema: -; Owner: superuser
--

SELECT pg_catalog.lo_create('16622');


ALTER LARGE OBJECT 16622 OWNER TO superuser;

--
-- Name: 16623; Type: BLOB; Schema: -; Owner: superuser
--

SELECT pg_catalog.lo_create('16623');


ALTER LARGE OBJECT 16623 OWNER TO superuser;

--
-- Name: 16624; Type: BLOB; Schema: -; Owner: superuser
--

SELECT pg_catalog.lo_create('16624');


ALTER LARGE OBJECT 16624 OWNER TO superuser;

--
-- Name: 16625; Type: BLOB; Schema: -; Owner: superuser
--

SELECT pg_catalog.lo_create('16625');


ALTER LARGE OBJECT 16625 OWNER TO superuser;

--
-- Name: 16626; Type: BLOB; Schema: -; Owner: superuser
--

SELECT pg_catalog.lo_create('16626');


ALTER LARGE OBJECT 16626 OWNER TO superuser;

--
-- Data for Name: assesments; Type: TABLE DATA; Schema: public; Owner: superuser
--

\i $$PATH$$/3114.dat

--
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: superuser
--

\i $$PATH$$/3116.dat

--
-- Data for Name: notifications; Type: TABLE DATA; Schema: public; Owner: superuser
--

\i $$PATH$$/3117.dat

--
-- Data for Name: requests_log; Type: TABLE DATA; Schema: public; Owner: superuser
--

\i $$PATH$$/3119.dat

--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: superuser
--

\i $$PATH$$/3121.dat

--
-- Data for Name: task_groups; Type: TABLE DATA; Schema: public; Owner: superuser
--

\i $$PATH$$/3124.dat

--
-- Data for Name: tasks; Type: TABLE DATA; Schema: public; Owner: superuser
--

\i $$PATH$$/3126.dat

--
-- Data for Name: testquestions; Type: TABLE DATA; Schema: public; Owner: superuser
--

\i $$PATH$$/3128.dat

--
-- Data for Name: tests; Type: TABLE DATA; Schema: public; Owner: superuser
--

\i $$PATH$$/3130.dat

--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: superuser
--

\i $$PATH$$/3132.dat

--
-- Data for Name: usersgradedetails; Type: TABLE DATA; Schema: public; Owner: superuser
--

\i $$PATH$$/3134.dat

--
-- Name: assesments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: superuser
--

SELECT pg_catalog.setval('public.assesments_id_seq', 18, true);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: superuser
--

SELECT pg_catalog.setval('public.hibernate_sequence', 282, true);


--
-- Name: notifications_id_seq; Type: SEQUENCE SET; Schema: public; Owner: superuser
--

SELECT pg_catalog.setval('public.notifications_id_seq', 3, true);


--
-- Name: requests_log_id_seq; Type: SEQUENCE SET; Schema: public; Owner: superuser
--

SELECT pg_catalog.setval('public.requests_log_id_seq', 133, true);


--
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: superuser
--

SELECT pg_catalog.setval('public.role_id_seq', 5, true);


--
-- Name: studentsgroup_id_seq; Type: SEQUENCE SET; Schema: public; Owner: superuser
--

SELECT pg_catalog.setval('public.studentsgroup_id_seq', 15, true);


--
-- Name: task_groups_id_seq; Type: SEQUENCE SET; Schema: public; Owner: superuser
--

SELECT pg_catalog.setval('public.task_groups_id_seq', 15, true);


--
-- Name: tasks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: superuser
--

SELECT pg_catalog.setval('public.tasks_id_seq', 7, true);


--
-- Name: testquestions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: superuser
--

SELECT pg_catalog.setval('public.testquestions_id_seq', 15, true);


--
-- Name: tests_id_seq; Type: SEQUENCE SET; Schema: public; Owner: superuser
--

SELECT pg_catalog.setval('public.tests_id_seq', 8, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: superuser
--

SELECT pg_catalog.setval('public.users_id_seq', 85, true);


--
-- Name: usersgradedetails_id_seq; Type: SEQUENCE SET; Schema: public; Owner: superuser
--

SELECT pg_catalog.setval('public.usersgradedetails_id_seq', 15, true);


--
-- Data for Name: BLOBS; Type: BLOBS; Schema: -; Owner: -
--

\i $$PATH$$/3148.dat

--
-- Name: assesments assesments_pkey; Type: CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.assesments
    ADD CONSTRAINT assesments_pkey PRIMARY KEY (id);


--
-- Name: notifications notifications_pkey; Type: CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.notifications
    ADD CONSTRAINT notifications_pkey PRIMARY KEY (id);


--
-- Name: requests_log requests_log_pkey; Type: CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.requests_log
    ADD CONSTRAINT requests_log_pkey PRIMARY KEY (id);


--
-- Name: roles role_name_key; Type: CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT role_name_key UNIQUE (name);


--
-- Name: roles role_pkey; Type: CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- Name: groups studentsgroup_name_key; Type: CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.groups
    ADD CONSTRAINT studentsgroup_name_key UNIQUE (name);


--
-- Name: groups studentsgroup_pkey; Type: CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.groups
    ADD CONSTRAINT studentsgroup_pkey PRIMARY KEY (id);


--
-- Name: task_groups task_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.task_groups
    ADD CONSTRAINT task_groups_pkey PRIMARY KEY (id);


--
-- Name: tasks tasks_pkey; Type: CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (id);


--
-- Name: testquestions testquestions_pkey; Type: CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.testquestions
    ADD CONSTRAINT testquestions_pkey PRIMARY KEY (id);


--
-- Name: tests tests_pkey; Type: CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.tests
    ADD CONSTRAINT tests_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: usersgradedetails usersgradedetails_pkey; Type: CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.usersgradedetails
    ADD CONSTRAINT usersgradedetails_pkey PRIMARY KEY (id);


--
-- Name: assesments assesments_assessorid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.assesments
    ADD CONSTRAINT assesments_assessorid_fkey FOREIGN KEY (assessorid) REFERENCES public.users(id);


--
-- Name: assesments assesments_taskid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.assesments
    ADD CONSTRAINT assesments_taskid_fkey FOREIGN KEY (taskid) REFERENCES public.tasks(id);


--
-- Name: notifications notifications_creatorid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.notifications
    ADD CONSTRAINT notifications_creatorid_fkey FOREIGN KEY (creatorid) REFERENCES public.users(id);


--
-- Name: notifications notifications_recieverid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.notifications
    ADD CONSTRAINT notifications_recieverid_fkey FOREIGN KEY (recieverid) REFERENCES public.users(id);


--
-- Name: task_groups task_groups_groupid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.task_groups
    ADD CONSTRAINT task_groups_groupid_fkey FOREIGN KEY (groupid) REFERENCES public.groups(id);


--
-- Name: task_groups task_groups_taskid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.task_groups
    ADD CONSTRAINT task_groups_taskid_fkey FOREIGN KEY (taskid) REFERENCES public.tasks(id);


--
-- Name: tasks tasks_graderid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_graderid_fkey FOREIGN KEY (graderid) REFERENCES public.users(id);


--
-- Name: tasks tasks_testid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_testid_fkey FOREIGN KEY (testid) REFERENCES public.tests(id);


--
-- Name: testquestions testquestions_testid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.testquestions
    ADD CONSTRAINT testquestions_testid_fkey FOREIGN KEY (testid) REFERENCES public.tests(id);


--
-- Name: tests tests_creatorid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.tests
    ADD CONSTRAINT tests_creatorid_fkey FOREIGN KEY (creatorid) REFERENCES public.users(id);


--
-- Name: users users_groupid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_groupid_fkey FOREIGN KEY (groupid) REFERENCES public.groups(id);


--
-- Name: users users_roleid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_roleid_fkey FOREIGN KEY (roleid) REFERENCES public.roles(id);


--
-- Name: usersgradedetails usersgradedetails_userid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: superuser
--

ALTER TABLE ONLY public.usersgradedetails
    ADD CONSTRAINT usersgradedetails_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    