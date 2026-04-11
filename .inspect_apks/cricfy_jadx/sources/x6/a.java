package x6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f14392v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f14393w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f14394x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ a[] f14395y;

    static {
        a aVar = new a("PREFER_ARGB_8888", 0);
        f14392v = aVar;
        a aVar2 = new a("PREFER_RGB_565", 1);
        f14393w = aVar2;
        f14395y = new a[]{aVar, aVar2};
        f14394x = aVar;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f14395y.clone();
    }
}
