package g6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f5030v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f5031w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ a[] f5032x;

    static {
        a aVar = new a("AUTOMATIC", 0);
        f5030v = aVar;
        a aVar2 = new a("ENABLED", 1);
        f5031w = aVar2;
        f5032x = new a[]{aVar, aVar2, new a("DISABLED", 2)};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f5032x.clone();
    }
}
