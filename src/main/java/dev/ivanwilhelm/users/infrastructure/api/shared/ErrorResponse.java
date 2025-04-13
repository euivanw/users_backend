package dev.ivanwilhelm.users.infrastructure.api.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.ivanwilhelm.users.infrastructure.utils.JsonConverter;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@RequiredArgsConstructor
public class ErrorResponse {
    private final String message;
    private List<String> details;

    public String toJson() {
        return JsonConverter.toJson(this);
    }
}
