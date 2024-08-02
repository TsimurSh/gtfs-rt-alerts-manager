package pl.servicealerts.model.servicealerts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ServiceAlert implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    @NonNull
    private String agencyId;
    @JsonIgnore
    private long creationTime;
    @NonNull
    private List<TimeRange> activeWindows;
    @NonNull
    private String cause;
    @NonNull
    private String effect;
    @NonNull
    private List<NaturalLanguageString> summaries;
    @NonNull
    private List<NaturalLanguageString> urls;
    @NonNull
    private List<SituationAffects> allAffects;
    @NonNull
    private List<NaturalLanguageString> descriptions;
}
