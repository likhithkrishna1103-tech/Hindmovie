package ha;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f6018g = {"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final SimpleDateFormat f6019h = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Date f6023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f6024e;
    public final long f;

    public b(String str, String str2, String str3, Date date, long j5, long j8) {
        this.f6020a = str;
        this.f6021b = str2;
        this.f6022c = str3;
        this.f6023d = date;
        this.f6024e = j5;
        this.f = j8;
    }

    public final ka.a a() {
        ka.a aVar = new ka.a();
        aVar.f7594a = "frc";
        aVar.f7604m = this.f6023d.getTime();
        aVar.f7595b = this.f6020a;
        aVar.f7596c = this.f6021b;
        String str = this.f6022c;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        aVar.f7597d = str;
        aVar.f7598e = this.f6024e;
        aVar.f7601j = this.f;
        return aVar;
    }
}
