CREATE SCHEMA dev;


--
-- TOC entry 218 (class 1259 OID 196785)
-- Name: author_id_seq; Type: SEQUENCE; Schema: dev; Owner: -
--

CREATE SEQUENCE dev.author_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 197 (class 1259 OID 196619)
-- Name: authors; Type: TABLE; Schema: dev; Owner: -
--

CREATE TABLE dev.authors (
                             id bigint NOT NULL,
                             first_name character varying(255),
                             last_name character varying(255),
                             nationality character varying(255)
);


--
-- TOC entry 196 (class 1259 OID 196617)
-- Name: authors_id_seq; Type: SEQUENCE; Schema: dev; Owner: -
--

CREATE SEQUENCE dev.authors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2936 (class 0 OID 0)
-- Dependencies: 196
-- Name: authors_id_seq; Type: SEQUENCE OWNED BY; Schema: dev; Owner: -
--

ALTER SEQUENCE dev.authors_id_seq OWNED BY dev.authors.id;


--
-- TOC entry 206 (class 1259 OID 196676)
-- Name: authors_of_books; Type: TABLE; Schema: dev; Owner: -
--

CREATE TABLE dev.authors_of_books (
                                      author_id bigint NOT NULL,
                                      book_id bigint NOT NULL
);


--
-- TOC entry 205 (class 1259 OID 196662)
-- Name: book; Type: TABLE; Schema: dev; Owner: -
--

CREATE TABLE dev.book (
                          id bigint NOT NULL,
                          isbn integer,
                          language character varying(255),
                          number_of_pages integer,
                          publication_date bytea,
                          title character varying(255),
                          editor_id bigint
);


--
-- TOC entry 204 (class 1259 OID 196660)
-- Name: book_id_seq; Type: SEQUENCE; Schema: dev; Owner: -
--

CREATE SEQUENCE dev.book_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2937 (class 0 OID 0)
-- Dependencies: 204
-- Name: book_id_seq; Type: SEQUENCE OWNED BY; Schema: dev; Owner: -
--

ALTER SEQUENCE dev.book_id_seq OWNED BY dev.book.id;


--
-- TOC entry 210 (class 1259 OID 196715)
-- Name: books_of_libraries; Type: TABLE; Schema: dev; Owner: -
--

CREATE TABLE dev.books_of_libraries (
                                        stock integer,
                                        book_id integer NOT NULL,
                                        library_id integer NOT NULL
);


--
-- TOC entry 207 (class 1259 OID 196689)
-- Name: categories_of_books; Type: TABLE; Schema: dev; Owner: -
--

CREATE TABLE dev.categories_of_books (
                                         book_id bigint NOT NULL,
                                         category_id bigint NOT NULL
);


--
-- TOC entry 199 (class 1259 OID 196630)
-- Name: category; Type: TABLE; Schema: dev; Owner: -
--

CREATE TABLE dev.category (
                              id bigint NOT NULL,
                              category character varying(255)
);


--
-- TOC entry 198 (class 1259 OID 196628)
-- Name: category_id_seq; Type: SEQUENCE; Schema: dev; Owner: -
--

CREATE SEQUENCE dev.category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2938 (class 0 OID 0)
-- Dependencies: 198
-- Name: category_id_seq; Type: SEQUENCE OWNED BY; Schema: dev; Owner: -
--

ALTER SEQUENCE dev.category_id_seq OWNED BY dev.category.id;


--
-- TOC entry 201 (class 1259 OID 196638)
-- Name: coordinates; Type: TABLE; Schema: dev; Owner: -
--

CREATE TABLE dev.coordinates (
                                 id bigint NOT NULL,
                                 additional_information character varying(255),
                                 city character varying(255),
                                 email character varying(255),
                                 phone character varying(255),
                                 postal_code bigint,
                                 street character varying(255),
                                 street_number character varying(255)
);


--
-- TOC entry 200 (class 1259 OID 196636)
-- Name: coordinates_id_seq; Type: SEQUENCE; Schema: dev; Owner: -
--

CREATE SEQUENCE dev.coordinates_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2939 (class 0 OID 0)
-- Dependencies: 200
-- Name: coordinates_id_seq; Type: SEQUENCE OWNED BY; Schema: dev; Owner: -
--

ALTER SEQUENCE dev.coordinates_id_seq OWNED BY dev.coordinates.id;


--
-- TOC entry 203 (class 1259 OID 196649)
-- Name: editor; Type: TABLE; Schema: dev; Owner: -
--

CREATE TABLE dev.editor (
                            id bigint NOT NULL,
                            name character varying(255),
                            coordinates_id bigint
);


--
-- TOC entry 202 (class 1259 OID 196647)
-- Name: editor_id_seq; Type: SEQUENCE; Schema: dev; Owner: -
--

CREATE SEQUENCE dev.editor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2940 (class 0 OID 0)
-- Dependencies: 202
-- Name: editor_id_seq; Type: SEQUENCE OWNED BY; Schema: dev; Owner: -
--

ALTER SEQUENCE dev.editor_id_seq OWNED BY dev.editor.id;


--
-- TOC entry 219 (class 1259 OID 196787)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: dev; Owner: -
--

CREATE SEQUENCE dev.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 209 (class 1259 OID 196704)
-- Name: library; Type: TABLE; Schema: dev; Owner: -
--

CREATE TABLE dev.library (
                             id bigint NOT NULL,
                             name character varying(255),
                             coordinates_id bigint
);


--
-- TOC entry 208 (class 1259 OID 196702)
-- Name: library_id_seq; Type: SEQUENCE; Schema: dev; Owner: -
--

CREATE SEQUENCE dev.library_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2941 (class 0 OID 0)
-- Dependencies: 208
-- Name: library_id_seq; Type: SEQUENCE OWNED BY; Schema: dev; Owner: -
--

ALTER SEQUENCE dev.library_id_seq OWNED BY dev.library.id;


--
-- TOC entry 216 (class 1259 OID 196756)
-- Name: loan; Type: TABLE; Schema: dev; Owner: -
--

CREATE TABLE dev.loan (
                          id bigint NOT NULL,
                          extended_end_date date,
                          initial_end_date date,
                          returned boolean NOT NULL,
                          start_date date,
                          book_id bigint,
                          user_id bigint
);


--
-- TOC entry 215 (class 1259 OID 196754)
-- Name: loan_id_seq; Type: SEQUENCE; Schema: dev; Owner: -
--

CREATE SEQUENCE dev.loan_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2942 (class 0 OID 0)
-- Dependencies: 215
-- Name: loan_id_seq; Type: SEQUENCE OWNED BY; Schema: dev; Owner: -
--

ALTER SEQUENCE dev.loan_id_seq OWNED BY dev.loan.id;


--
-- TOC entry 212 (class 1259 OID 196732)
-- Name: role; Type: TABLE; Schema: dev; Owner: -
--

CREATE TABLE dev.role (
                          id bigint NOT NULL,
                          role character varying(255)
);


--
-- TOC entry 211 (class 1259 OID 196730)
-- Name: role_id_seq; Type: SEQUENCE; Schema: dev; Owner: -
--

CREATE SEQUENCE dev.role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2943 (class 0 OID 0)
-- Dependencies: 211
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: dev; Owner: -
--

ALTER SEQUENCE dev.role_id_seq OWNED BY dev.role.id;


--
-- TOC entry 217 (class 1259 OID 196772)
-- Name: roles_of_users; Type: TABLE; Schema: dev; Owner: -
--

CREATE TABLE dev.roles_of_users (
                                    user_id bigint NOT NULL,
                                    role_id bigint NOT NULL
);


--
-- TOC entry 214 (class 1259 OID 196740)
-- Name: users; Type: TABLE; Schema: dev; Owner: -
--

CREATE TABLE dev.users (
                           id bigint NOT NULL,
                           first_name character varying(255),
                           last_name character varying(255),
                           password character varying(255),
                           registration_date bytea,
                           user_name character varying(255),
                           coordinates_id bigint
);


--
-- TOC entry 213 (class 1259 OID 196738)
-- Name: users_id_seq; Type: SEQUENCE; Schema: dev; Owner: -
--

CREATE SEQUENCE dev.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2944 (class 0 OID 0)
-- Dependencies: 213
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: dev; Owner: -
--

ALTER SEQUENCE dev.users_id_seq OWNED BY dev.users.id;


--
-- TOC entry 2742 (class 2604 OID 196622)
-- Name: authors id; Type: DEFAULT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.authors ALTER COLUMN id SET DEFAULT nextval('dev.authors_id_seq'::regclass);


--
-- TOC entry 2746 (class 2604 OID 196665)
-- Name: book id; Type: DEFAULT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.book ALTER COLUMN id SET DEFAULT nextval('dev.book_id_seq'::regclass);


--
-- TOC entry 2743 (class 2604 OID 196633)
-- Name: category id; Type: DEFAULT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.category ALTER COLUMN id SET DEFAULT nextval('dev.category_id_seq'::regclass);


--
-- TOC entry 2744 (class 2604 OID 196641)
-- Name: coordinates id; Type: DEFAULT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.coordinates ALTER COLUMN id SET DEFAULT nextval('dev.coordinates_id_seq'::regclass);


--
-- TOC entry 2745 (class 2604 OID 196652)
-- Name: editor id; Type: DEFAULT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.editor ALTER COLUMN id SET DEFAULT nextval('dev.editor_id_seq'::regclass);


--
-- TOC entry 2747 (class 2604 OID 196707)
-- Name: library id; Type: DEFAULT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.library ALTER COLUMN id SET DEFAULT nextval('dev.library_id_seq'::regclass);


--
-- TOC entry 2750 (class 2604 OID 196759)
-- Name: loan id; Type: DEFAULT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.loan ALTER COLUMN id SET DEFAULT nextval('dev.loan_id_seq'::regclass);


--
-- TOC entry 2748 (class 2604 OID 196735)
-- Name: role id; Type: DEFAULT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.role ALTER COLUMN id SET DEFAULT nextval('dev.role_id_seq'::regclass);


--
-- TOC entry 2749 (class 2604 OID 196743)
-- Name: users id; Type: DEFAULT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.users ALTER COLUMN id SET DEFAULT nextval('dev.users_id_seq'::regclass);


--
-- TOC entry 2907 (class 0 OID 196619)
-- Dependencies: 197
-- Data for Name: authors; Type: TABLE DATA; Schema: dev; Owner: -
--



--
-- TOC entry 2916 (class 0 OID 196676)
-- Dependencies: 206
-- Data for Name: authors_of_books; Type: TABLE DATA; Schema: dev; Owner: -
--



--
-- TOC entry 2915 (class 0 OID 196662)
-- Dependencies: 205
-- Data for Name: book; Type: TABLE DATA; Schema: dev; Owner: -
--

INSERT INTO dev.book (id, isbn, language, number_of_pages, publication_date, title, editor_id) VALUES (8, NULL, 'English', 145, NULL, 'Book1', NULL);


--
-- TOC entry 2920 (class 0 OID 196715)
-- Dependencies: 210
-- Data for Name: books_of_libraries; Type: TABLE DATA; Schema: dev; Owner: -
--

INSERT INTO dev.books_of_libraries (stock, book_id, library_id) VALUES (NULL, 8, 5);
INSERT INTO dev.books_of_libraries (stock, book_id, library_id) VALUES (5, 8, 4);


--
-- TOC entry 2917 (class 0 OID 196689)
-- Dependencies: 207
-- Data for Name: categories_of_books; Type: TABLE DATA; Schema: dev; Owner: -
--

INSERT INTO dev.categories_of_books (book_id, category_id) VALUES (8, 10);
INSERT INTO dev.categories_of_books (book_id, category_id) VALUES (8, 11);


--
-- TOC entry 2909 (class 0 OID 196630)
-- Dependencies: 199
-- Data for Name: category; Type: TABLE DATA; Schema: dev; Owner: -
--

INSERT INTO dev.category (id, category) VALUES (9, 'CHILDREN');
INSERT INTO dev.category (id, category) VALUES (10, 'CULTURE');
INSERT INTO dev.category (id, category) VALUES (11, 'EDUCATION');
INSERT INTO dev.category (id, category) VALUES (12, 'FANTASY');
INSERT INTO dev.category (id, category) VALUES (13, 'LITERATURE&FICTION');


--
-- TOC entry 2911 (class 0 OID 196638)
-- Dependencies: 201
-- Data for Name: coordinates; Type: TABLE DATA; Schema: dev; Owner: -
--

INSERT INTO dev.coordinates (id, additional_information, city, email, phone, postal_code, street, street_number) VALUES (2, NULL, NULL, 'john@gmail.com', NULL, NULL, NULL, NULL);
INSERT INTO dev.coordinates (id, additional_information, city, email, phone, postal_code, street, street_number) VALUES (6, NULL, NULL, 'librariry1@gmail.com', NULL, NULL, NULL, NULL);
INSERT INTO dev.coordinates (id, additional_information, city, email, phone, postal_code, street, street_number) VALUES (7, NULL, NULL, 'librariry2@gmail.com', NULL, NULL, NULL, NULL);


--
-- TOC entry 2913 (class 0 OID 196649)
-- Dependencies: 203
-- Data for Name: editor; Type: TABLE DATA; Schema: dev; Owner: -
--



--
-- TOC entry 2919 (class 0 OID 196704)
-- Dependencies: 209
-- Data for Name: library; Type: TABLE DATA; Schema: dev; Owner: -
--

INSERT INTO dev.library (id, name, coordinates_id) VALUES (4, 'Library1', NULL);
INSERT INTO dev.library (id, name, coordinates_id) VALUES (5, 'Library2', NULL);


--
-- TOC entry 2926 (class 0 OID 196756)
-- Dependencies: 216
-- Data for Name: loan; Type: TABLE DATA; Schema: dev; Owner: -
--



--
-- TOC entry 2922 (class 0 OID 196732)
-- Dependencies: 212
-- Data for Name: role; Type: TABLE DATA; Schema: dev; Owner: -
--

INSERT INTO dev.role (id, role) VALUES (1, 'ROLE_USER');


--
-- TOC entry 2927 (class 0 OID 196772)
-- Dependencies: 217
-- Data for Name: roles_of_users; Type: TABLE DATA; Schema: dev; Owner: -
--

INSERT INTO dev.roles_of_users (user_id, role_id) VALUES (3, 1);


--
-- TOC entry 2924 (class 0 OID 196740)
-- Dependencies: 214
-- Data for Name: users; Type: TABLE DATA; Schema: dev; Owner: -
--

INSERT INTO dev.users (id, first_name, last_name, password, registration_date, user_name, coordinates_id) VALUES (3, 'John', 'Doe', '$2a$10$m29PsludBr5BgmpYlbR9j.kdC6P0DrNfI2q7VCie2ZdiAAYdwi7GK', '\xaced0005737200166f72672e6a6f64612e74696d652e4461746554696d65b83c78646a5bddf90200007872001f6f72672e6a6f64612e74696d652e626173652e426173654461746554696d65fffff9e14f5d2ea30200024a0007694d696c6c69734c000b694368726f6e6f6c6f677974001a4c6f72672f6a6f64612f74696d652f4368726f6e6f6c6f67793b78700000016fe1a02219737200276f72672e6a6f64612e74696d652e6368726f6e6f2e49534f4368726f6e6f6c6f67792453747562a9c811667137502703000078707372001f6f72672e6a6f64612e74696d652e4461746554696d655a6f6e652453747562a62f019a7c321ae30300007870770e000c4575726f70652f50617269737878', 'TheJohn', 2);


--
-- TOC entry 2945 (class 0 OID 0)
-- Dependencies: 218
-- Name: author_id_seq; Type: SEQUENCE SET; Schema: dev; Owner: -
--

SELECT pg_catalog.setval('dev.author_id_seq', 1, false);


--
-- TOC entry 2946 (class 0 OID 0)
-- Dependencies: 196
-- Name: authors_id_seq; Type: SEQUENCE SET; Schema: dev; Owner: -
--

SELECT pg_catalog.setval('dev.authors_id_seq', 1, false);


--
-- TOC entry 2947 (class 0 OID 0)
-- Dependencies: 204
-- Name: book_id_seq; Type: SEQUENCE SET; Schema: dev; Owner: -
--

SELECT pg_catalog.setval('dev.book_id_seq', 1, false);


--
-- TOC entry 2948 (class 0 OID 0)
-- Dependencies: 198
-- Name: category_id_seq; Type: SEQUENCE SET; Schema: dev; Owner: -
--

SELECT pg_catalog.setval('dev.category_id_seq', 1, false);


--
-- TOC entry 2949 (class 0 OID 0)
-- Dependencies: 200
-- Name: coordinates_id_seq; Type: SEQUENCE SET; Schema: dev; Owner: -
--

SELECT pg_catalog.setval('dev.coordinates_id_seq', 1, false);


--
-- TOC entry 2950 (class 0 OID 0)
-- Dependencies: 202
-- Name: editor_id_seq; Type: SEQUENCE SET; Schema: dev; Owner: -
--

SELECT pg_catalog.setval('dev.editor_id_seq', 1, false);


--
-- TOC entry 2951 (class 0 OID 0)
-- Dependencies: 219
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: dev; Owner: -
--

SELECT pg_catalog.setval('dev.hibernate_sequence', 13, true);


--
-- TOC entry 2952 (class 0 OID 0)
-- Dependencies: 208
-- Name: library_id_seq; Type: SEQUENCE SET; Schema: dev; Owner: -
--

SELECT pg_catalog.setval('dev.library_id_seq', 1, false);


--
-- TOC entry 2953 (class 0 OID 0)
-- Dependencies: 215
-- Name: loan_id_seq; Type: SEQUENCE SET; Schema: dev; Owner: -
--

SELECT pg_catalog.setval('dev.loan_id_seq', 1, false);


--
-- TOC entry 2954 (class 0 OID 0)
-- Dependencies: 211
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: dev; Owner: -
--

SELECT pg_catalog.setval('dev.role_id_seq', 1, false);


--
-- TOC entry 2955 (class 0 OID 0)
-- Dependencies: 213
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: dev; Owner: -
--

SELECT pg_catalog.setval('dev.users_id_seq', 1, false);


--
-- TOC entry 2752 (class 2606 OID 196627)
-- Name: authors authors_pkey; Type: CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.authors
    ADD CONSTRAINT authors_pkey PRIMARY KEY (id);


--
-- TOC entry 2760 (class 2606 OID 196670)
-- Name: book book_pkey; Type: CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (id);


--
-- TOC entry 2764 (class 2606 OID 196719)
-- Name: books_of_libraries books_of_libraries_pkey; Type: CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.books_of_libraries
    ADD CONSTRAINT books_of_libraries_pkey PRIMARY KEY (book_id, library_id);


--
-- TOC entry 2754 (class 2606 OID 196635)
-- Name: category category_pkey; Type: CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- TOC entry 2756 (class 2606 OID 196646)
-- Name: coordinates coordinates_pkey; Type: CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.coordinates
    ADD CONSTRAINT coordinates_pkey PRIMARY KEY (id);


--
-- TOC entry 2758 (class 2606 OID 196654)
-- Name: editor editor_pkey; Type: CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.editor
    ADD CONSTRAINT editor_pkey PRIMARY KEY (id);


--
-- TOC entry 2762 (class 2606 OID 196709)
-- Name: library library_pkey; Type: CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.library
    ADD CONSTRAINT library_pkey PRIMARY KEY (id);


--
-- TOC entry 2770 (class 2606 OID 196761)
-- Name: loan loan_pkey; Type: CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.loan
    ADD CONSTRAINT loan_pkey PRIMARY KEY (id);


--
-- TOC entry 2766 (class 2606 OID 196737)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 2768 (class 2606 OID 196748)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2783 (class 2606 OID 196775)
-- Name: roles_of_users fk250ohij85iq9eqiqyoeeyvlt4; Type: FK CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.roles_of_users
    ADD CONSTRAINT fk250ohij85iq9eqiqyoeeyvlt4 FOREIGN KEY (user_id) REFERENCES dev.users(id);


--
-- TOC entry 2771 (class 2606 OID 196655)
-- Name: editor fk37n19rdatimavm4alfgybq3de; Type: FK CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.editor
    ADD CONSTRAINT fk37n19rdatimavm4alfgybq3de FOREIGN KEY (coordinates_id) REFERENCES dev.coordinates(id);


--
-- TOC entry 2778 (class 2606 OID 196720)
-- Name: books_of_libraries fk39v06awe92f1o1bpni56ubji7; Type: FK CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.books_of_libraries
    ADD CONSTRAINT fk39v06awe92f1o1bpni56ubji7 FOREIGN KEY (book_id) REFERENCES dev.book(id);


--
-- TOC entry 2775 (class 2606 OID 196692)
-- Name: categories_of_books fk3a26j798utkueryxn2p120887; Type: FK CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.categories_of_books
    ADD CONSTRAINT fk3a26j798utkueryxn2p120887 FOREIGN KEY (book_id) REFERENCES dev.book(id);


--
-- TOC entry 2780 (class 2606 OID 196749)
-- Name: users fk4vkox8genueg7f8bt5ti3s3gr; Type: FK CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.users
    ADD CONSTRAINT fk4vkox8genueg7f8bt5ti3s3gr FOREIGN KEY (coordinates_id) REFERENCES dev.coordinates(id);


--
-- TOC entry 2781 (class 2606 OID 196762)
-- Name: loan fk88c0ydlo57pcgp137tntrgqx1; Type: FK CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.loan
    ADD CONSTRAINT fk88c0ydlo57pcgp137tntrgqx1 FOREIGN KEY (book_id) REFERENCES dev.book(id);


--
-- TOC entry 2776 (class 2606 OID 196697)
-- Name: categories_of_books fk9kmwilky0md1g3hafjebwow9r; Type: FK CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.categories_of_books
    ADD CONSTRAINT fk9kmwilky0md1g3hafjebwow9r FOREIGN KEY (category_id) REFERENCES dev.category(id);


--
-- TOC entry 2777 (class 2606 OID 196710)
-- Name: library fkffh82lbqpl4b2i9w13c4muhmb; Type: FK CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.library
    ADD CONSTRAINT fkffh82lbqpl4b2i9w13c4muhmb FOREIGN KEY (coordinates_id) REFERENCES dev.coordinates(id);


--
-- TOC entry 2782 (class 2606 OID 196767)
-- Name: loan fkkv6kl0xa6lu02a89nlowpapnv; Type: FK CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.loan
    ADD CONSTRAINT fkkv6kl0xa6lu02a89nlowpapnv FOREIGN KEY (user_id) REFERENCES dev.users(id);


--
-- TOC entry 2779 (class 2606 OID 196725)
-- Name: books_of_libraries fknp2nufkeonirvqe5u02u5vn77; Type: FK CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.books_of_libraries
    ADD CONSTRAINT fknp2nufkeonirvqe5u02u5vn77 FOREIGN KEY (library_id) REFERENCES dev.library(id);


--
-- TOC entry 2784 (class 2606 OID 196780)
-- Name: roles_of_users fkoa9yg1yb80f1vff7d2mmcgq5i; Type: FK CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.roles_of_users
    ADD CONSTRAINT fkoa9yg1yb80f1vff7d2mmcgq5i FOREIGN KEY (role_id) REFERENCES dev.role(id);


--
-- TOC entry 2773 (class 2606 OID 196679)
-- Name: authors_of_books fkoweydgd36pt93avdt20962sta; Type: FK CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.authors_of_books
    ADD CONSTRAINT fkoweydgd36pt93avdt20962sta FOREIGN KEY (author_id) REFERENCES dev.authors(id);


--
-- TOC entry 2772 (class 2606 OID 196671)
-- Name: book fkpmv0yeqvng13trnm9so4aaq04; Type: FK CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.book
    ADD CONSTRAINT fkpmv0yeqvng13trnm9so4aaq04 FOREIGN KEY (editor_id) REFERENCES dev.editor(id);


--
-- TOC entry 2774 (class 2606 OID 196684)
-- Name: authors_of_books fkqiianqutodjs14x7ek8shjyao; Type: FK CONSTRAINT; Schema: dev; Owner: -
--

ALTER TABLE ONLY dev.authors_of_books
    ADD CONSTRAINT fkqiianqutodjs14x7ek8shjyao FOREIGN KEY (book_id) REFERENCES dev.book(id);


-- Completed on 2020-01-26 12:35:03

--
-- PostgreSQL database dump complete
--

