package g6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final h0 f5082v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final h0 f5083w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final h0 f5084x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ h0[] f5085y;

    static {
        h0 h0Var = new h0("AUTOMATIC", 0);
        f5082v = h0Var;
        h0 h0Var2 = new h0("HARDWARE", 1);
        f5083w = h0Var2;
        h0 h0Var3 = new h0("SOFTWARE", 2);
        f5084x = h0Var3;
        f5085y = new h0[]{h0Var, h0Var2, h0Var3};
    }

    public static h0 valueOf(String str) {
        return (h0) Enum.valueOf(h0.class, str);
    }

    public static h0[] values() {
        return (h0[]) f5085y.clone();
    }
}
