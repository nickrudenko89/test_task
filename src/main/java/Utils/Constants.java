package Utils;

public final class Constants {
    public static final class Cookies {
        public static final String USER_ID_COOKIE_NAME = "userId";
        public static final int COOKIE_LIFETIME = 700;
        public static final int COOKIE_EXPIRE_TIME = 0;
    }

    public static final class Errors {
        public static final String INCORRECT_LOGIN_OR_PASSWORD_ERROR = "Incorrect login or password.";
        public static final String EMPTY_REQUEST_ERROR = "Request must not be empty.";
        public static final String EMPTY_BID_ERROR = "Bid must not be empty.";
        public static final String EMPTY_DATE_ERROR = "Due date must not be empty.";
        public static final String INCORRECT_DATE_ERROR = "Due date has incorrect format.";
    }

}
