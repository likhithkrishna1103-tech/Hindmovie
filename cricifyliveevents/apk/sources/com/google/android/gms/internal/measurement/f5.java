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
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f5 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final f5 f2397w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final f5 f2398x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final f5[] f2399y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ f5[] f2400z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f2401v;

    /* JADX INFO: Fake field, exist only in values array */
    f5 EF0;

    static {
        s5 s5Var = s5.f2613z;
        f5 f5Var = new f5("DOUBLE", 0, 0, 1, s5Var);
        s5 s5Var2 = s5.f2612y;
        f5 f5Var2 = new f5("FLOAT", 1, 1, 1, s5Var2);
        s5 s5Var3 = s5.f2611x;
        f5 f5Var3 = new f5("INT64", 2, 2, 1, s5Var3);
        f5 f5Var4 = new f5("UINT64", 3, 3, 1, s5Var3);
        s5 s5Var4 = s5.f2610w;
        f5 f5Var5 = new f5("INT32", 4, 4, 1, s5Var4);
        f5 f5Var6 = new f5("FIXED64", 5, 5, 1, s5Var3);
        f5 f5Var7 = new f5("FIXED32", 6, 6, 1, s5Var4);
        s5 s5Var5 = s5.A;
        f5 f5Var8 = new f5("BOOL", 7, 7, 1, s5Var5);
        s5 s5Var6 = s5.B;
        f5 f5Var9 = new f5("STRING", 8, 8, 1, s5Var6);
        s5 s5Var7 = s5.E;
        f5 f5Var10 = new f5("MESSAGE", 9, 9, 1, s5Var7);
        s5 s5Var8 = s5.C;
        f5 f5Var11 = new f5("BYTES", 10, 10, 1, s5Var8);
        f5 f5Var12 = new f5("UINT32", 11, 11, 1, s5Var4);
        s5 s5Var9 = s5.D;
        f5 f5Var13 = new f5("ENUM", 12, 12, 1, s5Var9);
        f5 f5Var14 = new f5("SFIXED32", 13, 13, 1, s5Var4);
        f5 f5Var15 = new f5("SFIXED64", 14, 14, 1, s5Var3);
        f5 f5Var16 = new f5("SINT32", 15, 15, 1, s5Var4);
        f5 f5Var17 = new f5("SINT64", 16, 16, 1, s5Var3);
        f5 f5Var18 = new f5("GROUP", 17, 17, 1, s5Var7);
        f5 f5Var19 = new f5("DOUBLE_LIST", 18, 18, 2, s5Var);
        f5 f5Var20 = new f5("FLOAT_LIST", 19, 19, 2, s5Var2);
        f5 f5Var21 = new f5("INT64_LIST", 20, 20, 2, s5Var3);
        f5 f5Var22 = new f5("UINT64_LIST", 21, 21, 2, s5Var3);
        f5 f5Var23 = new f5("INT32_LIST", 22, 22, 2, s5Var4);
        f5 f5Var24 = new f5("FIXED64_LIST", 23, 23, 2, s5Var3);
        f5 f5Var25 = new f5("FIXED32_LIST", 24, 24, 2, s5Var4);
        f5 f5Var26 = new f5("BOOL_LIST", 25, 25, 2, s5Var5);
        f5 f5Var27 = new f5("STRING_LIST", 26, 26, 2, s5Var6);
        f5 f5Var28 = new f5("MESSAGE_LIST", 27, 27, 2, s5Var7);
        f5 f5Var29 = new f5("BYTES_LIST", 28, 28, 2, s5Var8);
        f5 f5Var30 = new f5("UINT32_LIST", 29, 29, 2, s5Var4);
        f5 f5Var31 = new f5("ENUM_LIST", 30, 30, 2, s5Var9);
        f5 f5Var32 = new f5("SFIXED32_LIST", 31, 31, 2, s5Var4);
        f5 f5Var33 = new f5("SFIXED64_LIST", 32, 32, 2, s5Var3);
        f5 f5Var34 = new f5("SINT32_LIST", 33, 33, 2, s5Var4);
        f5 f5Var35 = new f5("SINT64_LIST", 34, 34, 2, s5Var3);
        f5 f5Var36 = new f5("DOUBLE_LIST_PACKED", 35, 35, 3, s5Var);
        f2397w = f5Var36;
        f5 f5Var37 = new f5("FLOAT_LIST_PACKED", 36, 36, 3, s5Var2);
        f5 f5Var38 = new f5("INT64_LIST_PACKED", 37, 37, 3, s5Var3);
        f5 f5Var39 = new f5("UINT64_LIST_PACKED", 38, 38, 3, s5Var3);
        f5 f5Var40 = new f5("INT32_LIST_PACKED", 39, 39, 3, s5Var4);
        f5 f5Var41 = new f5("FIXED64_LIST_PACKED", 40, 40, 3, s5Var3);
        f5 f5Var42 = new f5("FIXED32_LIST_PACKED", 41, 41, 3, s5Var4);
        f5 f5Var43 = new f5("BOOL_LIST_PACKED", 42, 42, 3, s5Var5);
        f5 f5Var44 = new f5("UINT32_LIST_PACKED", 43, 43, 3, s5Var4);
        f5 f5Var45 = new f5("ENUM_LIST_PACKED", 44, 44, 3, s5Var9);
        f5 f5Var46 = new f5("SFIXED32_LIST_PACKED", 45, 45, 3, s5Var4);
        f5 f5Var47 = new f5("SFIXED64_LIST_PACKED", 46, 46, 3, s5Var3);
        f5 f5Var48 = new f5("SINT32_LIST_PACKED", 47, 47, 3, s5Var4);
        f5 f5Var49 = new f5("SINT64_LIST_PACKED", 48, 48, 3, s5Var3);
        f2398x = f5Var49;
        f2400z = new f5[]{f5Var, f5Var2, f5Var3, f5Var4, f5Var5, f5Var6, f5Var7, f5Var8, f5Var9, f5Var10, f5Var11, f5Var12, f5Var13, f5Var14, f5Var15, f5Var16, f5Var17, f5Var18, f5Var19, f5Var20, f5Var21, f5Var22, f5Var23, f5Var24, f5Var25, f5Var26, f5Var27, f5Var28, f5Var29, f5Var30, f5Var31, f5Var32, f5Var33, f5Var34, f5Var35, f5Var36, f5Var37, f5Var38, f5Var39, f5Var40, f5Var41, f5Var42, f5Var43, f5Var44, f5Var45, f5Var46, f5Var47, f5Var48, f5Var49, new f5("GROUP_LIST", 49, 49, 2, s5Var7), new f5("MAP", 50, 50, 4, s5.f2609v)};
        f5[] f5VarArrValues = values();
        f2399y = new f5[f5VarArrValues.length];
        for (f5 f5Var50 : f5VarArrValues) {
            f2399y[f5Var50.f2401v] = f5Var50;
        }
    }

    public f5(String str, int i, int i10, int i11, s5 s5Var) {
        this.f2401v = i10;
        int i12 = i11 - 1;
        if (i12 == 1 || i12 == 3) {
            s5Var.getClass();
        }
        if (i11 == 1) {
            s5 s5Var2 = s5.f2609v;
            s5Var.ordinal();
        }
    }

    public static f5[] values() {
        return (f5[]) f2400z.clone();
    }
}
