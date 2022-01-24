package com.github.daniilandco.alloyintegration.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Class which represents error info.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class ErrorDTO {
    private final String status;
    private final String title;
    private final String details;
}
