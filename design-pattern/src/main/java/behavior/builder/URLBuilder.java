package behavior.builder;
//使用Builder模式编写一个URLBuilder，调用方式如下

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;

/**
 * String url = URLBuilder.builder() // 创建Builder
 * .setDomain("www.liaoxuefeng.com") // 设置domain
 * .setScheme("https") // 设置scheme
 * .setPath("/") // 设置路径
 * .setQuery(Map.of("a", "123", "q", "K&R")) // 设置query
 * .build(); // 完成build
 */
public class URLBuilder {
    private String domain = null;
    private String scheme = "http";
    private int port = -1;
    private String path = "/";
    private String username = null;
    private String password = null;
    private Map<String, String> query = null;

    /**
     * 对封装的信息统一装配
     * @return String
     */
    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append(scheme).append("://");
        if (username != null && password != null) {
            sb.append(username).append(':').append(password).append('@');
        }
        sb.append(domain);
        if (port >= 0) {
            sb.append(':').append(port);
        }
        sb.append(path);
        if (query != null && !query.isEmpty()) {
            query.forEach((k, v) -> {
                try {
                    sb.append(k).append('=').append(URLEncoder.encode(v, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            });
        }
        return sb.toString();
    }

    /**
     * 设置域名
     * @param domain
     * @return
     */
    public URLBuilder setDomain(String domain) {
        this.domain = Objects.requireNonNull(domain);
        return this;
    }

    /**
     * 设置协议
     * @param scheme
     * @return
     */
    public URLBuilder setScheme(String scheme) {
        this.scheme = Objects.requireNonNull(scheme);
        return this;
    }

    /**
     * 设置路径
     * @param path
     * @return
     */
    public URLBuilder setPath(String path) {
        this.path = Objects.requireNonNull(path);
        return this;
    }

    /**
     * 设置插叙条件
     * @param query
     * @return
     */
    public URLBuilder setQuery(Map query) {
        this.query = query;
        return this;
    }

    /**
     * 设置端口号
     * @param port
     * @return
     */
    public URLBuilder setPort(int port) {
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("无效的端口号");
        }
        this.port = port;
        return this;
    }

    /**
     * 设置用户名、密码
     * @param username
     * @param password
     * @return
     */
    public URLBuilder setCredential(String username, String password) {
        this.username = Objects.requireNonNull(username);
        this.password = Objects.requireNonNull(password);
        return this;
    }

    public static void main(String[] args) {
        final URLBuilder urlBuilder = new URLBuilder();
        String url = urlBuilder.setCredential("lzx", "123")
                .setScheme("https")
                .setDomain("www.baidu.com")
                .setPort(80)
                .setPath("/")
                .setQuery(Map.of("a", "123", "q", "K&R"))
                .build();
        System.out.println(url);
    }
}
