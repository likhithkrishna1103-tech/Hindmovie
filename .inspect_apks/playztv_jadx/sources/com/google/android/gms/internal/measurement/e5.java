package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e5 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final e5 f2955v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final e5 f2956w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final e5[] f2957x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ e5[] f2958y;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f2959u;

    /* JADX INFO: Fake field, exist only in values array */
    e5 EF0;

    static {
        t5 t5Var = t5.f3202y;
        e5 e5Var = new e5("DOUBLE", 0, 0, 1, t5Var);
        t5 t5Var2 = t5.f3201x;
        e5 e5Var2 = new e5("FLOAT", 1, 1, 1, t5Var2);
        t5 t5Var3 = t5.f3200w;
        e5 e5Var3 = new e5("INT64", 2, 2, 1, t5Var3);
        e5 e5Var4 = new e5("UINT64", 3, 3, 1, t5Var3);
        t5 t5Var4 = t5.f3199v;
        e5 e5Var5 = new e5("INT32", 4, 4, 1, t5Var4);
        e5 e5Var6 = new e5("FIXED64", 5, 5, 1, t5Var3);
        e5 e5Var7 = new e5("FIXED32", 6, 6, 1, t5Var4);
        t5 t5Var5 = t5.f3203z;
        e5 e5Var8 = new e5("BOOL", 7, 7, 1, t5Var5);
        t5 t5Var6 = t5.A;
        e5 e5Var9 = new e5("STRING", 8, 8, 1, t5Var6);
        t5 t5Var7 = t5.D;
        e5 e5Var10 = new e5("MESSAGE", 9, 9, 1, t5Var7);
        t5 t5Var8 = t5.B;
        e5 e5Var11 = new e5("BYTES", 10, 10, 1, t5Var8);
        e5 e5Var12 = new e5("UINT32", 11, 11, 1, t5Var4);
        t5 t5Var9 = t5.C;
        e5 e5Var13 = new e5("ENUM", 12, 12, 1, t5Var9);
        e5 e5Var14 = new e5("SFIXED32", 13, 13, 1, t5Var4);
        e5 e5Var15 = new e5("SFIXED64", 14, 14, 1, t5Var3);
        e5 e5Var16 = new e5("SINT32", 15, 15, 1, t5Var4);
        e5 e5Var17 = new e5("SINT64", 16, 16, 1, t5Var3);
        e5 e5Var18 = new e5("GROUP", 17, 17, 1, t5Var7);
        e5 e5Var19 = new e5("DOUBLE_LIST", 18, 18, 2, t5Var);
        e5 e5Var20 = new e5("FLOAT_LIST", 19, 19, 2, t5Var2);
        e5 e5Var21 = new e5("INT64_LIST", 20, 20, 2, t5Var3);
        e5 e5Var22 = new e5("UINT64_LIST", 21, 21, 2, t5Var3);
        e5 e5Var23 = new e5("INT32_LIST", 22, 22, 2, t5Var4);
        e5 e5Var24 = new e5("FIXED64_LIST", 23, 23, 2, t5Var3);
        e5 e5Var25 = new e5("FIXED32_LIST", 24, 24, 2, t5Var4);
        e5 e5Var26 = new e5("BOOL_LIST", 25, 25, 2, t5Var5);
        e5 e5Var27 = new e5("STRING_LIST", 26, 26, 2, t5Var6);
        e5 e5Var28 = new e5("MESSAGE_LIST", 27, 27, 2, t5Var7);
        e5 e5Var29 = new e5("BYTES_LIST", 28, 28, 2, t5Var8);
        e5 e5Var30 = new e5("UINT32_LIST", 29, 29, 2, t5Var4);
        e5 e5Var31 = new e5("ENUM_LIST", 30, 30, 2, t5Var9);
        e5 e5Var32 = new e5("SFIXED32_LIST", 31, 31, 2, t5Var4);
        e5 e5Var33 = new e5("SFIXED64_LIST", 32, 32, 2, t5Var3);
        e5 e5Var34 = new e5("SINT32_LIST", 33, 33, 2, t5Var4);
        e5 e5Var35 = new e5("SINT64_LIST", 34, 34, 2, t5Var3);
        e5 e5Var36 = new e5("DOUBLE_LIST_PACKED", 35, 35, 3, t5Var);
        f2955v = e5Var36;
        e5 e5Var37 = new e5("FLOAT_LIST_PACKED", 36, 36, 3, t5Var2);
        e5 e5Var38 = new e5("INT64_LIST_PACKED", 37, 37, 3, t5Var3);
        e5 e5Var39 = new e5("UINT64_LIST_PACKED", 38, 38, 3, t5Var3);
        e5 e5Var40 = new e5("INT32_LIST_PACKED", 39, 39, 3, t5Var4);
        e5 e5Var41 = new e5("FIXED64_LIST_PACKED", 40, 40, 3, t5Var3);
        e5 e5Var42 = new e5("FIXED32_LIST_PACKED", 41, 41, 3, t5Var4);
        e5 e5Var43 = new e5("BOOL_LIST_PACKED", 42, 42, 3, t5Var5);
        e5 e5Var44 = new e5("UINT32_LIST_PACKED", 43, 43, 3, t5Var4);
        e5 e5Var45 = new e5("ENUM_LIST_PACKED", 44, 44, 3, t5Var9);
        e5 e5Var46 = new e5("SFIXED32_LIST_PACKED", 45, 45, 3, t5Var4);
        e5 e5Var47 = new e5("SFIXED64_LIST_PACKED", 46, 46, 3, t5Var3);
        e5 e5Var48 = new e5("SINT32_LIST_PACKED", 47, 47, 3, t5Var4);
        e5 e5Var49 = new e5("SINT64_LIST_PACKED", 48, 48, 3, t5Var3);
        f2956w = e5Var49;
        f2958y = new e5[]{e5Var, e5Var2, e5Var3, e5Var4, e5Var5, e5Var6, e5Var7, e5Var8, e5Var9, e5Var10, e5Var11, e5Var12, e5Var13, e5Var14, e5Var15, e5Var16, e5Var17, e5Var18, e5Var19, e5Var20, e5Var21, e5Var22, e5Var23, e5Var24, e5Var25, e5Var26, e5Var27, e5Var28, e5Var29, e5Var30, e5Var31, e5Var32, e5Var33, e5Var34, e5Var35, e5Var36, e5Var37, e5Var38, e5Var39, e5Var40, e5Var41, e5Var42, e5Var43, e5Var44, e5Var45, e5Var46, e5Var47, e5Var48, e5Var49, new e5("GROUP_LIST", 49, 49, 2, t5Var7), new e5("MAP", 50, 50, 4, t5.f3198u)};
        e5[] e5VarArrValues = values();
        f2957x = new e5[e5VarArrValues.length];
        for (e5 e5Var50 : e5VarArrValues) {
            f2957x[e5Var50.f2959u] = e5Var50;
        }
    }

    public e5(String str, int i, int i10, int i11, t5 t5Var) {
        this.f2959u = i10;
        int iC = v.e.c(i11);
        if (iC == 1 || iC == 3) {
            t5Var.getClass();
        }
        if (i11 == 1) {
            int i12 = f5.f2970a[t5Var.ordinal()];
        }
    }

    public static e5[] values() {
        return (e5[]) f2958y.clone();
    }
}
