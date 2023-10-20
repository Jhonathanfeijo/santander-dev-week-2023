CREATE TABLE `user` (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL,
    card_id BIGINT NOT NULL,
    account_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_user_card_id FOREIGN KEY (card_id) REFERENCES card(id),
    CONSTRAINT fk_user_account_id FOREIGN KEY (account_id) REFERENCES account(id)
);
