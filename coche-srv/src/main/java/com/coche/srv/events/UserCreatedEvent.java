package com.coche.srv.events;


import com.coche.srv.entity.UserDB;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserCreatedEvent extends Event<UserDB> {

}
