package wc;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f14139v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final d f14140w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ d[] f14141x;

    static {
        d dVar = new d("CRASHLYTICS", 0);
        f14139v = dVar;
        d dVar2 = new d("PERFORMANCE", 1);
        f14140w = dVar2;
        f14141x = new d[]{dVar, dVar2, new d("MATT_SAYS_HI", 2)};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f14141x.clone();
    }
}
