create table user_feature(
	id bigint not null,
	feature_id bigint not null,
	user_id bigint not null,
	primary key(id),
	CONSTRAINT fk_user_feature_user_id FOREIGN KEY (user_id) REFERENCES user(id),
	CONSTRAINT fk_user_feature_feature_id FOREIGN KEY (feature_id) REFERENCES feature(id)
)