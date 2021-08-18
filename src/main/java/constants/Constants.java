package constants;


    public class Constants {
        public static class  RunVariable{
            public static String server= Servers.UAPI_URL;
            public static String path= Path.AUTH_PATH;

        }
        public static class Servers{
            public static String UAPI_URL = "https://api.beeline.ru/mwint/";
        }

        public static class Path{
            public static String AUTH_PATH = "auth/1/";
        }

        public static class Actions{
            //uapi
            public static String GET_LOGIN_INFO = "loginInfo/";

        }
    }


