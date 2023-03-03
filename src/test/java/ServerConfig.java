import org.aeonbits.owner.Config;


public interface ServerConfig extends Config {
    int port();
    @DefaultValue("yandex.ru")
    String host();
}
