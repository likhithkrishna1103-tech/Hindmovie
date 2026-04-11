package h;

import android.content.res.Configuration;
import android.os.LocaleList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (locales.equals(locales2)) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    public static p0.g b(Configuration configuration) {
        return p0.g.b(configuration.getLocales().toLanguageTags());
    }

    public static void c(p0.g gVar) {
        LocaleList.setDefault(LocaleList.forLanguageTags(gVar.f9874a.a()));
    }

    public static void d(Configuration configuration, p0.g gVar) {
        configuration.setLocales(LocaleList.forLanguageTags(gVar.f9874a.a()));
    }
}
