package bb;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f1898g = {"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final SimpleDateFormat f1899h = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Date f1903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1904e;
    public final long f;

    public b(String str, String str2, String str3, Date date, long j4, long j7) {
        this.f1900a = str;
        this.f1901b = str2;
        this.f1902c = str3;
        this.f1903d = date;
        this.f1904e = j4;
        this.f = j7;
    }

    public final eb.a a() {
        eb.a aVar = new eb.a();
        aVar.f3869a = "frc";
        aVar.f3879m = this.f1903d.getTime();
        aVar.f3870b = this.f1900a;
        aVar.f3871c = this.f1901b;
        String str = this.f1902c;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        aVar.f3872d = str;
        aVar.f3873e = this.f1904e;
        aVar.f3876j = this.f;
        return aVar;
    }
}
