package io.smart.swings.toolpanel;

import io.smart.swings.x2jparser.builder.components.Button;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ToolbarConfiguration {
    Map<String, List<Button>> toolbarListMap;

}
