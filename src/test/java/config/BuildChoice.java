package config;

public enum BuildChoice {
    VALID  (1),  //calls constructor with value 3
    INVALID_VALIDATION(2),  //calls constructor with value 2
    INVALID_COMPULSARY   (3),   //calls constructor with value 1
    REQUEST_NULL   (4)
    ; // semicolon needed when fields / methods follow


    private final int levelCode;

    private BuildChoice(int levelCode) {
        this.levelCode = levelCode;
    }
}