package utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.Map;

public class RestIO {
    static private ObjectMapper mapper = new ObjectMapper();

    public static String readJson(HttpServletRequest req) throws IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader reader = req.getReader();
        String line;
        StringBuffer buffer = new StringBuffer();
        while((line = reader.readLine()) != null) buffer.append(line);
        reader.close();
        return buffer.toString();
    }

    public static void writeJson(HttpServletResponse resp, String json) throws IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().print(json);
        resp.flushBuffer();
    }


    public static <T> T readObject(HttpServletRequest req, Class<T> clazz) throws IOException {
        String json = readJson(req);
        return mapper.readValue(json, clazz);
    }

    public static void writeObject(HttpServletResponse resp, Object data) throws IOException {
        String json = mapper.writeValueAsString(data);
        writeJson(resp, json);
    }

    public static void writeEmptyObject(HttpServletResponse resp) throws IOException {
        writeObject(resp, Map.of());
    }
}
