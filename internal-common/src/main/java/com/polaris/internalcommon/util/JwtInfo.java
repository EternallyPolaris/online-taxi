package com.polaris.internalcommon.util;

import lombok.Data;

@Data
public class JwtInfo{
    String subject;
    Long issueDate;
}