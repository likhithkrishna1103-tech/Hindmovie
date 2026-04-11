package id;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final c f6568u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final c f6569v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ c[] f6570w;

    static {
        c cVar = new c("SEQUENTIAL", 0);
        f6568u = cVar;
        c cVar2 = new c("PARALLEL", 1);
        f6569v = cVar2;
        f6570w = new c[]{cVar, cVar2};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f6570w.clone();
    }
}
