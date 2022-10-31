package com.usuario.srv.events;


import com.usuario.srv.entity.UserDB;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserCreatedEvent extends Event<UserDB> {

}
