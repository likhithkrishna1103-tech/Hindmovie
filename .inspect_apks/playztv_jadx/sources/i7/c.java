package i7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final c f6449u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final c f6450v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final c f6451w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ c[] f6452x;

    static {
        c cVar = new c("NETWORK_UNMETERED", 0);
        f6449u = cVar;
        c cVar2 = new c("DEVICE_IDLE", 1);
        f6450v = cVar2;
        c cVar3 = new c("DEVICE_CHARGING", 2);
        f6451w = cVar3;
        f6452x = new c[]{cVar, cVar2, cVar3};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f6452x.clone();
    }
}
