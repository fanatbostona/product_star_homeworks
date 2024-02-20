import java.util.Objects;
import java.util.stream.Stream;

public enum Action {
    EXIT (0,false),
    CREATE(1, true),
    UPDATE(2, true),
    DELETE(3, true),
    STATS_BY_COURSE(4, false),
    STATS_BY_CITIES(5, false),
    SEARCH(6, true),
    ERROR(-1 , false);
    private Integer code;
    private Boolean requireAdditionalData;

    Action(Integer code, Boolean requireAdditionalData) {
        this.code = code;
        this.requireAdditionalData = requireAdditionalData;
    }

    public Integer getCode() {
        return code;
    }

    public Boolean getRequireAdditionalData() {
        return requireAdditionalData;
    }

    public static Action fromCode (Integer code)
    {
        return Stream.of(Action.values())
                .filter(action -> Objects.equals(action.getCode(),code))
                .findFirst()
                .orElseGet(() -> {
                        System.out.println("Неизвестный код действия " + code);
                        return Action.ERROR; });
    }
}
