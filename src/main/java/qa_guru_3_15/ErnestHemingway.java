package qa_guru_3_15;

import org.aeonbits.owner.Config;

import java.net.URL;

    @Config.LoadPolicy(Config.LoadType.MERGE)
    @Config.Sources({
    "file:../secret.properties",

    })
    public interface ErnestHemingway extends Config {

        @Key("user.login")
        String userLogin();

        @Key("user.password")
        String userPassword();

}
