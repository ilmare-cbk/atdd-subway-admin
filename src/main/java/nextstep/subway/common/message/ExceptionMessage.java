package nextstep.subway.common.message;

public class ExceptionMessage {
    public static final String REQUIRED = "필수값은 비어선 안됩니다!";
    public static final String NOT_FOUND_LINE = "노선을 찾을 수 없습니다.";
    public static final String NOT_FOUND_STATION = "지하철역을 찾을 수 없습니다.";
    public static final String UP_STATION_EQUALS_DOWN_STATION = "상행좀점역과 하행종점역은 같을 수 없습니다.";

    private ExceptionMessage() {
    }
}
