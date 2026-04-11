package k8;

import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p extends x1 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f7360x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f7361y;

    @Override // k8.x1
    public final boolean s1() {
        Calendar calendar = Calendar.getInstance();
        this.f7360x = TimeUnit.MINUTES.convert(calendar.get(16) + calendar.get(15), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        this.f7361y = language.toLowerCase(locale2) + "-" + locale.getCountry().toLowerCase(locale2);
        return false;
    }

    public final long t1() {
        q1();
        return this.f7360x;
    }

    public final String u1() {
        q1();
        return this.f7361y;
    }
}
