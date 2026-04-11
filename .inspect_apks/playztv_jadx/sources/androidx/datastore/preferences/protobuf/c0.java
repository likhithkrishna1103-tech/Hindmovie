package androidx.datastore.preferences.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {
    public static final c0 A;
    public static final c0 B;
    public static final c0 C;
    public static final c0 D;
    public static final /* synthetic */ c0[] E;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final c0 f1020u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final c0 f1021v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final c0 f1022w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final c0 f1023x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final c0 f1024y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final c0 f1025z;

    static {
        c0 c0Var = new c0("VOID", 0);
        f1020u = c0Var;
        c0 c0Var2 = new c0("INT", 1);
        f1021v = c0Var2;
        c0 c0Var3 = new c0("LONG", 2);
        f1022w = c0Var3;
        c0 c0Var4 = new c0("FLOAT", 3);
        f1023x = c0Var4;
        c0 c0Var5 = new c0("DOUBLE", 4);
        f1024y = c0Var5;
        c0 c0Var6 = new c0("BOOLEAN", 5);
        f1025z = c0Var6;
        c0 c0Var7 = new c0("STRING", 6);
        A = c0Var7;
        g gVar = g.f1043w;
        c0 c0Var8 = new c0("BYTE_STRING", 7);
        B = c0Var8;
        c0 c0Var9 = new c0("ENUM", 8);
        C = c0Var9;
        c0 c0Var10 = new c0("MESSAGE", 9);
        D = c0Var10;
        E = new c0[]{c0Var, c0Var2, c0Var3, c0Var4, c0Var5, c0Var6, c0Var7, c0Var8, c0Var9, c0Var10};
    }

    public static c0 valueOf(String str) {
        return (c0) Enum.valueOf(c0.class, str);
    }

    public static c0[] values() {
        return (c0[]) E.clone();
    }
}
