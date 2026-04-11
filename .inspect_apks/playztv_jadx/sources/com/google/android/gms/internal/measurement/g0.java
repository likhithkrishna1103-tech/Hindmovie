package com.google.android.gms.internal.measurement;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public enum g0 {
    f2998v("ADD"),
    f3000w("AND"),
    f3002x("APPLY"),
    f3004y("ASSIGN"),
    f3006z("BITWISE_AND"),
    A("BITWISE_LEFT_SHIFT"),
    B("BITWISE_NOT"),
    C("BITWISE_OR"),
    D("BITWISE_RIGHT_SHIFT"),
    E("BITWISE_UNSIGNED_RIGHT_SHIFT"),
    F("BITWISE_XOR"),
    G("BLOCK"),
    H("BREAK"),
    I("CASE"),
    J("CONST"),
    K("CONTINUE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("CONTROL"),
    L("CREATE_ARRAY"),
    M("CREATE_OBJECT"),
    N("DEFAULT"),
    O("DEFINE_FUNCTION"),
    P("DIVIDE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("DO"),
    Q("EQUALS"),
    R("EXPRESSION_LIST"),
    S("FN"),
    T("FOR_IN"),
    U("FOR_IN_CONST"),
    V("FOR_IN_LET"),
    W("FOR_LET"),
    X("FOR_OF"),
    Y("FOR_OF_CONST"),
    Z("FOR_OF_LET"),
    f2978a0("GET"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("GET_CONTAINER_VARIABLE"),
    f2979b0("GET_INDEX"),
    f2980c0("GET_PROPERTY"),
    f2981d0("GREATER_THAN"),
    f2982e0("GREATER_THAN_EQUALS"),
    f2983f0("IDENTITY_EQUALS"),
    f2984g0("IDENTITY_NOT_EQUALS"),
    f2985h0("IF"),
    f2986i0("LESS_THAN"),
    f2987j0("LESS_THAN_EQUALS"),
    f2988k0("MODULUS"),
    l0("MULTIPLY"),
    f2989m0("NEGATE"),
    f2990n0("NOT"),
    f2991o0("NOT_EQUALS"),
    f2992p0("NULL"),
    f2993q0("OR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("PLUS_EQUALS"),
    f2994r0("POST_DECREMENT"),
    f2995s0("POST_INCREMENT"),
    f2996t0("QUOTE"),
    f2997u0("PRE_DECREMENT"),
    f2999v0("PRE_INCREMENT"),
    f3001w0("RETURN"),
    f3003x0("SET_PROPERTY"),
    f3005y0("SUBTRACT"),
    f3007z0("SWITCH"),
    A0("TERNARY"),
    B0("TYPEOF"),
    C0("UNDEFINED"),
    D0("VAR"),
    E0("WHILE");

    public static final HashMap F0 = new HashMap();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f3008u;

    static {
        for (g0 g0Var : values()) {
            F0.put(Integer.valueOf(g0Var.f3008u), g0Var);
        }
    }

    g0(String str) {
        if (i > 100) {
            throw new AssertionError("Native functions over 100 are reserved for runtime implementations.");
        }
        this.f3008u = i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.valueOf(this.f3008u).toString();
    }
}
