create table user_news(
	id bigint not null,
	news_id bigint not null,
	user_id bigint not null,
	primary key(id),
	CONSTRAINT fk_user_news_user_id FOREIGN KEY (user_id) REFERENCES user(id),
	CONSTRAINT fk_user_news_news_id FOREIGN KEY (news_id) REFERENCES news(id)
)