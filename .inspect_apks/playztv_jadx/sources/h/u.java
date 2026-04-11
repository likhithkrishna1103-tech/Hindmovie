package h;

import android.content.res.Configuration;
import android.os.LocaleList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
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

    public static m0.g b(Configuration configuration) {
        return m0.g.b(configuration.getLocales().toLanguageTags());
    }

    public static void c(m0.g gVar) {
        LocaleList.setDefault(LocaleList.forLanguageTags(gVar.f8282a.a()));
    }

    public static void d(Configuration configuration, m0.g gVar) {
        configuration.setLocales(LocaleList.forLanguageTags(gVar.f8282a.a()));
    }
}
