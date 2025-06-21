package constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MeasurementUnits {
    METRIC("C"),
    IMPERIAL("F");

    private final String label;
}
