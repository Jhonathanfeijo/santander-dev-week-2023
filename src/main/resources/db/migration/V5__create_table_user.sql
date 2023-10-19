CREATE TABLE `user` (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL,
    id_card BIGINT NOT NULL,
    id_account BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_user_id_card FOREIGN KEY (id_card) REFERENCES card(id),
    CONSTRAINT fk_user_id_account FOREIGN KEY (id_account) REFERENCES account(id)
);
