package codes.laivy.npc.config;

import codes.laivy.mlanguage.LvMultiplesLanguages;
import codes.laivy.mlanguage.api.LocaleAPI;
import codes.laivy.mlanguage.lang.Language;
import codes.laivy.mlanguage.lang.LanguagePack;
import codes.laivy.mlanguage.lang.Locale;
import codes.laivy.npc.utils.JsonParser;
import com.google.gson.JsonObject;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import static codes.laivy.npc.LaivyNPC.laivynpc;

public class Translate {

    private static final @NotNull String[] DEFAULT_LANGUAGES_FILES = new String[] {
            "EN_US.json"
    };

    private static final @NotNull Map<@NotNull String, @NotNull String> messages = new HashMap<>();

    static {
        Map<String, LangInfo> infos = new LinkedHashMap<>();

        for (String str : DEFAULT_LANGUAGES_FILES) {
            LinkedHashMap<String, String> messages = new LinkedHashMap<>();
            String packName = null;

            InputStream stream = laivynpc().getResource("languages/" + str);
            JsonObject object = JsonParser.parse(new InputStreamReader(stream)).getAsJsonObject();

            for (String key : object.keySet()) {
                if (key.equals("info:pack_name")) {
                    packName = object.get(key).getAsString();
                } else {
                    messages.put(key, object.get(key).getAsString());
                }
            }

            infos.put(str, new LangInfo(Objects.requireNonNull(packName), messages));
        }

        if (laivynpc().hasMultiplesLanguagesSupport()) {
            Language lang = new Language("General Messages", null, laivynpc().getName(), new LinkedHashSet<LanguagePack>() {{
                for (Map.Entry<String, LangInfo> info : infos.entrySet()) {
                LinkedHashSet<Locale> locales = new LinkedHashSet<>(Collections.singletonList(Locale.valueOf(info.getKey().replace(".json", ""))));
                    add(new LanguagePack(locales, info.getValue().getPackName(), null, info.getValue().getMessages()));
                }
            }});
            if (lang.getFile() == null || !lang.getFile().exists()) {
                lang.register();
            } else {
                try {
                    Language.createByResourceStream(laivynpc().getName(), new FileInputStream(lang.getFile()));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException("LvML language loading", e);
                }
            }
        } else {
            messages.putAll(infos.get(DEFAULT_LANGUAGES_FILES[0]).getMessages());
        }
    }

    public static @NotNull String translate(@Nullable OfflinePlayer player, @NotNull String code, @NotNull Object... replaces) {
        String message = null;

        if (laivynpc().hasMultiplesLanguagesSupport()) {
            LocaleAPI api = LvMultiplesLanguages.getApi().getLocaleAPI();
            message = api.getNullableMessage(laivynpc().getName(), code, (player != null ? api.getLocale(player.getUniqueId()) : null));
        } else {
            if (messages.containsKey(code)) {
                message = messages.get(code);
            }
        }

        if (message == null) {
            throw new NullPointerException("Couldn't get message '" + code + "'");
        }

        for (Object replace : replaces) {
            message = message.replaceFirst("%s", replace.toString());
        }

        return message;
    }

    private static final class LangInfo {

        private final @NotNull String packName;
        private final @NotNull LinkedHashMap<@NotNull String, @NotNull String> messages;

        public LangInfo(@NotNull String packName, @NotNull LinkedHashMap<@NotNull String, @NotNull String> messages) {
            this.packName = packName;
            this.messages = messages;
        }

        public @NotNull String getPackName() {
            return packName;
        }

        public @NotNull LinkedHashMap<String, String> getMessages() {
            return messages;
        }
    }

}
