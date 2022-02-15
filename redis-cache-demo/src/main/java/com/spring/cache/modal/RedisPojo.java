package com.spring.cache.modal;


import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RedisPojo implements Serializable {

    @Getter @Setter
    private long id;
    @Getter @Setter
    private String cachaName;
    @Getter @Setter
    private String cacheDetails;

}
