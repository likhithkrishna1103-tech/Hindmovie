package w4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final c0 f13925v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final c0 f13926w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ c0[] f13927x;

    static {
        c0 c0Var = new c0("DEFERRED", 0);
        f13925v = c0Var;
        c0 c0Var2 = new c0("IMMEDIATE", 1);
        f13926w = c0Var2;
        f13927x = new c0[]{c0Var, c0Var2, new c0("EXCLUSIVE", 2)};
    }

    public static c0 valueOf(String str) {
        return (c0) Enum.valueOf(c0.class, str);
    }

    public static c0[] values() {
        return (c0[]) f13927x.clone();
    }
}
