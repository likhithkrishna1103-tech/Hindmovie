package md;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final c f8424v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final c f8425w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ c[] f8426x;

    static {
        c cVar = new c("SEQUENTIAL", 0);
        f8424v = cVar;
        c cVar2 = new c("PARALLEL", 1);
        f8425w = cVar2;
        f8426x = new c[]{cVar, cVar2};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f8426x.clone();
    }
}
