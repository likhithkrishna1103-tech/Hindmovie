package re;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f11004v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f11005w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f11006x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ a[] f11007y;

    static {
        a aVar = new a("SUSPEND", 0);
        f11004v = aVar;
        a aVar2 = new a("DROP_OLDEST", 1);
        f11005w = aVar2;
        a aVar3 = new a("DROP_LATEST", 2);
        f11006x = aVar3;
        f11007y = new a[]{aVar, aVar2, aVar3};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f11007y.clone();
    }
}
