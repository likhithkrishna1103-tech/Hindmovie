package vc;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final x0 f13711v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final x0 f13712w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ x0[] f13713x;

    static {
        x0 x0Var = new x0("GENERAL", 0);
        f13711v = x0Var;
        x0 x0Var2 = new x0("FALLBACK", 1);
        f13712w = x0Var2;
        f13713x = new x0[]{x0Var, x0Var2};
    }

    public static x0 valueOf(String str) {
        return (x0) Enum.valueOf(x0.class, str);
    }

    public static x0[] values() {
        return (x0[]) f13713x.clone();
    }
}
