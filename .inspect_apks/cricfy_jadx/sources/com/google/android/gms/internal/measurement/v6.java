package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF2' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v6 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final v6 f2666x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final v6 f2667y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ v6[] f2668z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final w6 f2669v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f2670w;

    /* JADX INFO: Fake field, exist only in values array */
    v6 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    v6 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    v6 EF2;

    static {
        v6 v6Var = new v6("DOUBLE", 0, w6.f2713y, 1);
        v6 v6Var2 = new v6("FLOAT", 1, w6.f2712x, 5);
        w6 w6Var = w6.f2711w;
        v6 v6Var3 = new v6("INT64", 2, w6Var, 0);
        v6 v6Var4 = new v6("UINT64", 3, w6Var, 0);
        w6 w6Var2 = w6.f2710v;
        v6 v6Var5 = new v6("INT32", 4, w6Var2, 0);
        v6 v6Var6 = new v6("FIXED64", 5, w6Var, 1);
        v6 v6Var7 = new v6("FIXED32", 6, w6Var2, 5);
        v6 v6Var8 = new v6("BOOL", 7, w6.f2714z, 0);
        v6 v6Var9 = new v6("STRING", 8, w6.A, 2);
        f2666x = v6Var9;
        w6 w6Var3 = w6.D;
        v6 v6Var10 = new v6("GROUP", 9, w6Var3, 3);
        f2667y = v6Var10;
        f2668z = new v6[]{v6Var, v6Var2, v6Var3, v6Var4, v6Var5, v6Var6, v6Var7, v6Var8, v6Var9, v6Var10, new v6("MESSAGE", 10, w6Var3, 2), new v6("BYTES", 11, w6.B, 2), new v6("UINT32", 12, w6Var2, 0), new v6("ENUM", 13, w6.C, 0), new v6("SFIXED32", 14, w6Var2, 5), new v6("SFIXED64", 15, w6Var, 1), new v6("SINT32", 16, w6Var2, 0), new v6("SINT64", 17, w6Var, 0)};
    }

    public v6(String str, int i, w6 w6Var, int i10) {
        this.f2669v = w6Var;
        this.f2670w = i10;
    }

    public static v6[] values() {
        return (v6[]) f2668z.clone();
    }
}
