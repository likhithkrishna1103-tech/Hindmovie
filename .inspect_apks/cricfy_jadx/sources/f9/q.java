package f9;

import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends b2 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f4332y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f4333z;

    @Override // f9.b2
    public final boolean n1() {
        Calendar calendar = Calendar.getInstance();
        this.f4332y = TimeUnit.MINUTES.convert(calendar.get(16) + calendar.get(15), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append("-");
        sb.append(lowerCase2);
        this.f4333z = sb.toString();
        return false;
    }

    public final long q1() {
        o1();
        return this.f4332y;
    }

    public final String r1() {
        o1();
        return this.f4333z;
    }
}
