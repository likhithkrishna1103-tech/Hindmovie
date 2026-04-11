package pe;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final w f10276v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final w f10277w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final w f10278x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ w[] f10279y;

    static {
        w wVar = new w("DEFAULT", 0);
        f10276v = wVar;
        w wVar2 = new w("LAZY", 1);
        w wVar3 = new w("ATOMIC", 2);
        f10277w = wVar3;
        w wVar4 = new w("UNDISPATCHED", 3);
        f10278x = wVar4;
        f10279y = new w[]{wVar, wVar2, wVar3, wVar4};
    }

    public static w valueOf(String str) {
        return (w) Enum.valueOf(w.class, str);
    }

    public static w[] values() {
        return (w[]) f10279y.clone();
    }
}
