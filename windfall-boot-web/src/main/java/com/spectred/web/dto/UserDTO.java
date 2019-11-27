package com.spectred.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author SWD
 */
@Setter
@Getter
@Builder
public class UserDTO {

    private String name ;

    private String age;
}
