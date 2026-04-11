package com.google.android.gms.internal.measurement;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public enum w {
    f2697w("ADD"),
    f2699x("AND"),
    f2701y("APPLY"),
    f2703z("ASSIGN"),
    A("BITWISE_AND"),
    B("BITWISE_LEFT_SHIFT"),
    C("BITWISE_NOT"),
    D("BITWISE_OR"),
    E("BITWISE_RIGHT_SHIFT"),
    F("BITWISE_UNSIGNED_RIGHT_SHIFT"),
    G("BITWISE_XOR"),
    H("BLOCK"),
    I("BREAK"),
    J("CASE"),
    K("CONST"),
    L("CONTINUE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("CONTROL"),
    M("CREATE_ARRAY"),
    N("CREATE_OBJECT"),
    O("DEFAULT"),
    P("DEFINE_FUNCTION"),
    Q("DIVIDE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("DO"),
    R("EQUALS"),
    S("EXPRESSION_LIST"),
    T("FN"),
    U("FOR_IN"),
    V("FOR_IN_CONST"),
    W("FOR_IN_LET"),
    X("FOR_LET"),
    Y("FOR_OF"),
    Z("FOR_OF_CONST"),
    f2676a0("FOR_OF_LET"),
    f2677b0("GET"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("GET_CONTAINER_VARIABLE"),
    f2678c0("GET_INDEX"),
    f2679d0("GET_PROPERTY"),
    f2680e0("GREATER_THAN"),
    f2681f0("GREATER_THAN_EQUALS"),
    f2682g0("IDENTITY_EQUALS"),
    f2683h0("IDENTITY_NOT_EQUALS"),
    f2684i0("IF"),
    f2685j0("LESS_THAN"),
    f2686k0("LESS_THAN_EQUALS"),
    f2687l0("MODULUS"),
    f2688m0("MULTIPLY"),
    f2689n0("NEGATE"),
    o0("NOT"),
    f2690p0("NOT_EQUALS"),
    f2691q0("NULL"),
    f2692r0("OR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("PLUS_EQUALS"),
    f2693s0("POST_DECREMENT"),
    f2694t0("POST_INCREMENT"),
    f2695u0("QUOTE"),
    f2696v0("PRE_DECREMENT"),
    f2698w0("PRE_INCREMENT"),
    f2700x0("RETURN"),
    f2702y0("SET_PROPERTY"),
    f2704z0("SUBTRACT"),
    A0("SWITCH"),
    B0("TERNARY"),
    C0("TYPEOF"),
    D0("UNDEFINED"),
    E0("VAR"),
    F0("WHILE");

    public static final HashMap G0 = new HashMap();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f2705v;

    static {
        for (w wVar : values()) {
            G0.put(Integer.valueOf(wVar.f2705v), wVar);
        }
    }

    w(String str) {
        this.f2705v = i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.valueOf(this.f2705v).toString();
    }
}
